package com.erphotel.personManagement.dao;

import com.erphotel.personManagement.domain.PersonDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDAO extends JpaRepository<PersonDomain, Long> {

}
