package org.example.dao;

import java.util.List;

public interface CrudDAO <T> extends SuperDAO{
    public boolean save (T object);
    public boolean update (T object);
    public boolean delete (T object);
    public T search (String id);
    public T get (T object);
    List<T> getAll();
}
