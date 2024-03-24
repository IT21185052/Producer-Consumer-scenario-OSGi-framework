package osgi_billing_publisher;

import java.util.ArrayList;

public interface BillingService {
	
	public float BillingService(ArrayList items, ArrayList price, int qty, int itemID) ;
	int getStock();
	public void removeItem();
	public double[] calculateBill();

}
