package models;

import datalayer.MysqlDAO;

import java.sql.Connection;

public class main {
    public static void main(String args[]) {
        Connection conn;

        conn = MysqlDAO.getInstance().connect();

        MysqlDAO.getInstance().closeConnection(conn);
    }
}
