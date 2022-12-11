import java.util.HashMap;
import java.util.HashSet;

public class ArticulationPointVisitor implements GraphVisitor {
    private final HashSet<Integer> articulationPoints = new HashSet<>();
    private HashMap<Integer, Integer> reachableAncestors = new HashMap<>();
    private HashMap<Integer, Integer> treeOutDegrees = new HashMap<>();

    @Override
    public void visitEdge(int x, int y, SearchContext context) {
        EdgeClass edgeClass = context.classify(x,y);
        if (edgeClass == EdgeClass.TREE){
            treeOutDegrees.put(x, treeOutDegrees.getOrDefault(x, 0)+1);
            // treeOutDegrees[x] = treeOutDegrees[x] + 1
        }
        if (edgeClass == EdgeClass.BACK && context.parent(x) != y){
            if (context.entryTime(y) < context.entryTime(reachableAncestors.get(x))){
                reachableAncestors.put(x,y);
            }
        }
    }

    @Override
    public void visitVertexEarly(int x, SearchContext context) {
        reachableAncestors.put(x,x);
    }

    @Override
    public void visitVertexLate(int x, SearchContext context) {
        int timeX, parentX;
        if (context.parent(x) < 1){
                if (treeOutDegrees.get(x) > 1) {
                    articulationPoints.add(x);
            }
            return;
        }
        if (reachableAncestors.get(x) == context.parent(x) && (!context.isRoot(context.parent(x)))){
            articulationPoints.add(context.parent(x));
        }
        if (reachableAncestors.get(x) == x){
            if (!context.isRoot(context.parent(x))) {
                articulationPoints.add(context.parent(x));
            }
            if (treeOutDegrees.get(x) != null && treeOutDegrees.get(x) > 0) {
                articulationPoints.add(x);
            }
        }
        timeX = context.entryTime(reachableAncestors.get(x));
        parentX = context.entryTime(reachableAncestors.get(context.parent(x)));
        if (timeX < parentX){
            reachableAncestors.put(context.parent(x), reachableAncestors.get(x));
        }
    }

    public HashSet<Integer> getArticulationPoints() {
        return articulationPoints;
    }
}