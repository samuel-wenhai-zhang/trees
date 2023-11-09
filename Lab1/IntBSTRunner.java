public class IntBSTRunner {
    public static void main(String[] args) {
        IntBST bst = new IntBST();
        String input = "90 100 80 98 85 70 120";
        for(String i : input.split(" ")) {
            bst.add(Integer.parseInt(i));
        }
        System.out.println("IN ORDER");
        bst.inOrder();
        System.out.println();

        System.out.println("PRE ORDER");
        bst.preOrder();
        System.out.println();

        System.out.println("POST ORDER");
        bst.postOrder();
        System.out.println();

        System.out.println("REVERSE ORDER");
        bst.revOrder();
        System.out.println();

        System.out.println("Tree height is " + bst.getHeight());
        System.out.println("Tree width is " + bst.getWidth());

        System.out.println("Number of leaves is " + bst.getNumLeaves());
        System.out.println("Number of nodes is " + bst.getNumNodes());
        System.out.println("Number of levels is " + bst.getNumLevels());

        System.out.println("Tree as a string " + bst.toString());
        
        System.out.println(bst.isFull() ? "The tree is full." : "The tree is not full.");

        System.out.println(bst.search(100) ? "The tree contains 100!" : "The tree does not contains 100!");
        System.out.println(bst.search(114) ? "The tree contains 114!" : "The tree does not contain 114!");        
        
        System.out.println("The smallest tree node " + bst.getSmallest());
        System.out.println("The largest tree node " + bst.getLargest());
        System.out.println("Tree before removing any nodes - using level order traversal.");
        bst.levelOrder();
    }
}
