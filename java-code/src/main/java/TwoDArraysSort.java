import java.util.Arrays;
import java.util.Comparator;

/*
 * Comparator
 *     ├── compare(T o1, T o2)
 *     ├── equals(Object obj)
 *     └── reversed()
 */

/*
 * Comparable
 *     └── compareTo(T o)
 */

public class TwoDArraysSort {
    public static void main(String[] args) {
        testMixedSorting();
        testIntegerSorting();
    }

    private static void testMixedSorting() {
        String[][] data = {
                {"300", "user_1", "resource_3"},
                {"599", "user_1", "resource_1"},
                {"100", "user_1", "resource_3"},
                {"1199", "user_1", "resource_2"},
                {"1200", "user_1", "resource_3"},
                {"1201", "user_1", "resource_2"},
                {"1202", "user_1", "resource_1"}
        };

         // Sorting based on resource then second column value
        Arrays.sort(data, (a, b) -> {
            if (a[2].compareTo(b[2]) == 0) {
                return Integer.parseInt(a[0]) - Integer.parseInt(b[0]);
            }
            return a[2].compareTo(b[2]);
        });

        System.out.println("Sorted on resource then value");
        for (String[] row : data) {
            for (String cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    private static void testIntegerSorting() {
        Integer[][] data = {
                {0, 10}, {10, 9}, {2, 9}, {3, 9}, {4, 15}, {5, 10}, {6, 4}
        };

        System.out.println("Unsorted array");
        for (Integer[] elem : data) {
            System.out.println("{" + elem[0] + "," + elem[1] + "}");
        }

        // Sorting based on first column
        Arrays.sort(data, Comparator.comparing(arr -> arr[0]));
        System.out.println("Sorted on first column");
        for (Integer[] elem : data) {
            System.out.println("{" + elem[0] + "," + elem[1] + "}");
        }

        // Sorting based on second column
        Arrays.sort(data, Comparator.comparing(arr -> arr[1]));
        System.out.println("Sorted on second column");
        for (Integer[] elem : data) {
            System.out.println("{" + elem[0] + "," + elem[1] + "}");
        }
    }
}
