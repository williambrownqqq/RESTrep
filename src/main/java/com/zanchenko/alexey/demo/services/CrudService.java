package com.zanchenko.alexey.demo.services;

import com.zanchenko.alexey.demo.models.Person;

public interface CrudService<T, ID>{

    T findById(ID id);

    T save(T t);
}
