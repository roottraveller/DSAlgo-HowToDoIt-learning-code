package org.leetcode.file_system_1166;



public class Main {

    //https://leetcode.ca/2019-02-08-1166-Design-File-System/
    public static void main(String[] args) {
        FileSystem fs = new FileSystem();
        System.out.println(fs.createPath("/a", 1)); // true
        System.out.println(fs.get("/a")); // 1
        System.out.println(fs.createPath("/leet", 1)); // true
        System.out.println(fs.createPath("/leet/code", 2)); // true
        System.out.println(fs.get("/leet/code")); // 2
        System.out.println(fs.createPath("/c/d", 1)); // false
        System.out.println(fs.get("/c")); // -1
    }
}