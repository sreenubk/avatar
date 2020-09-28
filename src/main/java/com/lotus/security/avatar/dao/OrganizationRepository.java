package com.lotus.security.avatar.dao;

import com.lotus.security.avatar.model.OrganizationUnit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface OrganizationRepository extends JpaRepository<OrganizationUnit, BigDecimal> {

}
