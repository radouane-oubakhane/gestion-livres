package com.oubakhane.tp1atelierservletsjspfiltersmvc.dao;

import java.util.List;
public interface Dao {
    public void add(Object o);
    public void update(Object o);
    public void delete(Object o);
    public Object find(int id);
    public List findAll();
}
