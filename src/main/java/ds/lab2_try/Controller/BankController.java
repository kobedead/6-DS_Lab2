package ds.lab2_try.Controller;

import ds.lab2_try.Person.Person;
import ds.lab2_try.Service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/bank")
public class BankController {

    private final BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }


    /**
     * Get balance from account
     *
     * @param email     the email of the person accessing the account
     * @param accountID the id of the bank account the person wants to access
     * @return the ResponseEntity with status 200 (OK) and with body of the list of products
     */
    @GetMapping("/{email}/account/{accountID}")
    public Double getBalance(@PathVariable String email, @PathVariable Long accountID) {
        return bankService.getBalance(email, accountID);
    }


    /**
     * Add money to account
     *
     * @param email     the email of the person accessing the account
     * @param accountID the id of the bank account the person wants to access
     * @param money     money to add to the account balance
     * @return the ResponseEntity with status 200 (OK) and with body of the product, or with status 404 (Not Found) if the product does not exist
     */
    @PutMapping("/{email}/account/{accountID}/addBalance")
    public ResponseEntity<String> addBalance(@PathVariable String email, @PathVariable Long accountID, @RequestBody Double money) {
        bankService.addBalance(email, accountID, money);
        return ResponseEntity.ok("money added succesfully");
    }

    /**
     * remove money to account
     *
     * @param email     the email of the person accessing the account
     * @param accountID the id of the bank account the person wants to access
     * @param money     money to remove from the account balance
     * @return the ResponseEntity with status 200 (OK) and with body of the product, or with status 404 (Not Found) if the product does not exist
     */
    @PutMapping("/{email}/account/{accountID}/removeBalance")
    public ResponseEntity<String> removeBalance(@PathVariable String email, @PathVariable Long accountID, @RequestBody Double money) {
        bankService.removeBalance(email, accountID, money);
        return ResponseEntity.ok("money removed succesfully");
    }


}