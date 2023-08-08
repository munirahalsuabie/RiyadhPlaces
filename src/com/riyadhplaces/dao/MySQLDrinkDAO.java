
package com.riyadhplaces.dao;

import com.riyadhplaces.entities.Drink;
import com.riyadhplaces.exceptions.DAOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLDrinkDAO extends DrinkDAO{
    
     private static final String TABLE_NAME = "drinks";
    private static final String[] cols = {"Dri_Type", "Dri_Name", "Dri_Address", "Dri_Phone"};

   
    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public String[] getCols() {
        return cols;
    }
 @Override
    protected void setStatementParas(PreparedStatement ps, Drink drink) throws DAOException {

        try {
            ps.setString(1, drink.getDri_Type());
            ps.setString(2, drink.getDri_Name());
            ps.setString(3, drink.getAddress());
            ps.setLong(4, drink.getPhone_Number());

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }

    }
  @Override
    protected  Drink mapObject(ResultSet rs) throws DAOException {
        Drink drink = new Drink();
        try {
            drink.setId(rs.getLong("Id"));
            drink.setDri_Type(rs.getString("Dri_Type"));
            drink.setDri_Name(rs.getString("Dri_Name"));
            drink.setAddress(rs.getString("Dri_Address"));
            drink.setPhone_Number(rs.getLong("Dri_Phone"));
         } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
        return drink;
    }

     

}
