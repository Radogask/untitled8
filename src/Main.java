class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    int count = 0;

    int kthSmallestElement(Node node, int k) {
        if (node == null) {
            return -1;
        }

        int leftResult = kthSmallestElement(node.left, k);
        if (leftResult != -1) {
            return leftResult;
        }

        count++;
        if (count == k) {
            return node.data;
        }

        return kthSmallestElement(node.right, k);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(5);
        tree.root.left = new Node(3);
        tree.root.right = new Node(7);
        tree.root.left.left = new Node(2);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(8);

        int k = 3;
        int kthSmallest = tree.kthSmallestElement(tree.root, k);

        System.out.println(k + "-й наименьший элемент: " + kthSmallest);
    }
}