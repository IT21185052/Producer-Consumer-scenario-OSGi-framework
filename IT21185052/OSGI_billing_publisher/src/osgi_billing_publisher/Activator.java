package osgi_billing_publisher;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		
		context.registerService(BillingService.class.getName(),new BillingServiceImp(),null);
		System.out.println("<<----------Royal Farmacy Billing System Started Successfully---------->>");
		
		DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println("Bill Open Time :  "+dateTime.format(now));
		
		System.out.println("<<------------------------------------------------------------------->>"); 
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		  
		System.out.println("<<-----------Royal Farmacy Billing System Stopped Successfully------------>>");
		
		
	}

}
