//package com.company.U1M6Summative.service;
//
//import com.company.U1M6Summative.dao.*;
//
//import com.company.U1M6Summative.model.Customer;
//import com.company.U1M6Summative.model.Invoice;
//import com.company.U1M6Summative.model.InvoiceItem;
//import com.company.U1M6Summative.model.Item;
//import org.junit.Before;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.Mockito.*;
//
//public class ServiceLayerTest {
//
//    ServiceLayer service;
//    CustomerDao customerDao;
//    InvoiceDao invoiceDao;
//    ItemDao itemDao;
//    InvoiceItemDao invoiceItemDao;
//
//    @Before
//    public void setUp() throws Exception {
//        setUpCustomerDaoMock();
//        setUpInvoiceDaoMock();
//        setUpInvoiceItemDaoMock();
//        setUpItemDaoMock();
//
//        service = new ServiceLayer(customerDao, invoiceDao, invoiceItemDao, itemDao);
//    }
//
//    // Helper methods
//    private void setUpCustomerDaoMock() {
//        customerDao = mock(CustomerDaoJdbcTemplateImpl.class);
//        Customer customer = new Customer();
//        customer.setCustomerId(1);
//        customer.setFirstName("Test");
//        customer.setLastName("Test");
//        customer.setEmail("Test@test.com");
//        customer.setCompany("Test");
//        customer.setPhone("Test");
//
//        //intentionally missing an id - modeling an object before it is saved
//        Customer customer2 = new Customer();
//
//        customer2.setFirstName("Test");
//        customer2.setLastName("Test");
//        customer2.setEmail("Test@test.com");
//        customer2.setCompany("Test");
//        customer2.setPhone("Test");
//
//
//        List<Customer> cList = new ArrayList<>();
//        cList.add(customer);
//
//        //creating -
//        doReturn(customer).when(customerDao).addCustomer(customer2);
//        doReturn(customer).when(customerDao).getCustomer(1);
//        doReturn(cList).when(customerDao).getAllCustomers();
//    }
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
//
//    private void setUpItemDaoMock() {
//        itemDao = mock(ItemDaoJdbcTemplateImpl.class);
//        Item item = new Item();
//        item.setItemId(1);
//        item.setName("Test");
//        item.setDescription("TestDescription");
//        item.setDailyRate(15.50);
////
////
////        Label label2 = new Label();
////        label2.setName("Blue Note");
////        label2.setWebsite("www.bluenote.com");
////
//        List<Item> iList = new ArrayList<>();
//        iList.add(item);
////
////        doReturn(label).when(labelDao).addLabel(label2);
////        doReturn(label).when(labelDao).getLabel(10);
////        doReturn(lList).when(labelDao).getAllLabels();
//    }
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
//
////        Track track2 = new Track();
////        track.setAlbumId(1);
////        track.setRunTime(180);
////        track.setTitle("Number 1 Hit!");
////
//        List<InvoiceItem> invtList = new ArrayList<>();
//        invtList.add(invt);
////
////        doReturn(track).when(trackDao).addTrack(track2);
////        doReturn(track).when(trackDao).getTrack(1);
////        doReturn(tList).when(trackDao).getAllTracks();
////        doReturn(tList).when(trackDao).getTracksByAlbum(1);
//    }
//
//
//
//}
