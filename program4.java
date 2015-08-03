/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * } 
 *    //Decision Trees – Fake (Counterfeit) Coin Puzzle (12 Coin Puzzle) ????????
 *    //Connect nodes at same level;?????????
 *    //Populate Inorder Successor for all nodes ????  
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
  z  }

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
   			System.out.print(path[i]);
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
    		System.out.print(tmp.data);

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
    		System.out.print(tmp.data);
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
    		System.out.print(root.data);
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
    static public Boolean checkChildrenSum(TreeNode root){
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
    static public void convertChildernSum(TreeNode root){
        if(root == null)
            return;
        convertChildernSum(root.left);
        convertChildernSum(root.right);

        int left_data = 0;
        int right_data = 0;

        if(root.left != null)
            left_data = root.left.data;
        if(root.right != null)
            right_data = root.right.data;

        int diff = left_data + right_data - root.data;
        if(diff > 0)
            root.data = left_data + right_data;
        else if(diff < 0){
            root.left.data = root.data - right_data;
            increase(root.left);
        }
    }

    static private void increase(TreeNode root){
        if(root == null || root.left == null && root.right == null)
            return;

        if(root.left == null){
            root.right.data = root.data;
            return;
        }
        if(root.right == null){
            root.left.data = root.data;
            return;
        }

        root.left.data = root.data - root.right.data;
        increase(root.left);
    }

    //End convert an arbitrary Binary Tree to a tree that holds Children Sum Property

    //Diameter of a Binary Tree
    static public int computeDiameter(TreeNode root){
        if(root == null)
            return 0;

        int left_height = height(root.left);
        int right_height = height(root.right);

        //through root.
        int diameterRt = left_height + right_height + 1;

        int leftDia = computeDiameter(root.left);
        int rightDia = computeDiameter(root.right);

        return Math.max(diameterRt,Math.max(lefDia,rightDia));
    }

    //if a binary tree is height-balanced
    static public Boolean isBalance(TreeNode root){
        // left sub tree is balanced && right sub tree is balanced
        // diff of max height of left and right is less than or equal to one. 
    }

    static public void inorderTraversalNoRecurse(TreeNode root){
        //???
    }

    //Maximum width of a binary tree
    static public int maxWidthOfTree(TreeNode root){
        if(root == null)
            return 0;
        int height = Height(root);
        int [] tmp = new int [height];
        int iterate = 0;
        helper(root,tmp,0);
        int maxWidth = 0;
        for(int i =0; i< height; i++){
            if(maxWidth < tmp[i])
                maxWidth = tmp[i];
        }
        return maxWidth；
    }

    static private void helper(TreeNode root,int[] tmp,int iterate){
        if(root == null || tmp.length <= iterate)
            return;
        tmp[iterate]=tmp[iterate]+1;
        helper(root.left,tmp,iterate+1);
        helper(root.right,tmp,iterate+1);
    }

    //End Maximum width of a binary tree
    //Print Ancestors of a given node in Binary Tree
    static public Boolean printAncestors(TreeNode root,int num){
        if(root == null)
            return false;

        if(root.data == num)
            return true;

        if(printAncestors(root.left,num) || printAncestors(root.right,num)){
            System.out.print(root.data);
            return true;
        }        

        return false;
    }

    //Print Range from a BST.
    static public void printRangeofBST(TreeNode root,int left,int right){
        if(root == null)
            return;

        if(root.data > left)
            printRangeofBST(root.left,left,right);
        if(root.data >= left && root.data <= right){
            System.out.print(root.data);
        }
        if(root.data < right)
            printRangeofBST(root.right,left,right);
    }

    //Tournament Tree (Winner Tree) and Binary Heap ????



    //Check if a given Binary Tree is SumTree
    static public Boolean isSumTree(TreeNode root){
        if(root == null)
            return false;

        //leave case.
        if(root.left == null && root.right == null)
            return true;
        int left = 0;
        int right = 0;

        //left is true
        if(root.left != null && isSumTree(root.left)){
            left = root.left;
        }
        //right is true
        if(root.right !- null && isSumTree(root.right)){
            right = root.right;
        }
        if(root.data == 2*(right+left))
            return true;

        return false;
    }

     //Check if a binary tree is subtree of another binary tree. Is a subtree of b. 
    static public Boolean isSubtree(TreeNode a, TreeNode b){
        if(b == null)
            return false;
        if(a == null)
            return true;

        if(a.data == b.data)
            return isIdentical(a,b);
        return (isSubtree(a,b.left) || isSubtree(a,b.left));
    }
    static private Boolean isIdentical(TreeNode a, TreeNode b){
        if(a == null && b == null)
            return true;
        if(a == null || b == null)
            return false;
        if(a.data == b.data)
            return (isIdentical(a.left,b.left) &&
                    isIdentical(a.right,b.right) );
        return false;
    }

    //Sorted Array to Balanced BST
    static public TreeNode convertToTree(ArrayList a){
        if(a == null || a.size()==0)
            return null;

        return sortedArrayToTree(a,0,a.size());
    }

    static private TreeNode sortedArrayToTree(ArrayList a, int left, int right){
        if(left > right)
            return null;

        int mid = (right + left)/2;

        int data = a.get(mid);
        TreeNode root = new TreeNode(data);
        root.left = sortedArrayToTree(a,left,mid-1);
        root.right = sortedArrayToTree(mid+1,right);

        return root;
    }


    //Vertical Sum in a given Binary Tree
    static private void printVerticalSum_helper(TreeNode node,int index, TreeMap<Integer,Integer> verticalSum){
        if(node == null)
            return null;

        if(verticalSum.contains(index)){
            int current = verticalSum.get(index) + node.data;
            verticalSum.put(index,current);
        }

        printVerticalSum(node.left,index-1,verticalSum);
        printVerticalSum(node.right,index+1,verticalSum);
    }

    static public void printVerticalSum(TreeNode node){
        if(node == null)
            return;

        HashMap<Integer,Integer> verticalSum = new  TreeMap<Integer,Integer> ();
        printVerticalSum_helper(node,0,verticalSum);
        for(Integer k : verticalSum.Values())
            System.out.println(k);
    }


    //Check if a given Binary Tree is SumTree
    static public Boolean isSumTree(TreeNode root){
        if(root == null)
            return true;

        int left; 
        int right;
        //a node with only .
        if(isSumTree(root.left) && isSumTree(root.right)){
            if(root.left ==null)
                left=0;
            else if(isLeafNode(root.left))
                left=root.left.data;
            else
                left = 2 * root.left.data;

            if(root.right ==null)
                right=0;
            else if(isLeafNode(root.right))
                right = root.right.data;
            else
                right = 2 * root.right.data;

            if(root.data = left + right)
                return true;
        }

        return false;
    }

    static private Boolean isLeafNode(TreeNode node){
        if(node == null)
            return false;
        if(node.left == null && node.right == null)
            return true;
        return false;
    }



    //Print BST keys in the given range
    static public void printBSTInRange(TreeNode root,int lo, int hi){
        if(root == null)
            return;
        if(root.data > lo)
            printRangeofBST(root.left,lo,hi);
            if(root.data < hi || root.data == hi)
                System.out.print(root.data+" ");
        else if(root.data == lo)
            System.out.print(root.data+" ");
        else
            printRangeofBST(root.right,lo,hi);

        return;
    }


    //Get Level of a node in a Binary Tree
    //getLevelOfTree(root,target,1);
    static public int getLevelOfTree(TreeNode root, int target, int level){
        if(root == null)
            return -1;

        if(root.data == target)
            return level;

        int result = getLevelOfTree(root.left,target,level+1);
        if(result > -1)
            return result;

        return getLevelOfTree(root.right,target,level+1);

    }


    //Find k-th smallest element in BST (Order Statistics in BST)
    static public void printKSmallest(TreeNode root, int k){
        if(root == null)
            return;
        Stack<TreeNode> stackNode = new Stack<TreeNode> ();
        TreeNode tmp = root;
        if(tmp.left != null){
            tmp = tmp.left;
            stackNode.push(tmp);    
        }

        int count = 1;

        while(count < k){
            tmp = stackNode.pop();
            count ++;
        }
    }

    //Inorder Successor in Binary Search Tree
    static public void printNextInoder(TreeNode node){

    }



    //Difference between sums of odd level and even level nodes of a Binary Tree
    static public int difOrderAndEvenLev(TreeNode node){
        if(node == null)
            return 0;

        return node.data - difOrderAndEvenLev(node.left) - difOrderAndEvenLev(node.right);
    }

    //print level order.
    static public void printLevelOrder(TreeNode node){
         if(node == null)
            return;
         Queue queue = new LinkedList();
         TreeNode tmp = node;
         queue.push(tmp);
         while(!queue.empty()){
            tmp = queue.pop();
            System.out.print(tmp+" ");
            if(tmp.left!=null)
                queue.push(tmp.left);
            if(tmp.right!=null)
                queue.push(tmp.right);
         }
    }

    //Print ancestors of a given binary tree node
    static public Boolean printAncestors(TreeNode node, int key){
        Boolean rt;
        if(node == null)
            return false;

        if(node.data == key)
            return true;

        if(node.data > key){
            rt = printAncestors(node.left,key);
            if(rt)
                System.out.print(node.data);
        }
        else{
            rt = printAncestors(node.right,key)
            if(rt)
                 System.out.print(node.data);
        }

        return rt;     
    }

    //Print ancestors of a given binary tree node without recursion
    static public void printAncestors(TreeNode node, int key){
        Stack<TreeNode> stackNode = new Stack<TreeNode>();
        if(node == null)
            return;

        stackNode.push(node);

        while(!stackNode.empty()){
            TreeNode tmp = stackNode.pop();
            if(tmp.data == key){
                break;
            }
            if(tmp.data > key){
                stackNode.push(tmp);
                if(tmp.left != null)
                    stackNode.push(tmp.left);
                else
                    return;//not found
            }else{
                stackNode.push(tmp);
                if(tmp.right != null)
                    stackNode.push(tmp.right);
                else
                    break;//not found
            }
        }
        while(!stackNode.empty()){
            System.out.print(stackNode.pop().data);
        }
    }

    //Convert a given Binary Tree to Doubly Linked List
    static public void convertTreeToDoubleL(TreeNode node){
        if(node == null)
            return;
        Stack<TreeNode> stackNode = new Stack<TreeNode>();
        TreeNode tmp = node;
        stackNode.push(tmp);
        

    }


//Different Ways to Add Parentheses 
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> rt = new ArrayList<Integer>();
        if(input == null || input.length() == 0)
            return rt;
        for(int i=0;i<input.length(); i++){
            char curChar = input.charAt(i);
            if(curChar == '+' || 
                curChar == '-' ||
                curChar == '*'){
                    String part1 = input.substring(0,i);
                    String part2 = input.substring(i+1);
                    List<Integer> p1Rt = diffWaysToCompute(part1);
                    List<Integer> p2Rt = diffWaysToCompute(part2);
                    int tmp = 0;
                    for(Integer p1 : p1Rt){
                         for(Integer p2 : p2Rt){
                             switch(curChar){
                                 case '+': tmp = p1+p2;
                                 break;
                                 case '-': tmp = p1-p2;
                                 break;
                                 case '*': tmp = p1*p2;
                                 break;
                             }
                             rt.add(tmp);
                         }
                    }
                }
        }
        if(rt.size() == 0)
            rt.add(Integer.parseInt(input));
        return rt;
    }
}


}