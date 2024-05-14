import java.util.List;

public class SelectionSort {

    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap array[i] and array[minIndex]
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    public static void selectionSort(List<String> list) {
        int n = list.size();
        for (int i = 0; i < n-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                // Compare adjacent elements and find the index of the smallest element
                if (list.get(j).compareTo(list.get(minIndex)) < 0) { // Or compareToIgnoreCase
                    minIndex = j;
                }
            }
            // Swap list.get(i) and list.get(minIndex)
            String temp = list.get(i);
            list.set(i, list.get(minIndex));
            list.set(minIndex, temp);
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        selectionSort(array);
        System.out.println("Sorted array:");
        printArray(array);

        List<String> list = List.of("banana", "apple", "orange", "grape", "pineapple");
        selectionSort(list);
        System.out.println("Sorted list:");
        System.out.println(list);
    }
}
