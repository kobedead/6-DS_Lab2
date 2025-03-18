package ds.lab2_try.Repo;

import ds.lab2_try.BankAccount.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankRepo extends JpaRepository<BankAccount, Long> {


    @Query("SELECT ba FROM BankAccount ba JOIN ba.owners o WHERE o.email = :email AND ba.id = :accountId")
    Optional<BankAccount> findByUserEmailAndAccountId(@Param("email") String email, @Param("accountId") Long accountId);




}