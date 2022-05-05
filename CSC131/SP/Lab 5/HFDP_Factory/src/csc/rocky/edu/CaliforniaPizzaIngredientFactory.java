package csc.rocky.edu;

import csc.rocky.edu.dough.Dough;
import csc.rocky.edu.dough.NeapolitanDough;
import csc.rocky.edu.toppings.cheese.CasuMarzuCheese;
import csc.rocky.edu.toppings.cheese.Cheese;
import csc.rocky.edu.toppings.clams.Clams;
import csc.rocky.edu.toppings.clams.Geoducks;
import csc.rocky.edu.toppings.pep.BeefPepperoni;
import csc.rocky.edu.toppings.pep.Pepperoni;
import csc.rocky.edu.toppings.sauce.Sauce;
import csc.rocky.edu.toppings.sauce.WhiteSauce;
import csc.rocky.edu.toppings.veggies.*;

public class CaliforniaPizzaIngredientFactory implements PizzaIngredientFactory{

    public Dough createDough() { return new NeapolitanDough(); }

    public Sauce createSauce() { return new WhiteSauce(); }

    public Cheese createCheese() { return new CasuMarzuCheese(); }


    public Veggies[] createVeggies() {
        Veggies veggies[] = { new BrusselsSprouts(), new Asparagus(), new Cucumber() };
        return veggies; }

    public Pepperoni createPepperoni() { return new BeefPepperoni(); }

    public Clams createClam() { return new Geoducks(); }

}
