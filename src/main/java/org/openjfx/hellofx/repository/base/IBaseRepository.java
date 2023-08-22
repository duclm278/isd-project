package org.openjfx.hellofx.repository.base;

import java.util.List;

public interface IBaseRepository<T, ID> {
    public T save(T object);

    public List<T> find();

    public T findById(ID id);

    public T findByIdAndReplace(ID id, T object);

    public T findByIdAndDelete(ID id);

    public List<T> findByField(String fieldName, Class<?> fieldType, Object fieldValue);

    public List<T> findByFieldAndReplace(String fieldName, Class<?> fieldType, Object fieldValue, T object);

    public List<T> findByFieldAndDelete(String fieldName, Class<?> fieldType, Object fieldValue);
}
