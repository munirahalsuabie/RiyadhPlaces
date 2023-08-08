package com.riyadhplaces.support;

public class QueryBuilder {

    
    public static String insertQuery(final String TABLE_NAME, String... paras) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO ");
        sql.append(TABLE_NAME);
        sql.append(getColos(paras));
        sql.append(" VALUES ");
        sql.append(getPlaceHolders(paras));
        return sql.toString();

    }

    public static String selectAll(final String TABLE_NAME) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM ");
        sql.append(TABLE_NAME);
        return sql.toString();

    }

    private static String getColos(final String... paras) {
        StringBuilder cols = new StringBuilder();
        cols.append(" (");
        for (String col : paras) {
            cols.append(col);
            cols.append(",");
        }
        cols.deleteCharAt(cols.length() - 1);
        cols.append(")");
        return cols.toString();
    }

    private static <T> String getPlaceHolders(final T... paras) {
        StringBuilder placeHolders = new StringBuilder();
        placeHolders.append(" (");
        for (T p : paras) {
            placeHolders.append("?,");
        }
        placeHolders.deleteCharAt(placeHolders.length() - 1);
        placeHolders.append(")");

        return placeHolders.toString();

    }
}
