package osgi_billing_publisher;

import java.util.ArrayList;
import java.util.Scanner;


public class BillingServiceImp implements BillingService{

	float totAmount = 0;
	int quantity = 50;
	
	Scanner sc = new Scanner(System.in);
	
	ArrayList<products> addedItems = new ArrayList<products>();
	
	@Override
	public float BillingService(ArrayList items, ArrayList price, int qty, int itemID) {
		// TODO Auto-generated method stub
		float itemPrice = (float)price.get(itemID-1);
		String itemName = (String) items.get(itemID-1);
		//System.out.println(items.get(itemID-1) + "    X  "+ qty+"=  "+(itemPrice * qty));
		
		addedItems.add(new products(itemName,qty,itemPrice));
		
		//totAmount = totAmount + (itemPrice * qty);
		
		return totAmount;
	}

	@Override
	public int getStock() {
		// TODO Auto-generated method stub
		return quantity;
	}
	
	
	
	public void removeItem() {
		
  		
		for(int  i = 0 ; i < addedItems.size() ; i++) {
			
			System.out.print(i+1 + "\t");
			System.out.print(addedItems.get(i).getProductName() +  "\t");
			System.out.print(addedItems.get(i).getQuanity() +  "\t");
			System.out.print(addedItems.get(i).getPrice() +  "\t");
			System.out.println();
			
		}
		
		
        	System.out.println("Enter Product No Need to remove : " );
        	int itemNo = sc.nextInt();
        	
        	
        	
        	addedItems.remove(itemNo-1); 		
        	System.out.println("Product Remove Sucessfully");
          	
        }
	
	
	public double[] calculateBill() {
		
		
		float totAmount = 0;
		float discount = 0;
		
		for(int  i = 0 ; i < addedItems.size() ; i++) {
			
			totAmount = totAmount + (addedItems.get(i).getPrice() * addedItems.get(i).getQuanity());
			
		}
		
		
		
		
		if(totAmount > 5000) {
			System.out.println(totAmount);
			System.out.println("Your total price is over the Rs.5000.You have 10% discount.Enjoy!\n");
			discount = totAmount * 10/100;
			
		}else if(totAmount > 2000) {
			System.out.println("Your total price is over the Rs.2000.You have 5% discount.Enjoy!\n");
			discount = totAmount * 5/100;	
		}
		else {
			discount = 0;
		}
		
		double[] array = new double[20];
		
		array[0] = discount;
		array[1] = totAmount;
		
		
		return array;
		
		
	}
	
	
	
        

}
