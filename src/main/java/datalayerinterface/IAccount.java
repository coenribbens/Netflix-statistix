package datalayerinterface;

import models.Account;
import java.util.List;

public interface IAccount {

     List getAllAccounts();

     Account getAccountById(int Id);

     void createAccount(Account a);

     void updateAccount(Account a);

     void deleteAccount(Account a);

     List getAllProfilesFromAccount();
}
