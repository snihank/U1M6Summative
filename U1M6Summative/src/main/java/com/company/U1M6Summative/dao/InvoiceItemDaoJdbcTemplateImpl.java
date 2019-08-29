package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.InvoiceItem;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InvoiceItemDaoJdbcTemplateImpl implements InvoiceItemDao {

    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_INVOICE_ITEM_SQL =
            "insert into invoice (invoice_id, item_id, quantity, unit_rate, discount) values (?, ?, ?, ?, ?)";

    private static final String SELECT_ALL_INVOICE_ITEMS_SQL =
            "select * from invoice_item";

    private static final String SELECT_INVOICE_SQL =
            "select * from invoice where invoice_item_id = ?";

    private static final String UPDATE_INVOICE_SQL =
            "update invoice_item set invoice_id = ?, item_id = ?, quantity = ?, unit_rate = ?, discount= ? " +
                    "where invoice_item_id = ?";

    private static final String DELETE_INVOICE_SQL =
            "delete from invoice where invoice_item_id = ?";

    @Override
    public InvoiceItem addInvoiceItem(InvoiceItem invoiceItem) {
        return null;
    }

    @Override
    public InvoiceItem getInvoiceItem(int id) {
        return null;
    }

    @Override
    public List<InvoiceItem> getAllInvoiceItems() {
        return null;
    }

    @Override
    public void updateInvoiceItem(InvoiceItem invoiceItem) {

    }

    @Override
    public void deleteInvoiceItem(int id) {

    }
}
