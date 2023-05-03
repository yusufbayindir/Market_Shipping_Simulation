package program;


public class Shipper {
	public void ship() {
		Producer p=new Producer();
		p.getTwodim();
		p.createBoxes();
		p.createItems();
		p.createContainer();
		Loader loader=new Loader(p);
		loader.load();
		double revenue=0;
		double unearnedRevenue=0;
		for(Container container:p.getContainersHolder()){
			revenue=container.getPriceOfContainer()+p.getTotalCost();
			unearnedRevenue=p.getTotalPrice()-container.getPriceOfContainer();
			System.out.println("Container "+container.getSerialNumber()+" has been shipped. Revenue= "+revenue);
			System.out.println("Unearned revenue= "+unearnedRevenue);
		}
		double totalRevenue=revenue;
		System.out.println("TotalRevenue= "+ totalRevenue);
	}
}
