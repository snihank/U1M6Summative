package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.model.Invoice;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceDaoJdbcTemplateImplTest {

    @Autowired
    protected InvoiceDao invoiceDao;

    @Autowired
    protected CustomerDao customerDao;

    @Before
    public void setUp() throws Exception{
        List<Customer> customerList = customerDao.getAllCustomers();
        List<Invoice> invoiceList = invoiceDao.getAllInvoices();

        customerList.stream()
                .forEach(customer -> customerDao.deleteCustomer(customer.getCustomerId()));

        invoiceList.stream()
                .forEach(invoice -> invoiceDao.deleteInvoice(invoice.getInvoiceId()));
    }

    @After
    public void tearDwon() throws Exception{}

    @Test
    public void addGetDeleteInvoice(){

    }
}
