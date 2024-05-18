package org.leetcode.search_autocomplete_642;

import java.util.*;

public class AutocompleteSystem {
    private final TrieNode root = new TrieNode();
    private final int TOP_K = 3;
    private String currentSentence = "";

    public AutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i++) {
            addSentence(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
            addSentence(currentSentence, 1);
            currentSentence = "";
            return Collections.emptyList();
        }

        currentSentence += c;
        TrieNode node = root;
        for (char cc : currentSentence.toCharArray()) {
            if (!node.childrenMap.containsKey(cc)) {
                return Collections.emptyList();
            }
            node = node.childrenMap.get(cc);
        }
        return getTopSentences(node);
    }

    private void addSentence(String sentence, int times) {
        TrieNode node = root;
        for (char c : sentence.toCharArray()) {
            if (!node.childrenMap.containsKey(c)) {
                node.childrenMap.put(c, new TrieNode());
            }
            node = node.childrenMap.get(c);

            // Update the frequency of the sentence
            node.sentenceFrequencyMap.put(sentence, node.sentenceFrequencyMap.getOrDefault(sentence, 0) + times);
        }

    }

    private List<String> getTopSentences(TrieNode node) {
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(
                (a, b) -> Objects.equals(a.getValue(), b.getValue())
                        ? a.getKey().compareTo(b.getKey())
                        : a.getValue() - b.getValue()
        );

        for (Map.Entry<String, Integer> entry : node.sentenceFrequencyMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > TOP_K) {
                minHeap.poll();
            }
        }

        List<String> topKResult = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            topKResult.add(minHeap.poll().getKey());
        }

        Collections.reverse(topKResult);
        return topKResult;
    }
}