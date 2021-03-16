package com.project.stella_boutique.adapter.database;

import java.sql.*;

public class MysqlDriver {
    private String mysqlURL;
    private String user;
    private String password;

    public MysqlDriver() {
        this.mysqlURL = "jdbc:mysql://127.0.0.1:3306/stella_boutique?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        this.user = "root";
        this.password = "peggy6688";
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(this.mysqlURL,this.user,this.password);
    }

    public void closeConnection(Connection connection) {
        if (connection == null) return;
        try {
            connection.close();
        } catch (SQLException e) {
            /* No connection */
        }
    }

}