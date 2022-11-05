package graph;

public class Main {

    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addEdge("A", "B", 1);
        graph.addEdge("B", "C", 1);
        graph.addEdge("B", "F", 2);
        graph.addEdge("C", "F", 1);
        graph.addEdge("D", "E", 1);
        graph.addEdge("A", "F", 1);
        // System.out.println(graph.dfs());
        // System.out.println(graph.bfs());
        // System.out.println(graph.floyd());
        System.out.println(graph.dijkstra("A"));
        // System.out.println(graph.prim());
    }
}
