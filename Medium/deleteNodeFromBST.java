
/*
10-07-2023
https://leetcode.com/problems/delete-node-in-a-bst/description/

Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.

Examples:
Input: root = [5,3,6,2,4,null,7], key = 3
Output: [5,4,6,2,null,null,7]
Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.

Input: root = [5,3,6,2,4,null,7], key = 0
Output: [5,3,6,2,4,null,7]
Explanation: The tree does not contain a node with value = 0.

Input: root = [], key = 0
Output: []

*/
class deleteNodeFromBST {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }
    public int minVal(TreeNode root){
        int min=root.val;
        while(root.left!=null){
            min=root.left.val;
            root=root.left;
        }return min;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(key > root.val){
            root.right = deleteNode(root.right, key);
            return root;
        }
        else if(key < root.val){
            root.left = deleteNode(root.left, key);
            return root;
        }
        else{
            if(root.left == null && root.right == null){
                return null;
            }
            else if(root.left == null && root.right!=null){
                return root.right;
            }
            else if(root.right == null && root.left!=null){
                return root.left;
            }
            else{
                int mVal = minVal(root.right);
                root.val = mVal;
                root.right = deleteNode(root.right, mVal);
                return root;
            }
        }
    }
}