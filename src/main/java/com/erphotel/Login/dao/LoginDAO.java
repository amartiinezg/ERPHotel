package com.erphotel.Login.dao;

import com.erphotel.Login.domain.LoginDomain;
import org.springframework.data.repository.CrudRepository;

public interface LoginDAO extends CrudRepository<LoginDomain, Long> {

}
