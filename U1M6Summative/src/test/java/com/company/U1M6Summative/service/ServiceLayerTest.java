package com.company.U1M6Summative.service;

import com.company.U1M6Summative.dao.*;

import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.model.Invoice;
import com.company.U1M6Summative.model.InvoiceItem;
import com.company.U1M6Summative.model.Item;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.Assert.assertNull;
import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;


public class ServiceLayerTest {

    ServiceLayer service;
    CustomerDao customerDao;
    InvoiceDao invoiceDao;
    ItemDao itemDao;
    InvoiceItemDao invoiceItemDao;

    @Before
    public void setUp() throws Exception {
        setUpCustomerDaoMock();
//        setUpInvoiceDaoMock();
//        setUpInvoiceItemDaoMock();
        setUpItemDaoMock();

        service = new ServiceLayer(
                customerDao,
                invoiceDao,
                invoiceItemDao,
                itemDao);
    }

//    SaveInvoice

//    DeleteInvoice

    @Test
    public void saveCustomer() {

       Customer customer1 = new Customer();
        customer1.setFirstName("Test");
        customer1.setLastName("Test");
        customer1.setEmail("Test@test.com");
        customer1.setCompany("Test");
        customer1.setPhone("Test");

        customer1 = service.saveCustomer(customer1);

        Customer c1 = service.findCustomer(customer1.getCustomerId());

        assertEquals(customer1,c1);


    }

    @Test
    public void findCustomer() {

        Customer c1 = new Customer();
        c1.setCustomerId(1);
        c1.setFirstName("Test");
        c1.setLastName("Test");
        c1.setEmail("Test@test.com");
        c1.setCompany("Test");
        c1.setPhone("Test");


        Customer foundcustomer = service.findCustomer(c1.getCustomerId());
        assertEquals(c1,foundcustomer);
    }
    @Test
    public void findAllCustomers() {
        List<Customer> cList = service.findAllCustomers();
        assertEquals(cList.size(),1);
    }
    @Test
    public void updateCustomer() {
        //Data for update
        Customer cUpdate = new Customer();
        cUpdate.setCustomerId(1);
//        cUpdate.setFirstName("Test");
        cUpdate.setLastName("Test1");
        cUpdate.setEmail("Test1@test.com");
        cUpdate.setCompany("Test1");
        cUpdate.setPhone("Test1");

        service.updateCustomer(cUpdate);
        Customer c2 = service.findCustomer(cUpdate.getCustomerId());

        assertEquals(cUpdate,c2);
    }
    @Test
    public void removeCustomer() {

        service.removeCustomer(3);
        Customer c = service.findCustomer(3);
        assertNull(c);
    }
    @Test
    public void saveItem() {

        Item i1 = new Item();
//        i1.setItemId(1);
        i1.setName("Test");
        i1.setDescription("TestDescription");
        i1.setDailyRate(new BigDecimal(15.50));

        i1 = service.saveItem(i1);

        Item i2 = service.findItem(i1.getItemId());

        assertEquals(i1,i2);
    }

    public Item findItem(int id) {

        return itemDao.getItem(id);
    }

    public List<Item> findAllItems() {

        return itemDao.getAllItems();
    }

    public void updateItem(Item item) {

        itemDao.updateItem(item);
    }

    public void removeItem(int id) {

        itemDao.deleteItem(id);
    }
//
//    // Helper methods
    private void setUpCustomerDaoMock() {
        customerDao = mock(CustomerDaoJdbcTemplateImpl.class);
        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setFirstName("Test");
        customer.setLastName("Test");
        customer.setEmail("Test@test.com");
        customer.setCompany("Test");
        customer.setPhone("Test");

        //intentionally missing an id - modeling an object before it is saved
        Customer customer2 = new Customer();

        customer2.setFirstName("Test");
        customer2.setLastName("Test");
        customer2.setEmail("Test@test.com");
        customer2.setCompany("Test");
        customer2.setPhone("Test");


        List<Customer> cList = new ArrayList<>();
        cList.add(customer);

        //creating -
        doReturn(customer).when(customerDao).addCustomer(customer2);
        doReturn(customer).when(customerDao).getCustomer(1);
        doReturn(cList).when(customerDao).getAllCustomers();
    }
//
//    private void setUpInvoiceDaoMock() {
//        invoiceDao = mock(InvoiceDaoJdbcTemplateImpl.class);
//        Invoice invoice = new Invoice();
//        invoice.setInvoiceId(2);
//        invoice.setCustomerId(1);
//        invoice.setOrderDate(LocalDate.of(1999, 05, 15));
//        invoice.setPickupDate(LocalDate.of(1999, 05, 16));
//        invoice.setReturnDate(LocalDate.of(1999, 05, 23));
//
//        Invoice invoice2 = new Invoice();
//
//        invoice.setCustomerId(1);
//        invoice.setOrderDate(LocalDate.of(1999, 05, 15));
//        invoice.setPickupDate(LocalDate.of(1999, 05, 16));
//        invoice.setReturnDate(LocalDate.of(1999, 05, 23));
//
//        List<Invoice> iList = new ArrayList();
//        iList.add(invoice);
//
//
//        Invoice invoice3 = new Invoice();
//        invoice3.setInvoiceId(5);
//        invoice3.setCustomerId(4);
//        invoice3.setOrderDate(LocalDate.of(2000, 06, 15));
//        invoice3.setPickupDate(LocalDate.of(2000, 06, 16));
//        invoice3.setReturnDate(LocalDate.of(2000, 06, 23));
//
//
//        doReturn(invoice).when(invoiceDao).addInvoice(invoice2);
//        doReturn(invoice).when(invoiceDao).getInvoice(2);
//
//        //This mimics fucntionality of
//        doReturn(iList).when(invoiceDao).getAllInvoices();
//
//        //will return the updated artist after passing in the original artist object. This mimics updating and actual object.
//        doNothing().when(invoiceDao).updateInvoice(invoice);
//        doReturn(invoice3).when(invoiceDao).getInvoice(5);
//    }

//
    private void setUpItemDaoMock() {
        itemDao = mock(ItemDaoJdbcTemplateImpl.class);
        Item item = new Item();
        item.setItemId(1);
        item.setName("Test");
        item.setDescription("TestDescription");
        item.setDailyRate(new BigDecimal(15.50));


        Item item2 = new Item();
        item2.setName("Test");
        item2.setDescription("TestDescription");
        item2.setDailyRate(new BigDecimal(15.50));

        List<Item> iList = new ArrayList<>();
        iList.add(item);

        doReturn(item).when(itemDao).addItem(item2);
        doReturn(item).when(itemDao).getItem(1);
        doReturn(iList).when(itemDao).getAllItems();
    }
//
//    private void setUpInvoiceItemDaoMock() {
//        invoiceItemDao = mock(InvoiceItemDaoJdbcTemplateImpl.class);
//        InvoiceItem invt = new InvoiceItem();
//        invt.setInvoiceItemId(1);
//        invt.setInvoiceId(3);
//        invt.setItemId(4);
//        invt.setQuantity(50);
//        invt.setUnitRate(13.50);
//        invt.setDiscount(2.75);

//        Track track2 = new Track();
//        track.setAlbumId(1);
//        track.setRunTime(180);
//        track.setTitle("Number 1 Hit!");
//
//        List<InvoiceItem> invtList = new ArrayList<>();
//        invtList.add(invt);
//
//        doReturn(track).when(trackDao).addTrack(track2);
//        doReturn(track).when(trackDao).getTrack(1);
//        doReturn(tList).when(trackDao).getAllTracks();
//        doReturn(tList).when(trackDao).getTracksByAlbum(1);
//    }
//
//
//
}
