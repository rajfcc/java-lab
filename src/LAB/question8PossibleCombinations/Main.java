package LAB.question8PossibleCombinations;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        List<List<Integer>> result = generateCombinations(array);

        // Print the result
        System.out.println("Combinations:");
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }

    public static List<List<Integer>> generateCombinations(int[] array) {
        List<List<Integer>> result = new ArrayList<>();
        generateCombinationsHelper(array, 0, new ArrayList<>(), result);
        return result;
    }

    private static void generateCombinationsHelper(int[] array, int index, List<Integer> current, List<List<Integer>> result) {
        // Add the current combination to the result list
        result.add(new ArrayList<>(current));

        // Generate all combinations that include the current element
        for (int i = index; i < array.length; i++) {
            current.add(array[i]);
            generateCombinationsHelper(array, i + 1, current, result);
            current.remove(current.size() - 1); // Backtrack
        }
    }
}
