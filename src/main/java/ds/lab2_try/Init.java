package ds.lab2_try;

import ds.lab2_try.BankAccount.BankAccount;
import ds.lab2_try.Person.Person;
import ds.lab2_try.Repo.BankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Init implements CommandLineRunner {

    @Autowired
    private BankRepo bankAccountRepository;

    @Override
    public void run(String... args) throws Exception {

        BankAccount bankAccount = new BankAccount();

        Person user1 = new Person();
        user1.setEmail("user1@example.com");
        user1.setBankAccount(bankAccount);

        Person user2 = new Person();
        user2.setEmail("user2@example.com");
        user2.setBankAccount(bankAccount);

        bankAccount.AddOwner(user1);
        bankAccount.AddOwner(user2);


        // Save the BankAccount to the repository
        bankAccountRepository.save(bankAccount);

        System.out.println(bankAccount.getId());



        System.out.println("Initialized BankAccount with users.");
    }
}
