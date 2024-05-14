public class BubbleSort {

    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (array[j] > array[j+1]) {
                    // Swap array[j] and array[j+1]
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

  public static void bubbleSort(List<String> list) {
        int n = list.size();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                // Compare adjacent elements and swap if they are in the wrong order
                if (list.get(j).compareTo(list.get(j+1)) > 0) { // Or compareToIgnoreCase
                    // Swap list.get(j) and list.get(j+1)
                    String temp = list.get(j);
                    list.set(j, list.get(j+1)); // IMP: set 
                    list.set(j+1, temp);
                }
            }
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
        bubbleSort(array);
        System.out.println("Sorted array:");
        printArray(array);

        List<String> list = List.of("banana", "apple", "orange", "grape", "pineapple");
        bubbleSort(list);
        System.out.println("Sorted list:");
        System.out.println(list);
    }
}
