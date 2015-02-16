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
	/*This is a function for Tree Inorder Traversals*/
    static public TreeNode InorderTraversal(TreeNode head) {
    	if(head == null)
    		return null;
    	InorderTraversal(head.left);
    	System.out.println(head.val);
    	InorderTraversal(head.right);
    }
    /*This is a function for Tree Preorder Traversals*/
    static public TreeNode PreorderTraversal(TreeNode head) {
    	if(head == null)
    		return null;
    	System.out.println(head.val);
    	PreorderTraversal(head.left);
    	PreorderTraversal(head.right);
    }
     /*This is a function for Tree Postorder Traversals*/
    static public TreeNode PostorderTraversal(TreeNode head) {
    	if(head == null)
    		return null;

    	PostorderTraversal(head.left);
    	PostorderTraversal(head.right);
    	System.out.println(head.val);
    }

    /*This is a function to Calculate Size of a tree*/
    static public TreeNode TreeSizeCal(TreeNode head) {
    	if(head == null)
    		return 0;
    	return TreeSizeCal(head.left)+TreeSizeCal(head.right) +1;    		
    }

    /*This is a function to check if two trees are identical*/
    static public Boolean sameTree(TreeNode tree1,TreeNode tree2){
    	if(tree1 == null && tree2 == null)
    		return true;
    	if(tree1 != null && tree2 != null){
    		return (tree1.data == tree2.data &&
    				sameTree(tree1.left, tree2.left) && sameTree(tree1.right, tree2.right)); 
    	}
    	return false;
    }

    /*Maximum Depth or Height of a Tree*/
    static public int maxDepth(TreeNode tree){
		if(tree == null)
			return 0;
		int left = maxDepth(tree.left);
		int right = maxDepth(tree.right);

		return Math.max(left,right)+1;
    }

    /*Convert a Binary Tree into its Mirror Tree*/
    static public void mirrorTree(TreeNode tree){
    	if(tree == null)
    		return;

    	mirrorTree(tree.left);
    	mirrorTree(tree.right);

    	TreeNode tmp = tree.left;
    	tree.left = tree.right;
    	tree.right = tmp;
    }

    /*Print all path of a Tree*/
	/*need to make sure path is large enough to cover the longest path.*/
    static public void printPath(int [] path, int size, TreeNode tree){
    	if(tree == null)
    		return;
    	if(tree.left == null && tree.right == null)
    		printAll(path);

    	path[size] = tree.data;
    	printPath(path,size+1,tree.left); 
    	printPath(path,size+1,tree.right);
    }

   	static private printAll(int[] path, int size){
   		for(int i=0, i<size; i++){
   			system.out.print(path[i]);
   		}
   	}

    /*End Print all path of a Tree*/

    /*Lowest Common Ancestor in a Binary Search Tree.*/
    static public TreeNode lowestCommonAnc(TreeNode root, int num1, int num2){
    	if(root == null)
    		return null;
    	if(root.data > num1 && root.data > num2)
    		return lowestCommonAnc(root.left,num1,num2);
    	if(root.data < num1 && root.data < num2)
    		return lowestCommonAnc(root.right,num1,num2);

    	return root;
    }


    /*Program to count leaf nodes in a binary tree*/

    static public int countLeaf(TreeNode root){
    	if(root == null)
    		return 0;

    	if(root.left == null && root.right == null)
    		return 1;

    	return countLeaf(root.left) + countLeaf(root.right);

    }

    static public void levelOrder(TreeNode	root){
    	Queue queueA = new LinkedList();
    	TreeNode tmp = root;

    	while(tmp!=null){
    		system.out.print(tmp.data);

    		if(tmp.left != null)
    			queueA.add(tmp.left);
    		if(tmp.right != null)
    			queueA.add(tmp.right);
    		tmp = queueA.pop();

    	}
    }

    //level order spiral with queue.
    static public void levelOrderSpiral(TreeNode root){
    	Queue queueA = new LinkedList();
    	TreeNode tmp = root;
    	int i=1;

    	while(tmp != null){
    		system.out.print(tmp.data);
    		if(i%2 == 1){
    			if (tmp.left != null) {
    				queueA.add(tmp.left);
    			}
    			if (tmp.right != null) {
    				queueA.add(tmp.right);
    			}
    		}else{
    			if (tmp.right != null) {
    				queueA.add(tmp.right);
    			}
    			if (tmp.left != null) {
    				queueA.add(tmp.left);
    			}
    		}
    		i++;
    	}
    }

    //level order spiral without queue.
    static public void levelOrderSpiralNQ(TreeNode root){
    	int height = Height(root);
    	for(int i = 0; i< height; i ++){
    		printLevel(root,i,i%2);	
    	}
    }

    static private void printLevel(TreeNode root, int level, int k){
    	if(level == 0 && root!=null)
    		system.out.print(root.data);
    	else{
    		if(k==1){
    			printLevel(root.left,level-1,k);
    			printLevel(root.right,level-1,k);	
    		}else{
    			printLevel(root.right,level-1,k);
    			printLevel(root.left,level-1,k);
    		}
    		
    	}
    }

    //level order spiral without queue helper.
    static private int Height(TreeNode root){
    	if(root == null)
    		return 0;
    	else{
    		int left = Height(root.left);
    		int right = Height(root.right);
    		if(left > right)
    			return left + 1;
    		return right +1;
    	}
    }


    //Check for Children Sum Property in a Binary Tree.
    static private Boolean checkChildrenSum(TreeNode root){
        if(root == null)
            return true;
        if(root.left == null && root.right == null)
            return true;

        int left=0;
        int right=0;
        if(root.left != null)
            left=root.left.data;
        if(root.right != null)
            right=root.right.data;

        if(left + right != root)
            return false;
        return checkChildrenSum(root.left) && checkChildrenSum(root.right);
    }

    //Convert an arbitrary Binary Tree to a tree that holds Children Sum Property
    static private void convertChildernSum(TreeNode root){

    }


}