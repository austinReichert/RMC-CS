public abstract class Beverage{

    public static final int SIZE_SMALL = 0;
    public static final int SIZE_MEDIUM = 1;
    public static final int SIZE_LARGE = 2;
    public int price;
    public int size;

    public Beverage(int price, int size){
        this.price = price;
        this.size = size; }

    public int getPrice(){ return this.price; }

    public abstract String toString();
    //Abstract means that it does not need '{}'

}

