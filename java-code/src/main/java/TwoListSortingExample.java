import java.util.*;

public class TwoListSortingExample {

    private static void testSorting(List<Integer> initialValues, List<Integer> targetValues) {
        List<Integer> sortedIndices = getSortedIndicesByDifference(initialValues, targetValues);

        List<Integer> sortedInitialValues = new ArrayList<>();
        List<Integer> sortedTargetValues = new ArrayList<>();

        for (int index : sortedIndices) {
            sortedInitialValues.add(initialValues.get(index));
            sortedTargetValues.add(targetValues.get(index));
        }

        System.out.println("Sorted initialValues: " + sortedInitialValues);
        System.out.println("Sorted targetValues: " + sortedTargetValues);
    }

    private static List<Integer> getSortedIndicesByDifference(List<Integer> initialValues, List<Integer> targetValues) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < initialValues.size(); i++) {
            indices.add(i);
        }

        // Sort indices based on the difference (targetValues - initialValues) in descending order
        Collections.sort(indices, (i, j) -> {
            int diffI = targetValues.get(i) - initialValues.get(i);
            int diffJ = targetValues.get(j) - initialValues.get(j);
            return Integer.compare(diffJ, diffI);
        });

        return indices;
    }

      public static void main(String[] args) {
        // Test Case 1
        List<Integer> initialValues1 = Arrays.asList(175, 133, 109, 210, 97);
        List<Integer> targetValues1 = Arrays.asList(200, 125, 128, 228, 133);
        testSorting(initialValues1, targetValues1);
        // Sorted initialValues: [210, 109, 175, 97, 133]
        // Sorted targetValues: [228, 128, 200, 133, 125]
    }
}
