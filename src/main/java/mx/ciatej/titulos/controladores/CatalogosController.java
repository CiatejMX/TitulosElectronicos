package mx.ciatej.titulos.controladores;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import mx.ciatej.titulos.domain.DatoRecibo;
import mx.ciatej.titulos.domain.Responsable;
import mx.ciatej.titulos.domain.Titulo;
import mx.ciatej.titulos.domain.entidadFederativa;
import mx.ciatej.titulos.domain.institucioncarrera;
import mx.ciatej.titulos.service.DatoReciboServiceImp;
import mx.ciatej.titulos.service.ResponsableService;
import mx.ciatej.titulos.service.TituloService;
import mx.ciatej.titulos.service.entidadFederativaService;
import mx.ciatej.titulos.service.institucioncarreraService;
import mx.ciatej.titulos.ws.Encriptar;
import mx.ciatej.titulos.ws.Utileria;
import mx.ciatej.titulos.ws.Xml;
import org.apache.commons.io.FileUtils;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//@Controller
@RestController
@Slf4j
public class CatalogosController {
    
    @Autowired
    private entidadFederativaService efservice ;
    
    @Autowired 
            TituloService titulosrv;
    
    @Autowired 
            ResponsableService Responsablesrv;
    
    @Autowired
            DatoReciboServiceImp DatoReciboSrv;
    
     @GetMapping("/ef/listar")
    public List<entidadFederativa>  listarEF(Model model,
      @RequestParam(name="uno", required = false, defaultValue = "Ahmed") String uno,      
      @RequestParam(name="dos", required = false, defaultValue = "Ahmed2") String dos      
    ){
      //  var personas = personaService.listarPersonas();
       List<entidadFederativa> ef = efservice.listarEF();
        log.info("parametros : " + uno + "," + dos);
        //model.addAttribute("personas", personas);
       return ef;
        
    }
    
    @GetMapping("/titulo/impreso/{idtitulo}")
    public Titulo impreso (  Titulo titulo 
                                  ){
        titulo = titulosrv.encontrar(titulo);
        titulo.setHistoricoenvio(null); // problema con historico
        return titulo;
        
    }
    // ejemplo http://localhost:8181/titulo/titulodgp/?curp=MUIA820614MMNXBD08&idcarrera=411598
     @GetMapping("/titulo/titulodgp/")
    public String titulodgp (  
                         @RequestParam(name="curp", required = false, defaultValue = "0") String curp,
                         @RequestParam(name="idcarrera", required = false, defaultValue = "0") String idcarrera
                                  ){
         String resultado = "";
         String folio = idcarrera+curp;
         
         DatoRecibo dr = new DatoRecibo();
         
         dr = DatoReciboSrv.encontrarFolio(folio,"1");// estatus 1 supuesto no error
         
         if( dr != null && dr.getEstatus().compareTo("1") == 0 )
             resultado = dr.getMensaje();
         else 
             resultado = "ERROR Resultado de folio " + folio +" no econtrado ";
         
        return resultado ;
        
    }
    
     @GetMapping("/titulo/impreso/responsables")
    public List<Responsable>  impreso_responsables (  ){
        
        return Responsablesrv.listar();
        
    }
    
    @Autowired
    Encriptar enc;
    
          @Value("${configuracion.archivoscert}")
         private String archivoscert;
    
   
    
    @GetMapping("/encripta2")
    public String encripta2(
            @RequestParam(name="cadena") String cadena  
    ) throws Exception{ 
        
        File org = new File(archivoscert+"/"+cadena);
        File cript = new File(archivoscert+"/"+cadena+".cript");
        
         File nocript = new File(archivoscert+"/"+cadena+".nocript");
        
        enc.encrypt(org, cript);
        log.info(  Xml.certSerial(org.toString()) );
        enc.decrypt(cript, nocript);
        log.info(  Xml.certSerial(nocript.toString()) );
    return null;
    }
    
}
