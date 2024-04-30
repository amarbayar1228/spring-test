package com.example.demo.interfaces;
import com.example.demo.entity.Company;
import com.example.demo.entity.Customers;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomersDao extends CrudRepository<Customers, Long> {

    @Query("select a from Customers a where a.id = ?1")
    Company getCustomers(Long id);


}
