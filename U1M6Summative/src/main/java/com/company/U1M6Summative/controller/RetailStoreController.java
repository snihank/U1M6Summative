//package com.company.U1M6Summative.controller;
//
//import com.company.U1M6Summative.model.Customer;
//import com.company.U1M6Summative.model.Invoice;
//import com.company.U1M6Summative.model.Item;
//import com.company.U1M6Summative.service.ServiceLayer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//
//import java.util.List;
//
//@RestController
//public class RetailStoreController {
//    @Autowired
//    private ServiceLayer service;
//
//
//    //    ReadAllCustomers
//    @RequestMapping(value = "/customers", method = RequestMethod.GET)
//    @ResponseStatus(value = HttpStatus.OK)
//    public List<Customer> getAllCustomers() {
//        return service.findAllCustomers();
//    }
//
//    //    ReadOneCustomer
//    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
//    @ResponseStatus(value = HttpStatus.OK)
//    public Customer getCustomer(@PathVariable(name = "id") int id) {
//        return service.findCustomer(id);
//    }
//
//
//    //    CreateCustomers
//    @RequestMapping(value = "/customer", method = RequestMethod.POST)
//    @ResponseStatus(value = HttpStatus.CREATED)
//    public Customer createCustomer(@RequestBody Customer customer) {
//        return service.saveCustomer(customer);
//
//    }
//
//    //    UpdateCustomer
//    @RequestMapping(value = "/customer/{id}", method = RequestMethod.PUT)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void updateCustomer(@RequestBody Customer customer, @PathVariable(name = "id") int id) {
//        service.updateCustomer(customer);
//    }
//
//    //    DeleteCustomer
//    @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteCustomer(@PathVariable(name = "id") int id) {
//        service.removeCustomer(id);
//    }
//
//
////    ______________________________________________________________
//
//    //    ReadAllItems
//    @RequestMapping(value = "/items", method = RequestMethod.GET)
//    @ResponseStatus(value = HttpStatus.OK)
//    public List<Item> getAllItems() {
//        return service.findAllItems();
//    }
//
//    // ReadOneItem
//    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
//    @ResponseStatus(value = HttpStatus.OK)
//    public Item getItem(@PathVariable(name = "id") int id) {
//        return service.findItem(id);
//    }
//
//
//    //    CreateItem
//    @RequestMapping(value = "/item/{id}", method = RequestMethod.POST)
//    @ResponseStatus(value = HttpStatus.CREATED)
//    public Item createItem(@RequestBody Item item) {
//
//        return service.saveItem(item);
//
//    }
//
//    //    UpdateItem
//    @RequestMapping(value = "/item/{id}", method = RequestMethod.PUT)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void updateItem(@RequestBody Item item, @PathVariable(name = "id") int id) {
//        service.updateItem(item);
//    }
//
//    //    DeleteItem
//    @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteItem(@PathVariable(name = "id") int id) {
//        service.removeItem(id);
//    }
//
//    //    CreateInvoice
////    @RequestMapping(value = "/invoice/{id}", method = RequestMethod.POST)
////    @ResponseStatus(value = HttpStatus.CREATED)
////    public Invoice createInvoice(@RequestBody Invoice invoice) {
////            return service.saveInvoice(invoice);
////    }
//
////    DeleteInvoice
////    @RequestMapping(value="/invoice/{id}", method = RequestMethod.DELETE)
////    @ResponseStatus(value = HttpStatus.NO_CONTENT)
////    public Invoice deleteInvoice(@RequestBody Invoice invoice) {
////
////
////    }
//
//
////
//    }
//
//
