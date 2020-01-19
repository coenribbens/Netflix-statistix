package datalayer;

import datalayerinterface.IAccount;
import models.Account;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class AccountDAO implements IAccount {
    private static AccountDAO instance;

    public AccountDAO() {
    }

    public static AccountDAO getInstance() {
        if (instance == null) {
            instance = new AccountDAO();
        }
        return instance;
    }

    @Override
    public List getAllAccounts() {
    ArrayList<Account> allAccounts = new ArrayList<Account>();
    Connection conn = null;

    try{
        conn = MysqlDAO.getInstance().connect();
        PreparedStatement getAllAccounts = conn.prepareStatement("SELECT * FROM account");
        ResultSet resultSet = getAllAccounts.executeQuery();

        while(resultSet.next()) {
            int accountID = resultSet.getInt("accountID");
            String accountName = resultSet.getString("accountName");
            String streetName = resultSet.getString("streetName");
            String houseNumber = resultSet.getString("houseNumber");
            String zipCode = resultSet.getString("zipcode");

            Account a = new Account(accountID, accountName, streetName, houseNumber, zipCode);
            allAccounts.add(a);
        }
    }catch(SQLException e) {
        e.printStackTrace();
    }finally {
        MysqlDAO.getInstance().closeConnection(conn);
    }
        return allAccounts;
    }

    @Override
    public Account getAccountById(int Id) {
        Connection conn = null;
        Account a = null;

        try {
            conn = MysqlDAO.getInstance().connect();
            PreparedStatement getAccountById = conn.prepareStatement("SELECT * FROM account WHERE accountId = ?");
            getAccountById.setInt(1, Id);
            ResultSet resultSet = getAccountById.executeQuery();

            while(resultSet.next()) {

                int accountID = resultSet.getInt("accountID");
                String accountName = resultSet.getString("accountName");
                String streetName = resultSet.getString("streetName");
                String houseNumber = resultSet.getString("houseNumber");
                String zipCode = resultSet.getString("zipcode");

                 a = new Account(accountID, accountName, streetName, houseNumber, zipCode);

            }
        }catch(SQLException e) {
            e.printStackTrace();
        }finally{
            MysqlDAO.getInstance().closeConnection(conn);
        }

        return a;
    }

    public List<Account> getAccountsWithOneProfile() {
        Connection conn = null;
        ArrayList<Account> accounts = new ArrayList<>();
        try {
            conn = MysqlDAO.getInstance().connect();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM account\n" +
                    "JOIN (\n" +
                    "\tSELECT accountID\n" +
                    "\tFROM profile\n" +
                    "\tGROUP BY accountID\n" +
                    "\tHAVING COUNT(1) = 1\n" +
                    ") AS profileAccounts\n" +
                    "ON profileAccounts.accountID = account.accountID");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int accountID = resultSet.getInt("accountId");
                String accountName = resultSet.getString("accountName");
                String streetName = resultSet.getString("streetName");
                String houseNumber = resultSet.getString("houseNumber");
                String zipCode = resultSet.getString("zipcode");

                Account acc = new Account(accountID, accountName, streetName, houseNumber, zipCode);
                accounts.add(acc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MysqlDAO.getInstance().closeConnection(conn);
        }
        return accounts;
    }

    @Override
    public void createAccount(Account a) {
        Connection conn = null;

        try {
            conn = MysqlDAO.getInstance().connect();
            PreparedStatement statement = conn.prepareStatement(""
                    + "INSERT INTO `account` (`accountName`,`streetName`,`houseNumber`,  `zipCode`) "
                    + "VALUES (?, ?, ?, ?,)");
            statement.setString(1, a.getAccountName());
            statement.setString(2, a.getStreetName());
            statement.setString(3, a.getHouseNumber());
            statement.setString(4, a.getZipcode());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            MysqlDAO.getInstance().closeConnection(conn);
        }
    }


    @Override
    public void updateAccount(Account a) {
        Connection conn = null;
        try {
            conn = MysqlDAO.getInstance().connect();
            PreparedStatement statement = conn.prepareStatement(""
                    + "UPDATE `account` SET `accountName` = ?,`streetName` = ?,`houseNumber` = ?,  `zipCode` = ?, WHERE accountID = ?");
            statement.setString(1, a.getAccountName());
            statement.setString(2, a.getStreetName());
            statement.setString(3, a.getHouseNumber());
            statement.setString(4, a.getZipcode());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            MysqlDAO.getInstance().closeConnection(conn);
        }
    }

    @Override
    public void deleteAccount(Account a) {
    Connection conn = null;
        try {
        conn = MysqlDAO.getInstance().connect();
        PreparedStatement statement = conn.prepareStatement(""
                + "DELETE FROM account "
                + "WHERE accountID = ?");
        statement.setInt(1, a.getAccountId());
        statement.executeUpdate();
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        MysqlDAO.getInstance().closeConnection(conn);
    }
}

    @Override
    public List getAllProfilesFromAccount() {
        //I'll do this one later on when the database is set up and ready.
        return null;
    }
}
