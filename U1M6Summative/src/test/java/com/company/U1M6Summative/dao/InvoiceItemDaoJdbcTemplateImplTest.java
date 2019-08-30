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
public class InvoiceItemDaoJdbcTemplateImplTest {

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
    public void addGetDeleteInvoiceItem(){
        Customer cust = new Customer();
        cust.setFirstName("Mark");
        cust.setLastName("Zuck");
        cust.setEmail("MarkZ@fb.com");
        cust.setCompany("Facebook");
        cust.setPhone("2129991010");

        cust = customerDao.addCustomer(cust);


        Item it = new Item();
        it.setName("Iphonex");
        it.setDescription("Apples newest smartphone");
        it.setDailyRate(new BigDecimal("59.99"));

        it = itemDao.addItem(it);


        Invoice inv = new Invoice();
        inv.setCustomerId(cust.getCustomerId());
        inv.setOrderDate(LocalDate.of(2019,8,29));
        inv.setPickupDate(LocalDate.of(2019,8,31));
        inv.setReturnDate(LocalDate.of(2019,9,4));
        inv.setLateFee(new BigDecimal("3.99"));
        inv = invoiceDao.addInvoice(inv);

        InvoiceItem invItem = new InvoiceItem();
        invItem.setInvoiceId(inv.getInvoiceId());
        invItem.setItemId(it.getItemId());
        invItem.setQuantity(3);
        invItem.setUnitRate(new BigDecimal("19.99"));
        invItem.setDiscount(new BigDecimal("10.15"));

        invItem = invoiceItemDao.addInvoiceItem(invItem);

        InvoiceItem invt2 = invoiceItemDao.getInvoiceItem(invItem.getInvoiceItemId());
        assertEquals(invItem,invt2);

        invoiceItemDao.deleteInvoiceItem(invItem.getInvoiceItemId());
        invt2 = invoiceItemDao.getInvoiceItem(invItem.getInvoiceItemId());

        assertNull(invt2);

    }



}
