package com.erphotel.personManagement.dao;

import com.erphotel.Login.domain.LoginDomain;
import com.erphotel.personManagement.domain.PersonDomain;
import org.springframework.data.repository.CrudRepository;

public interface PersonDAO extends CrudRepository<PersonDomain, Long> {

}
