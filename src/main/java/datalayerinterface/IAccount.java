package datalayerinterface;

import models.Account;
import java.util.List;

public interface IAccount {

     List getAllAccounts();

     Account getAccountById(Account a);

     void createAccount(Account a);

     void updateAccount(Account a);

     void deleteAccount(Account a);

     List getAllProfilesFromAccount();
}
