package org.leetcode.search_autocomplete_642;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    Map<Character, TrieNode> childrenMap;
    Map<String, Integer> sentenceFrequencyMap; // Map each sentence to its frequency

    public TrieNode() {
        childrenMap = new HashMap<>();
        sentenceFrequencyMap = new HashMap<>();
    }
}