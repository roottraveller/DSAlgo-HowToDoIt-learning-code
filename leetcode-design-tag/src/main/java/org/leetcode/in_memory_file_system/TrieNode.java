package org.leetcode.in_memory_file_system;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class TrieNode {
    private String name;
    private boolean isFile;
    private StringBuilder content;
    private Map<String, TrieNode> children;

    public TrieNode(String name) {
        this.name = name;
        this.isFile = false;
        this.content = new StringBuilder();
        this.children = new HashMap<>();
    }

    public List<TrieNode> getChildren() {
        return new ArrayList<>(children.values());
    }

    public boolean contains(String name) {
        return children.containsKey(name);
    }

    public void appendContent(String content) {
        if (!this.content.isEmpty()) {
            this.content.append(" ");
        }
        this.content.append(content);
    }

    public void addChild(TrieNode child) {
        children.put(child.getName(), child);
    }

    public TrieNode getChild(String name) {
        return children.get(name);
    }
}