package model;

import java.sql.CallableStatement;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import contract.*;

/**
 * The Class DAOLoadMap.
 *
 * @authors Maxence Chevreux and Mathieu Coupe and Alex Guilbaud
 */
class DAOLoadMap extends DAOEntity<LoadMap> {

    /**
     * Instantiates a new DAO Load Map.
     *
     * @param connection
     *          the connection
     * @throws SQLException
     *           the SQL exception
     */
    public DAOLoadMap(final Connection connection) throws SQLException {
        super(connection);
    }

    /*
     * (non-Javadoc)
     *
     * @see model.DAOEntity#create(model.Entity)
     */
    @Override
    public boolean create(final LoadMap entity) {
        // Not implemented
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see model.DAOEntity#delete(model.Entity)
     */
    @Override
    public boolean delete(final LoadMap entity) {
        // Not implemented
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see model.DAOEntity#update(model.Entity)
     */
    @Override
    public boolean update(final LoadMap entity) {
        // Not implemented
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see model.DAOEntity#find(int)
     */
    

    /*
     * (non-Javadoc)
     *
     * @see model.DAOEntity#find(java.lang.String)
     */
    @Override
    public LoadMap find(final String key) {
        LoadMap loadMap = new LoadMap();

        try {
            final String sql = "{call loadmapByKey(?)}";
            final CallableStatement call = this.getConnection().prepareCall(sql);
            call.setString(1, key);
            call.execute();
            final ResultSet resultSet = call.getResultSet();
            if (resultSet.first()) {
                loadMap = new LoadMap(resultSet.getInt("id"), key, resultSet.getString("map"));
            }
            return loadMap;
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

