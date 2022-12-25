
import java.util.*;

class threadclass extends Thread{   // inheritence and multithreading
    public void run(){
        for(int i=5;i>=0;i--){
            System.out.println("Your bill will be loaded in "+i+"  seconds....");
            try{               // exception handling
                Thread.sleep(500);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
}
    
    

interface bill{      //interface
    public void calcbill() throws negativeunits, InterruptedException;
}


class EB implements bill{   //implementing interface
    public void calcbill() throws negativeunits,InterruptedException{
        int units;
 
	double billpay=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of units consumed:");
        units=sc.nextInt();
        if(units<0){
            throw new negativeunits("Negative units nit allowed here");
        }
        else if(units<100)
	 {
	      billpay=units*1.20;
	  }
	else if(units<300)
	 {
	   billpay=100*1.20+(units-100)*2;
	 }
	else if(units>300)
	{
	    billpay=100*1.20+200*2+(units-300)*3;
	}
        threadclass t1=new threadclass();
        t1.start();
        t1.join();
	System.out.println("Bill to pay : " + billpay); 
      } 
    }

class negativeunits extends Exception{
    public negativeunits(String str){
        super(str);
    }
}

public class Electricitybill {

    public static void main(String[] args)throws InterruptedException {
        EB eb=new EB();
        try{
        eb.calcbill();
        }
        catch(negativeunits e){
            System.out.println(e);
        }
    }
    
}
