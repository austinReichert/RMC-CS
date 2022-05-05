package csc.rocky.edu;

import csc.rocky.edu.toppings.cheese.Cheese;
import csc.rocky.edu.toppings.cheese.ReggianoCheese;
import csc.rocky.edu.dough.Dough;
import csc.rocky.edu.dough.ThinCrustDough;
import csc.rocky.edu.toppings.sauce.MarinaraSauce;
import csc.rocky.edu.toppings.sauce.Sauce;
import csc.rocky.edu.toppings.clams.Clams;
import csc.rocky.edu.toppings.clams.FreshClams;
import csc.rocky.edu.toppings.pep.Pepperoni;
import csc.rocky.edu.toppings.pep.SlicedPepperoni;
import csc.rocky.edu.toppings.veggies.*;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
 
	public Dough createDough() {
		return new ThinCrustDough();
	}
 
	public Sauce createSauce() {
		return new MarinaraSauce();
	}
 
	public Cheese createCheese() {
		return new ReggianoCheese();
	}
 
	public Veggies[] createVeggies() {
		Veggies veggies[] = { new Garlic(), new Onion(), new Mushroom(), new RedPepper() };
		return veggies;
	}
 
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	public Clams createClam() {
		return new FreshClams();
	}
}
