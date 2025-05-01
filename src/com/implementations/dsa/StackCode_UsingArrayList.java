package com.implementations.dsa;

import java.util.ArrayList;

public class StackCode_UsingArrayList {

    static class Stack {

        ArrayList<Integer> al = new ArrayList<>();

        public void push (int x) {
            al.add(x);
        }

        public int pop() {
            if(al.isEmpty()) {
                System.out.println("Stack Underflow");
                return -1; // or throw an exception
            } else {
//                int result = al.get(al.size() - 1);
//                al.remove(al.size() - 1);
//                return result;
                return al.remove(al.size() - 1);
            }
        }

        public int size() {
            return al.size();
        }

        public boolean isEmpty() {
            return al.isEmpty();
        }

        int peek() {
            if(al.isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            else {
                return al.size() - 1;
            }
         }

        // Display method to show all elements in the stack
        public void display() {
            if (al.isEmpty()) {
                System.out.println("Stack is empty");
            } else {
                System.out.print("Stack elements: ");
                for (Integer element : al) {
                    System.out.print(element + " ");
                }
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.display();  // Will display: Stack elements: 10 20 30

        System.out.println("Top element: " + stack.peek());  // Will display: Top element: 30
        System.out.println("Stack size: " + stack.size());  // Will display: Stack size: 3

        stack.pop();  // Removes top element (30)
        stack.display();  // Will display: Stack elements: 10 20

        stack.push(40);
        stack.display();  // Will display: Stack elements: 10 20 40
    }
}
