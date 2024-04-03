import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheDemo2<K, V> {
    private final int capacity;
    private final LinkedHashMap<K, V> cache;

    public LRUCacheDemo2(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > capacity;
            }
        };
    }

    public static void main(String[] args) {
        LRUCacheDemo2<Integer, String> cache = new LRUCacheDemo2<>(3);

        cache.put(1, "one");
        cache.put(2, "two");
        cache.put(3, "three");
        cache.printCacheState(); // Output: 1 : one, 2 : two, 3 : three

        cache.get(2); // Accessing key 2
        cache.printCacheState(); // Output: 1 : one, 3 : three, 2 : two (2 is moved to the end)

        cache.put(4, "four"); // Adding new key-value pair, which evicts the least recently used key-value pair (1 : one)
        cache.printCacheState(); // Output: 3 : three, 2 : two, 4 : four
    }

    public synchronized V get(K key) {
        return cache.get(key);
    }

    public synchronized void put(K key, V value) {
        cache.put(key, value);
    }

    public synchronized void printCacheState() {
        System.out.println("Current cache state:");
        for (Map.Entry<K, V> entry : cache.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println();
    }
}
