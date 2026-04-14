package interfaces;

public interface Managable<T> {
    void add(T item);
    void update(T item);
    void delete(String id);
    T get(String id);
}