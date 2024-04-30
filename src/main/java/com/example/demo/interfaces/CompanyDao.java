package com.example.demo.interfaces;
import com.example.demo.entity.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public interface CompanyDao extends CrudRepository<Company, Long> {

    @Query("select a from Company a where a.id = ?1")
    Company getCompanyId(Long id);
    @Query("select a from Company a")
    List<Company> getAll();
    Company getFindByName(String name);
    List<Company> findByName(String name);

}
