package org.openjfx.hellofx.model.base;

import java.util.List;

import org.openjfx.hellofx.repository.base.IBaseRepository;

import lombok.Getter;

@Getter
public class BaseService<T, ID> {
    private IBaseRepository<T, ID> repository;

    public BaseService(IBaseRepository<T, ID> repository) {
        this.repository = repository;
    }

    public T save(T object) {
        return repository.save(object);
    }

    public List<T> find() {
        return repository.find();
    }

    public T findById(ID id) {
        return repository.findById(id);
    }

    public List<T> findByField(String fieldName, Class<?> fieldType, Object fieldValue) {
        return repository.findByField(fieldName, fieldType, fieldValue);
    }

    public T findByIdAndReplace(ID id, T object) {
        return repository.findByIdAndReplace(id, object);
    }

    public T findByIdAndDelete(ID id) {
        return repository.findByIdAndDelete(id);
    }
}
