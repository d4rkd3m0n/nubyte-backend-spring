/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nubyte.logica;


import static org.mockito.Mockito.after;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nubyte.model.oltp.Oltpcliente;
import com.nubyte.model.oltp.Oltpfuncio;
import com.nubyte.model.oltp.OltpfuncioPK;
import com.nubyte.repositories.oltp.OltpclienteRepository;
import com.nubyte.repositories.oltp.OltpfuncioRepository;


/**
 *
 * @author Joako
 */

public class FacadeLogin{

	@Autowired
	OltpfuncioRepository oltpfuncioRepository;
	
	@Autowired
	OltpclienteRepository oltpclienteRepository;
	
    public String login(String correo, String pass){
        String retorno = "-1";
        List<Oltpfuncio> clientes = oltpfuncioRepository.findAll();
        for (Oltpfuncio cliente : clientes) {
            if(cliente.getCorreo().equals(correo)){
                if(cliente.getContrasena().equals(pass)){
                    retorno=cliente.getNombrefunc()+" "+cliente.getOltprol().getIdrol()+" "+cliente.getOltpfuncioPK().getOltpestableciNit();
                }
            }else{
                System.out.println("Usuario no encontrado");
            }
        }
        System.out.println("retornoCliente: "+retorno);
        return retorno;
    }
    
    public boolean crearCuenta(String cedula, String nombre, String correo, String contrasena, String rol, String nit){
        boolean retorno = false;
        BigInteger auxCed = new BigInteger(cedula);
        BigInteger auxRol = new BigInteger(rol);
        System.out.println("ced: "+auxCed);
        System.out.println("rol: "+auxRol);
        OltpfuncioPK pk = new OltpfuncioPK(auxCed, nit, auxRol);
        Oltpfuncio oltpfuncio = new Oltpfuncio(pk, nombre, contrasena, correo);
        try{
            oltpfuncioRepository.save(oltpfuncio);
            retorno = true;
            return retorno;
        }catch(Exception e){
            return retorno;
        }
    }
    public String loginUsuario(String correo, String pass){
        String retorno = "-1";
        correo = correo.replaceAll("\\s","");
        pass = pass.replaceAll("\\s","");
        System.out.println(correo+pass);
        List<Oltpcliente> clientes = oltpclienteRepository.findAll();
        for (Oltpcliente cliente : clientes) {
            if(cliente.getCorreo().equals(correo)){
                if(cliente.getContrasena().equals(pass)){
                    retorno=cliente.getPuntos().toString();
                }
            }else{
                System.out.println("Usuario no encontrado");
            }
        }
        System.out.println("retornoApp: "+retorno);
        return retorno;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
