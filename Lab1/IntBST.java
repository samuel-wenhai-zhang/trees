// Your Name
//

public class IntBST {

    private TreeNode root;

    public IntBST() {
        root = null;
    }

    public void add(int value) {
        root = add(value, root);
    }

    private TreeNode add(int value, TreeNode tree) {
        if(tree == null) {
            tree = new TreeNode(value, null, null); 
        }

        else if(value < tree.value) {
            tree.left = add(value, tree.left);
        }

        else if(value > tree.value) {
            tree.right = add(value, tree.right);
        }

        return tree;
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(TreeNode tree) {
        if(tree != null) {
            inOrder(tree.left);
            System.out.print(tree.value + " ");
            inOrder(tree.right);
        }
    }


    // add preOrder, postOrder, and revOrder


    
    public int getNumLevels() {
		return getNumLevels(root);
	}

	private int getNumLevels(TreeNode tree) {
		if(tree==null)
			return 0;
		else if(getNumLevels(tree.left) >getNumLevels(tree.right))
			return 1+getNumLevels(tree.left);
		else
			return 1+getNumLevels(tree.right);
	}


    // add getNumLeaves, getWidth, getHeight, getNumNodes, toString, and isFull here
















    // add search, getLargest, getSmallest, levelOrder, remove, displayTree here






    private static class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }




}