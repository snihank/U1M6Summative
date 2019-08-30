package com.company.U1M6Summative.service;

import com.company.U1M6Summative.dao.CustomerDao;
import com.company.U1M6Summative.dao.InvoiceDao;
import com.company.U1M6Summative.dao.InvoiceItemDao;
import com.company.U1M6Summative.dao.ItemDao;
import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.model.Invoice;
import com.company.U1M6Summative.model.InvoiceItem;
import com.company.U1M6Summative.model.Item;
import com.company.U1M6Summative.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Component
public class ServiceLayer {

    private CustomerDao customerDao;
    private InvoiceDao invoiceDao;
    private InvoiceItemDao invoiceItemDao;
    private ItemDao itemDao;

    @Autowired
    public ServiceLayer(CustomerDao customerDao, InvoiceDao invoiceDao, InvoiceItemDao invoiceItemDao, ItemDao itemDao) {
        this.customerDao = customerDao;
        this.invoiceDao = invoiceDao;
        this.invoiceItemDao = invoiceItemDao;
        this.itemDao = itemDao;
    }


//    Create Invoices


    @Transactional
    public InvoiceViewModel saveInvoice(InvoiceViewModel invm){
        Invoice in = new Invoice();
        in.setCustomerId(invm.getCustomer().getCustomerId());
        in.setOrderDate(invm.getInvoice().getOrderDate());
        in.setPickupDate(invm.getInvoice().getPickupDate());
        in.setReturnDate(invm.getInvoice().getReturnDate());
        in.setLateFee(invm.getInvoice().getLateFee());
        invm.setId(in.getInvoiceId());

        Customer customer = invm.getCustomer();

        customer = customerDao.getCustomer(invm.getId());

        invm.setCustomer(customer);

        return invm;
    }

//    Delete Invoices
    @Transactional
    public void removeInvoice(int id) {

    // Remove customer first
    Customer customer = customerDao.getCustomer(id);

    customerDao.deleteCustomer(customer.getCustomerId());

    // Remove Item
//    invoiceDao.deleteInvoice(buildInvoiceViewModel(ingetInvoice().getInvoiceId()));

}



    //
    // Customer API
    //

    public Customer saveCustomer(Customer customer) {

        return customerDao.addCustomer(customer);
    }

    public Customer findCustomer(int id) {

        return customerDao.getCustomer(id);
    }

    public List<Customer> findAllCustomers() {

        return customerDao.getAllCustomers();
    }

    public void updateCustomer(Customer customer) {

        customerDao.updateCustomer(customer);
    }

    public void removeCustomer(int id) {

        customerDao.deleteCustomer(id);
    }

    //
    // Item API
    //

    public Item saveItem(Item item) {

        return itemDao.addItem(item);
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

     //HELPER METHOD
    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {

        if (invoice==null) return null;

        Customer customer = customerDao.getCustomer(invoice.getCustomerId());

        InvoiceViewModel invm = new InvoiceViewModel();
//        invm.setId(invoice.getInvoiceId());
        invm.setCustomer(customer);
        invm.setInvoice(invoice);
        return invm;
    }

}
