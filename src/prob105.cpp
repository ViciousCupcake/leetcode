#include <iostream>
#include <vector>
using namespace std;
int search(const vector<int> &preorder, int start, int end, int key);
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};
TreeNode *buildTree(vector<int> &preorder, vector<int> &inorder);

int main() {
    cout << "hello world" << endl;
    TreeNode *root = new TreeNode(3);
    root->left = new TreeNode(9);
    root->right = new TreeNode(20);
    root->right->left = new TreeNode(15);
    root->right->left = new TreeNode(7);
    vector<int> preorder{3, 9, 20, 15, 7};
    vector<int> inorder{9, 3, 15, 20, 7};
    TreeNode* r = buildTree(preorder, inorder);
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
TreeNode *recurBuildTree(vector<int> &preorder, int pStart, int pEnd, vector<int> &inorder, int iStart, int iEnd) {
    if (pStart >= pEnd) {
        return nullptr;
    }
    TreeNode *root = new TreeNode(preorder[pStart]);
    int inOrderLeftSubTreeEnding = search(inorder, iStart, iEnd, preorder[pStart]);
    int sizeLeftSubTree = inOrderLeftSubTreeEnding - iStart;
    root->left = recurBuildTree(preorder, pStart + 1, pStart + 1 + sizeLeftSubTree, inorder, iStart, inOrderLeftSubTreeEnding);
    root->right = recurBuildTree(preorder, pStart + 1 + sizeLeftSubTree, pEnd, inorder, inOrderLeftSubTreeEnding + 1, iEnd);
    return root;
}
TreeNode *buildTree(vector<int> &preorder, vector<int> &inorder) {
    return recurBuildTree(preorder, 0, preorder.size(), inorder, 0, inorder.size());
}