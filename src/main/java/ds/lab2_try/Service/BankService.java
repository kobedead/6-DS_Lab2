package ds.lab2_try.Service;

import ds.lab2_try.BankAccount.BankAccount;
import ds.lab2_try.Repo.BankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {
    /**
     * Service class for managing Product entities.
     */

    private final BankRepo bankRepo;


    @Autowired
    public BankService(BankRepo bankRepo) {
        this.bankRepo = bankRepo;
    }


    /**
     * Get one accounts balance by ID.
     *
     * @param email the email of the entity
     * @return the entity
     */
    public Double getBalance(String email, Long accountID) {
        // Find the BankAccount by email and accountId
        BankAccount bankAccount = bankRepo.findByUserEmailAndAccountId(email, accountID)
                .orElseThrow(() -> new RuntimeException("BankAccount not found for email: " + email + " and account ID: " + accountID));

        // Return the balance
        return bankAccount.getBalance();
    }


    /**
     * add to account balace.
     *
     * @param email     email of the owner
     * @param accountID the ID of the bank account
     * @param money     the money that gets added
     */
    public Double addBalance(String email, Long accountID, Double money) {

        // Find the BankAccount by email and accountId
        BankAccount bankAccount = bankRepo.findByUserEmailAndAccountId(email, accountID)
                .orElseThrow(() -> new RuntimeException("BankAccount not found for email: " + email + " and account ID: " + accountID));

        bankAccount.addBalance(money);

        bankRepo.save(bankAccount);
        return bankAccount.getBalance();

    }


    /**
     * remove from account balance.
     *
     * @param email     email of the owner
     * @param accountID the ID of the bank account
     * @param money     the money that gets removed
     */
    public Double removeBalance(String email, Long accountID, Double money) {

        // Find the BankAccount by email and accountId
        BankAccount bankAccount = bankRepo.findByUserEmailAndAccountId(email, accountID)
                .orElseThrow(() -> new RuntimeException("BankAccount not found for email: " + email + " and account ID: " + accountID));


        // Check if the balance is zero or insufficient
        if (bankAccount.getBalance() == 0 || bankAccount.getBalance() < money) {
            throw new RuntimeException("Insufficient balance in the account. Current balance: " + bankAccount.getBalance());
        }

        bankAccount.addBalance(-money);
        bankRepo.save(bankAccount);
        return bankAccount.getBalance();

    }


    /**
     * delete all account balace.
     *
     * @param email     email of the owner
     * @param accountID the ID of the bank account
     */
    public Double deleteBalance(String email, Long accountID) {

        // Find the BankAccount by email and accountId
        BankAccount bankAccount = bankRepo.findByUserEmailAndAccountId(email, accountID)
                .orElseThrow(() -> new RuntimeException("BankAccount not found for email: " + email + " and account ID: " + accountID));


        bankAccount.addBalance(-bankAccount.getBalance());
        bankRepo.save(bankAccount);
        return bankAccount.getBalance();

    }


}