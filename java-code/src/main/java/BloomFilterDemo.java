import java.util.BitSet;
import java.util.function.Function;

/*
 * The Bloom Filter is a probabilistic data structure used for membership testing, particularly in cases where the
 * data set is large and access to individual elements needs to be fast. it may return false positives, meaning it 
 * may incorrectly indicate that an element is a member of the set when it's not, but it will never return false negatives. 
 * 
 */

public class BloomFilterDemo<T> {
    private final BitSet bitSet;
    private final int size;
    private final int[] hashSeeds;
    private final Function<T, Integer>[] hashFunctions;

    public BloomFilterDemo(int size, int[] hashSeeds, Function<T, Integer>[] hashFunctions) {
        this.size = size;
        this.bitSet = new BitSet(size);
        this.hashSeeds = hashSeeds;
        this.hashFunctions = hashFunctions;
    }

    public static void main(String[] args) {
        int size = 100;
        int[] hashSeeds = {17, 31};
        // Creating a BloomFilter for strings
        BloomFilterDemo<String> bloomFilter = new BloomFilterDemo<>(size, hashSeeds, new Function[]{
                // Define hash functions using hash codes and hash seeds
                item -> item.hashCode() + hashSeeds[0],
                item -> item.hashCode() + hashSeeds[1]
        });

        // Adding elements to the Bloom filter
        bloomFilter.add("hello");
        bloomFilter.add("world");

        // Checking for membership
        System.out.println(bloomFilter.contains("hello")); // Output: true
        System.out.println(bloomFilter.contains("world")); // Output: true
        System.out.println(bloomFilter.contains("java"));  // Output: false (might be a false positive)
    }

    public void add(T item) {
        for (Function<T, Integer> hashFunction : hashFunctions) {
            int hash = hashFunction.apply(item);
            int index = Math.abs(hash % size);
            bitSet.set(index, true);
        }
    }

    public boolean contains(T item) {
        for (Function<T, Integer> hashFunction : hashFunctions) {
            int hash = hashFunction.apply(item);
            int index = Math.abs(hash % size);
            if (!bitSet.get(index)) {
                return false;
            }
        }
        return true;
    }
}
