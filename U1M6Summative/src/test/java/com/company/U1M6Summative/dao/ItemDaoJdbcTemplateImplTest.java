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
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ItemDaoJdbcTemplateImplTest {




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

        itemList.stream()
                .forEach(item -> itemDao.deleteItem(item.getItemId()));

        invoiceList.stream()
                .forEach(invoice -> invoiceDao.deleteInvoice(invoice.getInvoiceId()));

        customerList.stream()
                .forEach(customer -> customerDao.deleteCustomer(customer.getCustomerId()));


    }

    @After
    public void tearDown() throws Exception{}

    @Test
    public void addGetDeleteItem(){
        Item it = new Item();
        it.setName("Iphonex");
        it.setDescription("Apples newest smartphone");
        it.setDailyRate(new BigDecimal("59.99"));

        itemDao.addItem(it);

        Item it2 = itemDao.getItem(it.getItemId());
        assertEquals(it2,it);

        itemDao.deleteItem(it.getItemId());
        it2 = itemDao.getItem(it.getItemId());
        assertNull(it2);
    }

    @Test
    public void updateItem(){
        Item it = new Item();
        it.setName("Iphonex");
        it.setDescription("Apples newest smartphone");
        it.setDailyRate(new BigDecimal("59.99"));

        it = itemDao.addItem(it);

        it.setDescription("UPDATED");
        itemDao.updateItem(it);

        Item it2 = itemDao.getItem(it.getItemId());
        assertEquals(it2,it);
    }

    @Test
    public void getAllItems(){

        Item it = new Item();
        it.setName("Iphonex");
        it.setDescription("Apples newest smartphone");
        it.setDailyRate(new BigDecimal("59.99"));

        itemDao.addItem(it);

        it = new Item();
        it.setName("Iphone9");
        it.setDescription("Apples newest smartphone");
        it.setDailyRate(new BigDecimal("29.99"));

        itemDao.addItem(it);

        it = new Item();
        it.setName("IphoneXI");
        it.setDescription("Apples newest smartphone");
        it.setDailyRate(new BigDecimal("69.99"));

        itemDao.addItem(it);

        it = new Item();
        it.setName("IphoneXII");
        it.setDescription("Apples newest smartphone");
        it.setDailyRate(new BigDecimal("89.99"));

        itemDao.addItem(it);

        List<Item> itemList = itemDao.getAllItems();
        assertEquals(itemList.size(),4);

    }
}
