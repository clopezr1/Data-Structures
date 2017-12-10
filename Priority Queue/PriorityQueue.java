/**
 * Created by Carlos on 10/16/2017.
 */
public class PriorityQueue {

    private int size = 0; //how many objects
    private int index = 0;
    private int max = 0;
    private int parent, leftChildIndex, rightChildIndex, leftChildPriority, rightChildPriority, largerIndex, largerPriority;
    private PriorityCustomer[] heap = new PriorityCustomer[50];
    private PriorityCustomer temp, swap;

    public void add(PriorityCustomer c){
        if (size + 2 > heap.length) {
            System.out.println ("The heap is full");
            return;
        }

        size++;
        updateMax(size);
        index = size;
        heap[index] = c;

        while(index > 1){
            parent = index / 2;
            if(heap[index].getPriority() > heap[parent].getPriority()){
                temp = heap[index];
                heap[index] = heap[parent];
                heap[parent] = temp;
                index = parent;
            } else {
                break;
            }
        }

    }

    public PriorityCustomer remove(){
        if (size == 0) {
            System.out.println ("The heap is already empty");
            return null;
        }

        temp = heap[1];
        heap[1] = heap [size];
        heap[size] = null;
        size--;


        while (index <= (size/2)){
            leftChildIndex = index * 2;
            rightChildIndex = leftChildIndex + 1;
            leftChildPriority = heap[leftChildIndex].getPriority();
            rightChildPriority = -1;
            if(rightChildIndex <= size){
                rightChildPriority = heap[rightChildIndex].getPriority();
            }
            if (rightChildPriority > leftChildPriority){
                largerIndex = rightChildIndex;
                largerPriority = rightChildPriority;
            } else {
                largerIndex = leftChildIndex;
                largerPriority = leftChildPriority;
            }
            if (heap[index].getPriority() < largerPriority){
                swap = heap[index];
                heap[index] = heap[largerIndex];
                heap[largerIndex] = swap;
                index = largerIndex;
            } else {
                break;
            }
        }
        updateMax(size);
        return temp;
    }

    public int getSize() {
        return size;
    }
    public PriorityCustomer getFirst(){
        return heap[1];
    }
    private void updateMax(int currentLength){
        if (currentLength > max)
            max = currentLength;
    }

    public int getMax() {
        return max;
    }
}
