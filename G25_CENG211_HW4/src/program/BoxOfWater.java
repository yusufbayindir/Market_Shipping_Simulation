package program;

public class BoxOfWater extends Item implements Countable {
    public static final String ITEMCODE="W1";

    BoxOfWater(double volume,String itemSerialNumber) {
        super(ITEMCODE,volume,itemSerialNumber);
        setCost(CostAndPrice.valueOf(ITEMCODE).getUnitCost()*getVolume());
        setPrice(CostAndPrice.valueOf(ITEMCODE).getUnitPrice()*getVolume());
    }
    BoxOfWater(){
        super();
    }
    BoxOfWater(BoxOfWater otherBoxOfWater){
        super(otherBoxOfWater);
    }

}
