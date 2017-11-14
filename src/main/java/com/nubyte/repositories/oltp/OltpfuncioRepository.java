package com.nubyte.repositories.oltp;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nubyte.model.oltp.Oltpfuncio;


public interface OltpfuncioRepository extends JpaRepository<Oltpfuncio, BigInteger> {

}
