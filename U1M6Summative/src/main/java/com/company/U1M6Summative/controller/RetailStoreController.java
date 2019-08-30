package com.company.U1M6Summative.controller;

import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.http.HttpStatus;
=======
>>>>>>> 417e35371d327df83332a3a1674f70b970ea5c6d
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RetailStoreController {
    @Autowired
    private ServiceLayer serviceLayer;
<<<<<<< HEAD


//    ReadAllCustomers
//    @RequestMapping(value="/customers", method = RequestMethod.GET)
//    @ResponseStatus(value = HttpStatus.OK)
//    public List<Customer> getAllCustomers() {
//
//    }


//    CreateCustomers
//    @RequestMapping(value="/customer", method = RequestMethod.POST)
//    @ResponseStatus(value = HttpStatus.CREATED)
//    public Customer createCustomer(@RequestBody Customer customer) {
//
//
//    }

//    UpdateCustomer
//    @RequestMapping(value="/customer/{id}", method = RequestMethod.PUT)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void updateCustomer(@RequestBody Customer customer, @PathVariable(name = "id") int id) {
//
//    }

//    DeleteCustomer
//    @RequestMapping(value="/customer/{id}", method = RequestMethod.DELETE)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteCustomer(@PathVariable(name = "id") int id) {
//
//   }


//    ______________________________________________________________

//    ReadAllItems
//    @RequestMapping(value="/items", method = RequestMethod.GET)
//    @ResponseStatus(value = HttpStatus.OK)
//    public List<Item> getAllItems() {
//
//    }


//    CreateItem
//    @RequestMapping(value="/item/{id}", method = RequestMethod.POST)
//    @ResponseStatus(value = HttpStatus.CREATED)
//    public Item createItem(@RequestBody Item item) {
//
//
//    }

//    UpdateItem
//    @RequestMapping(value="/item/{id}", method = RequestMethod.PUT)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void updateItem(@RequestBody Item item, @PathVariable(name = "id") int id) {
//
//    }

//    DeleteItem
//    @RequestMapping(value="/customer/{id}", method = RequestMethod.DELETE)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteItem(@PathVariable(name = "id") int id) {
//
//   }

//    CreateInvoice
//    @RequestMapping(value="/invoice/{id}", method = RequestMethod.POST)
//    @ResponseStatus(value = HttpStatus.CREATED)
//    public Invoice createInvoice(@RequestBody Invoice invoice) {
//
//    }

//    DeleteInvoice
//    @RequestMapping(value="/invoice/{id}", method = RequestMethod.DELETE)
//    @ResponseStatus(value = HttpStatus.NO_CONTENT)
//    public Invoice deleteInvoice(@RequestBody Invoice invoice) {
//
//
//    }






=======
>>>>>>> 417e35371d327df83332a3a1674f70b970ea5c6d

//    @RequestMapping(value="/customers", method = RequestMethod.GET)
//    public Customer getAllCustomers() {
//
//    }
//
//    @RequestMapping(value="/customer/{id}", method = RequestMethod.GET)
//    public Customer getCustomerById(@PathVariable(name="id") int id) {
//        return customerRepo.findOne(id);
//    }
//
//    @RequestMapping(value="/customer/{id}", method = RequestMethod.PUT)
//    public void updateCustomer(@RequestBody Customer customer, @PathVariable(name = "id") int id) {
//
//        customerRepo.save(customer);
//    }
//
//    @RequestMapping(value="/customer/{id}", method = RequestMethod.DELETE)
//    public void deleteCustomer(@PathVariable(name = "id") int id) {
//        customerRepo.delete(id);
//    }
//
//    @RequestMapping(value="/customers", method = RequestMethod.GET)
//    public List<Customer> getAllCustomers() {
//        return customerRepo.findAll();
//    }
//
//    @RequestMapping(value="/note", method = RequestMethod.POST)
//    public Note createNote(@RequestBody Note note) {
//        noteRepo.save(note);
//        return note;
//    }
//
//    @RequestMapping(value="/note/{id}", method = RequestMethod.GET)
//    public Note getNoteById(@PathVariable(name="id") int id) {
//        Note note = noteRepo.findOne(id);
//        return note;
//    }
//
//    @RequestMapping(value="/note/{id}", method = RequestMethod.PUT)
//    public void updateNote(@RequestBody Note note, @PathVariable(name="id") int id) {
//        // TODO - check matching ids...
//        noteRepo.save(note);
//    }
//
//    @RequestMapping(value="/note/{id}", method = RequestMethod.DELETE)
//    public void deleteNote(@PathVariable(name="id") int id) {
//        noteRepo.delete(id);
//    }
//
//    @RequestMapping(value="/notes", method = RequestMethod.GET)
//    public List<Note> getAllNotes() {
//        List<Note> noteList =  noteRepo.findAll();
//        return noteList;
//    }
//
}

