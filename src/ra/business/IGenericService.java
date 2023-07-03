package ra.business;

import java.util.List;

public interface IGenericService<T,E> {
    List<T> findAll();
    boolean save(T t);
    boolean delete(E e);
    T findById(E e);
}
