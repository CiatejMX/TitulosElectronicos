package mx.ciatej.titulos.controladores;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mx.ciatej.titulos.dao.institucioncarreraDAO;
import mx.ciatej.titulos.domain.AutorizacionReconocimiento;
import mx.ciatej.titulos.domain.Cargo;
import mx.ciatej.titulos.domain.FirmasTitulo;
import mx.ciatej.titulos.domain.FundamentoLegalServicioSocial;
import mx.ciatej.titulos.domain.HistoricoEnvio;
import mx.ciatej.titulos.domain.LogAccion;
import mx.ciatej.titulos.domain.ModalidadTitulacion;
import mx.ciatej.titulos.domain.MotivoCancelacion;
import mx.ciatej.titulos.domain.Responsable;
import mx.ciatej.titulos.domain.Roles;
import mx.ciatej.titulos.domain.entidadFederativa;
import mx.ciatej.titulos.domain.TipoEstudioAntecedente;
import mx.ciatej.titulos.domain.Titulo;
import mx.ciatej.titulos.domain.Usuario;
import mx.ciatej.titulos.domain.carrera;
import mx.ciatej.titulos.domain.institucioncarrera;
import mx.ciatej.titulos.service.AutorizacionReconocimientoService;
import mx.ciatej.titulos.service.TipoEstudioAntecedenteService;
import mx.ciatej.titulos.service.CargoService;
import mx.ciatej.titulos.service.FundamentoLegalServicioSocialService;
import mx.ciatej.titulos.service.HistoricoEnvioService;
import mx.ciatej.titulos.service.ModalidadTitulacionService;
import mx.ciatej.titulos.service.MotivoCancelacionService;
import mx.ciatej.titulos.service.ResponsableService;
import mx.ciatej.titulos.service.TituloService;
import mx.ciatej.titulos.service.carreraService;
import mx.ciatej.titulos.service.entidadFederativaService;
import mx.ciatej.titulos.service.institucioncarreraService;
import mx.ciatej.titulos.ws.Utileria;
import mx.ciatej.titulos.ws.Xml;
import mx.ciatej.titulos.ws.puente.ConectorWS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.core.io.FileSystemResource;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import mx.ciatej.titulos.reporteador.UseReport;
import mx.ciatej.titulos.service.FirmasTitulloService;
import mx.ciatej.titulos.service.LogAccionService;
import mx.ciatej.titulos.service.RolesServiceImp;
import mx.ciatej.titulos.service.UsuarioService;
import mx.ciatej.titulos.ws.Encriptar;
import mx.ciatej.titulos.ws.ReaderXLS;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

@Controller
@Slf4j
public class inicioController {
    
    @Value("${configuracion.archivoscert}")
        private String archivoscert;
    
     @Value("${configuracion.csv}")
        private String csv;
   
     @GetMapping("/")
    public String inicio(Model model ){
        log.info("inicio" );
       return "panel";
        
    }
    
    
      @GetMapping("/panel")
    public String panel(Model model ){
        log.info("panel" );
       return "panel";  
    }
    
    @Autowired
    private entidadFederativaService  efsrv;
    
      @GetMapping("/catalogo/entidadfederativa")
    public String ef(Model model, @AuthenticationPrincipal User user ){
        log.info("EF" );
        List<entidadFederativa> ef = efsrv.listarEF();
        model.addAttribute("efs", ef);
        model.addAttribute("user", user);
       return "Catalogo/entidadFederativa";  
    }
    //---------------------------------------------------------------------------
     @Autowired
    private CargoService  CargoSrv;
    
      @GetMapping("/catalogo/cargo")
    public String cargo(Model model ){
        log.info("cargo load" );
        List<Cargo> Cargos = CargoSrv.listar();
        Cargo cargoNew = new Cargo();
        model.addAttribute("cargos", Cargos);
        model.addAttribute("cargoNew", cargoNew);
       return "Catalogo/cargo";  
    }
    
     @PostMapping("/catalogo/cargo/guardar")
    public String Cargoguardar(@Valid Cargo cargo, Errors errores){
        if(errores.hasErrors()){
            return "modificar";
        }
           loga.log("/catalogo/cargo/guardar",cargo.toString() );
        CargoSrv.guardar(cargo);
        return "redirect:/catalogo/cargo/";
    }
    
     @GetMapping("/catalogo/cargo/eliminar")
    public String eliminar(Cargo cargo){
        loga.log("/catalogo/cargo/eliminar",cargo.toString() );
        CargoSrv.eliminar(cargo);
        return "redirect:/catalogo/cargo/";
    }
    //-----------------------------------------------
    @Autowired
    private TipoEstudioAntecedenteService  TipoEstudioAntecedenteSrv;
    
    @ModelAttribute("tipostudioAntecedentes")
    public List<TipoEstudioAntecedente> listarTipoEstudio(){
        return TipoEstudioAntecedenteSrv.listar();
    }
     @GetMapping("/catalogo/tipoestudioantecedente")
    public String tipoestudioantecedente(Model model, @AuthenticationPrincipal User user ){
        log.info("TipoEstudioAntecedente load" );
        List<TipoEstudioAntecedente> TipoEstudioAntecedente = TipoEstudioAntecedenteSrv.listar();
        TipoEstudioAntecedente TipoEstudioAntecedenteNew = new TipoEstudioAntecedente();
        model.addAttribute("TipoEstudioAntecedentes", TipoEstudioAntecedente);
        model.addAttribute("TipoEstudioAntecedenteNew", TipoEstudioAntecedenteNew);
        model.addAttribute("user", user);
       return "Catalogo/tipoestudioantecedente";  
    }
    
     @PostMapping("/catalogo/tipoestudioantecedente/guardar")
    public String tipoesudioantecedenteguardar(@Valid TipoEstudioAntecedente TipoEstudioAntecedente, Errors errores){
        if(errores.hasErrors()){
            return "modificar";
        }
        loga.log("/catalogo/tipoestudioantecedente/guardar",TipoEstudioAntecedente.toString() );
        TipoEstudioAntecedenteSrv.guardar(TipoEstudioAntecedente);
        return "redirect:/catalogo/tipoestudioantecedente/";
    }
    
     @GetMapping("/catalogo/tipoestudioantecedente/eliminar")
    public String tipoesudioantecedenteeliminar(TipoEstudioAntecedente TipoEstudioAntecedente){
        loga.log("/catalogo/tipoestudioantecedente/eliminar",TipoEstudioAntecedente.toString() );
        TipoEstudioAntecedenteSrv.eliminar(TipoEstudioAntecedente);
        return "redirect:/catalogo/tipoestudioantecedente/";
    }
    //-------------------------------------------------------
     //---------------------------------------------------------------------------
     @Autowired
    private FundamentoLegalServicioSocialService  FundamentoLegalSS;
    
      @GetMapping("/catalogo/fundamentolegalserviciosociales")
    public String fundamentolegalserviciosociales(Model model , @AuthenticationPrincipal User user ){
        log.info("cargo load" );
        List<FundamentoLegalServicioSocial> FundamentoLegalServicioSocial = FundamentoLegalSS.listar();
        FundamentoLegalServicioSocial FundamentoLegalServicioSocialNew = new FundamentoLegalServicioSocial();
        model.addAttribute("fundamentolegalserviciosociales", FundamentoLegalServicioSocial);
        model.addAttribute("fundamentolegalserviciosocialNew", FundamentoLegalServicioSocialNew);
        model.addAttribute("user", user);
       return "Catalogo/fundamentolegalserviciosociales";  
    }
    
     @PostMapping("/catalogo/fundamentolegalserviciosociales/guardar")
    public String fundamentolegalserviciosocialesguardar(@Valid FundamentoLegalServicioSocial FundamentoLegalServicioSocial, Errors errores){
        if(errores.hasErrors()){
            return "modificar";
        }
        loga.log("/catalogo/tipoestudioantecedente/guardar",FundamentoLegalServicioSocial.toString() );
        FundamentoLegalSS.guardar(FundamentoLegalServicioSocial);
        return "redirect:/catalogo/fundamentolegalserviciosociales/";
    }
    
     @GetMapping("/catalogo/fundamentolegalserviciosociales/eliminar")
    public String fundamentolegalserviciosocialeseliminar(FundamentoLegalServicioSocial FundamentoLegalServicioSocial){
        loga.log("/catalogo/fundamentolegalserviciosociales/eliminar",FundamentoLegalServicioSocial.toString() );
        FundamentoLegalSS.eliminar(FundamentoLegalServicioSocial);
        return "redirect:/catalogo/fundamentolegalserviciosociales/";
    }
    //----------------------------------------------------------------
     @Autowired
    private ModalidadTitulacionService  ModalidadTitulacioSrv;
    
      @GetMapping("/catalogo/modalidadtitulacion")
    public String modalidadtitulacion(Model model , @AuthenticationPrincipal User user ){
        log.info("cargo load" );
        List<ModalidadTitulacion> ModalidadTitulacion = ModalidadTitulacioSrv.listar();
        ModalidadTitulacion ModalidadTitulacionNew = new ModalidadTitulacion();
        model.addAttribute("ModalidadTitulacions", ModalidadTitulacion);
        model.addAttribute("ModalidadTitulacionNew", ModalidadTitulacionNew);
        model.addAttribute("user", user);
       return "Catalogo/modalidadtitulacion";  
    }
    
     @PostMapping("/catalogo/modalidadtitulacion/guardar")
    public String modalidadtitulacionguardar(@Valid ModalidadTitulacion ModalidadTitulacion, Errors errores){
        if(errores.hasErrors()){
            return "modificar";
        }
        loga.log("/catalogo/modalidadtitulacion/guardar",ModalidadTitulacion.toString() );
        ModalidadTitulacioSrv.guardar(ModalidadTitulacion);
        return "redirect:/catalogo/modalidadtitulacion/";
    }
    
     @GetMapping("/catalogo/modalidadtitulacion/eliminar")
    public String ModalidadTitulacioeliminar(ModalidadTitulacion ModalidadTitulacion){
         loga.log("/catalogo/modalidadtitulacion/eliminar",ModalidadTitulacion.toString() );
        ModalidadTitulacioSrv.eliminar(ModalidadTitulacion);
        return "redirect:/catalogo/modalidadtitulacion/";
    }
    //--------------------------------------------------------------------------
     @Autowired
    private AutorizacionReconocimientoService  AutorizacionReconocimientoSrv;
     
    @ModelAttribute("autorizacionReconocimientos")
     public List<AutorizacionReconocimiento> listarautorizacionReconocimiento(){
     return AutorizacionReconocimientoSrv.listar();
    }
    
    
      @GetMapping("/catalogo/autorizacionreconocimiento")
    public String AutorizacionReconocimiento(Model model , @AuthenticationPrincipal User user ){
        log.info("cargo load" );
        List<AutorizacionReconocimiento> AutorizacionReconocimiento = AutorizacionReconocimientoSrv.listar();
        AutorizacionReconocimiento AutorizacionReconocimientoNew = new AutorizacionReconocimiento();
        model.addAttribute("AutorizacionReconocimientos", AutorizacionReconocimiento);
        model.addAttribute("AutorizacionReconocimientoNew", AutorizacionReconocimientoNew);
        model.addAttribute("user", user);
       return "Catalogo/autorizacionreconocimiento";  
    }
    
     @PostMapping("/catalogo/autorizacionreconocimiento/guardar")
    public String AutorizacionReconocimientoguardar(@Valid AutorizacionReconocimiento AutorizacionReconocimiento, Errors errores){
        if(errores.hasErrors()){
            return "modificar";
        }
         loga.log("/catalogo/autorizacionreconocimiento/guardar",AutorizacionReconocimiento.toString() );
       AutorizacionReconocimientoSrv.guardar(AutorizacionReconocimiento);
        return "redirect:/catalogo/autorizacionreconocimiento/";
    }
    
     @GetMapping("/catalogo/autorizacionreconocimiento/eliminar")
    public String AutorizacionReconocimientoeliminar(AutorizacionReconocimiento AutorizacionReconocimiento){
        loga.log("/catalogo/autorizacionreconocimiento/eliminar",AutorizacionReconocimiento.toString() );
        AutorizacionReconocimientoSrv.eliminar(AutorizacionReconocimiento);
        return "redirect:/catalogo/autorizacionreconocimiento/";
    }
    //----------------------------------------------------
     @Autowired
    private MotivoCancelacionService  MotivoCancelacionSrv;
    
      @GetMapping("/catalogo/motivocancelacion")
    public String MotivoCancelacion(Model model , @AuthenticationPrincipal User user ){
        log.info("cargo load" );
        List<MotivoCancelacion> MotivoCancelacion = MotivoCancelacionSrv.listar();
        MotivoCancelacion MotivoCancelacionNew = new MotivoCancelacion();
        model.addAttribute("MotivoCancelacions", MotivoCancelacion);
        model.addAttribute("MotivoCancelacionoNew", MotivoCancelacionNew);
        model.addAttribute("user", user);
       return "Catalogo/motivocancelacion";  
    }
    
     @PostMapping("/catalogo/motivocancelacion/guardar")
    public String MotivoCancelacionguardar(@Valid MotivoCancelacion MotivoCancelacion, Errors errores){
        if(errores.hasErrors()){
            return "modificar";
        }
        loga.log("/catalogo/motivocancelacion/guardar",MotivoCancelacion.toString() );
       MotivoCancelacionSrv.guardar(MotivoCancelacion);
        return "redirect:/catalogo/motivocancelacion/";
    }
    
     @GetMapping("/catalogo/motivocancelacion/eliminar")
    public String MotivoCancelacioneliminar(MotivoCancelacion MotivoCancelacion){
          loga.log("/catalogo/motivocancelacion/eliminar",MotivoCancelacion.toString() );
        MotivoCancelacionSrv.eliminar(MotivoCancelacion);
        return "redirect:/catalogo/motivocancelacion/";
    }//----------------------------------------------------
     @Autowired
    private carreraService  carreraSrv;
    
    @Autowired
    private institucioncarreraService  institucioncarreraSrv;
    
    
      @GetMapping("/catalogo/carrera")
    public String carrera(Model model , @AuthenticationPrincipal User user ){
        log.info("carrera load" );
        List<carrera> carrera = carreraSrv.listar();
        carrera carreraNew = new carrera();
        model.addAttribute("carreras", carrera);
        model.addAttribute("carreraNew", carreraNew);
        model.addAttribute("user", user);
       return "Catalogo/carrera";  
    }
    
     @PostMapping("/catalogo/carrera/guardar")
    public String carreraguardar(@Valid carrera carrera, Errors errores){
        if(errores.hasErrors()){
            return "modificar";
        }
       carreraSrv.guardar( carrera );
         
         
        return "redirect:/catalogo/carrera/";
    }
    
     @GetMapping("/catalogo/carrera/eliminar")
    public String carreraeliminar(carrera carrera){
        carreraSrv.eliminar(carrera);
        return "redirect:/catalogo/carrera/";
    }
    
    @GetMapping("/catalogo/carrera/editar/{cve_carrera}")
    public String carreraeditar(carrera carrera, Model model){
        carrera car = carreraSrv.encontrar(carrera);
        model.addAttribute("carrera", car);
        
        List<entidadFederativa> entidadfederativa = efsrv.listarEF();
        model.addAttribute("entidadfederativa", entidadfederativa);
        
        return "Catalogo/carreraedit";
    }
    
     @GetMapping("/catalogo/carrera/agregar")
    public String carreraagregar(carrera carrera, Model model){
        
        carrera carr = new carrera();
        model.addAttribute("carrera", carr);
        
        List<entidadFederativa> entidadfederativa = efsrv.listarEF();
        model.addAttribute("entidadfederativa", entidadfederativa);
        

        return "Catalogo/carreraedit";
    }
    //----------------------------------------------------
     @Autowired
    private ResponsableService  ResponsableSrv;
    
      @GetMapping("/catalogo/responsable")
    public String Responsable(Model model , @AuthenticationPrincipal User user ){
        log.info("cargo load" );
        List<Responsable> Responsable = ResponsableSrv.listar();
        Responsable ResponsableNew = new Responsable();
        model.addAttribute("Responsables", Responsable);
        model.addAttribute("ResponsableNew", ResponsableNew);
        model.addAttribute("user", user);
       return "Catalogo/responsable";  
    }
    
     @PostMapping("/catalogo/responsable/guardar")
    public String Responsableguardar(@Valid Responsable Responsable, Errors errores){
        if(errores.hasErrors()){
            return "modificar";
        }
        log.info( "----------------------------------" +Responsable.toString());
         loga.log("/catalogo/responsable/guardar",Responsable.toString() );
       ResponsableSrv.guardar( Responsable);
        return "redirect:/catalogo/responsable/";
    }
     @GetMapping("/catalogo/responsable/eliminar")
    public String Responsableeliminar(Responsable Responsable){
        ResponsableSrv.eliminar(Responsable);
          loga.log("/catalogo/responsable/eliminar",Responsable.toString() );
        return "redirect:/catalogo/responsable/";
    }
    
    @GetMapping("/catalogo/responsable/editar/{idresponsable}")
    public String editar(Responsable responsable, Model model){
        Responsable res = ResponsableSrv.encontrar(responsable);
        
        List<Cargo> Cargos = CargoSrv.listar();
        model.addAttribute("Cargo", Cargos);
        
        model.addAttribute("Responsable", res);
        return "Catalogo/responsableedit";
    }
    
     @GetMapping("/catalogo/responsable/agregar")
    public String agregar(Responsable Responsable, Model model){
        
        Responsable res = new Responsable();
        model.addAttribute("Responsable", res);

        List<Cargo> Cargos = CargoSrv.listar();
        model.addAttribute("Cargo", Cargos);
        return "Catalogo/responsableedit";
    }
      @Autowired
    Encriptar enc;
    private static String UPLOADED_FOLDER = "/cerificados";
    
    @PostMapping("/upload/cert/resp/{idresponsable}") 
    public String singleFileUpload(Responsable responsable,@RequestParam("file") MultipartFile file,
            @RequestParam("campo") String opc,
                                   RedirectAttributes redirectAttributes) {
        log.info("---------------------------------------------------file" + file.getOriginalFilename() );
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
           // return "redirect:uploadStatus";
        }
        Responsable res = ResponsableSrv.encontrar(responsable);
        
        
        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            
            String nombreArchivo = file.getOriginalFilename();
            Path path = Paths.get(archivoscert).resolve(nombreArchivo).toAbsolutePath();
            //Files.write(path, bytes);
            Files.copy(file.getInputStream(), path);
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
            
            if ( opc.equals("cert")  ){
                String serie = Xml.certSerial(path.toString());
                log.info( "serie: " + serie + "  certificado:  " + path.toString() );
                 res.setNumerocertificado(serie); 
                res.setCertificadoresponsable(nombreArchivo);
               
                
            }else{
                res.setLlaveesponsable(nombreArchivo);
                log.info("---------------------file-key :" + opc );
            }
             loga.log("/upload/cert/resp/",responsable.toString() );
            ResponsableSrv.guardar(res);
            
             // *** para enrciptar y borra el archivo cert
             //enc.desactivaArchivo(path.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/catalogo/responsable/editar/"+res.getIdresponsable();
        
    }
    //------------------------------historialenvio-----------------------------------------
         @Autowired
    private HistoricoEnvioService  heSrv;
    
      @GetMapping("/titulo/historicoenvio")
    public String historicoenvio(Model model , @AuthenticationPrincipal User user ){
        log.info("he load" );
        List<HistoricoEnvio> historicoEnvio = heSrv.listar();
        HistoricoEnvio historicoEnvioNew = new HistoricoEnvio();
        model.addAttribute("historicoEnvios", historicoEnvio);
        model.addAttribute("historicoEnvioNew", historicoEnvioNew);
        model.addAttribute("user", user);
       return "titulo/historicoEnvio";  
    }
    
     @PostMapping("/titulo/historicoenvio/buscador")
    public String historicoenvioBuscador(Model model , @AuthenticationPrincipal User user,
                 @RequestParam(name="opcion", required = false, defaultValue = "ninguno") String opcion,      
             @RequestParam(name="texto", required = false) String texto    
            ){
        
        log.info("he load" );
        List<HistoricoEnvio> historicoEnvio = null;
         if ("curp".equals(opcion)){
           historicoEnvio = heSrv.buscaCurp(texto);
        }
        if ("nombre".equals(opcion)){
           historicoEnvio = heSrv.buscaNombreCompleto(texto);
        }
        if ("ninguno".equals(opcion)){
           historicoEnvio = heSrv.listar();
        }
        
        
        HistoricoEnvio historicoEnvioNew = new HistoricoEnvio();
        model.addAttribute("historicoEnvios", historicoEnvio);
        model.addAttribute("historicoEnvioNew", historicoEnvioNew);
        model.addAttribute("user", user);
       return "titulo/historicoEnvio";  
    }
    
     @PostMapping("/titulo/historicoenvio/guardar")
    public String historicoenvioguardar(@Valid HistoricoEnvio historicoEnvio, Errors errores){
        if(errores.hasErrors()){
            return "modificar";
        }
        log.info( "----------------------------------" +historicoEnvio.toString());
         loga.log("/titulo/historicoenvio/guardar",historicoEnvio.toString() );
       heSrv.guardar( historicoEnvio);
        return "redirect:/titulo/historicoenvio/editar/"+historicoEnvio.getIdhistoricoenvio();
    }
    
    @GetMapping("/titulo/historicoenvio/guardaritem")
    public String historicoenvioguardaritem(@Valid HistoricoEnvio historicoEnvio, Errors errores,
      @RequestParam(name="idhistoricoenvio", required = false ) Long idhistoricoenvio,      
      @RequestParam(name="idtitulo", required = false) Long idtitulo  
    ){
        Titulo paramTit  = new Titulo();
        paramTit.setIdtitulo( idtitulo );
        
        HistoricoEnvio paramHistorico = new HistoricoEnvio();
        paramHistorico.setIdhistoricoenvio(idhistoricoenvio);
        
        Titulo tit = tituloSrv.encontrar(paramTit);
        tit.setHistoricoenvio(paramHistorico);
        log.info( "-------------------titulo : -----" +tit.toString());
         loga.log("/titulo/historicoenvio/guardaritem",historicoEnvio.toString() );
        tituloSrv.guardar(tit);
       
        return "redirect:/titulo/historicoenvio/editar/"+idhistoricoenvio;
    }
    
    @GetMapping("/titulo/historicoenvio/eliminaritem")
    public String historicoenvioeliminaitem(@Valid HistoricoEnvio historicoEnvio, Errors errores,
      @RequestParam(name="idhistoricoenvio", required = false ) Long idhistoricoenvio,      
      @RequestParam(name="idtitulo", required = false) Long idtitulo  
    ){
        Titulo paramTit  = new Titulo();
        paramTit.setIdtitulo( idtitulo );
        
        HistoricoEnvio paramHistorico = new HistoricoEnvio();
        paramHistorico.setIdhistoricoenvio(idhistoricoenvio);
        
        Titulo tit = tituloSrv.encontrar(paramTit);
        tit.setHistoricoenvio(null);
        log.info( "-------------------titulo : -----" +tit.toString());
        loga.log("/titulo/historicoenvio/eliminaritem",historicoEnvio.toString() );
        tituloSrv.guardar(tit);
       
        return "redirect:/titulo/historicoenvio/editar/"+idhistoricoenvio;
    }
    
      @GetMapping("/titulo/historicoenvio/eliminaritemsimple")
    public String historicoEliminarItem(@Valid Titulo titulo){
        titulo.setHistoricoenvio(null);
        loga.log("/titulo/historicoenvio/eliminaritemsimple",titulo.toString() );
       tituloSrv.guardar(titulo);
        return "redirect:/titulo/historicoenvio/";
    }
    
     @GetMapping("/titulo/historicoenvio/eliminar/{idhistoricoenvio}")
    public String historicoenvioeliminar(HistoricoEnvio historicoEnvio){
         loga.log("/titulo/historicoenvio/eliminar/",historicoEnvio.toString() );
        heSrv.eliminar(historicoEnvio);
        return "redirect:/titulo/historicoenvio";
    }
    
    @GetMapping("/titulo/historicoenvio/editar/{idhistoricoenvio}")
    public String historicoenvioeditar(HistoricoEnvio historicoEnvio, Model model){
        HistoricoEnvio he = heSrv.encontrar(historicoEnvio);
   
        model.addAttribute("HistoricoEnvio", he);
        return "titulo/historicoEnvioEdit";
    }
    
     @GetMapping("/titulo/historicoenvio/agregar")
    public String historicoenvioagregar(HistoricoEnvio historicoEnvio, Model model){
        
        HistoricoEnvio  he = new HistoricoEnvio ();
        model.addAttribute("HistoricoEnvio", he);


        return "titulo/historicoEnvioEdit";
    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------
    //----------------------------------------titulos--------------------------------------------
     @Autowired
    private TituloService  tituloSrv;
     
     @Autowired
     private institucioncarreraDAO icDAO;
    
     @GetMapping(value="/titulo/buscanombre/{nombre}",produces={"application/json"})
     public @ResponseBody List<Titulo> buscaNombre(@PathVariable String nombre){
         return tituloSrv.buscaNombre(nombre);
     }
     
      @GetMapping("/titulo")
    public String Titulo(Model model , Authentication auth ){
        log.info("cargo titulo" );
        List<Titulo> titulo = tituloSrv.listar();
       
       
        Titulo tituloNew = new Titulo();
        model.addAttribute("titulo", titulo);
        model.addAttribute("tituloNew", tituloNew);
       
       
       return "titulo/titulo";  
    }
    
      @PostMapping("/titulo/buscador/")
    public String TituloBuscador(Model model , @AuthenticationPrincipal User user,
             @RequestParam(name="opcion", required = false, defaultValue = "ninguno") String opcion,      
             @RequestParam(name="texto", required = false) String texto    
    ){
        
        List<Titulo> titulo = null;
        

        if ("curp".equals(opcion)){
            titulo = tituloSrv.buscaCurp(texto);
        }
        if ("nombre".equals(opcion)){
            titulo = tituloSrv.buscaNombreCompleto(texto);
        }
        if ("ninguno".equals(opcion)){
            titulo = tituloSrv.listar();
        }
        
        Titulo tituloNew = new Titulo();
        model.addAttribute("titulo", titulo);
        model.addAttribute("tituloNew", tituloNew);
        model.addAttribute("user", user);
       return "titulo/titulo";  
    }
    
    @PostMapping("/titulo/guardar")
    public String tituloguardar(@Valid Titulo titulo, Errors errores){
        if(errores.hasErrors()){
            log.info(errores.getAllErrors().toString());
            log.info("==========fechaini:"+titulo.getFechainicio());
            return "titulo/tituloedit";
        }
         loga.log("/titulo/guardar",titulo.toString() );
       tituloSrv.guardar(titulo);
        return "redirect:/titulo/";
    }
    
     @GetMapping("/titulo/eliminar")
    public String Responsableeliminar(Titulo titulo){
         loga.log("/titulo/eliminar",titulo.toString() );
        tituloSrv.eliminar(titulo);
        return "redirect:/titulo/";
    }

    
    @Autowired
    private LogAccionService loga;
    @GetMapping("/titulo/editar/{idtitulo}")
    public String tituloeditar(Titulo titulo, Model model
            //,@AuthenticationPrincipal User user
    ){
        Titulo tit = tituloSrv.encontrar(titulo);
        
        List<ModalidadTitulacion> modalidadtitulacion = ModalidadTitulacioSrv.listar();
        model.addAttribute("modalidadtitulacion", modalidadtitulacion);
        
        List<FundamentoLegalServicioSocial> fundamentolegalserviciosocial = FundamentoLegalSS.listar();
        model.addAttribute("fundamentolegalserviciosocial", fundamentolegalserviciosocial);
        
        List<entidadFederativa> entidadfederativa = efsrv.listarEF();
        model.addAttribute("entidadfederativa", entidadfederativa);
        
        List<institucioncarrera> ics = (List<institucioncarrera>) icDAO.findAll();
        model.addAttribute("institucioncarreras", ics);
        
        
        model.addAttribute("titulo", tit );
        return "titulo/tituloedit";
    }
        @Autowired
        ReaderXLS excelsrv;
        
        @PostMapping("/upload/csv") 
        public String  tittuloImportaCsvLoad(@RequestParam("file") MultipartFile file,RedirectAttributes redirectAttributes ){
         log.info("---------------------------------------------------file" + file.getOriginalFilename() );
         
          if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
           // return "redirect:uploadS  tatus";
        }
          
        try {
          
            byte[] bytes = file.getBytes();
            
            String nombreArchivo = file.getOriginalFilename();
            Path path = Paths.get(csv).resolve(nombreArchivo).toAbsolutePath();
            
            Files.deleteIfExists(path);
            //Files.write(path, bytes);
            Files.copy(file.getInputStream(), path);
            
            excelsrv.ReadCSV(path);
        } catch (IOException ex) {
            Logger.getLogger(inicioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(inicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
         
          return "titulo/tituloimporta";    
        }

    @GetMapping("/titulo/importacsv")
    public String tituloImpotaCSV(
            //Titulo titulo, 
            Model model
            //,@AuthenticationPrincipal User user
    ){
        //Titulo tit = tituloSrv.encontrar(titulo);
        
       // List<ModalidadTitulacion> modalidadtitulacion = ModalidadTitulacioSrv.listar();
        //ModalidadTitulacion modalidadTitulo = ModalidadTitulacioSrv.encontrarId(tit.getModalidadtitulacion().getId_modalidad_titulacion());
        
       // List<FundamentoLegalServicioSocial> fundamentolegalserviciosocial = FundamentoLegalSS.listar();
        
       //FundamentoLegalServicioSocial fundamentolegalserviciosocial = FundamentoLegalSS.encontrarId( tit.getFundamentoLegalServicioSocial().getId_fundamento_legal_servicio_social() );
        
        // List<entidadFederativa> entidadfederativa = efsrv.listarEF();
        
       // entidadFederativa entidadfederativa = efsrv.encontrarId(tit.getEntidadFederativa().getIdentidadfederativa());
        
        //entidadFederativa entidadfederativapro = efsrv.encontrarId(tit.getEntidadFederativa_procedencia().getIdentidadfederativa());
        
        
        // List<institucioncarrera> ics = (List<institucioncarrera>) icDAO.findAll();
        
        //Optional<institucioncarrera> ics =  icDAO.findById(tit.getInstitucioncarrera().getIdinstitucioncarrera());
        
        return "titulo/tituloimporta";
    }
    
    
     @GetMapping("/titulo/agregar")
    public String tituloagregar(Titulo titulo, Model model){
        
        Titulo tit = new Titulo();
        model.addAttribute("titulo", tit);
           
        List<Titulo> titulos = tituloSrv.listar();
        model.addAttribute("titulos", titulos);
        
        List<ModalidadTitulacion> modalidadtitulacion = ModalidadTitulacioSrv.listar();
        model.addAttribute("modalidadtitulacion", modalidadtitulacion);
        
        List<FundamentoLegalServicioSocial> fundamentolegalserviciosocial = FundamentoLegalSS.listar();
        model.addAttribute("fundamentolegalserviciosocial", fundamentolegalserviciosocial);
        
        List<entidadFederativa> entidadfederativa = efsrv.listarEF();
        model.addAttribute("entidadfederativa", entidadfederativa);
        
        List<institucioncarrera> ics = (List<institucioncarrera>) icDAO.findAll();
        model.addAttribute("institucioncarreras", ics);
        
        return "titulo/tituloedit";
    }
    @Autowired
    Xml xmlsrv;
    
     @Value("${configuracion.archivosxml}")
       private String archivosxml;
    
     @GetMapping("/titulo/xml/{idtitulo}")
    public String tituloGeneraXML(Titulo titulo, Model model){
        Titulo tit = tituloSrv.encontrar(titulo);
        List<Responsable> responsables =  ResponsableSrv.listar();
        
        String folio = tit.getInstitucioncarrera().getCarrera().getCve_carrera().toString()+tit.getCurp();
        String archivo = archivosxml+folio+".xml";
         
        if( Utileria.existeArchivo(archivo) ){
            
           log.info("----aqui no !!!");
            
            return "redirect:/titulo/descarga/"+tit.getIdtitulo().toString();
        }else{
            
             xmlsrv.Genera(tit,responsables,false);
             tit.setNombrexmlenvio(folio+".xml");
              loga.log("/titulo/xml/",tit.getIdtitulo()+tit.getNombrexmlenvio());
             tituloSrv.guardar(tit);
              
             
        }
        
        return "redirect:/titulo/";
    }
    
      @GetMapping("/titulo/xmlBorrar/{idtitulo}")
    public String tituloBorrarXML(Titulo titulo, Model model){
        Titulo tit = tituloSrv.encontrar(titulo);
        
        String folio = tit.getInstitucioncarrera().getCarrera().getCve_carrera().toString()+tit.getCurp();
        String archivo = archivosxml+folio+".xml";
         
        if( Utileria.existeArchivo(archivo) ){
            
          File f = new File(archivo);
          f.delete();
          
            
        }
        loga.log("/titulo/xml/","Borrardo: "+tit.getIdtitulo()+tit.getNombrexmlenvio());
           
        tit.setNombrexmlenvio(null);
              
        tituloSrv.guardar(tit);
        return "redirect:/titulo/";
    }
    
     @Autowired
     private UsuarioService userDAO;
    
     @Autowired
     private FirmasTitulloService firmaTitulo;
     
     
    @Autowired
    public RolesServiceImp rolesDAO;
    @GetMapping("/titulo/firmar/{idtitulo}")
    public String tituloFirmar(Titulo titulo, Model model,Principal principal){
        
        Titulo tit = tituloSrv.encontrar(titulo);
        //List<Responsable> responsables =  ResponsableSrv.listar();
        FirmasTitulo nuevaUsrFirma = new FirmasTitulo();
        Usuario usrFirma = userDAO.encontrarID( principal.getName() );
         //log.info( tit.getIdtitulo().toString());
         //log.info ( principal.getName() );
         log.info(usrFirma.getIdusuario().toString());
        
         Roles rolFirmante = rolesDAO.encuentraUsuarioRol(usrFirma.getIdusuario(),"ROLE_SIGN" );
         
        FirmasTitulo firmantEnTitulo  = firmaTitulo.encontrarUsuarioTitulo(tit,usrFirma);
         
         nuevaUsrFirma.setTitulo(tit);
         nuevaUsrFirma.setUsuario(usrFirma);
                 
         if ( rolFirmante != null && firmantEnTitulo == null ) {
             firmaTitulo.guardar(nuevaUsrFirma);
         } 
 
        return "redirect:/titulo/";
    }
       
    @GetMapping("/titulo/descarga1/{idtitulo}")
    @ResponseBody
    public FileSystemResource downloadFile( Titulo titulo, Model model ) {
    
        Titulo tit = tituloSrv.encontrar(titulo);
        
        String folio = tit.getInstitucioncarrera().getCarrera().getCve_carrera().toString()+tit.getCurp();
        String archivo = archivosxml+folio+".xml";
        
        return new FileSystemResource(new File( archivo) );
    }
        
    @GetMapping("/titulo/descarga/{idtitulo}")
    public void downloadFile2( Titulo titulo,HttpServletResponse response ) {
    
        Titulo tit = tituloSrv.encontrar(titulo);
        //  loga.log("/titulo/descarga/",tit.toString() );
        String folio = tit.getInstitucioncarrera().getCarrera().getCve_carrera().toString()+tit.getCurp();
        String archivo = archivosxml+folio+".xml";
        
        response.setContentType("application/xml");
         String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", folio+".xml" );
        
        response.setHeader(headerKey, headerValue);
        
        FileInputStream inputStream;
        try {
            String fileName;
            inputStream = new FileInputStream( archivo );
            try {
                int c;
                while ((c = inputStream.read()) != -1) {
                response.getWriter().write(c);
                }
            } finally {
                if (inputStream != null)
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    response.getWriter().close();
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        
        
    }
    @Autowired
    ConectorWS ws;
    
     @Value("${configuracion.usuariows}")
     private String usr;
     
     @Value("${configuracion.passwordws}")
     private String pwd;
    
   /* @GetMapping("/titulo/wsenviar/{idtitulo}")
    @ResponseBody
    public void  wsEnviar( Titulo titulo, Model model ) {
    
        Titulo tit = tituloSrv.encontrar(titulo);
        
        String folio = tit.getInstitucioncarrera().getCarrera().getCve_carrera().toString()+tit.getCurp();
        String archivo = archivosxml+folio+".xml";
        
        log.info("------------Carga ----------");
        ws.pEnvio("cancela",usr,pwd);
     
    } */
    
     @GetMapping("/titulo/historicoenvio/wsenviar/{idhistoricoenvio}")
    public String enviaws(  HistoricoEnvio historicoenvio ,
                             Model model   ){
         loga.log("/titulo/historicoenvio/wsenviar/",historicoenvio.toString() );
       historicoenvio =  heSrv.encontrar(historicoenvio);
       List<Titulo> titulosMal = ws.ValidaArchivos(historicoenvio);
       
       
       if  ( titulosMal == null || titulosMal.size() == 0  ){
         
            if (  ws.comprimeArchivos(historicoenvio) ) {
                       log.info("Preparando envio, proceso carga en WS");
                       ws.setHistoricoEnvio(historicoenvio);
                       ws.pEnvio("carga",usr,pwd);
            }
       } else {
            
            model.addAttribute("malos", titulosMal);
//            flash.addAttribute("idenvio",historicoenvio.getIdhistoricoenvio() );
            return "titulo/listadoMalos";
       }
         
        
        return "redirect:/titulo/historicoenvio";
        
    }
    
     @GetMapping("/titulo/historicoenvio/wsdescarga/{idhistoricoenvio}")
    public String recibews (  HistoricoEnvio historicoenvio ,
                             Model model   ){
        
        ws.setHistoricoEnvio( heSrv.encontrar(historicoenvio) );
        ws.pEnvio("descarga",usr,pwd);
         loga.log("/titulo/historicoenvio/wsrecibe/",historicoenvio.toString() );
        return "redirect:/titulo/historicoenvio";
        
    }
   
     @GetMapping("/titulo/historicoenvio/wsconsulta/{idhistoricoenvio}")
    public String consultaws (  HistoricoEnvio historicoenvio ,
                                Model model   ){
        ws.setHistoricoEnvio( heSrv.encontrar(historicoenvio) );
        ws.pEnvio("consulta",usr,pwd);
         loga.log("/titulo/historicoenvio/wsconsulta/",historicoenvio.toString() );
        return "redirect:/titulo/historicoenvio";
        
    }
    
    @GetMapping("/titulo/historicoenvio/wscancela/{idhistoricoenvio}")
    public String cancelaws (  Titulo titulo ,
                                Model model   ){
        
        ws.setTitulo( tituloSrv.encontrar(titulo) );
        ws.pEnvio("cancela",usr,pwd);
        loga.log("/titulo/historicoenvio/wscancela/",titulo.toString() );
        return "redirect:/titulo/historicoenvio";
        
    }
    @Autowired
    UseReport imprime;
    
     @GetMapping("/titulo/pdf/{idtitulo}")
    public void ImpimeTitulo (  Titulo titulo ,
                                 HttpServletResponse response ){
        
        // generacion sin jasper server
      /*  imprime.setJasperXML("titulo.jrxml");
        imprime.setDataxmljasperL("DataAdapter.xml");
       imprime.run( tituloSrv.encontrar(titulo) );
      
       */
      // generacion con jasper server
      String archivo = imprime.usaREST(tituloSrv.encontrar(titulo) );
      
        
        
        response.setContentType("application/pdf");
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", archivo );
        
        response.setHeader(headerKey, headerValue);
        loga.log("/titulo/pdf/",titulo.toString() );
        FileInputStream inputStream;
        try {
        
            inputStream = new FileInputStream( archivo );
            try {
                int c;
                while ((c = inputStream.read()) != -1) {
                response.getWriter().write(c);
                }
            } finally {
                if (inputStream != null)
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    response.getWriter().close();
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
   
        
    }
    
       

        
       
        

       
    
      @GetMapping("/log")
    public String vistalog(Model model , @AuthenticationPrincipal User user,
             @RequestParam(name="opcion", required = false, defaultValue = "ninguno") String opcion,      
             @RequestParam(name="texto", required = false) String texto    ,
            @RequestParam(name="fecha", required = false)  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate f,
            @RequestParam(name="fecha2", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate f2
            ){
                
         List<LogAccion> logaccion = null;
        
        if ("usuario".equals(opcion)){
            logaccion = loga.buscarUsuario(texto);
        }
        if ("fecha".equals(opcion)){
       
                 logaccion = loga.buscarFecha(f,f2);
            
        }
        if ("url".equals(opcion)){
            logaccion = loga.buscarUrl(texto);
        }
        if ("ninguno".equals(opcion)){
            logaccion = loga.listar();
        }
        
        model.addAttribute("log", logaccion);
        model.addAttribute("user", user);
       return "log";  
    }
    
    
}
