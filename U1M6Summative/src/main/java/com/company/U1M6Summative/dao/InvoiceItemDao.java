package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.InvoiceItem;
import com.company.U1M6Summative.model.Item;

import java.util.List;

public interface InvoiceItemDao {
    InvoiceItem addInvoiceItem(InvoiceItem invoiceItem);
    InvoiceItem getInvoiceItem(int id);

    List<InvoiceItem> getAllInvoiceItems();

    void updateInvoiceItem(InvoiceItem invoiceItem);
    void deleteInvoiceItem(int id);

}
