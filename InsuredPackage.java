
public class InsuredPackage extends Package{

	InsuredPackage(double weight, char shippingMethod) {
		super(weight, shippingMethod);
		
		if(super.getShippingCost() >= 0 && super.getShippingCost() <= 1) {
			super.setShippingCost(super.getShippingCost() + 2.45d);
		}else if(super.getShippingCost() >= 1.01 && super.getShippingCost() <= 3) {
			super.setShippingCost(super.getShippingCost() + 3.95d);
		}else if(super.getShippingCost() >= 3.01) {
			super.setShippingCost(super.getShippingCost() + 5.55d);
		}
		
	}
	
}