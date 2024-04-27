package org.leetcode.in_memory_file_system;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FileSystem {
    private final TrieNode root;

    public FileSystem() {
        root = new TrieNode("");
    }

    public List<String> ls(String path) {
        TrieNode node = traverse(path);
        if (node.isFile()) {
            return Collections.singletonList(node.getName());
        } else {
            List<String> contents = new ArrayList<>();
            for (TrieNode child : node.getChildren()) {
                contents.add(child.getName());
            }
            Collections.sort(contents);
            return contents;
        }
    }

    public void mkdir(String path) {
        traverse(path);
    }

    public void addContentToFile(String filePath, String content) {
        TrieNode node = traverse(filePath);
        node.appendContent(content);
    }

    public String readContentFromFile(String filePath) {
        TrieNode node = traverse(filePath);
        return node.getContent().toString();
    }

    private TrieNode traverse(String path) {
        String[] dirs = path.split("/");
        TrieNode curr = root;
        for (String dir : dirs) {
            if (dir.isEmpty()) {
                continue;
            }
            if (!curr.contains(dir)) {
                curr.addChild(new TrieNode(dir));
            }
            curr = curr.getChild(dir);
        }
        return curr;
    }
}