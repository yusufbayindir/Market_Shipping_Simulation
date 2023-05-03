package program;
import exceptions.AlreadyBoxedException;
import exceptions.LoadedBoxAddException;
import exceptions.NumberBoxOverflowException;
import exceptions.UncountableItemMismatchException;

public class NumberBox extends Box<Item> {
	public static final String BOXCODE="B1";
	private int currentNumberOfItems;
	private double currentVolume;
	
	private int numberOfItems;//max number of items can hold.
	
	NumberBox(int numberOfItems, double volume, String boxSerialNumber) {
		super(BOXCODE, volume, boxSerialNumber,volume*2,0);;
		this.numberOfItems=numberOfItems;
		this.currentVolume=0.0;
		this.currentNumberOfItems=0;
		
	}

	@Override
	public void add(Item item) {
		try{	
			if(!(item instanceof Countable)) {
				throw new UncountableItemMismatchException();
			}
			else{
				//Volume control
				if(!isLoaded()) {
					if(controlVolume(item)&&controlNumberOfItems()) {
						if (getBox().add(item)) {
							calculateCost(item);
							calculatePrice(item);
							currentNumberOfItems++;
							currentVolume+=item.getVolume();
						}
						else {
							throw new AlreadyBoxedException();
						}
					}
					else {
						throw new NumberBoxOverflowException();
					}
				}
				else{
					throw new LoadedBoxAddException();
				}
				
			}
		}
		catch(UncountableItemMismatchException e) {
			System.out.println(e.getMessage());
		}
		catch(LoadedBoxAddException e) {
			System.out.println(e.getMessage());
		}
		catch(NumberBoxOverflowException e) {
			System.out.println(e.getMessage());
		}
		catch(AlreadyBoxedException e) {
			System.out.println(e.getMessage());
		}
	}
	private boolean controlNumberOfItems(){
		return !(1+currentNumberOfItems>numberOfItems);
	}

	
	private boolean controlVolume(Item item) {
		return !(item.getVolume()+currentVolume>getVolume());
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
		return numberOfItems;
	}

}

