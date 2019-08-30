package com.company.U1M6Summative.viewmodel;


import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.model.Invoice;
import com.company.U1M6Summative.model.InvoiceItem;
import com.company.U1M6Summative.model.Item;

import java.util.List;
import java.util.Objects;

public class InvoiceViewModel {
    private int id;
    private Invoice invoice;
    private Customer customer;
    private Item item;
    private List<InvoiceItem> invoiceItem;


    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<InvoiceItem> getInvoiceItem() {
        return invoiceItem;
    }

    public void setInvoiceItem(List<InvoiceItem> invoiceItem) {
        this.invoiceItem = invoiceItem;
    }

    public Item getItem() {
        return item;
    }

    public void setItems(Item item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceViewModel that = (InvoiceViewModel) o;
        return getId() == that.getId() &&
                Objects.equals(getInvoice(), that.getInvoice()) &&
                Objects.equals(getCustomer(), that.getCustomer()) &&
                Objects.equals(getInvoiceItem(), that.getInvoiceItem()) &&
                Objects.equals(getItem(), that.getItem());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getInvoice(), getCustomer(), getInvoiceItem(), getItem());
    }
}
