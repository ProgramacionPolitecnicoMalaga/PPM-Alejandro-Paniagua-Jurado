package com.politecnicomalaga.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConn {
    private final static String url="jdbc:mysql://localhost:3306/empleados";
    private final static String usuario="empleadouser";
    private final static String password="123";
    private Connection conn;

    public DBConn () {
        try {
            conn = DriverManager.getConnection(url, usuario, password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet read (String consulta) throws SQLException {
        return conn.prepareStatement(consulta).executeQuery();
    }

    public int create (String consulta) throws SQLException {
        return conn.prepareStatement(consulta).executeUpdate();
    }

    public int delete (String consulta) throws SQLException {
        return conn.prepareStatement(consulta).executeUpdate();
    }


}
