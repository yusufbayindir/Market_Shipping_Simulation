package program;

public class Rice extends Item implements Uncountable {    
	public static final String ITEMCODE = "R1";
    private int mass;
    Rice(int mass ,double volume,String itemSerialNumber){
        super(ITEMCODE,volume,itemSerialNumber);
        this.mass = mass;
        setCost(CostAndPrice.valueOf(ITEMCODE).getUnitCost()*mass);
        setPrice(CostAndPrice.valueOf(ITEMCODE).getUnitPrice()*volume);
    }
    Rice(Rice otherRice){
        super(otherRice);
        this.mass = otherRice.mass;
    }
    Rice(){
        super();
        this.mass = 0;
    }
	@Override
	public String toString() {
		return "Rice [mass=" + mass + super.toString();
	}

	public int getMass() {
		return mass;
	}
	
    
    
}
