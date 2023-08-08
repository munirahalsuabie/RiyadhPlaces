package com.riyadhplaces.dao;

import com.riyadhplaces.datasource.ConnectionFactory;
import com.riyadhplaces.entities.Identifiable;
import com.riyadhplaces.exceptions.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class AbstractDAO<T extends Identifiable, ID> implements GenericDAO<T, ID> {

    private static final int UPDATE_EXECUTED_SUCCESSFULLY = 1;

    protected abstract ConnectionFactory getConnectionFactory();

    protected abstract String getInsertQuery(T entity);

    protected abstract String getSelectQuery();

    protected abstract void setStatementParas(PreparedStatement ps, T entity) throws DAOException;

    protected abstract void setGeneratedKey(ResultSet rs, T entity) throws DAOException;

    protected abstract T mapObject(ResultSet rs) throws DAOException;

    @Override
    public T insert(T entity) throws DAOException {
        //"INSERT INTO " + resturents + " (Type, Name, Adress, PhoneNumber) VALUES(?, ?, ?, ?)";
        String InsertQuery = getInsertQuery(entity);

        try ( Connection connection = getConnectionFactory().creatConnection();  
                PreparedStatement ps = connection.prepareStatement(InsertQuery, PreparedStatement.RETURN_GENERATED_KEYS)) {

            setStatementParas(ps, entity);

            if (ps.executeUpdate() < UPDATE_EXECUTED_SUCCESSFULLY) {
                throw new DAOException("Could NOT save the object");
            }

            setGeneratedKey(ps.getGeneratedKeys(), entity);

        } catch (Exception ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
        return entity;
    }

    @Override
    public T read(T entity) throws DAOException {

        String SelectAllQuery = getSelectQuery();

        try ( Connection connection = getConnectionFactory().creatConnection();  PreparedStatement ps = connection.prepareStatement(SelectAllQuery)) {

            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                entity = mapObject(rs);
            }

        } catch (Exception ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
        return entity;
    }

}
