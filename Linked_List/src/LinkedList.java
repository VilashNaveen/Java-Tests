import java.util.List;
import java.util.NoSuchElementException;

public class LinkedList {

    public class Node {
        private int value;
        private Node next;
        public Node(int value) {
            this.value = value;
        }
    }
    private Node first;
    private Node last;
    private int size;
    private boolean isEmpty() {
        return first == null;
    }

    public void addLast(int item) {
        var node = new Node(item);
        if (isEmpty()) {
            first = last = node;
        }
        else {
            last.next = node;
            last = node;
        }
    }
    public void addFirst(int item) {
        var node = new Node(item);
        if (isEmpty()) {
            first = last = node;
        }
        else {
            node.next = first;
            first = node;
        }
        size++;
    }
    public void deleteFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        var second = first.next;
        first = null;
        first = second;
        size--;
    }
    public void deleteLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (first == last) {
           first = last = null;
           size = 1;
           return;
        }
        if (first == null) {
            return;
        }
        Node current = first;
        while (current.next != last) {
            current = current.next;
        }
        last = current;
        last.next = null;
        size++;
    }
    public int indexOf(int item) {
        if (first.value == item) {
            return 0;
        }
        Node current = first;
        int flag = 0;
        while (current.next != last) {
            current = current.next;
            if (current.value == item) {
                flag++;
                return flag;
            }
            flag++;
        }
        if (last.value == item) {
            return ++flag;
        }
        return -1;
    }
    public boolean contains(int item) {
        Node current = first;
        while (current != null) {
            if (current.value == item) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public int size() {
        return size;
    }

    public int[] toList() {
        int [] array = new int[size];
        var current = first;
        var index = 0;
        while (current != null) {
            array[index] = current.value;
            current = current.next;
            index++;
        }
        return array;
    }
}
