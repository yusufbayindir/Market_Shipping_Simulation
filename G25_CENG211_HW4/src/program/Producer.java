package program;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import DataAccess.FileOpen;
import exceptions.SameSerialNumberException;

public class Producer {	
	private List<Item> itemsHolder;
	private List<Box<Item>> boxesHolder;
	private List<List<String>> twoDim;
	private List<Container> containersHolder;
	private double totalCost;
	private double totalPrice;
	
	public Producer() {
		this.itemsHolder= new ArrayList<Item>();
		this.boxesHolder= new ArrayList<Box<Item>>();
		this.twoDim= new ArrayList<List<String>>();
		this.containersHolder=new ArrayList<Container>();
		this.totalCost=0;
		this.totalPrice=0;
	}
	private void createTwoDim(){
		try {
			twoDim=FileOpen.getTwoDim("ExampleCommands.csv");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public List<List<String>> getTwodim() {
		createTwoDim();
		return twoDim;
	}
	/*
	 * This method is used for producing items
	 * Produced items are hold in an arraylist.
	 */
	public void createItems() {
		for(List<String> line:twoDim) {
				if((line.size()!=0)){
				switch(line.get(1)) {
				case "M1":
					BoxOfMilk milk = new BoxOfMilk(Double.parseDouble(line.get(2)),line.get(3));
					createBoxOfMilk(line);
					break;
				case "S1":
					createSugar(line);
					break;
				case "W1":
					createBoxOfWater(line);
					break;
				case "O1":
					createBoxOfOil(line);
					break;
				case "P1":
					createPasta(line);
					break;
				case "R1":
					createRice(line);
					break;
				case "F1":
					createFlour(line);
					break;
				default:
					break;	
				}
			}
		}		
	}
	/*
	 * This method is used for producing boxes
	 * Produced boxes are hold in an arraylist.
	 */
	public void createBoxes() {
		for(List<String> line:twoDim) {
			if(line.size()!=0){
				switch(line.get(1)) {
				case "B1":
					createNumberBox(line);
					break;
				case "B2":
					createMassBox(line);
					break;	
				}
			}	
		}
	}
	/*
	 * This method is used for producing container
	 * Produced containers are hold in an arraylist.
	 */
	public void createContainer() {
		for(List<String> line:twoDim) {
			if(line.size()!=0){
				switch(line.get(1)) {
				case "C1":
					Container container = new Container(Double.parseDouble(line.get(2)),line.get(3));
					try {
						if(!containersHolder.contains(container)){
							containersHolder.add(container);
							System.out.println(container.getVolume()+" liters of container has been produced with the "
									+ "serial number "+container.getSerialNumber());
							totalCost-=container.getCostOfContainer();
							System.out.println("Revenue: "+totalCost);
						}
						else {
							throw new SameSerialNumberException("\n"+"An container cannot be produced with the same serial number. "+" Ex code: "+ SameSerialNumberException.CODE+"\n");
						}
					}
					catch(SameSerialNumberException e) {
						System.out.println(e.getMessage());
					}
					break;
					
				}
			}	
		}
	}
	private void createBoxOfMilk(List<String> line) {
		BoxOfMilk milk = new BoxOfMilk(Double.parseDouble(line.get(2)),line.get(3));
		try {
			if(!itemsHolder.contains(milk)){
				itemsHolder.add(milk);
				System.out.println(milk.getVolume()+" liter of milk has been produced with the serial number "+milk.getItemSerialNumber());
				totalCost-=milk.getCost();
				totalPrice+=milk.getPrice();
				System.out.println("Revenue: "+totalCost);
			}
			else{
				throw new SameSerialNumberException("\n"+"An item cannot be produced with the same serial number. "+" Ex code: "+ SameSerialNumberException.CODE+"\n");
			}	
		}
		catch(SameSerialNumberException e) {
			System.out.println(e.getMessage());
		}
		
	}
	private void createSugar(List<String> line) {
		Sugar sugar = new Sugar(Integer.parseInt(line.get(2)),Double.parseDouble(line.get(3)),line.get(4));
		try {
			if(!itemsHolder.contains(sugar)){
				itemsHolder.add(sugar);
				System.out.println(sugar.getMass()+" kilograms of sugar has been produced with the serial number "+sugar.getItemSerialNumber());
				totalCost-=sugar.getCost();
				totalPrice+=sugar.getPrice();
				System.out.println("Revenue: "+totalCost);
			}
			else{
				throw new SameSerialNumberException("\n"+"An item cannot be produced with the same serial number. "+" Ex code: "+ SameSerialNumberException.CODE+"\n");
			}
		}
		catch(SameSerialNumberException e) {
			System.out.println(e.getMessage());
		}
		
	}
	private void createBoxOfWater(List<String> line) {
		BoxOfWater water = new BoxOfWater(Double.parseDouble(line.get(2)),line.get(3));
		try {
			if(!itemsHolder.contains(water)){
				itemsHolder.add(water);
				System.out.println(water.getVolume()+" liter of water has been produced with the serial number "+water.getItemSerialNumber());
				totalCost-=water.getCost();
				totalPrice+=water.getPrice();
				System.out.println("Revenue: "+totalCost);
			}
			else{
				throw new SameSerialNumberException("\n"+"An item cannot be produced with the same serial number. "+" Ex code: "+ SameSerialNumberException.CODE+"\n");
			}	
		}
		catch(SameSerialNumberException e) {
			System.out.println(e.getMessage());
		}
	}
	private void createBoxOfOil(List<String> line) {
		BoxOfOil oil = new BoxOfOil(Double.parseDouble(line.get(2)),line.get(3));
		try {
			if(!itemsHolder.contains(oil)){
				itemsHolder.add(oil);
				System.out.println(oil.getVolume()+" liter of oil has been produced with the serial number "+oil.getItemSerialNumber());
				totalCost-=oil.getCost();
				totalPrice+=oil.getPrice();
				System.out.println("Revenue: "+totalCost);
			}
			else{
				throw new SameSerialNumberException("\n"+"An item cannot be produced with the same serial number. "+" Ex code: "+ SameSerialNumberException.CODE+"\n");
			}
		}
		catch(SameSerialNumberException e) {
			System.out.println(e.getMessage());
		}
	}
	private void createPasta(List<String> line) {
		Pasta pasta = new Pasta(Integer.parseInt(line.get(2)),Double.parseDouble(line.get(3)),line.get(4));
		try {
			if(!itemsHolder.contains(pasta)){
				itemsHolder.add(pasta);
				System.out.println(pasta.getMass()+" kilograms of pasta has been produced with the serial number "+pasta.getItemSerialNumber());
				totalCost-=pasta.getCost();
				totalPrice+=pasta.getPrice();
				System.out.println("Revenue: "+totalCost);
			}
			else{
				throw new SameSerialNumberException("\n"+"An item cannot be produced with the same serial number. "+" Ex code: "+ SameSerialNumberException.CODE+"\n");
			}
		}
		catch(SameSerialNumberException e) {
			System.out.println(e.getMessage());
		}
	}
	private void createFlour(List<String> line) {
		Flour flour = new Flour(Integer.parseInt(line.get(2)),Double.parseDouble(line.get(3)),line.get(4));
		try {
			if(!itemsHolder.contains(flour)){
				itemsHolder.add(flour);
				System.out.println(flour.getMass()+" kilograms of flour has been produced with the serial number "+flour.getItemSerialNumber());
				totalCost-=flour.getCost();
				totalPrice+=flour.getPrice();
				System.out.println("Revenue: "+totalCost);	
			}
			else{
				throw new SameSerialNumberException("\n"+"An item cannot be produced with the same serial number. "+" Ex code: "+ SameSerialNumberException.CODE+"\n");
			}
		}
		catch(SameSerialNumberException e) {
			System.out.println(e.getMessage());
		}
	}
	private void createRice(List<String> line) {
		Rice rice = new Rice(Integer.parseInt(line.get(2)),Double.parseDouble(line.get(3)),line.get(4));
		try {
			if(!itemsHolder.contains(rice)){
				itemsHolder.add(rice);
				System.out.println(rice.getMass()+" kilograms of rice has been produced with the serial number "+rice.getItemSerialNumber());
				totalCost-=rice.getCost();
				totalPrice+=rice.getPrice();
				System.out.println("Revenue: "+totalCost);
			}
			else{
				throw new SameSerialNumberException("\n"+"An item cannot be produced with the same serial number. "+" Ex code: "+ SameSerialNumberException.CODE+"\n");
			}
		}
		catch(SameSerialNumberException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void createNumberBox(List<String> line) {
		NumberBox numberBox = new NumberBox(Integer.parseInt(line.get(2)),Double.parseDouble(line.get(3)),line.get(4));
		try {
			if(!boxesHolder.contains(numberBox)){
				System.out.println(numberBox.getVolume()+" liters of number box has been produced with "
						+ "capacity of "+numberBox.getCapacity()+" with the serial number "+numberBox.getBoxSerialNumber());
				totalCost-=numberBox.getCostOfBox();
				System.out.println("Revenue: "+ totalCost);
				boxesHolder.add(numberBox);
			}
			else{
				throw new SameSerialNumberException("\n"+"An box cannot be produced with the same serial number. "+" Ex code: "+ SameSerialNumberException.CODE+"\n");
				
			}
		}
		catch(SameSerialNumberException e) {
			System.out.println(e.getMessage());
		}
	}
	private void createMassBox(List<String> line) {
		MassBox massBox = new MassBox(Integer.parseInt(line.get(2)),Double.parseDouble(line.get(3)),line.get(4));
		try{
			if(!boxesHolder.contains(massBox)){
			System.out.println(massBox.getVolume()+" liters of mass box has been produced with "
					+ "capacity of "+massBox.getCapacity()+" kg with the serial number "+massBox.getBoxSerialNumber());
			totalCost-=massBox.getCostOfBox();
			System.out.println("Revenue: "+ totalCost);
			boxesHolder.add(massBox);
			}
			else{
				throw new SameSerialNumberException("\n"+"An box cannot be produced with the same serial number. "+" Ex code: "+ SameSerialNumberException.CODE+"\n");
			}
			

		}
		catch(SameSerialNumberException e) {
			System.out.println(e.getMessage());
		}
	}
	public List<Item> getItemsHolder() {
		return itemsHolder;
	}
	public List<Box<Item>> getBoxesHolder() {
		return boxesHolder;
	}
	public List<Container> getContainersHolder() {
		return containersHolder;
	}
	
	public double getTotalCost() {
		return totalCost;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	
}