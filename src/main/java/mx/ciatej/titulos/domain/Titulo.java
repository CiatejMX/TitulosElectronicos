package mx.ciatej.titulos.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Data
@Entity
@Table(name = "titulo")
public class Titulo implements Serializable {
    
   private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtitulo;
    private String curp;
    private String nombre;
    private String primerapellido;
    private String segundoapellido;
    private String correoelectronico;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso=ISO.DATE)
    private Date fechainicio;
   
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso=ISO.DATE)
    private Date fechaterminacion;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso=ISO.DATE)
    private Date fechaexpedicion;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso=ISO.DATE)
    private Date fechaexamenprofesional;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso=ISO.DATE)
    private Date fechaexencionexamenprofecional;
   
    private String cumplioserviciosocial;
    private String institucionprocedencia;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso=ISO.DATE)
    private Date fechainicio_procedencia;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso=ISO.DATE)
    private Date fechaterminacion_procedencia;
    
    private String nocedula;
    private Long lote;
    private String nombrexmlenvio;
    private String tituloxml;
     
    //private Long idinstitucioncarrera;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idinstitucioncarrera")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private institucioncarrera institucioncarrera; 
    
     @OneToOne(fetch=FetchType.LAZY)
     @JoinColumn(name="idmodalidadtitulacion")
     @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
     private ModalidadTitulacion modalidadtitulacion;
    //private Long idmodalidadtitulacion;
             
     @OneToOne(fetch=FetchType.LAZY)
     @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
     @JoinColumn(name="idfundamentolegalserviciosocial")
     private FundamentoLegalServicioSocial fundamentoLegalServicioSocial;
    //private Long idfundamentolegalserviciosocial;
    
     @OneToOne(fetch=FetchType.LAZY)
     @JoinColumn(name="identidadfederativa")
     @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
     private entidadFederativa entidadFederativa;
    //private Long identidadfederativa;
     
     @OneToOne(fetch=FetchType.LAZY)
     @JoinColumn(name="identidadfederativa_procedencia")
     @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private entidadFederativa entidadFederativa_procedencia; 
    //private Long identidadfederativa_procedencia;
     
     @OneToOne(fetch=FetchType.LAZY)
     @JoinColumn(name="idautorizacionreconocimiento")
     @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private AutorizacionReconocimiento autorizacionReconocimiento; 
     
      @OneToOne(fetch=FetchType.LAZY)
     @JoinColumn(name="idtipoestudioantecedente")
     @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private TipoEstudioAntecedente tipostudioAntecedente; 
      
      @ManyToOne(fetch=FetchType.LAZY)
      @JoinColumn(name="idhistoricoenvio")
        private HistoricoEnvio  historicoenvio;
      
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "titulo")
    private List<FirmasTitulo> firmatitulo;

      
      public String getNombreCompleto(){
          return this.nombre + " " + this.primerapellido + " " + this.segundoapellido;
      }
       
}
