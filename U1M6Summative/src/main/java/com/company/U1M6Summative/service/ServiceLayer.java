package com.company.U1M6Summative.service;

import com.company.U1M6Summative.dao.CustomerDao;
import com.company.U1M6Summative.dao.InvoiceDao;
import com.company.U1M6Summative.dao.InvoiceItemDao;
import com.company.U1M6Summative.dao.ItemDao;
import com.company.U1M6Summative.model.Invoice;
import com.company.U1M6Summative.model.Item;
import com.company.U1M6Summative.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
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


    public InvoiceViewModel saveInvoice(InvoiceViewModel inv){
        Invoice invoice = new Invoice();
        invoice.setCustomerId(inv.getCustomer().getCustomerId());
        invoice.setReturnDate(inv.getInvoice().getReturnDate());
        invoice.setOrderDate(inv.getInvoice().getOrderDate());
        invoice.setPickupDate(inv.getInvoice().getPickupDate());
        invoice = invoiceDao.addInvoice(invoice);
        inv.setId(invoice.getInvoiceId());

        List<Item> item = inv.getItems();

        item.stream().forEach(t->{
            t.setItemId(inv.getId());

            itemDao.addItem(t);

            });

            item = itemDao.g

    }


}
