package com.bkacad.nnt.base10toother;


// Đưa ra các phép toán trên stack
public interface Stack {
    // Thêm vào trên cùng của stack
    public void push(char e);

    // Trả về phần tử trên cùng, đồng thời xoá khỏi stack
    public char pop();

    // Trả về phâần tử trên cùng, nhưng không xoá khỏi stack
    public char peek();

    // Kiểm tra xem trống hay ko?
    public boolean isEmpty();

    // Kiểm tra xem stack đã đầy hay chưa?
    public boolean isFull();

    // Reset stack
    public void clear();


}
