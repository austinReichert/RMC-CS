import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

public class CycleFinderVisitor implements GraphVisitor{
    private LinkedList<Integer> cycle;

    @Override
    public void visitEdge(int x, int y, GraphVisitor.SearchContext context) {
        if (!Objects.equals(context.getParents().get(y), x)){
            cycle = (findPath(y, x, context));
            context.setFinished(true);
        }
    }
    @Override
    public void visitVertexEarly(int x, GraphVisitor.SearchContext context) {}
    @Override
    public void visitVertexLate(int x, GraphVisitor.SearchContext context) {}
    private LinkedList<Integer> findPath(int start, Integer end, GraphVisitor.SearchContext context){
        LinkedList<Integer> list;
        if (start == end || end == -1){
            list = new LinkedList<>();
            list.add(start);
        }
        else {
            list = findPath(start, context.getParents().getOrDefault(end, -1), context);
            list.add(end);
        }
        return list;
    }
    public LinkedList<Integer> getCycle(){
        return cycle;
    }
}
