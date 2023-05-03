package program;

import exceptions.AlreadyBoxedException;
import exceptions.CountableItemMismatchException;
import exceptions.LoadedBoxAddException;
import exceptions.MassBoxOverflowException;

public class MassBox extends Box<Item> {
	public static final String BOXCODE="B2";
	private double currentVolume;
	private int currentMass;
	private int takenMassOfBox; //maximum mass

	MassBox(int takenMassOfBox, double volume, String boxSerialNumber) {
		super(BOXCODE, volume, boxSerialNumber,volume*3,0);
		this.takenMassOfBox = takenMassOfBox;
		this.currentVolume=0.0;
		this.currentMass=0;	
	}

	@Override
	public void add(Item item) {
		try{
			if(!(item instanceof Uncountable)) {
				throw new CountableItemMismatchException();
			}
			else{
				
				if(!isLoaded())	{
					if(controlVolume(item)&&controlMass(item)) {
						if (getBox().add(item)) {
							calculateCost(item);
							calculatePrice(item);
							currentMass+=item.getMass();
							currentVolume+=item.getVolume();
						}
						else {
							throw new AlreadyBoxedException();
						}
					}
					else{
						throw new MassBoxOverflowException();
					}
				}
				else{
						throw new LoadedBoxAddException();
				}
			}
		}
		catch(CountableItemMismatchException e) {
			System.out.println(e.getMessage());
		}
		catch(LoadedBoxAddException e){
			System.out.println(e.getMessage());
		}
		catch(MassBoxOverflowException e){
			System.out.println(e.getMessage());
		}
		catch(AlreadyBoxedException e){
			System.out.println(e.getMessage());
		}
	}

	private boolean controlVolume(Item item) {
		return !(item.getVolume()+currentVolume>getVolume());
	}
	
	private boolean controlMass(Item item) {
		return !(item.getMass()+currentMass>takenMassOfBox) ;	
	}
	

	@Override
	public void calculateCost(Item item) {
		setCostOfBox(getCostOfBox()+item.getCost());
		
	}
	@Override
	public void calculatePrice(Item item) {
		setPriceOfBox(getPriceOfBox()+item.getPrice());
		
	}

	public int getCapacity() {
		return takenMassOfBox;
	}

	@Override
	public String toString() {
		return "MassBox [currentVolume=" + currentVolume + ", currentMass=" + currentMass + ", takenMassOfBox="
				+ takenMassOfBox + ", costOfBox=" + getCostOfBox() + ", Price="+getPriceOfBox()+ "]";
	}


}
