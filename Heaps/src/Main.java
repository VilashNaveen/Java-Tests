import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //var heap = new Heap(20);
        /*
        heap.Insert(5);
        heap.Insert(6);
        heap.Insert(8);
        heap.Insert(2);
        heap.Insert(1);
        heap.Insert(10);
        heap.Insert(3);
        heap.Delete();
        heap.Insert(22);
        */
        /*
        int[] numbera = {5,3,10,1,4,2,7,11,56};
        for (var num : numbera) {
            heap.Insert(num);
        }
        for (int i = 0; i < numbera.length; i++) {
            System.out.println(heap.Delete());
        }
        */
        int[] numbers = {5,3,10,1,4,2,7,11,56};
        //var maxheap = new maxHeap(numbers);
        //maxheap.heapify();
        maxHeap2.heapify(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}