package program;

import java.util.List;

public class Loader {
	Producer producer;
    Loader(){
        this.producer=null;
    }
    Loader(Producer producer){
        this.producer=producer;
    }
  /*
   * After creation of boxes and Items this method should be used.
   * This method loads items to boxes and boxes to containers
   */
	public void load() {
        for(List<String> line:producer.getTwodim()) {
        	if((line.size()!=0)&&line.get(0).equals("2")) {
                for(Box<Item> box : producer.getBoxesHolder()){
        		    if(line.get(2).equals(box.getBoxSerialNumber())){
        		    	Item item = findItem(line.get(1));
        		        box.add(item);
        		        System.out.println("Item "+item.getItemSerialNumber()+" has been placed"
        		        		+ " to the box "+box.getBoxSerialNumber());
        		        
        		    }
                }
                for(Container container: producer.getContainersHolder()){
        		    if(line.get(2).equals(container.getSerialNumber())) { 
        		    	Box<Item> box = findBox(line.get(1));
        		    	System.out.println("Box "+box.getBoxSerialNumber()+" has been placed "
        		    			+ "to the container "+container.getSerialNumber());
        		   			container.add(box);
        		    	findBox(line.get(1)).setLoaded(true);
        		    }
        		}
        	}
        }
	}
	/*
	 * This method returns the box with the given serial number amon all boxes 
	 */
	private Box<Item> findBox(String boxSerialNumber){
		for(Box<Item> temp:producer.getBoxesHolder()) {
			if(temp.getBoxSerialNumber().equals(boxSerialNumber)) {
				return temp;
			}
		}
		return null;
	}
	/*
	 * This method returns the item with the given serial number among all the items
	 */
	private Item findItem(String itemSerialNumber) {
		for(Item temp:producer.getItemsHolder()) {
			if(temp.getItemSerialNumber().equals(itemSerialNumber)) {
				
				return temp;
			}
		}
		return null;
	}
	
	}

