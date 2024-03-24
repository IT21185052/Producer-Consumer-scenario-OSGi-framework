package osgi_billing_subscriber;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import osgi_billing_publisher.BillingService;
import osgi_billing_publisher.BillingServiceImp;

public class BillingActivator implements BundleActivator {

	private static BundleContext context;
	ServiceReference serviceReference;
	private ServiceTracker serviceTracker = null;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		BillingActivator.context = bundleContext;
		
		

		serviceTracker = new ServiceTracker(context, context.createFilter("(&(objectClass="+BillingService.class.getName()+")"+"(Language=*))"),null);
		serviceTracker.open();
		System.out.println("<<----------Royal Farmacy Billing System Started Successfully---------->>");
		//Header
		    System.out.println("\n ****************************************************************************************** ");
		    System.out.println(" -----------------------------------Welcome to Royal Farmacy------------------------------- ");
		    System.out.println(" ******************************************************************************************\n ");
		      
			
		    int size = 4;
		    int left = size/2;
		    int right = size - left;
		    String format = "%" + left + "c%-" + right + "c";

		    System.out.printf(format,' ', 'R');
		    System.out.printf(format,' ', 'O');
		    System.out.printf(format,' ', 'Y');
		    System.out.printf(format,' ', 'A');
		    System.out.printf(format,' ', 'L');
		    System.out.printf(format,' ', ' ');
		    System.out.printf(format,' ', 'F');
		    System.out.printf(format,' ', 'A');
		    System.out.printf(format,' ', 'R');
		    System.out.printf(format,' ', 'M');
		    System.out.printf(format,' ', 'A');
		    System.out.printf(format,' ', 'C');
		    System.out.printf(format,' ', 'Y');
		    System.out.printf(format,' ', ' ');
		    System.out.printf(format,' ', '(');
		    System.out.printf(format,' ', 'P');
		    System.out.printf(format,' ', 'V');
		    System.out.printf(format,' ', 'T');
		    System.out.printf(format,' ', ')');
		    System.out.printf(format,' ', '.');
		    System.out.printf(format,' ', 'L');
		    System.out.printf(format,' ', 'T');
		    System.out.printf(format,' ', 'D');
		    
		//Header End
		
		
		
		System.out.println();
		System.out.println("--------------------------------Royal Farmacy Price Catalog--------------------------------");
		System.out.println();
		
try {
	    	
	    	int itemID;
	    	int qty = 0;
	    	float amount = 0;
	    	float discount = (float) 0.10;
	    	float tot = 0;
	    	int quentity = 30;
	    	char choice;
	    	
	    	ArrayList<String> items = new ArrayList<String>();
	    	ArrayList<Float> price = new ArrayList<Float>();
	    	//ArrayList<> addedItems = new ArrayList<>();
	    	
	    	items.add("  Hand sanitizers(50ml)              : ");
			price.add((float) 200.00);
			
			items.add("  Bandages Pack                      : ");
			price.add((float) 100.00);
			
			items.add("  Vitamic C(1 Pill)                  : ");
			price.add((float) 10.00);
			
			items.add("  Amoxiline(1 Pill)                  : ");
			price.add((float) 8.00);
			
			items.add("  Cough Syrup                        : ");
			price.add((float) 450.00);
			
			items.add("  Cetirizine(1 Pill)                 : ");
			price.add((float) 8.00);
			
			items.add("  First-Aid Box                      : ");
			price.add((float) 1800.00);
			
			items.add("  Glucose Meter                      : ");
			price.add((float) 1200.00);
			
			items.add("  Dove Shampoo(100ml Bottle)         : ");
			price.add((float) 450.00);
			
			items.add(" Soap(Detol)                        : ");
			price.add((float) 150.00);
			
			items.add(" Drinking Water(1L)                 : ");
			price.add((float) 200.00);
			
			items.add(" Glucose Oral(100g)                 : ");
			price.add((float) 600.00);
			
			items.add(" Baby Diaper(Small)                 : ");
			price.add((float) 560.00);
			
			items.add(" Wet Wipes(10s)                     : ");
			price.add((float) 390.00);
			
			items.add(" Tissue Paper(50Ps)                 : ");
			price.add((float) 450.00);
			
			items.add(" Dulcolax Tab(1 Card)               : ");
			price.add((float) 180.00);
			
			items.add(" Wound Dressing                     : ");
			price.add((float) 270.00);
			
			items.add(" Baby Hygiene                       : ");
			price.add((float) 990.00);
			
			items.add(" Conditioner(100ml Bottle)          : ");
			price.add((float) 650.00);
			
			items.add(" Mask(20Pak)                        : ");
			price.add((float) 400.00);
			
			for (int i = 0; i < price.size(); i++)
			  {
		        System.out.println(i+1 + "  " +items.get(i) +"  Rs:"+price.get(i));
		      }
			
			Scanner sc = new Scanner(System.in);
			BillingService bill = new BillingServiceImp();
			
			System.out.println();
			do {
				System.out.println("Enter Product (Product No) : ");
					itemID = sc.nextInt();
				
				System.out.println("Enter Quantity : ");
				if(qty > quentity) {
					System.out.println("Store limit Exceeded!");
				}
				else {
					//System.out.println("Store limit Success!");
				}
			    	qty = (int) sc.nextFloat();
			    	
			    	System.out.print("Want to Add More Product? (Y or N): ");
			        choice = sc.next().charAt(0);	
			
			amount = bill.BillingService(items, price,qty, itemID);
			}while(choice == 'y' || choice == 'Y');
			
			//Added
			
			System.out.print("Want to Remove Cart Product? (Y or N): ");
	        choice = sc.next().charAt(0);
			
			//BillingService billObj = new BillingServiceImp();
			
			while(choice == 'Y' || choice == 'y') {
				
				bill.removeItem();
				
				System.out.print("Want to Remove cart Product Again? (Y or N): ");
		        choice = sc.next().charAt(0);
				
			}
			
			
			
	        
	       
			System.out.println("<<=========================================================>>\n");
			
			double array[] = bill.calculateBill();
			
			double totalAmount = array[1] - array[0];
			
				System.out.println("Discount Total : " + array[0]);
			
				System.out.println("Gross Total :" + array[1]);
				
				System.out.println("Total : " + totalAmount);
				
			System.out.println("---------------------------------------------------------------------");	
			
			DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();  
			
			System.out.println("-----------------------------------------------------------------------"); 
			
			System.out.println("Bill Closed Time :  "+ dateTime.format(now));  
			System.out.println("                   Thank you ! Welcome !! ");
	    }
	    
	    catch (Exception e)
	    {
	    	
	    }
		
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		BillingActivator.context = null;
		
		System.out.println("<<------------- Royal Farmacy Billing System Stopped successfully ----------->>");
	}
	
	
	public void removeItem() {
		
		
		
	}

}
