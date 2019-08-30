package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.model.Invoice;
import com.company.U1M6Summative.model.InvoiceItem;
import com.company.U1M6Summative.model.Item;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomerDaoJdbcTemplateImplTest {

    @Autowired
    protected ItemDao itemDao;

    @Autowired
    protected CustomerDao customerDao;

    @Autowired
    protected InvoiceDao invoiceDao;


    @Autowired
    protected InvoiceItemDao invoiceItemDao;

    @Before
    public void setUp() throws Exception{
        List<Item>itemList = itemDao.getAllItems();
        List<Customer>customerList = customerDao.getAllCustomers();
        List<Invoice>invoiceList = invoiceDao.getAllInvoices();
        List<InvoiceItem>invoiceItemList = invoiceItemDao.getAllInvoiceItems();

        invoiceItemList.stream()
                .forEach(invoiceItem -> invoiceItemDao.deleteInvoiceItem(invoiceItem.getInvoiceItemId()));



    @Before
    public void setUp() throws Exception{

        List<Invoice> invoiceList = invoiceDao.getAllInvoices();


        invoiceList.stream()
                .forEach(invoice -> invoiceDao.deleteInvoice(invoice.getInvoiceId()));


        itemList.stream()
                .forEach(item -> itemDao.deleteItem(item.getItemId()));


        customerList.stream()
                .forEach(customer -> customerDao.deleteCustomer(customer.getCustomerId()));




        List<Customer> customerList = customerDao.getAllCustomers();

        customerList.stream()
                .forEach(customer -> customerDao.deleteCustomer(customer.getCustomerId()));

    }
    @After
    public void tearDown() throws Exception{
    }

    @Test
    public void addGetDeleteCustomer(){
        Customer cust = new Customer();
        cust.setFirstName("Mark");
        cust.setLastName("Zuck");
        cust.setEmail("MarkZ@fb.com");
        cust.setCompany("Facebook");
        cust.setPhone("2129991010");

        customerDao.addCustomer(cust);

        Customer cust2 = customerDao.getCustomer(cust.getCustomerId());

        assertEquals(cust2,cust);
        customerDao.deleteCustomer(cust.getCustomerId());
        cust2 = customerDao.getCustomer(cust.getCustomerId());
        assertNull(cust2);
    }

    @Test
    public void getAllCustomers(){
        Customer cust = new Customer();
        cust.setFirstName("Mark");
        cust.setLastName("Zuck");
        cust.setEmail("MarkZ@fb.com");
        cust.setCompany("Facebook");
        cust.setPhone("2129991010");

        customerDao.addCustomer(cust);

        cust = new Customer();
        cust.setFirstName("Eduardo");
        cust.setLastName("Saverin");
        cust.setEmail("eds@fb.com");
        cust.setCompany("Facebook");
        cust.setPhone("2129991020");

        customerDao.addCustomer(cust);

        cust = new Customer();
        cust.setFirstName("Napster");
        cust.setLastName("Nap");
        cust.setEmail("nap@fb.com");
        cust.setCompany("Facebook");
        cust.setPhone("2120000000");

        customerDao.addCustomer(cust);

        List<Customer>customerList = customerDao.getAllCustomers();
        assertEquals(customerList.size(),3);
    }

    @Test
    public void updateCustomer(){
        Customer cust = new Customer();
        cust.setFirstName("Mark");
        cust.setLastName("Zuck");
        cust.setEmail("MarkZ@fb.com");
        cust.setCompany("Facebook");
        cust.setPhone("2129991010");

        cust = customerDao.addCustomer(cust);

        cust.setFirstName("UPDATED");
        cust.setLastName("UPDATED");
        cust.setEmail("UPDATED");
        customerDao.updateCustomer(cust);

        Customer cust2 = customerDao.getCustomer(cust.getCustomerId());

        assertEquals(cust,cust2);


    }

}
