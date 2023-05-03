package program;

public class BoxOfMilk extends Item implements Countable {
    public static final String ITEMCODE="M1";
    BoxOfMilk(double volume,String itemSerialNumber){
        super(ITEMCODE,volume,itemSerialNumber);
        setCost(CostAndPrice.valueOf(ITEMCODE).getUnitCost()*getVolume());
        setPrice(CostAndPrice.valueOf(ITEMCODE).getUnitPrice()*getVolume());
    }

    BoxOfMilk(){
        super();
    }

    BoxOfMilk(BoxOfMilk otherBoxOfMilk){
        super(otherBoxOfMilk);
    }
    

    
}
