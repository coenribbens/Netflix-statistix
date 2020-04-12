package datalayer;

import datalayerinterface.IAccount;
import models.Account;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class AccountDAO implements IAccount {
    //This class is responsible for handling all databse interactions for accounts
    private static AccountDAO instance;

    public AccountDAO() {
    }

    //To make sure only one instance is used
    public static AccountDAO getInstance() {
        if (instance == null) {
            instance = new AccountDAO();
        }
        return instance;
    }

    //Gets all accounts and returns them from a list
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

    //Gets a single account on the basis of the given id
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

    //Gets a list of all profiles with only one account
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

    //Creates a new account, requires accountname, streetname, housenumber and zipcode
    @Override
    public void createAccount(Account a) {
        Connection conn = null;

        try {
            conn = MysqlDAO.getInstance().connect();
            PreparedStatement statement = conn.prepareStatement(""
                    + "INSERT INTO account (accountName, streetName, houseNumber, zipCode) "
                    + "VALUES (?, ?, ?, ?)");
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


    //Updates an existing account, requires accountname, streetname, housenumber, zipcode and accountId
    @Override
    public void updateAccount(Account a) {
        Connection conn = null;
        try {
            conn = MysqlDAO.getInstance().connect();
            PreparedStatement statement = conn.prepareStatement(""
                    + "UPDATE account SET accountName = ?, streetName = ?, houseNumber = ?, zipCode = ? WHERE accountID = ?;");
            statement.setString(1, a.getAccountName());
            statement.setString(2, a.getStreetName());
            statement.setString(3, a.getHouseNumber());
            statement.setString(4, a.getZipcode());
            statement.setInt(5, a.getAccountId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            MysqlDAO.getInstance().closeConnection(conn);
        }
    }

    //Deletes an account on basis of the given id
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
