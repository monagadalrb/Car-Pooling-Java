
package carpooling;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;

//________________________________________________________________________________________________________________________________________________
/** Interface that represents the different Type of gifts
 * solid  principles
 */ 
 interface Gift
{
    public void Display ();
}
/** A child that represents Normal gift*/
 class Normalgift implements Gift{
//overrideng 
    @Override
    public void Display() {
        
        System.out.println ("Congratulation! You won a 50% discount on your ticket price");
        
    }

}
/** A child that represents special  gift*/
 class Specialgift implements Gift{

    @Override
    public void Display() {
        
        System.out.println ("Congratulation! You won a trip for free");
    }

}

//________________________________________________________________________________________________________________________________________________
/** The class passenger is a abstract class */
 abstract class Passenger{
protected boolean Subscriber;
protected float SFactor;
protected ticket T;
protected ArrayList<ticket>Ticket;
protected String Complaint;
protected boolean Error;


    public Passenger() {
        Ticket=new ArrayList<ticket>();
        SFactor=1000f;
    }
// Final Method 
public final void SearchForRoute(String From ,String To){
  boolean Exist=false;
  
    for(String S :Route.From)
    {
        if(S.equals(From))
            for(String s:Route.To)
                if(s.equals(To))
                    Exist=true;
    }
           if(Exist==true)
               System.out.println("The route is found. ");
           else
               System.out.println("Error!! This route can not be found. ");
               
          
}
// Final Method 
public final void Subscribe (int Age,int NoOfTrips){
Error=false;
try{
    // it is already subscriber 
    if(Subscriber==true)
            {
        Error=true;
    throw new IOException("You are already subscribed");
            }
}catch(IOException io)
{
    System.out.println(""+io.getMessage());
}
if(!Error)
{
Subscriber=T.discount=true;
// Calculate data member
 float Fees=SFactor*(Age-NoOfTrips);
 Subscriber=T.discount=true;
 System.out.printf("You have subscribed successfully with fees (%f)\n",Fees);
}
}
// Final Method
public final void Unsubscribe(){
    boolean Error=false;
try{
    if(Subscriber==false)
            {
        Error=true;
    throw new IOException("You are already unsubscribed");
            }
}catch(IOException io)
{
    System.out.println(""+io.getMessage());
}
if(Error)
{
Subscriber=T.discount=false;
System.out.println("Subscription canceled successfully");

}
} 

//Abstract Method 
public abstract void ReserveTicket(car C);

public final void Review(String review){
    boolean checker =false ;
    try
    {
    if(review.equals(""))
     {
      checker=true;
      throw new IOException ("please, Enter your opinion");
     }
    }
    catch(IOException io )
    {
    System.out.println("Error !!"+io.getMessage());
    }
    if (checker)
    {
    this.Complaint=review;
    System.out.println("Your review has been sent successfully .");
    }
    
        


}
}
//________________________________________________________________________________________________________________________________________________
/**The non-subscriber class is inherited from the Passenger class
 *Inheritance 
 * it is a child class 
 */
 class Nonsubscriber extends Passenger{

    public Nonsubscriber() {
        Subscriber=false;
    }
    
/** The overriding */
    @Override
    public void ReserveTicket(car C){
    T=new ticket(C);
        Ticket.add(T);
        T.discount =(Subscriber)?true:false;
        System.out.println("The ticket was successfully reserved.");
    }
    
    public void Reward (car C)
    {
    ReserveTicket(C);
    System.out.println("Only to your first trip..");
    }
}
//________________________________________________________________________________________________________________________________________________

/**The subscriber class is inherited from the Passenger class
 *Inheritance 
 * it is a child class
 */
 class Subscriber extends Passenger{
    //Final  data member
    private final float Discount;

    public Subscriber() 
    {
        Discount=0.5f;
        ticket.Discount=this.Discount;
        Subscriber=true;
    }
/** The overriding */
    @Override
    public void ReserveTicket(car C)
    {
        T=new ticket(C);
        Ticket.add(T);
        T.discount =(Subscriber)?true:false;
        System.out.println("The ticket was successfully reserved with 50% discount.");
        
    }
    
}

//________________________________________________________________________________________________________________________________________________
/** this class represents the route */
 class Route{
    //private data member
private String StartLocation;
//prinate data member
private String DestinationLocation;
/** Static Data Member */
public   static ArrayList<String>From=new ArrayList<String>();
/** Static Data Member */
public static ArrayList<String>To=new ArrayList<String>();

/** Default Constructor  to get the route  from the user
*@param StartLocation  to get start location 
* @param DestinationLocation  to get end location
*/
    public Route(String StartLocation, String DestinationLocation) {
        this.StartLocation = StartLocation;
        this.DestinationLocation = DestinationLocation;
        From.add(StartLocation);
        To.add(DestinationLocation);
    }

    public String getStartLocation() {
        return StartLocation;
    }

    public String getDestinationLocation() {
        return DestinationLocation;
    }
    
}

//________________________________________________________________________________________________________________________________________________
/** This class represents the car*/
 class car
{
    private Route R;
    /**Static data member*/
    private static int Counter=0;
    public int C_ID;
    private String DriverName;
    private int No_of_trips;
    private int capacity_per_trip;
    
    /**  Default  constructor 
     * 
     * @param R   object from route 
     * @param DriverName  the driver name 
     * @param No_of_trips  per day 
     * @param capacity_per_trip   
     */ 
    public car(Route R, String DriverName, int No_of_trips, int capacity_per_trip) {
        this.R = R;
        this.DriverName = DriverName;
        this.No_of_trips = No_of_trips;
        this.capacity_per_trip = capacity_per_trip;
        Counter++;
        this.C_ID=Counter;
        
      }

    public Route getR() {
        return R;
    }

    public static int getCounter() {
        return Counter;
    }

    public String getDriverName() {
        return DriverName;
    }

    public int getNo_of_trips() {
        return No_of_trips;
    }

    public int getCapacity_per_trip() {
        return capacity_per_trip;
    }
   // this method to display cars' data
    public void DisplayCarData(){
    System.out.printf("Car Id: %d\t",C_ID);
    System.out.printf("Driver Name: %s\t",DriverName);
    System.out.printf("Trips per day: %d\t",No_of_trips);
    System.out.printf("Capacity per trip: %d\t",capacity_per_trip);
    System.out.printf("Route: From %s To %s\t\n",R.getStartLocation(),R.getDestinationLocation());
    }
}
//________________________________________________________________________________________________________________________________________________
/** this class represents tickets */
 class ticket{
    private int TicketID;
    private float Price;
    /** Static data member */
    private static int count=0;
    //private data member
    private car C;
    //static data member 
    public static float Discount;
    public boolean discount; 
    
    public ticket(car C) {
        this.C = C;
        count++;
        TicketID=count;
    }
    
    private void Discount(){
        Price=120f;
        if(discount) 
        /** Calculate data member */
        Price=Price-(Price*Discount);
   
     
    }
    
    public void DisplayTicketData(){
    Discount();
    System.out.printf("Ticket: %d ",TicketID,"\n");
    System.out.printf("Car Id: %d ",C.C_ID,"\n");
    System.out.printf("Driver Name: %s ",C.getDriverName() ,"\n");
    System.out.printf("Route: From %s To %s ",C.getR().getStartLocation(),C.getR().getDestinationLocation(),"\n");
    System.out.printf("Price: %f pounds",Price,"\n");
    
    
    }
}
//________________________________________________________________________________________________________________________________________________
/**Main class*/
public class CarPooling {

    
    public static void main(String[] args) {
        
        // Array of different routes
      ArrayList <Route>route=new ArrayList<Route>();
        Route R;
       R=new Route("Matarya","El-Abassya");
       route.add(R);
       
       R=new Route("Maadi","Hadayiq El- Maadi");
       route.add(R);
       
       R=new Route("Saraya alqiba","El-Abassya");
       route.add(R);
       
       R=new Route("Nagibe","El-sadat");
       route.add(R);
       
       R=new Route("Al-buhuth","Cairo University");
       route.add(R);
       
       R=new Route("Masara","Alshuhada'");
       route.add(R);
       //______________________________________________________________________________________________________________________________________
       //Array of cars with different routes 
       ArrayList <car> Car=new ArrayList<car>();
       car c;
       c=new car(route.get(0),"Mohamed ",10,9);
        Car.add(c);
       c=new car(route.get(1),"Ahmed",15,12);
        Car.add(c);
       c=new car(route.get(2),"Hassan",5,20);
        Car.add(c);
       c=new car(route.get(3),"Mahmoud",7,14);
        Car.add(c);
       c=new car(route.get(4),"Ashrf",11,7);
       Car.add(c);
       c=new car(route.get(5),"Gad",14,18);
       Car.add(c);
        
        //_____________________________________________________________________________________________________________________________________
        //single array  of passengers
        Passenger passenger[]=new Passenger [7];
        passenger[0]=new Subscriber();
        passenger[1]=new Subscriber();
        passenger[2]=new Subscriber();
        passenger[3]=new Subscriber();
        passenger[4]=new Nonsubscriber();
        passenger[5]=new Nonsubscriber();
        passenger[6]=new Nonsubscriber();
        //_____________________________________________________________________________________________________________________________________
        Scanner Input=new Scanner(System.in);
        for(int i =0; ;i++)
        {
        System.out.println("Press 1 to search for a specific route");
        System.out.println("Press 2 to subscribe and you are a subscriber");
        System.out.println("Press 3 to unsubscribe and you are nonsubscriber ");
        System.out.println("Press 4 to subscribe  you are a nonsubscriber");
        System.out.println("Press 5 to unsubscribe and you are subscriber ");
        System.out.println("Press 6 to reserve a ticket -Subscriber- and display tickets' data ");
        System.out.println("Press 7 to reserve a ticket -nonubscriber-and display tickets' data ");
        System.out.println("Press 8 to display cars' data ");
        System.out.println("Press 9 to review");
        System.out.println("Press 10 to Exit ");
        
        System.out.print("Enter your choice:");
         int Num=Input.nextInt();
         
             System.out.println("______________________________________________");
        //_____________________________________________________________________________________________________________________________________1
        if(Num==1)
           {
            String End;
            String Start;
            System.out.print("Start Location :");
            Scanner Input1=new Scanner(System.in);
            Start=Input1.next();
            
            System.out.print("End Location :");
            Scanner Input2=new Scanner(System.in);
            End=Input2.next();
            
            passenger[0].SearchForRoute(Start,End);
            System.out.println("______________________________________________");
          
           }
           //_________________________________________________________________________________________________________________________________
           if(Num==2)
           {
            
            System.out.print("Age :");
            Scanner Input2=new Scanner(System.in);
            int Age=Input2.nextInt();
            
            System.out.print("No of trips:");
            Scanner Input3=new Scanner(System.in);
            int NoOfTrips=Input3.nextInt();
            
            passenger[0].Subscribe( Age, NoOfTrips);
            System.out.println("______________________________________________");
       
           }
           //__________________________________________________________________________________________________________________________________
           if(Num==3)
           {
            passenger[4].Unsubscribe();
             System.out.println("______________________________________________");
           }
           //__________________________________________________________________________________________________________________________________
           if(Num==4)
           {
            System.out.print("Age :");
            Scanner Input5=new Scanner(System.in);
            int Age=Input5.nextInt();
            
            System.out.print("No of trips:");
            Scanner Input6=new Scanner(System.in);
            int NoOfTrip=Input6.nextInt();
            
            passenger[4].Subscribe(Age,NoOfTrip);
           }
           
           //_________________________________________________________________________________________________________________________________
           if(Num==5)
           {
           passenger[1].Unsubscribe();
           }
           //_________________________________________________________________________________________________________________________________
           if(Num==6)
           {
            System.out.print("Car Id :");
            Scanner Input5=new Scanner(System.in);
            int Id=Input5.nextInt();
           passenger[0].ReserveTicket(Car.get(--Id));
           passenger[0].T.DisplayTicketData();
           System.out.println("\n_________________________________________________________");
           }
           //_________________________________________________________________________________________________________________________________
           if(Num==7)
           {
            System.out.print("Car Id :");
            Scanner Input5=new Scanner(System.in);
            int Id=Input5.nextInt();
           passenger[5].ReserveTicket(Car.get(--Id));
           passenger[5].T.DisplayTicketData();
           System.out.println("\n_________________________________________________________");
           }
           //__________________________________________________________________________________________________________________________________
           if(Num==8)
           {
            System.out.println("Cars Data");
             for(car Carr:Car)
                 Carr.DisplayCarData();
              
            System.out.println("__________________________________________________________________________________________________________________________");
            
           }
           //_________________________________________________________________________________________________________________________________
           if(Num==9)
           {
           System.out.print("Your opinion :");
           Scanner Input5=new Scanner(System.in);
           String review=Input5.next();
           passenger[0].Review(review);
           System.out.println("\n_________________________________________________________");
           }
           //_________________________________________________________________________________________________________________________________
           if(Num==10)
               break;
        }
       
        }
    
}
