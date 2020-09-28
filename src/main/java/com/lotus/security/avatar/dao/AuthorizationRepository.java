package com.lotus.security.avatar.dao;

import com.lotus.security.avatar.model.AuthorizationGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface AuthorizationRepository  extends JpaRepository<AuthorizationGroup, BigDecimal> {

}
