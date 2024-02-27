import java.util.Scanner;

public class Package {
	
	private double weight;
	private char shippingMethod;
	private double shippingCost;
	private static Scanner sc = new Scanner(System.in);
	
	public double getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(double shippingCost) {
		this.shippingCost = shippingCost;
	}

	Package(double weight, char shippingMethod){
		this.weight = weight;
		this.shippingMethod = shippingMethod;
		shippingCost();
		
	}
	
	void shippingCost() {
		switch(this.shippingMethod) {
			case 'A':
				if(this.weight >= 1 && this.weight <= 8) {
					this.shippingCost = 2.00d;
				}else if(this.weight >= 9 && this.weight <= 16) {
					this.shippingCost = 3.00d;
				}else if(this.weight >= 17) {
					this.shippingCost = 4.50d;
				}
				break;
			case 'T':
				if(this.weight >= 1 && this.weight <= 8) {
					this.shippingCost = 1.50d;
				}else if(this.weight >= 9 && this.weight <= 16) {
					this.shippingCost = 2.35d;
				}else if(this.weight >= 17) {
					this.shippingCost = 3.25d;
				}
				break;
			case 'M':
				if(this.weight >= 1 && this.weight <= 8) {
					this.shippingCost = 0.50d;
				}else if(this.weight >= 9 && this.weight <= 16) {
					this.shippingCost = 1.50d;
				}else if(this.weight >= 17) {
					this.shippingCost = 2.15d;
				}
				break;
		}
		
	}
	
	public void displayValues() {
		System.out.printf("Package Weight: %,.2f oz\n", this.weight);
		System.out.print("Shipping Method: " + this.shippingMethod + "\n");
		System.out.printf("Shippin Cost: %,.2f \n", this.shippingCost);
	}

	public static void main(String[] args) {
		int cnt = 1;
		
		Package packages[] = new Package[3];
		InsuredPackage insuredPackages[] = new InsuredPackage[3];
		
		for(int i = 0; i < 3; i++) {
			System.out.println("Package " + (i+1));
			packages[i] = new Package(doubleInput(), charInput());
			System.out.println();
		}
		
		System.out.println("----Packages Values----");
		for(Package item : packages) {
			System.out.println("Package " + cnt);
			item.displayValues();
			cnt++;
			System.out.println();
		}
		System.out.println("-----------------------");
		
		
		for(int i = 0; i < 3; i++) {
			System.out.println("Insured Package " + (i+1));		
			insuredPackages[i] = new InsuredPackage(doubleInput(), charInput());
			System.out.println();
		}
		
		cnt = 1;
		System.out.println("----Insured Packages Values----");
		for(InsuredPackage item : insuredPackages) {
			System.out.println("Insured Package " + cnt);
			item.displayValues();
			cnt++;
			System.out.println();
		}
		System.out.println("-------------------------------");
	}
	
	static char charInput() {
		char input = ' ';
		
		while(true) {
			System.out.print("Enter Shipping Method('A', 'T' or 'M'): ");
			input = sc.next().charAt(0);
			if(input == 'A' || input == 'T' || input == 'M') {
				break;
			}else {
				System.out.println("The input is invalid. Please enter a valid value.");
			}

		}
		
		return input;
	}

	static double doubleInput() {
		double input;
		
		while(true) {
			try {
				System.out.print("Enter Package Weight(oz): ");
				input = sc.nextDouble();
				break;
			}catch (Exception e) {
				System.out.println("The input type is invalid. Please enter a valid value.");
				sc.nextLine();
			}
		}
		
		return input;
	}
}
