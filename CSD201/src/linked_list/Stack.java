package linked_list;

public class Stack<T> {

    private SingleLinkedList<T> list;

    public Stack() {
        list = new SingleLinkedList<>();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void clear() {
        list.clear();
    }

    public void push(T x) {
        list.addNodeToHead(x);
    }

    public T top() {
        if (isEmpty()) return null;
        return list.getHead().getData();
    }

    public T pop() {
        if (isEmpty()) return null;
        return list.removeHead().getData();
    }
}
