package graph;

public class Edge<T> implements Comparable<Edge<T>> {

    private final Vertex<T> u;
    private final Vertex<T> v;
    private final int weight;

    protected Edge(Vertex<T> u, Vertex<T> v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    public Vertex<T> getU() {
        return this.u;
    }

    public Vertex<T> getV() {
        return this.v;
    }

    public int getWeight() {
        return this.weight;
    }

    public int compareTo(Edge<T> other) {
        return Integer.compare(this.weight, other.weight);
    }

    public String toString() {
        return String.format("%s--(%d)->%s", u, weight, v);
    }
}
