public class Num implements Expr{
    private Integer value;
    public Num(Integer value){
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public int eval() {
        return value;
    }

    @Override
    public String infix() {
        return String.valueOf(value);
    }

    @Override
    public String prefix() {
        return String.valueOf(value);
    }
}
