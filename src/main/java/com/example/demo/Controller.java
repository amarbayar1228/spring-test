package com.example.demo;

import com.example.demo.entity.Company;
import com.example.demo.entity.Customers;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Users;
import com.example.demo.interfaces.CompanyDao;
import com.example.demo.modal.ResponseModel;
import com.example.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
public class Controller {
    @Autowired
    private UsersService usersService;
    @GetMapping("/welcome")
    public String getWelcome(){
        return "welcome";
    }

    @PostMapping("/saveCompany")
    public ResponseModel saveCompany(@RequestBody Company company){
        return usersService.saveCompanyService(company);
    }
    @PostMapping("/saveCompanyList")
    public ResponseModel saveCompany(@RequestBody List<Company> company){
        return usersService.saveCompanyList(company);
    }
    @PostMapping("/saveCustomers")
    public ResponseModel saveCustomers(@RequestBody List<Customers> customers){
        return usersService.saveCustomers(customers);
    }
    @GetMapping("/getCompanyId")
    public Optional<Company> getCompanyId(@RequestParam Long id){
     return usersService.getCompanyId(id);
    }
    @GetMapping("/delComId")
    public void delComId(@RequestParam Long id){
       usersService.delComId(id);
    }
    @PostMapping("/updateCompany")
    public ResponseModel updateCompany(@RequestBody Company company){
     return usersService.updateCompany(company);
    }
    @GetMapping("/getCompanyAll")
    public ResponseEntity<List<Company>> getCompanyAll() throws Exception {
     return ResponseEntity.ok(usersService.getCompanyAll());
    }
    @GetMapping("/getCustomers")
    public ResponseEntity<List<Customers>> getCustomers() throws Exception {
     return ResponseEntity.ok(usersService.getCustomers());
    }
    @GetMapping("/getCount")
    public Long getCount() {
       return  usersService.getCount();
    }
    @GetMapping("/getFindByName")
    public Company getFindByName(@RequestBody Company company) {
       return  usersService.getFindByName(company);
    }
    @GetMapping("/getFindByNameList")
    public List<Company> getFindByNameList(@RequestBody Company company) {
       return  usersService.getFindByNameList(company);
    }

}
