package csc.rocky.edu;

import csc.rocky.edu.toppings.cheese.Cheese;
import csc.rocky.edu.dough.Dough;
import csc.rocky.edu.toppings.sauce.Sauce;
import csc.rocky.edu.toppings.clams.Clams;
import csc.rocky.edu.toppings.pep.Pepperoni;
import csc.rocky.edu.toppings.veggies.Veggies;

public interface PizzaIngredientFactory {
 
	public Dough createDough();
	public Sauce createSauce();
	public Cheese createCheese();
	public Veggies[] createVeggies();
	public Pepperoni createPepperoni();
	public Clams createClam();
 
}
