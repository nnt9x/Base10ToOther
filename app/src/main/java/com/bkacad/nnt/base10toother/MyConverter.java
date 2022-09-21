package com.bkacad.nnt.base10toother;

public class MyConverter implements Converter {
    // Triển khai lại chi tiết các phương thức

    private MyStack stack;

    @Override
    public String decToBin(long num) {
        stack = new MyStack(16);
        long t = -1, r = -1;
        while (true) {
            t = num / 2;
            r = num % 2;
            stack.push((char) (r + '0'));
            if (t == 0) break;
            num = t;
        }
        return stack.toString();
    }

    @Override
    public String decToOct(long num) {
        stack = new MyStack(16);
        long t = -1, r = -1;
        while (true) {
            t = num / 8;
            r = num % 8;
            stack.push((char) (r + '0'));
            if (t == 0) break;
            num = t;
        }
        return stack.toString();
    }

    @Override
    public String decToHex(long num) {
        stack = new MyStack(16);
        long t = -1, r = -1;
        while (true) {
            t = num / 16;
            r = num % 16;
            // Kiểm tra r, nếu r = 10 -> 'A', 11 -> 'B', 15 -> 'F'
            if (r == 10) {
                stack.push('A');
            } else if (r == 11) {
                stack.push('B');
            } else if (r == 12) {
                stack.push('C');
            } else if (r == 13) {
                stack.push('D');
            } else if (r == 14) {
                stack.push('E');
            } else if (r == 15) {
                stack.push('F');
            } else {
                stack.push((char) (r + '0'));
            }
            if (t == 0) break;
            num = t;
        }
        return stack.toString();
    }
}
