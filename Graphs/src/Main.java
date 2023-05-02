public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode("x");
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("p");
        graph.addEdge("x","b");
        graph.addEdge("x","a");
        graph.addEdge("b","p");
        graph.addEdge("a","p");
        graph.print();
        graph.topologicalSort("x");
    }
}