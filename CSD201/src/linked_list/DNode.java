package linked_list;

public class DNode<T> {

    private T data;
    private DNode<T> next;
    private DNode<T> prev;

    public DNode(T data, DNode<T> next, DNode<T> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public DNode(T data) {
        this(data, null, null);
    }

    public T getData() {
        return this.data;
    }

    public DNode<T> getNext() {
        return this.next;
    }

    public void setNext(DNode<T> next) {
        this.next = next;
    }

    public DNode<T> getPrev() {
        return this.prev;
    }

    public void setPrev(DNode<T> prev) {
        this.prev = prev;
    }

    public boolean hasNext() {
        return next != null;
    }

    public boolean hasPrev() {
        return prev != null;
    }
}
