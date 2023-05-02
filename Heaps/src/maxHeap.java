public class maxHeap {
    private int heap[];
    private int size;
    public maxHeap (int[] list) {
        heap = list;
        size = list.length;
    }
    // heapify
    public void heapify() {
        for (int i = 0; i < heap.length; i++) {
            heapify(i);
        }
    }
    private void heapify(int index) {
       if (heap[index] > heap[parentIndex(index)]) {
           bubbleup(index);
           bubbledown(index);
       }
       else if (leftExist(index) && !rightExist(index)) {
           if (heap[index] < heap[leftIndex(index)])
               swap(index,leftIndex(index));
           bubbleup(index);
       }
       else if (leftExist(index) && rightExist(index)) {
           bubbledown(index);
           bubbleup(index);
       }

    }
    private void bubbleup(int index) {
        var currentIndex = index;
        while (currentIndex > 0 && heap[currentIndex] > heap[parentIndex(currentIndex)]) {
            swap(currentIndex,parentIndex(currentIndex));
            currentIndex = parentIndex(currentIndex);
        }
    }
    private void bubbledown(int index) {
        var currentIndex = index;
        while (leftExist(currentIndex) && rightExist(currentIndex) &&
                (heap[currentIndex] < heap[leftIndex(currentIndex)] ||
                        heap[currentIndex] < heap[rightIndex(currentIndex)])) {
            if (heap[leftIndex(currentIndex)] > heap[rightIndex(currentIndex)]) {
                swap(currentIndex,leftIndex(currentIndex));
                currentIndex = leftIndex(currentIndex);
            }
            else {
                swap(currentIndex,rightIndex(currentIndex));
                currentIndex = rightIndex(currentIndex);
            }
        }

    }
    //checking wether left and right exist
    private boolean leftExist(int index) {
        return leftIndex(index) < size;
    }
    private boolean rightExist(int index) {
        return rightIndex(index) <= size;
    }
    // finding indexes
    private int leftIndex(int i) {
        return i*2 + 1;
    }
    private int rightIndex(int i) {
        return i*2 + 2;
    }
    private int parentIndex(int i) {
        return (i - 1)/2;
    }


    private void swap (int first, int second) {
        var temp = heap[first];
        heap[first] = heap[second];
        heap[second] = temp;
    }
}
