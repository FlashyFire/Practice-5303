package praktika;

import java.io.InputStream;
import java.util.Scanner;
import java.util.List;

public abstract class GraphReader {
    
    public Graph read(InputStream stream) {
        try (Scanner scanner = new Scanner(stream)) {
            int vertexCount = scanner.nextInt();
            Graph result = new Graph(vertexCount);
            readVertices(scanner, result);
            readEdges(scanner, result);
            return result;
        }
    }
    
    private void readVertices(Scanner scanner, Graph graph) {
        int count = graph.vertexCount();
        List<Vertex> vertices = graph.vertices();
        for (int i = 0; i < count; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            vertices.add(new Vertex(x, y));
        }
    }
    
    protected abstract void readEdges(Scanner scanner, Graph graph);
}
