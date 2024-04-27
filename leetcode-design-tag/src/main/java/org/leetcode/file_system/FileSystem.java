package org.leetcode.file_system;

public class FileSystem {
    private final TrieNode root;

    public FileSystem() {
        root = new TrieNode("");
    }

    //todo: has bug, need to fix later
    public boolean createPath(String path, int value) {
        if (path.equals("/")) {
            root.setFile(true);
            root.setValue(value);
            return true;
        }

        TrieNode curr = root;
        String[] dirs = path.split("/");
        for (String dir : dirs) {
            if (dir.isEmpty()) continue;
            if (!curr.contains(dir)) {
                curr.addChild(new TrieNode(dir));
            }
            curr = curr.getChild(dir);
        }
        if (curr.isFile()) {
            return false; // Path already exists
        }
        curr.setFile(true);
        curr.setValue(value);
        return true;
    }


    public int get(String path) {
        TrieNode curr = root;
        String[] dirs = path.split("/");
        for (String dir : dirs) {
            if (dir.isEmpty()) {
                continue;
            }
            if (!curr.contains(dir)) {
                return -1; // Path doesn't exist
            }
            curr = curr.getChild(dir);
        }
        return curr.isFile() ? curr.getValue() : -1;
    }
}
