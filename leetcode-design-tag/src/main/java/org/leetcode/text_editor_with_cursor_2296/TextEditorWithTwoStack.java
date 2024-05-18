package org.leetcode.text_editor_with_cursor_2296;

import java.util.Stack;

public class TextEditorWithTwoStack {
    // Stack to store characters to the left and right of the cursor
    private final Stack<Character> leftStack;
    private final Stack<Character> rightStack;

    public TextEditorWithTwoStack() {
        leftStack = new Stack<>();
        rightStack = new Stack<>();
    }

    public void addText(String text) {
        for (char c : text.toCharArray()) {
            leftStack.push(c);
        }
    }

    public int deleteText(int k) {
        int deleteCount = Math.min(k, leftStack.size());
        for (int i = 0; i < deleteCount; i++) {
            leftStack.pop();
        }
        return deleteCount;
    }

    public String cursorLeft(int k) {
        int moveCount = Math.min(k, leftStack.size());
        for (int i = 0; i < moveCount; i++) {
            rightStack.push(leftStack.pop());
        }
        return getLeftString();
    }

    public String cursorRight(int k) {
        int moveCount = Math.min(k, rightStack.size());
        for (int i = 0; i < moveCount; i++) {
            leftStack.push(rightStack.pop());
        }
        return getLeftString();
    }

    private String getLeftString() {
        int length = Math.min(10, leftStack.size());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(leftStack.get(leftStack.size() - length + i));
        }
        return result.toString();
    }
}
