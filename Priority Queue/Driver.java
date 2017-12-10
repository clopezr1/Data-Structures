/**
 * Created by Carlos on 10/16/2017.
 */
public class Driver {

    public static void main(String[] args){

        int time = 0, chance = 0, serviced = 0;
        //Creates Queue
        PriorityQueue line = new PriorityQueue();
        //goes through 60 iterations
        for(int i = 1; i < 61; i++){
            chance = (int) (Math.random() * 4); // 1/4 chance to get new customer
            //if new customer arrives
            if (chance == 3){
                line.add(new PriorityCustomer()); //AddCustomer
                System.out.println("New customer added! Queue length is now " + line.getSize() + ".");
            }
            //update customer being serviced
            if (line.getSize() > 0){  //checks if the line is not empty
                line.getFirst().decServiceTime();//decrease service time of first in line;
                if(line.getFirst().getServiceTime() == 0){ //if service time is done
                    line.remove(); //remove from line
                    serviced++;
                    System.out.println("Customer serviced and removed! Queue length is now " + line.getSize() + ".");
                }
            }
            //end of iteration (minute)
            System.out.println("---------------End minute:" + i + "-----------------");
        }
        //print total serviced and max line size throughout the simulation
        System.out.println("\n\nTotal customers serviced: " + serviced + " customers.");
        System.out.println("The largest the line got: " + line.getMax() +" customers.");

    }
}
