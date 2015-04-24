/**
 * Created by jiazhangliu on 4/23/15.
 */
public class Main {
    public static void main(String args[]) {
        LowestCommonAncestorOfBinaryTree tree = new LowestCommonAncestorOfBinaryTree();

        Node root = new Node(5);
        Node left = new Node(3);
        Node right = new Node(7);
        root.left = left;
        root.right = right;
        left.parent = root;
        right.parent = root;

        Node left1 = new Node(2);
        Node right1 = new Node(4);
        left.left = left1;
        left.right = right1;
        left1.parent = left;
        right1.parent = left;

        Node left2 = new Node(6);
        Node right2 = new Node(9);
        right.left = left2;
        right.right = right2;
        left2.parent = right;
        right2.parent = right;

        Node left3 = new Node(1);
        Node right3 = new Node(8);
        left1.left = left3;
        left3.parent = left1;
        right2.left = right3;
        right3.parent = right2;

        /*
        *                         5
        *                    3         7
        *                 2    4    6     9
         *               1               8
        *
         */

        Node common = tree.BST(root, left3, right3);
        System.out.println(common.val); // 5

        common = tree.BinaryTreeWithOnlyPointerDownwards(root, left2, right3);
        System.out.println(common.val); // 7

        common = tree.WithParentPointerUpwards(root, right3, right2);
        System.out.println(common.val); // 9s
    }
}
