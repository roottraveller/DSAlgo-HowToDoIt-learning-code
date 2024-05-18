package org.leetcode.text_editor_with_cursor_2296;

import java.util.Deque;
import java.util.LinkedList;

public class TextEditorWithTwoDeque {
    // Deque to store characters to the left and right of the cursor
    private final Deque<Character> leftDeque;
    private final Deque<Character> rightDeque;

    public TextEditorWithTwoDeque() {
        leftDeque = new LinkedList<>();
        rightDeque = new LinkedList<>();
    }

    public void addText(String text) {
        for (char c : text.toCharArray()) {
            leftDeque.addLast(c);
        }
    }

    public int deleteText(int k) {
        int deleteCount = Math.min(k, leftDeque.size());
        for (int i = 0; i < deleteCount; i++) {
            leftDeque.removeLast();
        }
        return deleteCount;
    }

    public String cursorLeft(int k) {
        int moveCount = Math.min(k, leftDeque.size());
        for (int i = 0; i < moveCount; i++) {
            rightDeque.addFirst(leftDeque.removeLast());
        }
        return getLeftString();
    }

    public String cursorRight(int k) {
        int moveCount = Math.min(k, rightDeque.size());
        for (int i = 0; i < moveCount; i++) {
            leftDeque.addLast(rightDeque.removeFirst());
        }
        return getLeftString();
    }

    private String getLeftString() {
        StringBuilder result = new StringBuilder();
        int length = Math.min(10, leftDeque.size());
        Object[] leftArray = leftDeque.toArray();
        for (int i = leftDeque.size() - length; i < leftDeque.size(); i++) {
            result.append(leftArray[i]);
        }
        return result.toString();
    }

}
