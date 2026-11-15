package net.zraouf.ebankservice.service;

import net.zraouf.ebankservice.enetities.BankAccount;
import net.zraouf.ebankservice.model.Customer;
import net.zraouf.ebankservice.repository.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class EbankService {
    private final BankAccountRepository bankAccountRepository;

    public EbankService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public List<BankAccount> getAllBankAccounts(){
        return bankAccountRepository.findAll();
    }

    public BankAccount getBankAccountById(String id){
        return bankAccountRepository.findById(id).
                orElseThrow(()->new RuntimeException("Account not found!"));
    }

    public BankAccount save(BankAccount bankAccount) {
        try {
            //Customer customer = customerRestClient.getCustomerById(bankAccount.getCustomerId());
            bankAccount.setId(UUID.randomUUID().toString());
            bankAccount.setCreatedAt(new Date());
            return bankAccountRepository.save(bankAccount);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
