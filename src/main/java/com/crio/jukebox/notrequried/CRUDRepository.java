package com.crio.jukebox.notrequried;

public interface CRUDRepository<T,ID> {
    public T save(T entity);
}
