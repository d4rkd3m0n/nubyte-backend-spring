    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nubyte.services.rest;



import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nubyte.logica.FacadeAppMovil;
import com.nubyte.logica.FacadeLogin;
import com.nubyte.logica.FacadePedirInfo;
import com.nubyte.logica.FacadeReserva;

/**
 *
 * @author Joako
 */

@CrossOrigin
@RestController
public class WebServiceREST {

	/*
    @Autowired
    private FacadeAppMovilRemote facadeAppMovil;

    @Autowired
    private FacadeReservaRemote facadeReserva;

    @Autowired
    private FacadePedirInfoRemote facadePedirInfo;

    @Autowired
    private FacadeLoginInterface facadeLogin;

    @Autowired
    private OltpclienteFacadeRemote ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @POST
    @Consumes("application/json")
    @Path("/create")
    public void create(Oltpcliente oltpcliente) {
        create(oltpcliente);
    }

    @POST
    @Consumes("application/json")
    @Path("/edit")
    public void edit(@WebParam(name = "oltpcliente") Oltpcliente oltpcliente) {
        ejbRef.edit(oltpcliente);
    }

    @POST
    @Consumes("application/json")
    @Path("/remove")
    public void remove(@WebParam(name = "oltpcliente") Oltpcliente oltpcliente) {
        ejbRef.remove(oltpcliente);
    }

    @GET
    @Produces("application/json")
    public Oltpcliente find(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @GET
    @Produces("application/json")
    public List<Oltpcliente> findAll() {
        return ejbRef.findAll();
    }

    @GET
    @Produces("application/json")
    public List<Oltpcliente> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @GET
    public int count() {
        return ejbRef.count();
    }*/
	
	private FacadeLogin facadeLogin;
	private FacadePedirInfo facadePedirInfo;
	private FacadeAppMovil facadeAppMovil;
	private FacadeReserva facadeReserva;
	
    /**
     * Web service operation
     */
    @POST
    @Path("/login")
    
    public String login(@HeaderParam("correo") String correo, @HeaderParam("pass") String pass) {
        //TODO write your implementation code here:
        return facadeLogin.login(correo, pass);
    }

    /**
     * Web service operation
     */
    @POST
    @Path("/crearCuenta")
    public Boolean crearCuenta(@HeaderParam("cedula") String cedula, @HeaderParam("nombre") String nombre, @HeaderParam("correo") String correo, @HeaderParam("contrasena") String contrasena, @HeaderParam("rol") String rol, @HeaderParam("nit") String nit) {
        //TODO write your implementation code here:
        return facadeLogin.crearCuenta(cedula, nombre, correo, contrasena, rol, nit);
    }

    /**
     * Web service operation
     */
    @GET
    @Produces("application/json")
    @Path("/listaFuncionarios")
    public ArrayList<String> listaFuncionarios() {
        //TODO write your implementation code here:
        ArrayList<String> retorno = facadePedirInfo.listaFuncionarios();
        for (String a : retorno) {
            System.out.println("retorno: "+a);
        }
        return retorno;
    }

    /**
     * Web service operation
     */
    @GET
    @Produces("application/json")
    @Path("/reglasAsociacion")
    public ArrayList<String> reglasAsociacion() {
        //TODO write your implementation code here:
        ArrayList<String> retorno = facadePedirInfo.pedirInfoAsociacion();
        for (String a : retorno) {
            System.out.println("retorno: "+a);
        }
        return retorno;
    }

    /**
     * Web service operation
     */
    @POST
    @Path("/crearReserva")
    public Boolean crearReserva(@HeaderParam("nombre") String nombre, @HeaderParam("cedula") String cedula, @HeaderParam("numPersonas") String numPersonas, @HeaderParam("fecha") String fecha, @HeaderParam("nit") String nit) {
        //TODO write your implementation code here:
        return facadeReserva.crearReserva(cedula, nombre, fecha, numPersonas, nit);
    }

    /**
     * Web service operation
     */
    @POST
    @Produces("application/json")
    @Path("/listarReservas")
    public ArrayList<String> listaReservas(@HeaderParam("nit") String nit) {
        //TODO write your implementation code here:
        ArrayList<String> retorno = facadeReserva.listaReservas(nit);
        for (String a : retorno) {
            System.out.println("retorno: "+a);
        }
        return retorno;
    }

    /**
     * Web service operation
     */

    @RequestMapping(value="/perdirInfoSegmentacion",method=RequestMethod.GET, produces="application/json")
    public ArrayList<String> pedirInfoSegmentacion() {
        //TODO write your implementation code here:
        ArrayList<String> retorno = facadePedirInfo.pedirInfoSegmentacion();
        for (String a : retorno) {
            System.out.println("retorno: "+a);
        }
        return retorno;
    }

    /**
     * Web service operation
     */

    @RequestMapping(value="/loginAPP2",method=RequestMethod.GET)
    public String loginApp2() {
        //TODO write your implementation code here:
        return "funciona";
        }
        
    @RequestMapping(value="/loginAPP",method=RequestMethod.POST, produces="text/plain")
    public String loginApp(@HeaderParam("correo") String correo, @HeaderParam("contrasena") String contrasena) {
        //TODO write your implementation code here:
        return facadeLogin.loginUsuario(correo, contrasena);
    }

    /**
     * Web service operation
     */
//    @POST
//    @Path("/crearCuentaApp")
//    public boolean crearCuentaApp(@HeaderParam("correo") String correo, @HeaderParam("nombre") String nombre, @HeaderParam("cedula") String cedula, @HeaderParam("pass") String pass, @HeaderParam("fechaNacimiento") String fechaNacimiento, @HeaderParam("genero") String genero) {
//        //TODO write your implementation code here:
//        //return facadeAppMovil.registrarUsuario(correo, nombre, cedula, pass, fechaNacimiento, genero);
//    	return true;
//    }
    /**
     * Web service operation
     */
    @POST
    @Path("/crearCuentaApp")
    public boolean crearCuentaApp(@HeaderParam("correo") String correo, @HeaderParam("contrasena") String pass) {
        //TODO write your implementation code here:
        //return facadeAppMovil.registrarUsuario(correo, nombre, cedula, pass, fechaNacimiento, genero);
    	return true;
    }

    /**
     * Web service operation
     */
    @GET
    @Produces("application/json")
    @Path("/listarEstablecimientos")
    public ArrayList<String> listarEstablecimientos() {
        //TODO write your implementation code here:
        ArrayList<String> retorno = facadeAppMovil.mostrarEstablecimientos();
        for (String string : retorno) {
            System.out.println("retorno "+string);
        }
        return retorno;
    }

    /**
     * Web service operation
     * @param nit
     * @return 
     */
    @POST
    @Produces("application/json")
    @Path("/listaProductosEst")
    public ArrayList<String> listaProductosEst(@HeaderParam("nit") String nit) {
        //TODO write your implementation code here:
        ArrayList<String> retorno = facadePedirInfo.listaProductos(nit);
        for (String string : retorno) {
            System.out.println("retorno "+string);
        }
        return retorno;
    }

    /**
     * Web service operation
     * @param nit
     * @return 
     */
    @POST
    @Produces("application/json")
    @Path("/listarPromos")
    public java.util.ArrayList<String> listarPromos(@HeaderParam("nit") String nit) {
        //TODO write your implementation code here:
         ArrayList<String> retorno = facadePedirInfo.listaPromos(nit);
        for (String string : retorno) {
            System.out.println("retorno "+string);
        }
        return retorno;
    }

    /**
     * Web service operation
     */
    @POST
    @Path("/crearPromo")
    public boolean crearPromo(@HeaderParam("nombre") String nombre, @HeaderParam("precio") String precio, @HeaderParam("fechaInicio") String fechaInicio, @HeaderParam("fechaFin") String fechaFin, @HeaderParam("nit") String nit) {
        //TODO write your implementation code here:
        return facadePedirInfo.crearPromo(nombre, precio, fechaInicio, fechaFin, nit);
    }

    /**
     * Web service operation
     */
    @POST
    @Path("/asignarPuntos")
    public String asignarPuntos(@HeaderParam("cedula") String cedula, @HeaderParam("puntos") String puntos) {
        //TODO write your implementation code here:
        return facadePedirInfo.asignarPuntos(cedula, puntos);
    }

    /**
     * Web service operation
     */
    @POST
    @Path("/pedirPuntos")
    public String pedirPuntos(@HeaderParam("correo") String cedula) {
        //TODO write your implementation code here:
        String retorno = facadeAppMovil.pedirPuntos(cedula);
        System.out.println("Puntos: "+retorno);
        return retorno;
    }



    
}
