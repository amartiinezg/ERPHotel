package com.erphotel.personManagement.dao;

import com.erphotel.personManagement.domain.PersonDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonDAO extends JpaRepository<PersonDomain, Long> {
List<PersonDomain> findByName(String name);
}
