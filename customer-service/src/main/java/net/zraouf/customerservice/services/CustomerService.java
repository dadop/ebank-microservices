package net.zraouf.customerservice.services;

import net.zraouf.customerservice.entities.Customer;
import org.springframework.stereotype.Service;
import net.zraouf.customerservice.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();

    }

    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Customer not found!"));
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
}
