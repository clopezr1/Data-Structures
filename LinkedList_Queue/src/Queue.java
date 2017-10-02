/**
 * Created by Carlos on 9/14/2017.
 */
public class Queue {

    private Customer first, last;
    private int currentLength = 0, max = 0, serviced = 0;


    public Queue() {
        first = last = null;
    }
    //add
    public void enqueue(Customer c){

        //if empty set first to new customer
        if (isEmpty()){
            first = c;
            currentLength++;
        } else {
            //previous last references new customer
            last.setNext(c);
            currentLength++;
        }
        //change who is last in line
        last = c;
        //Update max line size
        updateMax(currentLength);
    }
    //remove
    public Customer dequeue(){
        if (isEmpty())
            return null; //check if empty when trying to remove

        Customer temp = first;
        first = first.getNext(); //the new first to be the next in line
        serviced++;
        currentLength--;
        if(isEmpty())   //check if empty after removal
            last = null;

        return temp;
    }
    //references the first in line
    public Customer peek(){
        return first;
    }
    //returns current length of line
    public int getLength(){
        return currentLength;
    }
    //Checks if line is empty
    public boolean isEmpty(){
        return first == null;
    }
    //checks current line size and updates max line size
    private void updateMax(int currentLength){
        if (currentLength > max)
            max = currentLength;
    }
    //returns the largest the line ever got
    public int getMax(){
        return max;
    }
    //returns how many customers were serviced/removed
    public int getServiced(){
        return serviced;
    }
}
