package csc.rocky.edu;

import csc.rocky.edu.toppings.cheese.Cheese;
import csc.rocky.edu.toppings.cheese.MozzarellaCheese;
import csc.rocky.edu.dough.Dough;
import csc.rocky.edu.dough.ThickCrustDough;
import csc.rocky.edu.toppings.sauce.PlumTomatoSauce;
import csc.rocky.edu.toppings.sauce.Sauce;
import csc.rocky.edu.toppings.clams.Clams;
import csc.rocky.edu.toppings.clams.FrozenClams;
import csc.rocky.edu.toppings.pep.Pepperoni;
import csc.rocky.edu.toppings.pep.SlicedPepperoni;
import csc.rocky.edu.toppings.veggies.BlackOlives;
import csc.rocky.edu.toppings.veggies.Eggplant;
import csc.rocky.edu.toppings.veggies.Spinach;
import csc.rocky.edu.toppings.veggies.Veggies;

public class ChicagoPizzaIngredientFactory
	implements PizzaIngredientFactory 
{

	public Dough createDough() {
		return new ThickCrustDough();
	}

	public Sauce createSauce() {
		return new PlumTomatoSauce();
	}

	public Cheese createCheese() {
		return new MozzarellaCheese();
	}

	public Veggies[] createVeggies() {
		Veggies veggies[] = { new BlackOlives(),
		                      new Spinach(),
		                      new Eggplant() };
		return veggies;
	}

	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	public Clams createClam() {
		return new FrozenClams();
	}
}
