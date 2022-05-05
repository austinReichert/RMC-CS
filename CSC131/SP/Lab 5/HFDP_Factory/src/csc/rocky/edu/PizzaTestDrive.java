package csc.rocky.edu;

import csc.rocky.edu.pizza.Pizza;

public class PizzaTestDrive {

	//List below is what I added to this code. [classes]
	//CaliforniaPizzaIngredientFactory, CaliforniaPizzaStore.
	//VEGGIES: Asparagus, BrusselsSprouts, Cucumber
	//SAUCE: WhiteSauce
	//PEP: HotSalami (didn't use), BeefPepperoni.
	//CLAMS: Geoducks
	//CHEESE: CasuMarzuCheese.
	//DOUGH: NeapolitanDough

	public static void main(String[] args) {
		PizzaStore caliStore = new CaliforniaPizzaStore();
		PizzaStore nyStore = new NYPizzaStore();
		PizzaStore chicagoStore = new ChicagoPizzaStore();

		//sorted pizza creation order (Cali, Chicago, NY)

		//CALIFORNIA
		Pizza pizza = caliStore.orderPizza("cheese");
		System.out.println("Ethan ordered a " + pizza + "\n");

		pizza = caliStore.orderPizza("clam");
		System.out.println("Ethan ordered a " + pizza + "\n");

		pizza = caliStore.orderPizza("pepperoni");
		System.out.println("Ethan ordered a " + pizza + "\n");

		pizza = caliStore.orderPizza("veggie");
		System.out.println("Ethan ordered a " + pizza + "\n");

		//CHICAGO
		pizza = chicagoStore.orderPizza("cheese");
		System.out.println("George ordered a " + pizza + "\n");

		pizza = chicagoStore.orderPizza("clam");
		System.out.println("George ordered a " + pizza + "\n");

		pizza = chicagoStore.orderPizza("pepperoni");
		System.out.println("George ordered a " + pizza + "\n");

		pizza = chicagoStore.orderPizza("veggie");
		System.out.println("George ordered a " + pizza + "\n");

		//NY
		pizza = nyStore.orderPizza("cheese");
		System.out.println("Jeff ordered a " + pizza + "\n");

		pizza = nyStore.orderPizza("clam");
		System.out.println("Jeff ordered a " + pizza + "\n");

		pizza = nyStore.orderPizza("pepperoni");
		System.out.println("Jeff ordered a " + pizza + "\n");

		pizza = nyStore.orderPizza("veggie");
		System.out.println("Jeff ordered a " + pizza + "\n");
	}
}
