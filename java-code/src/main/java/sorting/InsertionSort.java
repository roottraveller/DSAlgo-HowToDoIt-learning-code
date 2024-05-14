import java.util.List;

public class InsertionSort {

    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static void insertionSort(List<String> list) {
        int n = list.size();
        for (int i = 1; i < n; i++) {
            String key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j).compareTo(key) > 0) { // Or compareToIgnoreCase
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
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
        insertionSort(array);
        System.out.println("Sorted array:");
        printArray(array);

        List<String> list = List.of("banana", "apple", "orange", "grape", "pineapple");
        insertionSort(list);
        System.out.println("Sorted list:");
        System.out.println(list);
    }
}
