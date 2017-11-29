package com.java.dao;

import java.util.List;


public interface InterfaceCrudDao<T> {
    public void create(T obj) throws Exception;
    public T read(int  id) throws Exception;
    public void update(T obj) throws Exception;
    public void delete(int id) throws Exception;
    public List<T> list() throws Exception;
}
