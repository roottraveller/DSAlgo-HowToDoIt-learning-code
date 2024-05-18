package org.leetcode.text_editor_with_cursor_2296;

public class Main {

    public static void main(String[] args) {
//        TextEditorWithTwoStack editor = new TextEditorWithTwoStack();
        TextEditorWithTwoDeque editor = new TextEditorWithTwoDeque();

        // Execute the series of commands as specified in the input
        editor.addText("leetcode");
        System.out.println(editor.deleteText(4)); // Output should be 4
        editor.addText("practice");
        System.out.println(editor.cursorRight(3)); // Output should be "etpractice"
        System.out.println(editor.cursorLeft(8)); // Output should be "leet"
        System.out.println(editor.deleteText(10)); // Output should be 4 (since only 4 characters left)
        System.out.println(editor.cursorLeft(2)); // Output should be ""
        System.out.println(editor.cursorRight(6)); // Output should be "practi"
    }
}

