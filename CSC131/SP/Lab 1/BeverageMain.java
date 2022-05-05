public class BeverageMain {

    public static void main(String[] args){

        int i = 0;
        //counter variable

        Beverage[] drinks = new Beverage[10];
        //Array

        drinks[0] = new Latte(200,Beverage.SIZE_SMALL);
        drinks[1] = new Latte(300,Beverage.SIZE_MEDIUM);
        drinks[2] = new Latte(400,Beverage.SIZE_LARGE);
        drinks[3] = new Mocha(300,Beverage.SIZE_SMALL);
        drinks[4] = new Mocha(400,Beverage.SIZE_MEDIUM);
        drinks[5] = new Mocha(500,Beverage.SIZE_LARGE);
        drinks[6] = new Cappuccino(100,Beverage.SIZE_SMALL);
        drinks[7] = new Cappuccino(200,Beverage.SIZE_MEDIUM);
        drinks[8] = new Cappuccino(300,Beverage.SIZE_LARGE);
        drinks[9] = new Latte(300,Beverage.SIZE_SMALL);

        Mocha m = (Mocha) drinks[3];
        //Downcast?

        for(i = 0; i < 9; i++){
        System.out.println(drinks[i].toString());

        if(i == 4){
            m.addWhippedCream();
            //Can be applied to ALL Mochas, but was only applied to drinks[3]
            }
        }
    }
}