package frist;

/**
 * StackApp
 */

class Stack {
    private  int top = -1;
    private  int[] data = new int[6];

    boolean isEmpty() {
        if(top != -1) {
            return false;
        }
        return true;
    }

    boolean isFull() {
        if(top != 5) {
            return false;
        }
        return true;
    }

    int push(int item) {
        if(isFull()) {
            System.out.println("Stack Overflowed");
            return 0;
        }
        ++top;
        data[top] = item;
        return 0;
    }

    int pop() {
        if(isEmpty()) {
            System.out.println("Stack Underflowed");
            return 0;
        }
        --top;
        return 0;
    }
    
    int peek() { 
        if(isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return data[top];
    }

    int precedence(char operator) {
        if(operator == '/' || operator == '*') {
            return 2;
        }
        return 1; 
    }
}

public class StackApp {
    public static void main(String[] args) {
        Stack app = new Stack();
        app.push(1);
        app.push(2);
        app.push(3);
        app.push(4);
        app.push(5);
        app.push(6);
        System.out.println(app.peek());
        app.push(7);
        app.pop();
        app.pop();
        app.pop();
        app.pop();
        app.pop();
        System.out.println(app.peek());
        app.pop();
        app.pop();
        app.peek();
    }
}

