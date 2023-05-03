package program;

public class BoxOfOil extends Item implements Countable {
	public static final String ITEMCODE="O1";
    BoxOfOil(double volume,String itemSerialNumber){
        super(ITEMCODE,volume,itemSerialNumber);
        setCost(CostAndPrice.valueOf(ITEMCODE).getUnitCost()*getVolume());
        setPrice(CostAndPrice.valueOf(ITEMCODE).getUnitPrice()*getVolume());
    }
    BoxOfOil(){
        super();
    }
    BoxOfOil(BoxOfOil otherBoxOfOil){
        super(otherBoxOfOil);
    }

}
