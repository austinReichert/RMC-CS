public class Explode implements Expr{
    Expr value;
    public Explode(Expr value){
        this.value = value;
    }
    @Override
    public int eval() {
        int number = value.eval();
        if (number > 0){
            int result = 0;
            for(int i=0; i <= number; i++){
                result+=i;
            }
            return result;
        }
        int result = 0;
        for (int i= number; i < 0; i++){
            result+=i;
        }
        return result;
    }
    @Override
    public String infix() {
        return value.infix() + "#";
    }
    @Override
    public String prefix() {
        return "#" + value.prefix();
    }
}
