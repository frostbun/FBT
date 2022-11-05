package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class WeightedGraph<T> {
    private final Map<T, Vertex<T>> vertices;

    public WeightedGraph() {
        this.vertices = new HashMap<>();
    }

    public Map<T, Vertex<T>> getVertices() {
        return vertices;
    }

    public void addVertex(T v) {
        if (!vertices.containsKey(v)) vertices.put(v, new Vertex<>(v));
    }

    public void addEdge(T u, T v, int weight) {
        addVertex(u);
        addVertex(v);
        Vertex<T> uVertex = vertices.get(u);
        Vertex<T> vVertex = vertices.get(v);
        uVertex.addEdge(vVertex, weight);
        vVertex.addEdge(uVertex, weight);
    }

    public List<List<Vertex<T>>> bfs() {
        List<List<Vertex<T>>> connectedComponentList = new ArrayList<>();
        Map<Vertex<T>, Boolean> visited = new HashMap<>();
        for (Vertex<T> vertex: vertices.values()) {
            if (visited.containsKey(vertex)) continue;
            List<Vertex<T>> connectedComponent = new ArrayList<>();
            connectedComponentList.add(connectedComponent);
            List<Vertex<T>> queue = new LinkedList<>();
            queue.add(vertex);
            while (!queue.isEmpty()) {
                Vertex<T> next = queue.remove(0);
                if (visited.containsKey(next)) continue;
                visited.put(next, true);
                connectedComponent.add(next);
                for (Edge<T> edge: next.getAdjList()) {
                    if (visited.containsKey(edge.getV())) continue;
                    queue.add(edge.getV());
                }
            }
        }
        return connectedComponentList;
    }

    public List<List<Vertex<T>>> dfs() {
        List<List<Vertex<T>>> connectedComponentList = new ArrayList<>();
        Map<Vertex<T>, Boolean> visited = new HashMap<>();
        for (Vertex<T> vertex: vertices.values()) {
            if (visited.containsKey(vertex)) continue;
            List<Vertex<T>> connectedComponent = new ArrayList<>();
            connectedComponentList.add(connectedComponent);
            Stack<Vertex<T>> stack = new Stack<>();
            stack.push(vertex);
            while (!stack.isEmpty()) {
                Vertex<T> next = stack.pop();
                if (visited.containsKey(next)) continue;
                visited.put(next, true);
                connectedComponent.add(next);
                for (Edge<T> edge: next.getAdjList()) {
                    if (visited.containsKey(edge.getV())) continue;
                    stack.push(edge.getV());
                }
            }
        }
        return connectedComponentList;
    }

    public Map<Vertex<T>, Map<Vertex<T>, Integer>> floyd() {
        Map<Vertex<T>, Map<Vertex<T>, Integer>> shortestPath = new HashMap<>();
        for (Vertex<T> u: vertices.values()) {
            Map<Vertex<T>, Integer> path = new HashMap<>();
            shortestPath.put(u, path);
            path.put(u, 0);
            u.getAdjList().forEach(edge -> path.put(edge.getV(), edge.getWeight()));
            for (Vertex<T> v: vertices.values()) {
                if (!path.containsKey(v)) path.put(v, Integer.MAX_VALUE);
            }
        }
        for (Vertex<T> u: vertices.values()) {
            Map<Vertex<T>, Integer> path = shortestPath.get(u);
            for (Vertex<T> v: vertices.values()) {
                for (Vertex<T> t: vertices.values()) {
                    Edge<T> ut = u.getEdge(t);
                    Edge<T> tv = t.getEdge(v);
                    if (ut == null || tv == null) continue;
                    path.put(v, Integer.min(path.get(v), ut.getWeight() + tv.getWeight()));
                }
            }
        }
        return shortestPath;
    }

    public List<Edge<T>> dijkstra(T begin) {
        List<Edge<T>> shortestPath = new ArrayList<>();
        Vertex<T> beginVertex = vertices.get(begin);
        if (beginVertex == null) return shortestPath;
        Map<Vertex<T>, Boolean> visited = new HashMap<>();
        visited.put(beginVertex, true);
        PriorityQueue<Edge<T>> queue = new PriorityQueue<>();
        beginVertex.getAdjList().forEach(edge -> queue.add(edge));
        while (!queue.isEmpty()) {
            Edge<T> next = queue.remove();
            if (visited.containsKey(next.getV())) continue;
            visited.put(next.getV(), true);
            shortestPath.add(next);
            for (Edge<T> edge: next.getV().getAdjList()) {
                if (visited.containsKey(edge.getV())) continue;
                queue.add(new Edge<>(beginVertex, edge.getV(), next.getWeight() + edge.getWeight()));
            }
        }
        return shortestPath;
    }

    public List<List<Edge<T>>> prim() {
        List<List<Edge<T>>> minimumSpanningTreeList = new ArrayList<>();
        Map<Vertex<T>, Boolean> visited = new HashMap<>();
        for (Vertex<T> vertex: vertices.values()) {
            if (visited.containsKey(vertex)) continue;
            List<Edge<T>> minimumSpanningTree = new ArrayList<>();
            minimumSpanningTreeList.add(minimumSpanningTree);
            visited.put(vertex, true);
            PriorityQueue<Edge<T>> queue = new PriorityQueue<>();
            vertex.getAdjList().forEach(edge -> queue.add(edge));
            while (!queue.isEmpty()) {
                Edge<T> next = queue.remove();
                if (visited.containsKey(next.getV())) continue;
                visited.put(next.getV(), true);
                minimumSpanningTree.add(next);
                for (Edge<T> edge: next.getV().getAdjList()) {
                    if (visited.containsKey(edge.getV())) continue;
                    queue.add(edge);
                }
            }
        }
        return minimumSpanningTreeList;
    }
}
