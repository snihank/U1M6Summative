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

     //HELPER METHOD
    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {
        Customer customer = customerDao.getCustomer(invoice.getCustomerId());

        InvoiceViewModel invm = new InvoiceViewModel();

        invm.setCustomer(customer);
        invm.setInvoice(invoice);

        return invm;
    }

}
