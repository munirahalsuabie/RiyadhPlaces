package com.riyadhplaces.dao;

import com.riyadhplaces.entities.Restaurant;
import com.riyadhplaces.exceptions.DAOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLRestaurantDAO extends RestaurantDAO {

    private static final String TABLE_NAME = "restaurants";
    private static final String[] cols = {"Res_Type", "Res_Name", "Res_Address", "Res_Phone"};

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public String[] getCols() {
        return cols;
    }

    @Override
    protected void setStatementParas(PreparedStatement ps, Restaurant restaurant) throws DAOException {

        try {
            ps.setString(1, restaurant.getRes_Type());
            ps.setString(2, restaurant.getRes_Name());
            ps.setString(3, restaurant.getAddress());
            ps.setLong(4, restaurant.getPhone_Number());

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }

    }

    @Override
    protected Restaurant mapObject(ResultSet rs) throws DAOException {
        Restaurant restaurant = new Restaurant();
        try {
            restaurant.setId(rs.getLong("Id"));
            restaurant.setRes_Type(rs.getString("Res_Type"));
            restaurant.setRes_Name(rs.getString("Res_Name"));
            restaurant.setAddress(rs.getString("Res_Address"));
            restaurant.setPhone_Number(rs.getLong("Res_Phone"));

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
        return restaurant;
    }


}
