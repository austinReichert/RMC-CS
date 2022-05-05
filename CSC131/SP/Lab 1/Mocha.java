public class Mocha extends Latte{

    public Mocha(int price, int size){
        super(price, size);
    }

    public int getPrice(){
        return this.price;
    }

    public String toString() {
        String s = "";
        if(size == 0){ s = "small";}
        else if(size == 1){ s = "medium";}
        else if(size == 2){ s = "large";}
        //'s' is so the string changes depending on set size.

        return "I'm a " + s + " Mocha. " + "$" + price/100 + ".";
    }

    public void addWhippedCream(){
        String s = "";
        if(size == 0){ s = "small";}
        else if(size == 1){ s = "medium";}
        else if(size == 2){ s = "large";}
        //'s' is so the string changes depending on set size.
        System.out.println("Adding cream to your " + s + " Mocha!");
    }

}
