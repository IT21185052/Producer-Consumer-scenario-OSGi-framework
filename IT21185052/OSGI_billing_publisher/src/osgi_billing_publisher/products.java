package osgi_billing_publisher;



public class products {
	private String productName;
	private int quanity;
	private float price;
	
	
	public products(String productName, int quanity, float price) {
		super();
		this.productName = productName;
		this.quanity = quanity;
		this.price = price;
	}
	
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuanity() {
		return quanity;
	}
	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

}
