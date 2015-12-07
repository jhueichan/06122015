package com.action;

import com.dao.DaoEmpleado;
import com.dao.DaoProyecto;
import com.model.Empleado;
import com.model.Proyecto;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import java.io.IOException;

import java.util.List;

public class ProyectosAction {

    private DaoProyecto daoProyecto = new DaoProyecto();
    private DaoEmpleado daoEmpleado=new DaoEmpleado();
    public List<Proyecto> recordsProyecto;
    public List<Empleado> recordsEmpleado;
    private String result;
    private String message;
    private Proyecto record;
    
    private int codigoProyecto;    
    private int id;
    private String nomProyecto, ubicacion, descProyecto;
    private String fecha_inicio, fecha_termino;
    private Empleado ingeniero_originador, jefe_proyecto;

    private ValueStack val;
    public String iniciarFormulario() throws Exception {
//        val = ActionContext.getContext().getValueStack();
//        dao.eliminar(codigoProyecto);
//        val.push(record);
         try {
            // Fetch Data from Proyecto Table
            recordsEmpleado = daoEmpleado.listar();
            result = "OK";
        } catch (Exception e) {
            result = "ERROR";
            message = e.getMessage();
            System.err.println(e.getMessage());
        }
        
        return ActionSupport.SUCCESS;
    }
    
    
    
 public String rutEmpleado;
 public String create() throws IOException {
        Proyecto pro = new Proyecto();    
            
        try {                 
            pro.setNombre(this.nomProyecto);           
            pro.setUbicacion(this.ubicacion);        
            pro.setDescripcion(this.descProyecto); 
            pro.setFecha_inicio(fecha_inicio);
            pro.setFecha_termino(fecha_termino);             
            ingeniero_originador = daoEmpleado.buscarPorID(rutEmpleado);
            pro.setIngeniero_originador(this.ingeniero_originador);            
            jefe_proyecto = daoEmpleado.buscarPorID(rutEmpleado);            
            pro.setJefe_proyecto(this.jefe_proyecto);              
            daoProyecto.ingresar(pro);
            result = "OK";
        } catch (Exception e) {
            result = "ERROR";
            message = e.getMessage();
            System.err.println(e.getMessage());
        }
        return Action.SUCCESS;
 }
 
    public String list() {
        try {
            // Fetch Data from Proyecto Table
         recordsProyecto = daoProyecto.listar();
            result = "OK";
        } catch (Exception e) {
            result = "ERROR";
            message = e.getMessage();
            System.err.println(e.getMessage());
        }
        return Action.SUCCESS;
    }

    
    
    
    public DaoEmpleado getDaoEmpleado() {
        return daoEmpleado;
    }

    public void setDaoEmpleado(DaoEmpleado daoEmpleado) {
        this.daoEmpleado = daoEmpleado;
    }

    public String getNomProyecto() {
        return nomProyecto;
    }

    public void setNomProyecto(String nomProyecto) {
        this.nomProyecto = nomProyecto;
    }

    public String getDescProyecto() {
        return descProyecto;
    }

//    public String update() throws IOException {
//        Proyecto proyecto = new Proyecto();
//
//        proyecto.setId(this.codigoProyecto);
//        proyecto.setDescripcion(descripcion);
//        proyecto.setUbicacion(ubicacion);
//        proyecto.setFecha_inicio(fecha_inicio);
//        proyecto.setFecha_termino(fecha_termino);
//        proyecto.setIngeniero_originador(ingeniero_originador);
//        proyecto.setJefe_proyecto(jefe_proyecto);
//        
//        try {
//            // Update existing record
//            dao.actualizar(proyecto);
//            result = "OK";
//        } catch (Exception e) {
//            result = "ERROR";
//            message = e.getMessage();
//            System.err.println(e.getMessage());
//        }
//        return Action.SUCCESS;
//    }
//    public String delete() throws IOException {
//        // Delete record
//        try {
//            dao.eliminar(this.codigoProyecto);
//            result = "OK";
//        } catch (Exception e) {
//            result = "ERROR";
//            message = e.getMessage();
//            System.err.println(e.getMessage());
//        }
//        return Action.SUCCESS;
//    }
//    private int codigoProyecto;
//
//    public Proyecto buscaProyecto() throws IOException {
//        try {
//            record = dao.buscarPorID(codigoProyecto);
//            result = "OK";
//        } catch (Exception e) {
//            result = "ERROR";
//            message = e.getMessage();
//            System.err.println(e.getMessage());
//        }
//       
//        return record;
//    }
    public void setDescProyecto(String descProyecto) {
        this.descProyecto = descProyecto;
    }

    public DaoProyecto getDao() {
        return daoProyecto;
    }

    public void setDao(DaoProyecto dao) {
        this.daoProyecto = dao;
    }

    public List<Proyecto> getRecords() {
        return recordsProyecto;
    }

    public void setRecords(List<Proyecto> records) {
        this.recordsProyecto = records;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Proyecto getRecord() {
        return record;
    }

    public void setRecord(Proyecto record) {
        this.record = record;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  
    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }


    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_termino() {
        return fecha_termino;
    }

    public void setFecha_termino(String fecha_termino) {
        this.fecha_termino = fecha_termino;
    }

    public Empleado getIngeniero_originador() {
        return ingeniero_originador;
    }

    public void setIngeniero_originador(Empleado ingeniero_originador) {
        this.ingeniero_originador = ingeniero_originador;
    }

    public Empleado getJefe_proyecto() {
        return jefe_proyecto;
    }

    public void setJefe_proyecto(Empleado jefe_proyecto) {
        this.jefe_proyecto = jefe_proyecto;
    }

    public ValueStack getVal() {
        return val;
    }

    public void setVal(ValueStack val) {
        this.val = val;
    }

    public int getCodigoProyecto() {
        return codigoProyecto;
    }

    public void setCodigoProyecto(int codigoProyecto) {
        this.codigoProyecto = codigoProyecto;
    }
    
    
    
    
}
