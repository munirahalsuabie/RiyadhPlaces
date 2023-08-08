package com.riyadhplaces.app;

import com.riyadhplaces.dao.DrinkDAO;
import com.riyadhplaces.dao.MySQLDrinkDAO;
import com.riyadhplaces.dao.MySQLRestaurantDAO;
import com.riyadhplaces.dao.RestaurantDAO;
import com.riyadhplaces.entities.Restaurant;
import com.riyadhplaces.exceptions.DAOException;
import com.riyadhplaces.exceptions.DataSourceException;

public class App {

    public static void main(String[] args) throws DataSourceException, DAOException {

        DrinkDAO d = new MySQLDrinkDAO();
        RestaurantDAO r = new MySQLRestaurantDAO();

    }
}
