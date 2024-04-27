package org.leetcode.file_system;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class TrieNode {
    private String name;
    private boolean isFile;
    private int value;
    private Map<String, TrieNode> children;

    public TrieNode(String name) {
        this.name = name;
        this.isFile = false;
        this.value = 0;
        this.children = new HashMap<>();
    }

    public List<TrieNode> getChildren() {
        return new ArrayList<>(children.values());
    }

    public boolean contains(String name) {
        return children.containsKey(name);
    }


    public void addChild(TrieNode child) {
        children.put(child.getName(), child);
    }

    public TrieNode getChild(String name) {
        return children.get(name);
    }
}