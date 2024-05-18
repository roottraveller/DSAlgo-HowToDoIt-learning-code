package org.leetcode.in_memory_file_system_588;


public class Main {

    // https://leetcode.ca/all/588.html
    public static void main(String[] args) {
        FileSystem fs = new FileSystem();
        System.out.println(fs.ls("/"));  // []
        fs.mkdir("/a/b/c");
        fs.addContentToFile("/a/b/c/d", "hello");
        fs.addContentToFile("/a/b/c/d", "hello2");
        System.out.println(fs.ls("/"));  // ["a"]
        System.out.println(fs.readContentFromFile("/a/b/c/d"));  // "hello" "hello2"
        fs.mkdir("/a/b2");
        System.out.println(fs.ls("/a"));  // [b, b2]
    }
}