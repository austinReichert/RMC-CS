public class Divide implements Expr{

    Expr left, right;
    public Divide(Expr left, Expr right){
        this.left = left;
        this.right = right;
    }
    @Override
    public int eval() {
        return left.eval() / right.eval();
    }
    @Override
    public String infix() {
        return left.infix() + "/" + right.infix();
    }
    @Override
    public String prefix() {
        return "/" + left.prefix() + right.prefix();
    }
}