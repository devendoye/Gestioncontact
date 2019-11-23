package com.gestionContact.Contact.Service;

import com.gestionContact.Contact.Repository.Repository;
import com.gestionContact.Contact.client.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
public class ContactService {

    @Autowired
    private Repository contactRepository;

    @RequestMapping(value = "/Contacts" , method = RequestMethod.GET)
    public List<Contact>  getcontact()
    {
        return  contactRepository.findAll();
    }
    @RequestMapping(value = "/Contacts/{id}" , method = RequestMethod.GET)
    public  Contact findById(@PathVariable int id)
    {
        return contactRepository.findById(id);
    }

    @RequestMapping(value = "/cherchercontacts" , method = RequestMethod.GET)
    public Page<Contact> chercher(
        @RequestParam(name ="mc",defaultValue = "") String mc,
        @RequestParam(name ="page",defaultValue = "") int page,
        @RequestParam(name ="size",defaultValue = "5") int size)
    {
return  contactRepository.chercher("%"+mc+"%" , new PageRequest ( 1,  2));
    }
    @RequestMapping(value = "/Contacts", method = RequestMethod.POST)
    public Contact addContact(@RequestBody Contact contact)
    {
        return   contactRepository.save(contact);
    }
    @RequestMapping(value = "/Contacts", method = RequestMethod.PUT)
    public Contact ModifContact(@RequestBody Contact contact , @PathVariable int id)
    {
        contact.setId(id);
        return   contactRepository.save(contact);
    }
    @RequestMapping(value = "/Contacts/{id}", method = RequestMethod.DELETE)
       public Boolean supprimer(@PathVariable  int id)
        {
            contactRepository.deleteById(id);

            return true;
        }



}
