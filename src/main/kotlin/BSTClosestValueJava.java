public class BSTClosestValueJava {

     /*

      tree ->       10

              5           15

           2    6      13      22

        1                14

        target = 12

     */

    class BST{
        int value;
        BST left = null;
        BST right = null;
        BST(int value) {
            this.value = value;
        }
    }

    int findClosestValueInBst(BST tree, int target) {
        return -1;
    }


    BST createBST(){
        BST root = new BST(10);
        root.left = new BST(5);
        root.right = new BST(15);
        root.left.left = new BST(2);
        root.left.right = new BST(6);
        root.left.left.left = new BST(1);
        root.right.left = new BST(13);
        root.right.right = new BST(22);
        root.right.left.right = new BST(14);
        return root;
    }

}
