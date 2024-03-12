import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHashing2 {

    private final SortedMap<Integer, String> circle = new TreeMap<>();
    private final List<String> nodes = new ArrayList<>();
    private final int numberOfReplicas; // Replicas for each node

    public ConsistentHashing2(int numberOfReplicas, List<String> nodes) {
        this.numberOfReplicas = numberOfReplicas;
        this.nodes.addAll(nodes);

        // Populate the circle with nodes and replicas
        for (String node : nodes) {
            addNode(node);
        }
    }

    private void addNode(String node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            String virtualNode = getVirtualNode(node, i);
            int hash = hash(virtualNode);
            circle.put(hash, virtualNode);
        }
    }

    private static String getVirtualNode(String node, int i) {
        return node + "_" + i;
    }

    private void deleteNode(String node) {
        for (int i = 0; i < numberOfReplicas; ++i) {
            String virtualNode = getVirtualNode(node, i);
            int hash = hash(virtualNode);
            circle.remove(hash);
        }
    }

    // Hash function using SHA-1
    private int hash(String key) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] digest = md.digest(key.getBytes());
            return ((digest[0] & 0xff) << 24) | ((digest[1] & 0xff) << 16) | ((digest[2] & 0xff) << 8) | (digest[3] & 0xff);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Hashing algorithm not found.", e);
        }
    }

    // Get the node responsible for the given key
    public String getNode(String key) {
        if (circle.isEmpty()) {
            return null;
        }

        int hash = hash(key);
        if (!circle.containsKey(hash)) {
            SortedMap<Integer, String> tailMap = circle.tailMap(hash);
            hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }

        return circle.get(hash);
    }

    public static void main(String[] args) {
        List<String> nodes = List.of("NodeA", "NodeB", "NodeC");

        ConsistentHashing2 ch = new ConsistentHashing2(3, nodes);

        String key1 = "key1";
        String key67890 = "key67890";
        System.out.println("key1 is assigned to node: " + ch.getNode(key1));
        System.out.println("key67890 is assigned to node: " + ch.getNode(key67890));

        ch.addNode("NodeD");
        System.out.println("key1 is assigned to node: " + ch.getNode(key1));
        System.out.println("key67890 is assigned to node: " + ch.getNode(key67890));

        ch.deleteNode("NodeC");
        System.out.println("key1 is assigned to node: " + ch.getNode(key1));
        System.out.println("key67890 is assigned to node: " + ch.getNode(key67890));
    }
}