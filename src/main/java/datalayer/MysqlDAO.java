package datalayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MysqlDAO {

    private static MysqlDAO instance;
    private String dbname = "NetfflixStatistics";
    private String user = "root";
    private String pass = "theblackarrow";

    private MysqlDAO() {

    }

    public static MysqlDAO getInstance() {
        if (instance == null) {
            return new MysqlDAO();
        } else {
            return instance;
        }
    }

    public Connection connect() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager
                    .getConnection("jdbc:sqlserver://localhost\\MSSQLSERVER;databaseName=NetfflixStatistics;integratedSecurity=true;");
            return connection;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MysqlDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //Close connection if connection exists
    public void closeConnection(Connection conn){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(MysqlDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
