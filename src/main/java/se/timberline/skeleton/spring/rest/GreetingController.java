package se.timberline.skeleton.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se.timberline.skeleton.spring.repository.CustomerRepository;
import se.timberline.skeleton.spring.model.Customer;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        Customer customer = new Customer(name, name);
        customerRepository.save(customer);
        return new Greeting(customer.id(),
                            String.format(template, name));
    }
}