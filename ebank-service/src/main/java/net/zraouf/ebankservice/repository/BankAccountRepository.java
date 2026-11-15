package net.zraouf.ebankservice.repository;

import net.zraouf.ebankservice.enetities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
    List<BankAccount> findByCustomerId(Long id);
}
