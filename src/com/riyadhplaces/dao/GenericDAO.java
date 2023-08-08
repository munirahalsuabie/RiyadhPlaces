package com.riyadhplaces.dao;

import com.riyadhplaces.entities.Identifiable;
import com.riyadhplaces.exceptions.DAOException;
import java.util.List;

public interface GenericDAO<T extends Identifiable, ID> {

    public abstract T insert(T entity) throws DAOException;

    public abstract T read(T entity) throws DAOException;

}
