package org.openjfx.hellofx.model.common;

import java.util.List;

public interface IBaseService<T, ID> {
    public T save(T object);

    public List<T> find();

    public T findById(ID id);

    public List<T> findByField(String fieldName, Class<?> fieldType, Object fieldValue);

    public T findByIdAndReplace(ID id, T object);

    public T findByIdAndDelete(ID id);
}
