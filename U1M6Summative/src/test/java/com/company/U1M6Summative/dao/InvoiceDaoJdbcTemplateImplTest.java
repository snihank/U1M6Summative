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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceDaoJdbcTemplateImplTest {

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


        invoiceList.stream()
                .forEach(invoice -> invoiceDao.deleteInvoice(invoice.getInvoiceId()));

        itemList.stream()
                .forEach(item -> itemDao.deleteItem(item.getItemId()));


        customerList.stream()
                .forEach(customer -> customerDao.deleteCustomer(customer.getCustomerId()));

    }

    @After
    public void tearDown() throws Exception{}

    @Test
    public void addGetDeleteInvoice(){
        Customer cust = new Customer();
        cust.setFirstName("Mark");
        cust.setLastName("Zuck");
        cust.setEmail("MarkZ@fb.com");
        cust.setCompany("Facebook");
        cust.setPhone("2129991010");

        customerDao.addCustomer(cust);

        Invoice inv = new Invoice();
        inv.setCustomerId(cust.getCustomerId());
        inv.setOrderDate(LocalDate.of(2019,8,29));
        inv.setPickupDate(LocalDate.of(2019,8,31));
        inv.setReturnDate(LocalDate.of(2019,9,4));
        inv.setLateFee(new BigDecimal("3.99"));
        inv = invoiceDao.addInvoice(inv);

        Invoice inv2 = invoiceDao.getInvoice(inv.getInvoiceId());
        assertEquals(inv,inv2);

        invoiceDao.deleteInvoice(inv.getInvoiceId());
        inv2 = invoiceDao.getInvoice(inv.getInvoiceId());

        assertNull(inv2);

    }
    @Test
    public void getAllInvoices(){
        Customer cust = new Customer();
        cust.setFirstName("Mark");
        cust.setLastName("Zuck");
        cust.setEmail("MarkZ@fb.com");
        cust.setCompany("Facebook");
        cust.setPhone("2129991010");

        customerDao.addCustomer(cust);

        Invoice inv = new Invoice();
        inv.setCustomerId(cust.getCustomerId());
        inv.setOrderDate(LocalDate.of(2019,6,29));
        inv.setPickupDate(LocalDate.of(2019,7,31));
        inv.setReturnDate(LocalDate.of(2018,9,4));
        inv.setLateFee(new BigDecimal("2.99"));
        inv = invoiceDao.addInvoice(inv);

        inv = new Invoice();
        inv.setCustomerId(cust.getCustomerId());
        inv.setOrderDate(LocalDate.of(2019,8,20));
        inv.setPickupDate(LocalDate.of(2019,8,31));
        inv.setReturnDate(LocalDate.of(2019,9,4));
        inv.setLateFee(new BigDecimal("4.99"));
        inv = invoiceDao.addInvoice(inv);

        inv = new Invoice();
        inv.setCustomerId(cust.getCustomerId());
        inv.setOrderDate(LocalDate.of(2017,8,29));
        inv.setPickupDate(LocalDate.of(2017,8,31));
        inv.setReturnDate(LocalDate.of(2019,9,4));
        inv.setLateFee(new BigDecimal("13.99"));
        inv = invoiceDao.addInvoice(inv);

        inv = new Invoice();
        inv.setCustomerId(cust.getCustomerId());
        inv.setOrderDate(LocalDate.of(2019,6,29));
        inv.setPickupDate(LocalDate.of(2019,7,31));
        inv.setReturnDate(LocalDate.of(2019,9,4));
        inv.setLateFee(new BigDecimal("31.99"));
        inv = invoiceDao.addInvoice(inv);

        List<Invoice> invoiceList = invoiceDao.getAllInvoices();
        assertEquals(invoiceList.size(),4);
    }

    @Test
    public void updateInvoice(){
        Customer cust = new Customer();
        cust.setFirstName("Mark");
        cust.setLastName("Zuck");
        cust.setEmail("MarkZ@fb.com");
        cust.setCompany("Facebook");
        cust.setPhone("2129991010");

        cust = customerDao.addCustomer(cust);

        Invoice inv = new Invoice();
        inv.setCustomerId(cust.getCustomerId());
        inv.setOrderDate(LocalDate.of(2019,6,29));
        inv.setPickupDate(LocalDate.of(2019,7,31));
        inv.setReturnDate(LocalDate.of(2018,9,4));
        inv.setLateFee(new BigDecimal("2.99"));
        inv = invoiceDao.addInvoice(inv);

        inv.setReturnDate(LocalDate.of(2019,9,28));
        inv.setLateFee(new BigDecimal("20.99"));
        invoiceDao.updateInvoice(inv);

        Invoice inv2 = invoiceDao.getInvoice(inv.getInvoiceId());
        assertEquals(inv2,inv);
    }

    @Test
    public void getInvoiceByCustomerId(){

        Customer cust = new Customer();
        cust.setFirstName("Mark");
        cust.setLastName("Zuck");
        cust.setEmail("MarkZ@fb.com");
        cust.setCompany("Facebook");
        cust.setPhone("2129991010");

        cust = customerDao.addCustomer(cust);

        Customer cust2 = new Customer();
        cust2.setFirstName("Brian");
        cust2.setLastName("Lora");
        cust2.setEmail("Brian@fb.com");
        cust2.setCompany("Facebook");
        cust2.setPhone("2129991110");

        cust2 = customerDao.addCustomer(cust2);

        Customer cust3 = new Customer();
        cust3.setFirstName("Shaqib");
        cust3.setLastName("Z");
        cust3.setEmail("Shaqib@fb.com");
        cust3.setCompany("Facebook");
        cust3.setPhone("2129991210");
        cust3 = customerDao.addCustomer(cust3);

        Invoice inv = new Invoice();
        inv.setCustomerId(cust.getCustomerId());
        inv.setOrderDate(LocalDate.of(2019,8,29));
        inv.setPickupDate(LocalDate.of(2019,8,31));
        inv.setReturnDate(LocalDate.of(2019,9,4));
        inv.setLateFee(new BigDecimal("3.99"));
        invoiceDao.addInvoice(inv);

        inv = new Invoice();
        inv.setCustomerId(cust2.getCustomerId());
        inv.setOrderDate(LocalDate.of(2018,8,29));
        inv.setPickupDate(LocalDate.of(2018,8,31));
        inv.setReturnDate(LocalDate.of(2019,9,4));
        inv.setLateFee(new BigDecimal("2.99"));
        invoiceDao.addInvoice(inv);

        inv = new Invoice();
        inv.setCustomerId(cust2.getCustomerId());
        inv.setOrderDate(LocalDate.of(2017,8,29));
        inv.setPickupDate(LocalDate.of(2017,8,31));
        inv.setReturnDate(LocalDate.of(2019,9,4));
        inv.setLateFee(new BigDecimal("12.99"));
        invoiceDao.addInvoice(inv);

        List<Invoice> invoiceList = invoiceDao.getInvoicesByCustomerId(cust.getCustomerId());
        assertEquals(1,invoiceList.size());

        List<Invoice>invList2 = invoiceDao.getInvoicesByCustomerId(cust2.getCustomerId());
        assertEquals(2,invList2.size());

        List<Invoice>invList3 = invoiceDao.getInvoicesByCustomerId(cust3.getCustomerId());
        assertEquals(0,invList3.size());
    }


}
