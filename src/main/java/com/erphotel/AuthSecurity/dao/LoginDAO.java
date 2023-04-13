package com.erphotel.AuthSecurity.dao;

import com.erphotel.AuthSecurity.domain.LoginDomain;
import org.springframework.data.repository.CrudRepository;

public interface LoginDAO extends CrudRepository<LoginDomain, Long> {

    LoginDomain findByUsername(String username);

}
