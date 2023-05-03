package
    program;

public abstract class Item {
	private String itemCode;
    private double volume;
    private String itemSerialNumber;
    private double cost;
    private double price;
    public enum CostAndPrice{
    	M1(5,11),W1(1,3),O1(20,45),S1(13,25),F1(5,12),P1(12,28),R1(16,32);
		private int unitCost;
		private int unitPrice;

		CostAndPrice(int cost, int price) {
			this.unitCost=cost;
			this.unitPrice=price;
		}

		public int getUnitCost() {
			return unitCost;
		}
		
		public int getUnitPrice() {
			return unitPrice;
		}	
    }
	Item(String itemCode,double volume,String itemSerialNumber) {
    	this.itemCode=itemCode;
        this.volume=volume;
    	this.itemSerialNumber=itemSerialNumber;
    }
    Item(){
        this.itemCode= "";
        this.volume=0.0;
        this.itemSerialNumber="";
    }
    Item(Item otherItem){
        this.itemCode=otherItem.itemCode;
        this.volume=otherItem.volume;
        this.itemSerialNumber=otherItem.itemSerialNumber;
    }
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemSerialNumber() {
		return itemSerialNumber;
	}
	public void setItemSerialNumber(String itemSerialNumber) {
		this.itemSerialNumber = itemSerialNumber;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public double getCost() {
		return cost;
	}
	public double getPrice() {
		return price;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getMass() {
		return 0;
	}
	public boolean equals(Object other) {
		if(other==null) {
			return false;
		}
		else if(other.getClass()!=getClass()) {
			return false;
		}
		else {
			Item otherItem=(Item) other;
			return(otherItem.getItemSerialNumber().equals(getItemSerialNumber()));
		}	
	}
	
	}
	

