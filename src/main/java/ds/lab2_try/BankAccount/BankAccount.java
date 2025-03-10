package ds.lab2_try.BankAccount;

import ds.lab2_try.Person.Person;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Entity
public class BankAccount implements IBankAccount {


    @OneToMany(mappedBy = "bankAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Person> owners ;
    private Double balance;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    public BankAccount() {
        this.owners = new ArrayList<>();
        this.balance = 0.0;

    }


    @Override
    public Double getBalance() {
        return balance;
    }

    @Override
    public void addBalance(Double money) {
        balance+= money;
    }

    @Override
    public List<Person> getOwners() {
        return owners;
    }

    @Override
    public void AddOwner(Person person) {
        owners.add(person);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
