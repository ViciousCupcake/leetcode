#include <iostream>
#include <vector>
using namespace std;
int search(const vector<int> &postorder, int start, int end, int key);
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};
TreeNode *buildTree(vector<int> &postorder, vector<int> &inorder);

int main() {
    cout << "hello world" << endl;
    TreeNode *root = new TreeNode(3);
    root->left = new TreeNode(9);
    root->right = new TreeNode(20);
    root->right->left = new TreeNode(15);
    root->right->left = new TreeNode(7);
    vector<int> postorder{9, 15, 7, 20, 3};
    vector<int> inorder{9, 3, 15, 20, 7};
    TreeNode *r = buildTree(inorder, postorder);
    cout << r->val << endl;
    cout << r->left->val << r->right->val << endl;
    cout << r->right->left->val << r->right->right->val << endl;
}
int search(const vector<int> &arr, int start, int end, int key) {
    for (int i = start; i < end; i++) {
        if (arr[i] == key)
            return i;
    }
    return -1;
}
TreeNode *recurBuildTree(vector<int> &postorder, int pStart, int pEnd, vector<int> &inorder, int iStart, int iEnd) {
    if (pStart >= pEnd) {
        return nullptr;
    }
    TreeNode *root = new TreeNode(postorder.at(pEnd - 1));
    int inOrderLeftSubTreeEnding = search(inorder, iStart, iEnd, postorder.at(pEnd - 1));
    int sizeLeftSubTree = inOrderLeftSubTreeEnding - iStart;
    cout << inOrderLeftSubTreeEnding << ' ' << sizeLeftSubTree << endl;
    root->left = recurBuildTree(postorder, pStart, pStart + sizeLeftSubTree, inorder, iStart, inOrderLeftSubTreeEnding);
    root->right = recurBuildTree(postorder, pStart + sizeLeftSubTree, pEnd - 1, inorder, inOrderLeftSubTreeEnding + 1, iEnd);
    return root;
}
TreeNode *buildTree(vector<int> &inorder, vector<int> &postorder) {
    return recurBuildTree(postorder, 0, postorder.size(), inorder, 0, inorder.size());
}