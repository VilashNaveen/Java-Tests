import java.util.ArrayList;

public class Stack_Arr {
    private int[] arr;
    private int top = 0;

    public Stack_Arr (int size) {
        int[] arr = new int[size];
    }
    public void Push (int x) {
        if (top >= arr.length) {
            System.out.println("Stack is Full");
        }
        else {
            arr[top] = x;
            top++;
        }
    }
    public int Pop() {
        if (top == 0) {
            throw new IllegalStateException();
        }
        top--;
        return arr[top];
    }
    public void Peek() {
        if (top > 0) {
            System.out.println(arr[top - 1]);
        }
        else {
            System.out.println("Empty");
        }

    }
    public boolean isEmpty() {
        return (top==0);
    }

}
