/**
 * Created by jiazhangliu on 4/23/15.
 */

class Node {
    Node left;
    Node right;
    Node parent;
    int val;

    public Node(int value) {
        val = value;
    }
}

public class LowestCommonAncestorOfBinaryTree {
    public Node BST (Node root, Node n1, Node n2) {
        if(root == null || n1 == null || n2 == null) {
            return null;
        }

        if(Math.max(n1.val, n2.val) < root.val) {
            return BST(root.left, n1,n2);
        } else if (Math.min(n1.val, n2.val) > root.val) {
            return BST(root.right, n1,n2);
        } else {
            return root;
        }
    }

    // bottom up approach O(n) time complexity because we essentially need to traverse every node
    public Node BinaryTreeWithOnlyPointerDownwards(Node root, Node n1, Node n2) {
        if(root == null || n1 == null || n2 == null) {
            return null;
        } else if(root == n1 || root == n2) {
            return root;
        }
        // if we didn't find anything on left, we know n1,n2 are on right side
        if (BinaryTreeWithOnlyPointerDownwards(root.left, n1, n2) == null) {
            return BinaryTreeWithOnlyPointerDownwards(root.right, n1, n2);
        } else if (BinaryTreeWithOnlyPointerDownwards(root.right, n1, n2) == null) {
            // similar reason, if null return from right, we know n1,n2 are all on left
            return BinaryTreeWithOnlyPointerDownwards(root.left, n1, n2);
        } else {
            // if above two conditions fail, we know we find n1 and n2 on both sides, and the
            // first node is their common ancestor!!
            return root;
        }
    }

    public Node WithParentPointerUpwards(Node root, Node n1, Node n2) {
        int h1 = getHeight(n1);
        int h2 = getHeight(n2);

        int heightDifference = Math.abs(h1-h2);

        if(h1 > h2) {
            Node temp = n1;
            n1 = n2;
            n2 = temp;
        }

        for(int height = 0; height < heightDifference; height++) {
            n2 = n2.parent;
        }

        while(n1!= null && n2 != null) {
            if(n1 == n2) return n1;
            n1 = n1.parent;
            n2 = n2.parent;
        }

        return null;
    }

    int getHeight(Node node) {
        int height = 0;
        while(node != null) {
            height++;
            node = node.parent;
        }

        return height;
    }
}

