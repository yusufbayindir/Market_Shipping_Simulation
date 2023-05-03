package program;

import java.util.ArrayList;
import java.util.List;

import exceptions.ContainerCannotHoldItemException;
import exceptions.ContainerOverflowException;
import exceptions.LoadedBoxAddException;

public class Container {
	public static final String ContainerCode="C1";
	private double currentVolume;
	private double volume;
	private String serialNumber;
	private double costOfContainer;
    private double priceOfContainer;
	private List<Box<Item>> container;

	Container(double volume, String serialNumber){
		container=new ArrayList<Box<Item>>();
		this.volume=volume;
		this.serialNumber=serialNumber;
        this.costOfContainer=volume*1;
        this.priceOfContainer = 0 ;
	}
    
	@SuppressWarnings("unchecked")
	public void add(Object o) {
		try {
			if(o instanceof Box){
				Box<Item> box=(Box<Item>)o;
				if(!box.isLoaded()) {
					if(controlVolume(box)) {
						container.add(box);
						calculateCost(box);
						calculatePrice(box);
						currentVolume+=box.getVolume();
					}
					else {
						throw new ContainerOverflowException();
					}
				}
				else {
					throw new LoadedBoxAddException();
				}
			}
			else {
				throw new ContainerCannotHoldItemException();
			}
		}
		catch(ContainerCannotHoldItemException e) {
			System.out.println(e.getMessage());
		}
		catch(LoadedBoxAddException e) {
			System.out.println(e.getMessage());
		}
		catch(ContainerOverflowException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
    private boolean controlVolume(Box<Item> box) {
		return !(box.getVolume()+currentVolume>volume);
	}
    
    public void calculateCost(Box<Item> box) {
		costOfContainer+=box.getCostOfBox();
	}
    public void calculatePrice(Box<Item> box) {
    	priceOfContainer+=box.getPriceOfBox();
    }
	public double getVolume() {
		return volume;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public double getCostOfContainer() {
		return costOfContainer;
	}

	public double getPriceOfContainer() {
		return priceOfContainer;
	}

	}
    

