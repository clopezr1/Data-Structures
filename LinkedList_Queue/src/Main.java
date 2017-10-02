/**
 * Created by Carlos on 9/14/2017.
 */
public class Main {

    public static void main(String[] args){

        int time = 0, chance = 0;
        //Creates Queue
        Queue line = new Queue();
        //goes through 60 iterations
        for(int i = 1; i < 61; i++){
            chance = (int) (Math.random() * 4); // 1/4 chance to get new customer
            //if new customer arrives
            if (chance == 3){
                line.enqueue(new Customer()); //AddCustomer
                System.out.println("New customer added! Queue length is now " + line.getLength() + ".");
            }
            //update customer being serviced
            if (!line.isEmpty()){  //checks if the line is not empty
                line.peek().decServiceTime();//decrease service time of first in line;
                if(line.peek().getServiceTime() == 0){ //if service time is done
                    line.dequeue(); //remove from line
                    System.out.println("Customer serviced and removed! Queue length is now " + line.getLength() + ".");
                }
            }
            //end of iteration (minute)
            System.out.println("---------------End minute:" + i + "-----------------");
        }
        //print total serviced and max line size throughout the simulation
        System.out.println("\n\nTotal customers serviced: " + line.getServiced() + " customers.");
        System.out.println("The largest the line got: " + line.getMax() +" customers.");

    }

}
