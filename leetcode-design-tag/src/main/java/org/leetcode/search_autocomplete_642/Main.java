package org.leetcode.search_autocomplete_642;

public class Main {

    public static void main(String[] args) {
        AutocompleteSystem autocompleteSystem = new AutocompleteSystem(
                new String[]{"i love you", "island", "iroman", "i love leetcode"},
                new int[]{5, 3, 2, 2}
        );
        System.out.println(autocompleteSystem.input('i')); // ["i love you", "island", "i love leetcode"]
        System.out.println(autocompleteSystem.input(' ')); // ["i love you", "i love leetcode"]
        System.out.println(autocompleteSystem.input('a')); // []
        System.out.println(autocompleteSystem.input('#')); // []
    }
}
