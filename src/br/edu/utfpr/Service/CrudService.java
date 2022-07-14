package br.edu.utfpr.Service;

import br.edu.utfpr.Model.Entity;

import java.io.Serializable;

public interface  CrudService <T extends Entity,R extends Integer> {


    public T save(T entity);

    public T getById(R id) ;

    public void delete(T entity);

}
