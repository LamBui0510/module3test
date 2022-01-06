package dao;

import java.util.List;

public interface IDAO<T> {
    public void add(T t);

    public List<T> findAll();

    public void delete(int id);

    public void update(int id,T t);
}
