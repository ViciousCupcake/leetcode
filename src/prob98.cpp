#include <iostream>
#include <vector>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};
void toArr(TreeNode* root, vector<int> &list){
    if(root == nullptr)
        return;
    toArr(root->left, list);
    list.push_back(root->val);
    toArr(root->right,list);
}
bool isValidBST(TreeNode* root) {
    vector<int> list;
    toArr(root, list);
    for(int i = 1; i < list.size(); i++){
        if(list[i-1] >= list[i])
            return false;
    }
    return true;
}

int main() {
    cout << "hello world" << endl;
}