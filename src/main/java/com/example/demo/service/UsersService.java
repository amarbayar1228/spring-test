package com.example.demo.service;
import com.example.demo.entity.Company;
import com.example.demo.entity.Customers;
import com.example.demo.interfaces.CompanyDao;
import com.example.demo.interfaces.CustomersDao;
import com.example.demo.modal.ResponseModel;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class UsersService {
    @Autowired
    private final CompanyDao companyDao;
    @Autowired
    private final CustomersDao customersDao;

    public UsersService(CompanyDao companyDao, CustomersDao customersDao) {
        this.companyDao = companyDao;
        this.customersDao = customersDao;
    }

    public ResponseModel saveCompanyService(Company company) {
        ResponseModel responseModel = new ResponseModel();
        Company company1 = companyDao.save(company);
        responseModel.msg = "Success";
        responseModel.code = "200";
        responseModel.data = company1;
        return responseModel;
    }
    public ResponseModel saveCompanyList(List<Company> company) {
        ResponseModel responseModel = new ResponseModel();
            companyDao.saveAll(company);
            responseModel.msg = "Success";
            responseModel.code = "200";
        return responseModel;
    }
    public ResponseModel saveCustomers(List<Customers> customers) {
        ResponseModel responseModel = new ResponseModel();
            customersDao.saveAll(customers);
            responseModel.msg = "Success";
            responseModel.code = "200";
        return responseModel;
    }
    public ResponseModel updateCompany(Company company) {
        ResponseModel responseModel = new ResponseModel();
        Company getCompany = companyDao.getCompanyId(company.getId());
        if(getCompany != null){
            responseModel.msg = "Success";
            responseModel.code = "200";
            responseModel.data = companyDao.save(company);
        } else {
            responseModel.msg = "NOT FOUND";
            responseModel.code = "404";
        }
    return responseModel;

    }
    @Transactional()
    public Optional<Company> getCompanyId(Long id) {
       return companyDao.findById(id);
    }
    @Transactional
    public Long getCount() {
       return  companyDao.count();
    }
    public void delComId(Long id) {
        companyDao.deleteById(id);
    }

    public List<Company> getCompanyAll() throws Exception {
        return (List<Company>) companyDao.findAll();
    }

    public List<Customers> getCustomers() throws Exception {
        return (List<Customers>) customersDao.findAll();
    }

    @Transactional
    public Company getFindByName(Company company) {
        return companyDao.getFindByName(company.getName());
    }
    @Transactional
    public List<Company> getFindByNameList(Company company) {
        return  companyDao.findByName(company.getName());
    }



}
