import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class Node {
    String key;
    String value;
    Node left, right;

    public Node(String key, String value) {
        this.key = key;
        this.value = value;
        this.left = this.right = null;
    }
}

/**
 * https://highscalability.com/consistent-hashing-algorithm/#:~:text=Consistent%20hashing%20is%20a%20distributed,of%20nodes%20changes%20%5B4%5D
 */
public class ConsistentHashingBST {
    private Node root;

    public static void main(String[] args) {
        ConsistentHashingBST chBST = new ConsistentHashingBST();

        String key1 = "key1";
        String key67890 = "key67890";
        String key54321 = "key54321";
        // Add nodes to the consistent hashing BST
        chBST.addNode("NodeA", key1);
        chBST.addNode("NodeB", key67890);
        chBST.addNode("NodeC", key54321);

        System.out.println("key1 is assigned to node: " + chBST.getNode(key1));
        System.out.println("key67890 is assigned to node: " + chBST.getNode(key67890));
        System.out.println("key54321 is assigned to node: " + chBST.getNode(key54321));
    }

    // Add a new node to the BST
    public void addNode(String key, String value) {
        int hash = hash(key);
        root = addNodeRec(root, hash, key, value);
    }

    private Node addNodeRec(Node root, int hash, String key, String value) {
        // If the current node is null, create a new node
        if (root == null) {
            return new Node(key, value);
        }

        // Decide whether to go left or right based on hash values
        if (hash < hash(root.key)) {
            root.left = addNodeRec(root.left, hash, key, value);
        } else {
            root.right = addNodeRec(root.right, hash, key, value);
        }

        return root;
    }

    // Get the node responsible for a given key
    public String getNode(String key) {
        int hash = hash(key);
        return getNodeRec(root, hash);
    }

    private String getNodeRec(Node root, int hash) {
        // If the current node is null, return null
        if (root == null) {
            return null;
        }

        // Decide whether to go left or right based on hash values
        if (hash < hash(root.key)) {
            return getNodeRec(root.left, hash);
        } else if (hash >= hash(root.key) && (root.right == null || hash < hash(root.right.key))) {
//            return root.value;
            return root.key;
        } else {
            return getNodeRec(root.right, hash);
        }
    }

    // Hashing function using SHA-1
    private int hash(String key) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] digest = md.digest(key.getBytes());
            return ((digest[0] & 0xff) << 24)
                    | ((digest[1] & 0xff) << 16)
                    | ((digest[2] & 0xff) << 8)
                    | (digest[3] & 0xff);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Hashing algorithm not found.", e);
        }
    }
}
