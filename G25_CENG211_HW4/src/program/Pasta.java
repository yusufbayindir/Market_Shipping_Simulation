package program;

public class Pasta extends Item implements Uncountable {
    public static final String ITEMCODE="P1";
	private int mass;
    Pasta(int mass,double volume,String itemSerialNumber){
        super(ITEMCODE,volume,itemSerialNumber);
        this.mass = mass;
        setCost(CostAndPrice.valueOf(ITEMCODE).getUnitCost()*mass);
        setPrice(CostAndPrice.valueOf(ITEMCODE).getUnitPrice()*volume);
    }
    Pasta(Pasta otherPasta){
        super(otherPasta);
        this.mass = otherPasta.mass;
    }
    Pasta(){
        super();
        this.mass = 0;
    }
	@Override
	public int getMass() {
		return mass;
	}
	@Override
	public String toString() {
		return	"Pasta [mass=" + mass + super.toString();
	}
    
	
}
