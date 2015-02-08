/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] preorder) {
    	if(inorder == null 
    	  || preorder == null
    	  || inorder.length != preorder.length)
    		return null;

    	return helper(inorder, preorder, 0, inorder.length, 0, preorder.length);
    }

    private TreeNode helper(int[] inorder, int[] preorder, int i_st, int i_end, int p_st, int p_end){
    	if(p_end <= p_st  || i_st >= i_end)
        	return null;

        TreeNode head = new TreeNode(preorder[p_st]);
        int j=i_st;

       	while(inorder[j] != preorder[p_st])
       		j++;

       	head.left = helper(inorder,preorder,i_st,j-1,p_st+1,p_end);
       	head.right = helper(inorder,preorder,j+1,i_end,p_st+1,p_end);

       	return head;
    }
}