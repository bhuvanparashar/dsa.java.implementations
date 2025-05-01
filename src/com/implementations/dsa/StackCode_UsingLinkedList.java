package com.implementations.dsa;

public class StackCode_UsingLinkedList {
    static class Stack {

        private class Node {
            int data;
            Node next;

            Node (int d) {
                data = d;
                next = null;
            }
        }

        Node head;
        int size;

        Stack () {
            head = null;
            size = 0;
        }

        private int size() {
            return size;
        }

        private boolean isEmpty() {
            return head == null;
        }

        private void push(int x) {
            Node temp = new Node(x);
            temp.next = head;
            head = temp;
            size ++;

        }
        private int pop () {
            if(head == null){
                return Integer.MAX_VALUE;
            }
            int result = head.data;
            head = head.next;
            size --;
            return result;
        }

        private int peek() {
            if(head == null) {
                return Integer.MAX_VALUE;
            }
            return head.data;
        }
        public void display() {
            if (head == null) {
                System.out.println("Stack is empty");
            } else {
                System.out.print("Stack elements: ");
                Node current = head;
                while (current != null) {
                    System.out.print(current.data + " ");
                    current = current.next;
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        // Performing stack operations and displaying the results
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();  // Expected: Stack elements: 30 20 10

        System.out.println("Peek: " + stack.peek());  // Expected: Peek: 30

        stack.pop();  // Removes top element (30)
        stack.display();  // Expected: Stack elements: 20 10

        System.out.println("Peek after pop: " + stack.peek());  // Expected: Peek after pop: 20

        stack.push(40);
        stack.display();  // Expected: Stack elements: 40 20 10

        System.out.println("Stack size: " + stack.size());  // Expected: Stack size: 3
    }

}
