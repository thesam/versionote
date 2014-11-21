package se.timberline.skeleton.spring.repository;

import org.springframework.data.repository.CrudRepository;
import se.timberline.skeleton.spring.model.Customer;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}