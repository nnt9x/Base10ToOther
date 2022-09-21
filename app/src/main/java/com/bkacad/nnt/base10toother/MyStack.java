package com.bkacad.nnt.base10toother;

public class MyStack implements Stack {

    // Mảng kí tự
    private char arr[];
    // Khai báo vị trí top (theo index)
    private int top;
    // Kích thước của stack
    private int size;

    // Định nghĩa cách tạo ra đối tượng Stack - constructor
    public MyStack(int size) {
        if (size <= 0) {
            throw new RuntimeException("Kích thước phải lớn hơn 1");
        }
        this.size = size;
        this.arr = new char[size];
        this.top = -1;
    }

    @Override
    public void push(char e) {
        // Khi stack chưa đầy -> thêm được
        if (!isFull()) {
            top++;
            arr[top] = e;
        }
    }

    @Override
    public char pop() {
        if (!isEmpty()) {
            char e = arr[top];
            top = top - 1;
            return e;
        }
        return Character.MIN_VALUE;
    }

    @Override
    public char peek() {
        return arr[top];
    }

    @Override
    public boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isFull() {
        if (this.size == this.top + 1) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        // Chuyển top = -1
        top = -1;
    }

    @Override
    public String toString() {
        // Chuyển stack ra string top -> index 0
        StringBuffer buffer = new StringBuffer();
        for (int i = top; i >= 0; i--) {
            buffer.append(arr[i]);
        }
        return buffer.toString();
    }
}
