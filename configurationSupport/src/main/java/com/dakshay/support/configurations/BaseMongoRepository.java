package com.dakshay.support.configurations;


/**
 * Created by dakshay on 02/06/2021.
 */
public class BaseMongoRepository<T> extends MongoAbstractBundle implements MongoCrudRepository<T>{

    private final Class<T> klass;

    public BaseMongoRepository(String moduleName, Class<T> klass) {
        super(moduleName);
        this.klass = klass;
    }

    @Override
    public T save(T entity) {
        return getMongoTemplate().save(entity);
    }

    @Override
    public T findById(Long id) {
        return getMongoTemplate().findById(id,klass);
    }

}
