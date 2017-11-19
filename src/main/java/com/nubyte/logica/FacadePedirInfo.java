/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nubyte.logica;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.nubyte.model.oltp.Oltpcliente;
import com.nubyte.model.oltp.Oltpestableci;
import com.nubyte.model.oltp.Oltpfuncio;
import com.nubyte.model.oltp.OltpfuncioPK;
import com.nubyte.model.oltp.Oltpproducto;
import com.nubyte.model.oltp.Oltppromos;
import com.nubyte.repositories.oltp.OltpclienteRepository;
import com.nubyte.repositories.oltp.OltpestableciRepository;
import com.nubyte.repositories.oltp.OltpfuncioRepository;
import com.nubyte.repositories.oltp.OltpproductoRepository;
import com.nubyte.repositories.oltp.OltppromosRepository;
import com.rapidminer.Process;
import com.rapidminer.RapidMiner;
import com.rapidminer.example.ExampleSet;
import com.rapidminer.example.Example;
import com.rapidminer.example.Attribute;
import com.rapidminer.example.AttributeRole;
import com.rapidminer.example.set.RemappedExampleSet;
import com.rapidminer.example.set.SimpleExampleSet;
import com.rapidminer.gui.renderer.AbstractGraphRenderer;
import com.rapidminer.gui.renderer.cluster.ClusterModelFolderRenderer;
import com.rapidminer.gui.viewer.DataTableViewerTable;
import com.rapidminer.operator.IOContainer;
import com.rapidminer.operator.IOObject;
import com.rapidminer.operator.Operator;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.operator.clustering.CentroidClusterModel;
import com.rapidminer.operator.clustering.Cluster;
import com.rapidminer.operator.learner.associations.AssociationRule;
import com.rapidminer.operator.learner.associations.AssociationRules;
import com.rapidminer.operator.learner.associations.FrequentItemSet;
import com.rapidminer.operator.learner.associations.Item;
import com.rapidminer.report.Reportable;
import com.rapidminer.tools.PlatformUtilities;
//import com.rapidminer.operator.io.ExcelExampleSource;
import com.rapidminer.tools.XMLException;


import java.nio.file.Paths;
import java.util.List;
import com.rapidminer.license.AlreadyRegisteredException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Vector;

/**
 *
 * @author Joako
 */
public class FacadePedirInfo {

    @Autowired
    private OltpclienteRepository oltpclienteFacade;

    @Autowired
    private OltppromosRepository oltppromosFacade;

    @Autowired
    private OltpproductoRepository oltpproductoFacade;

    @Autowired
    private OltpfuncioRepository oltpfuncioFacade;
    
    @Autowired
    private OltpestableciRepository oltpestablecimiento;
 
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public ArrayList<String> listaFuncionarios(){
        ArrayList<String> retorno = new ArrayList<>() ;
        List<Oltpfuncio> aux = oltpfuncioFacade.findAll();
        for (Oltpfuncio oltpfuncio : aux) {
            String func = "";
            func = func+oltpfuncio.getNombrefunc()+" ";
            func = func+oltpfuncio.getCorreo()+" ";
            OltpfuncioPK auxPK = oltpfuncio.getOltpfuncioPK();
            String ced = auxPK.getCedula().toString();
            func = func+ced;
            //System.out.println("retornoFunc: "+func);
            retorno.add(func);
        }
        
        return retorno; 
           
    }
    public ArrayList<String> pedirInfoSegmentacion(){
        ArrayList<String> values = new ArrayList<>();
        try {
            System.setProperty("rapidminer.home", "C:\\Program Files\\Rapidminer\\RapidMiner Studio");
          RapidMiner.setExecutionMode(RapidMiner.ExecutionMode.COMMAND_LINE);
          RapidMiner.init();
            
          Process process = new Process(new File("C:\\Users\\Joako\\OneDrive\\Universidad\\Seminario-Compartida\\TrabajodeGrado\\Codigo\\BlowoutCentral\\ModeloSegmentacionV4.rmp"));
          //Process process = new Process(new File("\\ModeloSegmentacionV4.rmp"));
          IOContainer res = process.run();
            SimpleExampleSet rem = (SimpleExampleSet) res.getElementAt(1);
            
          int i = 0;
          String out = "";
          /*Iterator<AttributeRole> allLabels = rem.getAttributes().allAttributeRoles();
              while (allLabels.hasNext()) {
                AttributeRole r = allLabels.next();
                String aux = r.getAttribute().getName();
                out=out+r.getAttribute().getName()+" ";
              }
              values.add(out);*/
              //System.out.println(out);
          for (Example example : rem) {
            Iterator<Attribute> allAtts = example.getAttributes().allAttributes();
              String aux = "";
            while (allAtts.hasNext()) {
                Attribute a = allAtts.next();
                if (a.isNumerical()) {
                    double value = example.getValue(a);
                    String c= String.valueOf(value);
                    aux = aux+" "+c;
                    //System.out.print(value);
                } else {
                    String value = example.getValueAsString(a);
                    aux=aux+" "+value+" ";
                    //System.out.print(value + " ");
                }
            }
            values.add(aux);
            
        }
          /*System.out.println("\n");
           for (String value : values) {
                  System.out.println(value.toString());
              }*/
          
        } catch (IOException | XMLException | OperatorException ex) {
          ex.printStackTrace();
        }
        
      return values;
    
    }
    public ArrayList<String> pedirInfoAsociacion(){
        ArrayList<String> values = new ArrayList<>();
        try {
          System.setProperty("rapidminer.home", "C:\\Program Files\\Rapidminer\\RapidMinerStudio");
          //System.setProperty(PlatformUtilities.PROPERTY_RAPIDMINER_HOME, Paths.get("").toAbsolutePath().toString());
          RapidMiner.setExecutionMode(RapidMiner.ExecutionMode.COMMAND_LINE);
          RapidMiner.init();
           Process process = new Process (new File("C:\\Users\\Joako\\OneDrive\\Universidad\\Seminario-Compartida\\TrabajodeGrado\\Codigo\\BlowoutCentral\\ModeloReglasAsociacionV4.rmp"));
           //com.rapidminer.Process process = new com.rapidminer.Process (new File("ModeloReglasAsociacionV4.rmp"));

          //Process process = new Process(new File("ModeloReglasAsociacionV4.rmp"));
          IOContainer res = process.run();
            AssociationRules rem = (AssociationRules) res.getElementAt(0);
            int i = 0;
            int j= 0;
            for (AssociationRule associationRule : rem) {
                System.out.println("regla no. "+i);
                String premisa = "";
                String conclusion = "";
                Iterator<Item> itemsPremise = rem.getRule(i).getPremiseItems();
                Iterator<Item> itemsConclusion = rem.getRule(i).getConclusionItems();
                while(itemsPremise.hasNext()){
                    
                    Item it = itemsPremise.next();
                    System.out.println("Premise "+i+" "+ it.toString());
                    String aux = quitarSumQuantity(it.toString());
                    premisa=premisa+" "+aux;
                }
                while(itemsConclusion.hasNext()){
                    
                    Item itC = itemsConclusion.next();
                    System.out.println("Conclusion "+i+" "+itC.toString());
                    String aux = quitarSumQuantity(itC.toString());
                    conclusion = conclusion+" "+aux;
                }
                double aux = rem.getRule(i).getConfidence();
                this.round(aux,4);
                String confianza = String.valueOf(aux);
                
                System.out.println("Confianza "+rem.getRule(i).getConfidence());
                i++;
                String regla = premisa+" / "+conclusion+" / "+confianza;
                System.out.println(j+" "+regla);
                values.add(regla);
                j++;
                if(j==5){
                    break;
                }
            }
           
        } catch (IOException | XMLException | OperatorException ex) {
            System.out.println("excepcion");
            ex.printStackTrace();
        }
           //ReadRapidminerProcess rm = new ReadRapidminerProcess();
      //return rm.reglasAsociacion();
      return values;
    }
    public String quitarSumQuantity(String aux){
        String retorno = "";
        retorno = aux.replace("sum(Quantity)_", "");
        return retorno; 
    }
    public double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    public String listaProductos(String nit){
        List<Oltpproducto> aux = oltpproductoFacade.findAll();
        List<Oltpestableci> auxEst = oltpestablecimiento.findAll();
        JSONArray retorno = new JSONArray();
        for (Oltpestableci oltpestablecimientoAux : auxEst) {
			if(oltpestablecimientoAux.getNit().equals(nit)) {
		
	            for (Oltpproducto oltpproducto : aux) {
            	   try {
            		   
            			JSONObject item = new JSONObject();
           				item.put("nombre", oltpproducto.getNombreprod());
           				item.put("id", oltpproducto.getId());
           	            item.put("marca", oltpproducto.getMarca());
           	            item.put("volumen", oltpproducto.getVolumen());
           	            item.put("precio", oltpproducto.getPrecio());
           	            retorno.put(item);
           	            System.out.println("prod "+item);
            		   
           			} catch (JSONException e) {
           				// TODO Auto-generated catch block
           				e.printStackTrace();
           			}
	            }
			}
        }
        return retorno.toString();
    }
    public ArrayList<String> listaPromos(String nit){
        ArrayList<String> retorno = new ArrayList<>();
        List<Oltppromos> aux = oltppromosFacade.findAll();
        for (Oltppromos oltppromos : aux) {
            if(oltppromos.getNitest().equals(nit)){
                String value = "";
                value = value+oltppromos.getNombrepromo()+"/"+oltppromos.getPreciopromo()+"/"+oltppromos.getFechainicio()+"/"+ oltppromos.getFechafin();
                retorno.add(value);
            }
        }
        return retorno;
    }
    public boolean crearPromo(String nombre, String precio, String fechaInicio, String fechaFin, String nit){
        boolean retorno = false;
        try{
            double precioFin = Double.valueOf(precio);
            BigDecimal id = new BigDecimal(oltppromosFacade.count()) ;
            Oltppromos promo = new Oltppromos(id ,nombre, precioFin, fechaInicio, fechaFin, nit);
            oltppromosFacade.save(promo);
            retorno = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return retorno;
    }
    public String asignarPuntos(String cedula, String puntos){
        String retorno = "";
        try{
            Oltpcliente cl = new Oltpcliente();
            BigDecimal cedulaDec = new BigDecimal(cedula);
            cl = oltpclienteFacade.findOne(cedulaDec);
            BigInteger puntosInt = new BigInteger(puntos);
            cl.setPuntos(puntosInt);
            oltpclienteFacade.save(cl);
            retorno = oltpclienteFacade.findOne(cedulaDec).getNombrecliente();
        }catch(Exception e){
            e.printStackTrace();
        }
        return retorno;
    }
}
