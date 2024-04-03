import java.util.ArrayList;
import java.util.List;


public class PermutationGenerator<T> {

    public static void main(String[] args) {
        List<String> permutations = new ArrayList<>();
        // Example usage with integer array
        Integer[] intArr = {1, 2, 3};
        generatePermutations(intArr, 0, permutations);
        for (String permutation : permutations) {
            System.out.println(permutation);
        }

        // Example usage with character array
        permutations.clear();
        Character[] charArr = {'a', 'b', 'c'};
        generatePermutations(charArr, 0, permutations);
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }

    public static <T> void generatePermutations(T[] arr, int idx, List<String> permutations) {
        if (idx == arr.length - 1) {
            permutations.add(arrayToString(arr));
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            swap(arr, idx, i);
            generatePermutations(arr, idx + 1, permutations);
            swap(arr, idx, i);
        }
    }

    public static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static <T> String arrayToString(T[] arr) {
        StringBuilder sb = new StringBuilder();
        for (T item : arr) {
            sb.append(item).append(" ");
        }
        return sb.toString().trim();
    }
}
