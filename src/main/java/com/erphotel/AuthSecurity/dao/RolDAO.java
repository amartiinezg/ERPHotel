package com.erphotel.AuthSecurity.dao;

import com.erphotel.AuthSecurity.domain.RolDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface RolDAO extends JpaRepository<RolDomain, Long> {

    @Query("SELECT rol FROM Rols rol GROUP BY rol.name HAVING COUNT(*) = 1")
    List<RolDomain> findDistinctRols();

    List<RolDomain> findByName(String name);
}
