package ds.lab2_try.BankAccount;

import ds.lab2_try.Person.Person;

import java.util.List;

public interface IBankAccount {

    Double getBalance();
    void addBalance(Double money);

    List<Person> getOwners();

    void AddOwner(Person person);


}
