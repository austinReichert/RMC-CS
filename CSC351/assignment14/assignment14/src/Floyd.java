import java.util.TreeSet;

public class Floyd {
    private final Integer[][] weights;
    private final TreeSet<Integer> vertices = new TreeSet<>();
    private final int maxSize;
    private final boolean directed;

    public Floyd(int maxSize, boolean directed) {
        this.maxSize = maxSize;
        this.directed = directed;
        weights = new Integer[maxSize + 1][maxSize + 1];
        for (int i = 1; i < maxSize; i++) {
            for (int j = 1; j < maxSize; j++) {
                //edges that are not added have a weight of the largest integer.
                weights[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    public void insertEdge(int a, int b, Integer weight) {
        if (a > maxSize) {
            throw new IllegalArgumentException(String.format("vertex a:%s was bigger than configured maxSize", a));
        }
        if (b > maxSize) {
            throw new IllegalArgumentException(String.format("vertex b:%s was bigger than configured maxSize", b));
        }
        weights[a][a] = 0;
        weights[b][b] = 0;
        vertices.add(a);
        vertices.add(b);

        weights[a][b] = weight;
        if (!directed) {
            weights[b][a] = weight;
        }
    }

    public void floyd() {
        int through_k;
        for (Integer k : vertices) {
            for (Integer i : vertices) {
                for (Integer j : vertices) {
                    if (edgeExists(i, k) && edgeExists(k, j)) {
                        through_k = getWeight(i, k) + getWeight(k, j);
                        if (through_k < getWeight(i, j)) {
                            weights[i][j] = through_k;
                        }
                    }
                }
            }
        }
    }

    public boolean edgeExists(int a, int b) {
        return weights[a][b] != Integer.MAX_VALUE;
    }

    public boolean edgeMissing(int a, int b) {
        return weights[a][b] == Integer.MAX_VALUE;
    }

    public int getWeight(int a, int b) {
        return weights[a][b];
    }
}