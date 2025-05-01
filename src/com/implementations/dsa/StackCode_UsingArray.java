package com.implementations.dsa;


//this is the basic implementation which doesn't manager overflow and underflow condition and also there is no dynamic resizing.
public class StackCode_UsingArray {
    static class Stack {

        int arr[];
        int capacity;
        int top;

        Stack (int c) {
            top = -1;
            capacity = c;
            arr = new int[capacity];
        }

        public void push (int x) {
            if (top == capacity - 1) {
                System.out.println("Stack Overflow");
            } else {
                top++;
                arr[top] = x;
            }
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack Underflow");
                return -1;
            } else {
                int result = arr[top];
                top--;
                return result;
            }
        }

        public int size() {
            return top + 1;
        }

        public boolean isEmpty() {
            return top == -1;
        }

        // Display method to print all elements in the stack
        public void display() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
            } else {
                System.out.print("Stack elements: ");
                for (int i = 0; i <= top; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println(); // Newline for clarity
            }
        }
    }
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(20);
        System.out.println(stack.size());
    }
}
