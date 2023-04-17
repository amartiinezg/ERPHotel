package com.erphotel.AuthSecurity.dao;

import com.erphotel.AuthSecurity.domain.RolDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RolDAO extends JpaRepository<RolDomain, Long> {

    List<RolDomain> findByName(String name);
}
