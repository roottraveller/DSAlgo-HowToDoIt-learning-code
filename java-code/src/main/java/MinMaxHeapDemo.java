import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

/*
 * Minimum Heap                Maximum Heap
 * ------------                ------------
 *         1                           7
 *       /   \                       /   \
 *      3     2                     6     5
 *     / \   / \                   / \   / \
 *    5   4 6   7                 4   3 2   1
 */

public class MinMaxHeapDemo {
    private static final int HEAP_SIZE = 10; // size of heap

    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(HEAP_SIZE);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(HEAP_SIZE, Collections.reverseOrder());

        Random random = new Random();
        for (int i = 1; i <= HEAP_SIZE; ++i) {
            int data = random.nextInt(100) + 1; // number between 1 to 100
            minHeap.add(data);
            maxHeap.add(data);
        }

        System.out.println("MIN Heap : ");
        prettyPrintHeap(minHeap);

        System.out.println("\nMAX Heap : ");
        prettyPrintHeap(maxHeap);
    }

    private static void prettyPrintHeap(PriorityQueue<Integer> heap) {
        int level = 0;
        int elementsInLevel = 1;

        while (!heap.isEmpty()) {
            int elementsPrinted = 0;
            int elementsToPrint = Math.min(elementsInLevel, heap.size());
            StringBuilder levelString = new StringBuilder();

            while (elementsPrinted < elementsToPrint) {
                int num = heap.poll();
                levelString.append(num).append(" ");
                elementsPrinted++;
            }

            System.out.println(levelString.toString().trim());
            level++;
            elementsInLevel *= 2;
        }
    }
}
