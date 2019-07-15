package demo.controller;

import demo.entity.Customer;
import demo.model.NotFound;
import demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    private CustomerRepository CustomerRepository;

    @GetMapping("/add")
    public String add(@RequestParam String firstName, @RequestParam String lastName) {
        CustomerRepository.save(new Customer(firstName, lastName));
        return "add success!";
    }

    @GetMapping("/find")
    public List<Customer> find() {
        return  CustomerRepository.findAll();
    }

    @GetMapping("/find-first-name")
    public Object findFirstName(@RequestParam String firstName) {
        if (CustomerRepository.findByFirstName(firstName) == null) {
            return new NotFound("Not Found");
        } else {
            return  CustomerRepository.findByFirstName(firstName);
        }
    }

    @GetMapping("/update")
    public String update(@RequestParam String id, @RequestParam String firstName, @RequestParam String lastName) {
        Customer customer = new Customer(firstName, lastName);
        customer.setId(id);
        CustomerRepository.save(customer);
        return "update success";
    }
}
