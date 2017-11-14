package com.nubyte.repositories.oltp;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nubyte.model.oltp.Oltpreserva;

public interface OltpreservaRepository extends JpaRepository<Oltpreserva, BigDecimal> {

}
