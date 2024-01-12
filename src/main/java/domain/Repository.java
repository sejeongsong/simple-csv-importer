package domain;

public interface Repository<T> {

    void save(T entity);

}
