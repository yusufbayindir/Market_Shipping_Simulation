package program;

    
public class Flour extends Item implements Uncountable {
    public static final String ITEMCODE="F1";
    private int mass;
    Flour(int mass ,double volume,String itemSerialNumber){
        super(ITEMCODE,volume,itemSerialNumber);
        this.mass = mass;
        setCost(CostAndPrice.valueOf(ITEMCODE).getUnitCost()*mass);
        setPrice(CostAndPrice.valueOf(ITEMCODE).getUnitPrice()*volume);
    }
    Flour(Flour otherFlour){
        super(otherFlour);
        this.mass = otherFlour.mass;
    }
    Flour(){
        super();
        this.mass = 0;
    }
	@Override
	public int getMass() {
		return mass;
	}
	@Override
	public String toString() {
		return "Flour [mass=" + mass + super.toString();
	}
	

}
