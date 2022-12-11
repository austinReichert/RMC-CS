import java.util.Map;

public class PrintGraphVisitor implements GraphVisitor {
    @Override
    public void visitEdge(int x, int y, GraphVisitor.SearchContext context) {
        System.out.println("Edge (" + x + "," + y + ")");
    }
    @Override
    public void visitVertexEarly(int x, GraphVisitor.SearchContext context) {
        System.out.println("Vertex (" + x + ")");

    }
    @Override
    public void visitVertexLate(int x, GraphVisitor.SearchContext context) {

    }

}