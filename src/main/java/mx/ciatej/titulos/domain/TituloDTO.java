/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ciatej.titulos.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import lombok.Data;

/**
 *
 * @author crojo
 */
@Data
@Entity
public class TituloDTO implements Serializable {
    
    @Id
    private Long idtitulo;
    private String curp;
    private String nombre;
    private String primerapellido;
    private String segundoapellido;
    private String correoelectronico;
    
    private Date fechainicio;
     
    private Date fechaterminacion;
  
    private Date fechaexamenprofesional;
   
    private Date fechaexencionexamenprofecional;
   
    private String cumplioserviciosocial;
    private String institucionprocedencia;
   
    private Date fechainicio_procedencia;
    
    private Date fechaterminacion_procedencia;
    
    private String nocedula;
    private Long lote;
    private String nombrexmlenvio;
    private String tituloxml;
    
    private String archivo;
    private String folio;
    private Integer estatus;
    
    
    public String getNombreCompleto(){
          return this.nombre + " " + this.primerapellido + " " + this.segundoapellido;
      }
    
}
