import java.util.List;
import java.util.NoSuchElementException;

public class Heap {
    // storing array
    private int heap[];
    private int size;
    public Heap(int size) {
        heap = new int[size];
    }
    // find location of nodes
    private int findLeft(int i) {
        return i*2 + 1;
    }
    private int findRight(int i) {
        return i*2 + 2;
    }
    private int findParent(int i) {
        return (i - 1)/2;
    }

    // Insert method
    public void Insert(int number) {
        if (size == heap.length) {
            System.out.println("Heap is full. Cannot insert.");
            return;
        }
        heap[size++] = number;
        bubbleup();
    }

    private void swap (int first, int second) {
        var temp = heap[first];
        heap[first] = heap[second];
        heap[second] = temp;
    }
    private void bubbleup() {
        int currentIndex = size-1;

        while (currentIndex > 0 && heap[currentIndex] > heap[findParent(currentIndex)]) {
            int parentIndex = findParent(currentIndex);
            swap(currentIndex,parentIndex);
            currentIndex = parentIndex;
        }
    }
    // delete method

    public int Delete() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        var root = heap[0];
        heap[0] = heap[--size];
        bubbledown();
        return root;
    }

    private void bubbledown() {
        var index = 0;
        while (findLeft(index) < size && findRight(index) < size && (heap[index] < heap[findRight(index)] || heap[index] < heap[findLeft(index)])) {
            if (heap[findLeft(index)] > heap[findRight(index)]) {
                swap(index,findLeft(index));
                index = findLeft(index);
            }
            else {
                swap(index, findRight(index));
                index = findRight(index);
            }
        }
    }


}
