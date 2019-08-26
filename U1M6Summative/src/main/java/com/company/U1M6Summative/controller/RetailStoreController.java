package com.company.U1M6Summative.controller;

import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RetailStoreController {
    @Autowired
    private ServiceLayer serviceLayer;

    @RequestMapping(value="/customers", method = RequestMethod.GET)
    public Customer getAllCustomers() {

    }

    @RequestMapping(value="/customer/{id}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable(name="id") int id) {
        return customerRepo.findOne(id);
    }

    @RequestMapping(value="/customer/{id}", method = RequestMethod.PUT)
    public void updateCustomer(@RequestBody Customer customer, @PathVariable(name = "id") int id) {

        customerRepo.save(customer);
    }

    @RequestMapping(value="/customer/{id}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable(name = "id") int id) {
        customerRepo.delete(id);
    }

    @RequestMapping(value="/customers", method = RequestMethod.GET)
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    @RequestMapping(value="/note", method = RequestMethod.POST)
    public Note createNote(@RequestBody Note note) {
        noteRepo.save(note);
        return note;
    }

    @RequestMapping(value="/note/{id}", method = RequestMethod.GET)
    public Note getNoteById(@PathVariable(name="id") int id) {
        Note note = noteRepo.findOne(id);
        return note;
    }

    @RequestMapping(value="/note/{id}", method = RequestMethod.PUT)
    public void updateNote(@RequestBody Note note, @PathVariable(name="id") int id) {
        // TODO - check matching ids...
        noteRepo.save(note);
    }

    @RequestMapping(value="/note/{id}", method = RequestMethod.DELETE)
    public void deleteNote(@PathVariable(name="id") int id) {
        noteRepo.delete(id);
    }

    @RequestMapping(value="/notes", method = RequestMethod.GET)
    public List<Note> getAllNotes() {
        List<Note> noteList =  noteRepo.findAll();
        return noteList;
    }

}
