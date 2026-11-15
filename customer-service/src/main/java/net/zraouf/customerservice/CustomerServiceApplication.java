package net.zraouf.customerservice;

import net.zraouf.customerservice.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import net.zraouf.customerservice.services.CustomerService;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CustomerService customerService) {
        return args -> {
            List<String> names = List.of("Mohamed", "Imene", "Yassine");
            names.forEach(name->{
                customerService.save(Customer.builder()
                        .name(name).email(name+"@gmail.com")
                        .build());
            });
        };
    }

}
