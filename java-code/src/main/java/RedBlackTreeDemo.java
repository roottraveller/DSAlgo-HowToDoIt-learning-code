/*
 * Red-Black Tree Rules:
 * 
 * 1. Every node is either red or black.
 * 2. The root is always black.
 * 3. There are no two adjacent red nodes.
 * 4. Every path from a node (including the root) to any of its descendant's NULL nodes has the same number of black nodes.
 * 5. Every leaf (i.e., NULL node) must be colored BLACK.
 */

public class RedBlackTreeDemo {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;

    public RedBlackTreeDemo() {
        root = null;
    }

    public static void main(String[] args) {
        RedBlackTreeDemo tree = new RedBlackTreeDemo();

        // Insert elements into the tree
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(15);
        tree.insert(25);

        // Display the elements in the tree
        System.out.println("Elements in the Red-Black Tree:");
        displayTree(tree.getRoot());
        prettyPrintTree(tree.getRoot());
    }

    // Helper method to recursively display the elements in the tree
    private static void displayTree(Node node) {
        if (node != null) {
            displayTree(node.left);
            System.out.println(node.key);
            displayTree(node.right);
        }
    }

    // Pretty print tree
    private static void prettyPrintTree(Node node) {
        printHelper(node, "", true);
    }

    // Helper method to pretty print the tree
    private static void printHelper(Node node, String indent, boolean last) {
        if (node != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "     ";
            } else {
                System.out.print("L----");
                indent += "|    ";
            }
            String colorString = node.color == RED ? "RED" : "BLACK";
            System.out.println(node.key + "(" + colorString + ")");
            printHelper(node.left, indent, false);
            printHelper(node.right, indent, true);
        }
    }

    private Node getRoot() {
        return root;
    }

    // Rotate left
    private void rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    // Rotate right
    private void rotateRight(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != null) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    // Insertion
    public void insert(int key) {
        Node newNode = new Node(key);
        Node parent = null;
        Node current = root;
        while (current != null) {
            parent = current;
            if (key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        newNode.parent = parent;
        if (parent == null) {
            root = newNode;
        } else if (key < parent.key) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        fixInsertion(newNode);
    }

    // Fix insertion
    private void fixInsertion(Node x) {
        while (x != root && x.parent.color == RED) {
            if (x.parent == x.parent.parent.left) {
                Node y = x.parent.parent.right;
                if (y != null && y.color == RED) {
                    x.parent.color = BLACK;
                    y.color = BLACK;
                    x.parent.parent.color = RED;
                    x = x.parent.parent;
                } else {
                    if (x == x.parent.right) {
                        x = x.parent;
                        rotateLeft(x);
                    }
                    x.parent.color = BLACK;
                    x.parent.parent.color = RED;
                    rotateRight(x.parent.parent);
                }
            } else {
                Node y = x.parent.parent.left;
                if (y != null && y.color == RED) {
                    x.parent.color = BLACK;
                    y.color = BLACK;
                    x.parent.parent.color = RED;
                    x = x.parent.parent;
                } else {
                    if (x == x.parent.left) {
                        x = x.parent;
                        rotateRight(x);
                    }
                    x.parent.color = BLACK;
                    x.parent.parent.color = RED;
                    rotateLeft(x.parent.parent);
                }
            }
        }
        root.color = BLACK;
    }

    private class Node {
        int key;
        boolean color;
        Node left, right, parent;

        public Node(int key) {
            this.key = key;
            this.color = RED;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }
}
