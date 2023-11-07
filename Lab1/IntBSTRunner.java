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
        System.out.println("Number of levels is " + bst.getNumLevels());
    }
}
