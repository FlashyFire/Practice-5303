package praktika;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final int vertexCount;
    private final ArrayList<Vertex> vertices;
    private final Matrix edges;
    
    public Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        this.vertices = new ArrayList<>(vertexCount);
        this.edges = new Matrix(vertexCount, vertexCount);
    }
    
    public int vertexCount() {
        return this.vertexCount;
    }
    
    public List<Vertex> vertices() {
        return this.vertices;
    }
    
    public Matrix edges() {
        return this.edges;
    }
}
