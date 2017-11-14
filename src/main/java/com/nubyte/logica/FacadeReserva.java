/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nubyte.logica;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.ejb.EJB;

import org.springframework.beans.factory.annotation.Autowired;

import com.nubyte.model.oltp.Oltpestableci;
import com.nubyte.model.oltp.Oltpreserva;
import com.nubyte.repositories.oltp.OltpestableciRepository;
import com.nubyte.repositories.oltp.OltpreservaRepository;

/**
 *
 * @author Joako
 */
public class FacadeReserva {

    @Autowired
    private OltpestableciRepository oltpestableciFacade;

    @Autowired
    private OltpreservaRepository oltpreservaFacade;



    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public boolean crearReserva(String cedula, String nombre, String fecha, String numeroPersonas, String nit){
        
        
        boolean retorno = false;
       
            System.out.println("recibo "+cedula+" "+nombre+" "+fecha+" "+numeroPersonas+" "+nit);
            
            BigInteger cant = new BigInteger(numeroPersonas);
            BigInteger ced = new BigInteger(cedula);
            Oltpestableci auxEst = oltpestableciFacade.findOne(nit);
            System.out.println("est "+auxEst.getNombre());
            int tam = oltpreservaFacade.findAll().size();
            BigDecimal id = new BigDecimal(tam);
            
            Oltpreserva r = new Oltpreserva(id, ced, nombre, fecha, cant);
            r.setNit(auxEst);
           
        try {
            oltpreservaFacade.save(r);
            retorno = true;
        }catch(Exception e){
            //e.printStackTrace();
            System.out.println("error");
        }
        return retorno;
    }
    public ArrayList<String> listaReservas(String nit){
         ArrayList<String> retorno = new ArrayList<>() ;
        List<Oltpreserva> aux = oltpreservaFacade.findAll();
        
        for (Oltpreserva oltpreserva : aux) {
            if(nit.equals(oltpreserva.getNit().getNit())){
                String func = "";
                //func = func+oltpreserva.getIdreserva().toString()+" ";
                func = func+oltpreserva.getCedula()+" ";
                func = func+oltpreserva.getNombrecliente()+" ";
                func = func+oltpreserva.getFecha()+" ";
                func = func+oltpreserva.getCantidadpersonas().toString();
                System.out.println("retornoFunc: "+func);
                retorno.add(func);
            }
        }
        
        return retorno; 
    }
}
