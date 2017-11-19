/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nubyte.logica;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.nubyte.model.oltp.Oltpcliente;
import com.nubyte.model.oltp.Oltpestableci;
import com.nubyte.repositories.oltp.OltpclienteRepository;
import com.nubyte.repositories.oltp.OltpestableciRepository;



/**
 *
 * @author Joako
 */

public class FacadeAppMovil {

    @Autowired
    OltpestableciRepository oltpestableciFacade;

    @Autowired
    OltpclienteRepository oltpclienteFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public boolean registrarUsuario(String correo, String nombre, String cedula, String pass, String fechaNacimiento, String genero){
        BigDecimal ced = new BigDecimal(cedula);
        boolean retorno = false; 
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int anio = 0;
        Date fechanacimiento = new Date();
        
        try {
            fechanacimiento = dateFormat.parse(fechaNacimiento);
            anio = fechanacimiento.getYear();
        } catch (ParseException ex) {
            Logger.getLogger(FacadeAppMovil.class.getName()).log(Level.SEVERE, null, ex);
        }
        String generacion = calcularGeneracion(anio);
        String datestring=dateFormat.format(fechanacimiento);
        System.out.println( datestring );
        String generoAux = codigoGenero(genero);
        Oltpcliente cl = new Oltpcliente(ced, nombre, fechanacimiento, pass, correo, generoAux, generacion);
        try{
            System.out.println("cliente "+cl.getGeneracion()+" "+cl.getGenero()+" "+cl.getFechanacimiento().toString()+" "+cl.getCedula());
            oltpclienteFacade.save(cl);
            retorno = true;
            System.out.println("resultado "+retorno);
            return retorno;
        }catch(Exception e){
            return retorno;
        } 
        
    }
    public boolean registrarUsuario(String correo, String pass){
        BigDecimal ced = new BigDecimal(123456);
        boolean retorno = false; 
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int anio = 0;
        Date fechanacimiento = new Date();
        
        /*try {
            fechanacimiento = dateFormat.parse(fechaNacimiento);
            anio = fechanacimiento.getYear();
        } catch (ParseException ex) {
            Logger.getLogger(FacadeAppMovil.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        String generacion = calcularGeneracion(anio);
        String datestring=dateFormat.format(fechanacimiento);
        System.out.println( datestring );
        //String generoAux = codigoGenero(genero);
        Oltpcliente cl = new Oltpcliente(ced, pass, correo);
        try{
            System.out.println("cliente "+cl.getCorreo()+" "+cl.getContrasena()+" "+cl.getCedula());
            oltpclienteFacade.save(cl);
            retorno = true;
            System.out.println("resultado "+retorno);
            return retorno;
        }catch(Exception e){
            return retorno;
        } 
        
    }
    private String codigoGenero(String genero){
        String retorno = "";
        if(genero.equals("Masculino"))
            retorno="M";
        else 
            retorno="F";
        return retorno;
    }
    private String calcularGeneracion(int anio) {
        String generacion = "";
        if (anio<=1964){
            generacion = "Baby Bommer";
        }
        if(1965<=anio || anio<=1979){
            generacion = "X";
        }
        if(1980>=anio || anio<=1999){
            generacion = "Y";
        }else{
            generacion = "-";
        }
        return generacion;
    }
    public String mostrarEstablecimientos(){
        List<Oltpestableci> est = new ArrayList<>();
        JSONArray retorno = new JSONArray();
        est =  oltpestableciFacade.findAll();
        for (Oltpestableci oltpestableci : est) {
            /*String value = "";
            value += "{nombre:"+ oltpestableci.getNombre()+" "+oltpestableci.getDireccion();
            retorno.add(value);*/

            try {
                JSONObject item = new JSONObject();
				item.put("nombre", oltpestableci.getNombre());
				item.put("id", oltpestableci.getNit());
	            item.put("direccion", oltpestableci.getDireccion());
	            item.put("latitud", oltpestableci.getLatitud());
	            item.put("longitud", oltpestableci.getLongitud());
	            item.put("latitud", oltpestableci.getLatitud());
	            retorno.put(item);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            

        }
        return retorno.toString();
    }
    public String pedirPuntos(String correo){
        correo = correo.replaceAll("\\s","");
        String puntos = "0";
        try{
            List<Oltpcliente> cl = oltpclienteFacade.findAll();
            
            for (Oltpcliente cliente : cl) {
                System.out.println("cuenta "+cliente.getCorreo().equals(correo));
                if(cliente.getCorreo().equals(correo)){
                    puntos=cliente.getPuntos().toString();
                    System.out.println("encontro "+puntos);
                    
                }
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return puntos;
    }

}
