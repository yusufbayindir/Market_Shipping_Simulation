package program;

public class Sugar extends Item implements Uncountable {
	public static final String ITEMCODE = "S1";
    private int mass;
    Sugar(int mass ,double volume,String itemSerialNumber){
        super(ITEMCODE,volume,itemSerialNumber);
        this.mass = mass;
        setCost(CostAndPrice.valueOf(ITEMCODE).getUnitCost()*mass);
        setPrice(CostAndPrice.valueOf(ITEMCODE).getUnitPrice()*volume);
    }
    Sugar(Sugar otherSugar){
        super(otherSugar);
        this.mass=otherSugar.mass;
    }
    Sugar(){
        super();
        this.mass = 0;
    }
	@Override
	public int getMass() {
		return mass;
	}
	@Override
	public String toString() {
		return "Sugar [mass=" + mass + super.toString();
	}
	
}
