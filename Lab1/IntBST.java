// Your Name
// Samuel Zhang

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

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
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(TreeNode tree) {
        if (tree != null) {
            System.out.print(tree.value + " ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(TreeNode tree) {
        if (tree != null) {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.print(tree.value + " ");
        }
    }

    public void revOrder() {
        revOrder(root);
    }

    private void revOrder(TreeNode tree) {
        if (tree != null) {
            revOrder(tree.right);
            System.out.print(tree.value + " ");
            revOrder(tree.left);
        }
    }
    
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
    public int getNumLeaves() {
        return getNumLeaves(root);
    }

    private int getNumLeaves(TreeNode tree) {
        if (tree == null) {
            return 0;
        }
        if (tree.left == null && tree.right == null) {
            return 1;
        }
        return getNumLeaves(tree.left) + getNumLeaves(tree.right);
    }



    public int getWidth() {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> level = new LinkedList<TreeNode>();
        Queue<TreeNode> children = new LinkedList<TreeNode>();
        int max = 1;
        level.add(root);

        while (!level.isEmpty()) {
            TreeNode tree = level.remove();
            if (tree.left != null) {
                children.add(tree.left);
            }
            if (tree.right != null) {
                children.add(tree.right);
            }
            if (level.isEmpty()) {
                if (children.size() > max) {
                    max = children.size();
                }
                while (!children.isEmpty()) {
                    level.add(children.remove());
                }
            }
        }

        return max;
    }


    public int getHeight() {
        return getNumLevels() - 1;
    }


    public int getNumNodes() {
        return getNumNodes(root);
    }

    private int getNumNodes(TreeNode tree) {
        if (tree != null) {
            return 1 + getNumNodes(tree.left) + getNumNodes(tree.right);
        }
        return 0;
    }


    @Override
    public String toString() {
        return toString(new StringBuilder(), root);
    }

    private String toString(StringBuilder result, TreeNode tree) {
        if (tree != null) {
            toString(result, tree.left);
            result.append(tree.value + " ");
            toString(result, tree.right);
        }
        return result.toString();
    }

    public boolean isFull() {
        return isFull(root);
    }

    private boolean isFull(TreeNode tree) {
        if (tree != null) {
            if (tree.left == null && tree.right != null || tree.left != null && tree.right == null) {
                return false;
            }
            return isFull(tree.left) && isFull(tree.right);
        }
        return true;
    }

    // add search, getLargest, getSmallest, levelOrder, remove, displayTree here
    public boolean search(int value) {
        return search(root, value);
    }

    private boolean search(TreeNode tree, int value) {
        if (tree != null) {
            if (tree.value == value) {
                return true;
            }
            if (tree.value > value) {
                return search(tree.left, value);
            }
            return search(tree.right, value);
        }
        return false;
    }

    public int getLargest() {
        TreeNode tree = root;
        if (tree != null) {
            while (tree.right != null) {
                tree = tree.right;
            }
            return tree.value;
        }
        throw new NoSuchElementException();
    }

    public int getSmallest() {
        TreeNode tree = root;
        if (tree != null) {
            while (tree.left != null) {
                tree = tree.left;
            }
            return tree.value;
        }
        throw new NoSuchElementException();
    }

    public void levelOrder() {
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                System.out.print(node.value + " ");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }

    public void remove(int value) {
        TreeNode tree = root;
        while (tree != null && tree.value != value) {
            if (tree.value < value) {
                tree = tree.left;
            }
            else {
                tree = tree.right;
            }
        }
    }


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