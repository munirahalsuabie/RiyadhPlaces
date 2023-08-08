package com.riyadhplaces.dao;

import com.riyadhplaces.datasource.ConnectionFactory;
import com.riyadhplaces.datasource.DataSourceType;
import com.riyadhplaces.entities.Identifiable;
import com.riyadhplaces.exceptions.DAOException;
import com.riyadhplaces.support.QueryBuilder;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class MySQLDAO<T extends Identifiable> extends AbstractDAO<T, Long> {

    public abstract String getTableName();

    public abstract String[] getCols();

    @Override
    protected ConnectionFactory getConnectionFactory() {
        return ConnectionFactory.getConnectionFactory(DataSourceType.MY_SQL);

    }

    @Override
    protected String getInsertQuery(T entity) {
        final String TABLE_NAME = getTableName();
        final String[] cols = getCols();
        return QueryBuilder.insertQuery(TABLE_NAME, cols);

    }

    @Override
    protected String getSelectQuery() {
        final String TABLE_NAME = getTableName();
        final String[] cols = getCols();
        return QueryBuilder.selectAll(TABLE_NAME);
    }

    @Override
    protected void setGeneratedKey(ResultSet rs, T entity) throws DAOException {
        try {
            if (rs != null && rs.next()) {
                Long id = rs.getLong(1);
                entity.setId(id);
            }

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }

}
