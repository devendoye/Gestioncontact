package com.gestionContact.Contact.Repository;

import com.gestionContact.Contact.client.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Contact, Integer> {
    Contact  findById(int id);
    @Query("select c from Contact c where c.nom like :x")
    public Page<Contact> chercher(@Param("x") String mc , Pageable pageable);
}
