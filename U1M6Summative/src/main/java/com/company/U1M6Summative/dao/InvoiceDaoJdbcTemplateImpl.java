package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.Invoice;
<<<<<<< HEAD

import java.util.List;

public class InvoiceDaoJdbcTemplateImpl implements InvoiceDao {
    //Prepared statements go here

=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class InvoiceDaoJdbcTemplateImpl implements InvoiceDao{

    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_INVOICE_SQL =
            "insert into invoice (title, artist_id, release_date, label_id, list_price) values (?, ?, ?, ?, ?)";

    private static final String SELECT_INVOICE_SQL =
            "select * from album where invoice_id = ?";

    private static final String SELECT_INVOICE_BY_CUSTOMER_SQL =
            "select * from invoice where customer_id =?";


    @Autowired
    public InvoiceDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
>>>>>>> master


    @Override
    public Invoice addInvoice(Invoice invoice) {
        return null;
    }

    @Override
    public Invoice getInvoice(int id) {
        return null;
    }

    @Override
<<<<<<< HEAD
=======
    public Invoice getInvoiceByCustomerId(int customerId) {
        try {
            return jdbcTemplate.queryForObject(SELECT_INVOICE_BY_CUSTOMER_SQL, this::mapRowToInvoice, customerId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
>>>>>>> master
    public List<Invoice> getAllInvoices() {
        return null;
    }

    @Override
    public void updateInvoice(Invoice invoice) {

    }

    @Override
    public void deleteInvoice(int id) {

    }
<<<<<<< HEAD
=======

    // HELPER METHOD
    private Invoice mapRowToInvoice(ResultSet rs, int rowNum) throws SQLException {
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(rs.getInt("invoice_id"));
        invoice.setCustomerId(rs.getInt("customer_id"));
        invoice.setOrderDate(rs.getDate("order_date").toLocalDate());
        invoice.setPickupDate(rs.getDate("pickup_date").toLocalDate());
        invoice.setReturnDate(rs.getDate("return_date").toLocalDate());
        invoice.setLateFee(rs.getBigDecimal("late_fee"));

        return invoice;
    }

>>>>>>> master
}
