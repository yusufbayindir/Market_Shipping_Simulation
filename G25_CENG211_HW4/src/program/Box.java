package program;

import java.util.Collection;
import java.util.HashSet;


public abstract class Box<T> {
	private Collection<T> box;
	private double volume;
	private String boxCode;
	private String boxSerialNumber;
	private double costOfBox;
	private double priceOfBox;
	private boolean isLoaded;
	Box(){
		box=new HashSet<T>();
		this.volume=0.0;
		this.boxCode="";
		this.boxSerialNumber="";
		this.costOfBox=0;
		this.priceOfBox=0;
		this.isLoaded=false;
	}
	
	Box(String boxCode,double volume,String boxSerialNumber,double costOfBox,double priceOfBox){
		box=new HashSet<>();
		this.volume=volume;
		this.boxCode=boxCode;
		this.boxSerialNumber=boxSerialNumber;
		this.costOfBox=costOfBox;
		this.priceOfBox=priceOfBox;
		this.isLoaded=false;
	}

	public abstract void add(T item);
	public abstract void calculateCost(T Item);
	public abstract void calculatePrice(T Item);
	
	public Collection<T> getBox(){
		return box;
	}
	
	public double getVolume() {
		return volume;
	}

	public double getPriceOfBox() {
		return priceOfBox;
	}

	public double getCostOfBox() {
		return costOfBox;
	}

	public void setCostOfBox(double costOfBox) {
		this.costOfBox = costOfBox;
	}

	public void setPriceOfBox(double priceOfBox) {
		this.priceOfBox = priceOfBox;
	}

	public String getBoxCode() {
		return boxCode;
	}

	public String getBoxSerialNumber() {
		return boxSerialNumber;
	}

	public boolean isLoaded() {
		return isLoaded;
	}

	public void setLoaded(boolean isLoaded) {
		this.isLoaded = isLoaded;
	}
	
}
