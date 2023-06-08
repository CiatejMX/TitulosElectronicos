
package mx.ciatej.titulos.ws.puente;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.security.KeyStore;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import lombok.extern.slf4j.Slf4j;
import mx.ciatej.titulos.TitulosApplication;
import mx.ciatej.titulos.controladores.ConfiarSSL;
import mx.ciatej.titulos.domain.DatoRecibo;
import mx.ciatej.titulos.domain.HistoricoEnvio;
import mx.ciatej.titulos.domain.HistoricoRecibo;
import mx.ciatej.titulos.domain.Titulo;
import mx.ciatej.titulos.service.DatoReciboService;
import mx.ciatej.titulos.service.HistoricoEnvioService;
import mx.ciatej.titulos.service.HistoricoReciboService;
import mx.ciatej.titulos.service.TituloService;
import mx.ciatej.titulos.ws.ReaderXLS;
import mx.ciatej.titulos.ws.UnzipUtility;
import mx.sep.mec.web.ws.schemas.AutenticacionType;
import mx.sep.mec.web.ws.schemas.CancelaTituloElectronicoRequest;
import mx.sep.mec.web.ws.schemas.CancelaTituloElectronicoResponse;
import mx.sep.mec.web.ws.schemas.CargaTituloElectronicoRequest;
import mx.sep.mec.web.ws.schemas.CargaTituloElectronicoResponse;
import mx.sep.mec.web.ws.schemas.ConsultaProcesoTituloElectronicoRequest;
import mx.sep.mec.web.ws.schemas.ConsultaProcesoTituloElectronicoResponse;
import mx.sep.mec.web.ws.schemas.DescargaTituloElectronicoRequest;
import mx.sep.mec.web.ws.schemas.DescargaTituloElectronicoResponse;
import mx.sep.mec.web.ws.schemas.TitulosPortType;
import mx.sep.mec.web.ws.schemas.TitulosPortTypeService;
import org.apache.commons.io.FileUtils;
import org.apache.cxf.common.logging.LogUtils;
import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.transport.http.HTTPConduit;
//import org.apache.xmlbeans.impl.util.Base64;
import org.apache.tomcat.util.codec.binary.Base64;  // usado por DGP en su aplicacion
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConectorWS {
    
    private CargaTituloElectronicoResponse carga;
    private ConsultaProcesoTituloElectronicoResponse consulta;
    private DescargaTituloElectronicoResponse descarga;
    private CancelaTituloElectronicoResponse cancela;
    private String ArchivoXMLS;
    private String ArchivoDercarga;
    private HistoricoEnvio historicoEnvio;
    private Titulo titulo;
    
    private AutenticacionType aut;

    public void setHistoricoEnvio(HistoricoEnvio historicoEnvio) {
        this.historicoEnvio = historicoEnvio;
    }

    public HistoricoEnvio getHistoricoEnvio() {
        return historicoEnvio;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
    }
    
    @Autowired
    private HistoricoReciboService hrecibo;
    
    @Autowired
    private DatoReciboService drecibo;
         
    @Autowired
    private UnzipUtility zip;
    
    @Autowired
    private TituloService titsrv;
     
    @Autowired
    private HistoricoEnvioService  heSrv;
    
    @Value("${configuracion.archivosZIPresp}")
    private String archivosZIPresp;
    @Value("${configuracion.archivosxml}")
    private String archivosxml;
    @Value("${configuracion.archivosZIP}")
    private String archivosZIP;
        
    String outXml= null;
    String inXml = null;
        
    public void pEnvio(String accion,String usr,String pw){
        TitulosPortTypeService serv = new TitulosPortTypeService();
        TitulosPortType port = serv.getTitulosPortTypeSoap11();
        
        aut = new AutenticacionType();
        aut.setUsuario(usr);
        aut.setPassword(pw);
        
        
        LogUtils.setLoggerClass(org.apache.cxf.common.logging.Slf4jLogger.class);
        Client client = ClientProxy.getClient(port);
        LoggingInInterceptor loggingIn = new LoggingInInterceptor();
        LoggingOutInterceptor logginOut = new LoggingOutInterceptor();
        loggingIn.setPrettyLogging(true);
        logginOut.setPrettyLogging(true);
        client.getInInterceptors().add(loggingIn);
        client.getOutInterceptors().add(logginOut);
        
	    HTTPConduit http = (HTTPConduit) client.getConduit();	
            
            
	    // Set the TLS client parameters
	    TLSClientParameters parameters = new TLSClientParameters();
        try {
            parameters.setSSLSocketFactory(createSSLContext().getSocketFactory());
        } catch (Exception ex) {
            Logger.getLogger(ConectorWS.class.getName()).log(Level.SEVERE, null, ex);
        }
	    http.setTlsClientParameters(parameters);
            log.info(  port.toString() );
            
            if( "carga".equals(accion) ){
                
                List<Titulo> titulos =  historicoEnvio.getTitulos();
                this.titulo = titulos.get(0);
                
             CargaTituloElectronicoRequest cargaRequests = new CargaTituloElectronicoRequest();
             cargaRequests.setNombreArchivo(this.titulo.getNombrexmlenvio());
             //cargaRequests.setArchivoBase64( Base64.encode(ArchivoCarga(ArchivoXMLS)));
            try {             
                FileUtils.writeByteArrayToFile( new File(archivosxml+titulo.getNombrexmlenvio()+".enc"), Base64.encodeBase64(ArchivoCarga( archivosxml+titulo.getNombrexmlenvio())));
            } catch (IOException ex) {
                Logger.getLogger(ConectorWS.class.getName()).log(Level.SEVERE, null, ex);
            }
             //cargaRequests.setArchivoBase64( Base64.encodeBase64(ArchivoCarga( archivosxml+titulo.getNombrexmlenvio())));
             cargaRequests.setArchivoBase64( ArchivoCarga( archivosxml+titulo.getNombrexmlenvio()) );
             cargaRequests.setAutenticacion(aut);
        
                carga =  port.cargaTituloElectronico(cargaRequests);
                 historicoEnvio.setLote( new BigInteger( carga.getNumeroLote().toString() ).longValue() );
                 historicoEnvio.setMensaje( carga.getMensaje() );
                 historicoEnvio.setIdestaustitulo(1L);
                 heSrv.guardar(historicoEnvio);
                 
                 
            }
            
             if( "consulta".equals(accion) ){
                ConsultaProcesoTituloElectronicoRequest consultaRequests = new ConsultaProcesoTituloElectronicoRequest();
                consultaRequests.setNumeroLote( new BigInteger( historicoEnvio.getLote().toString() )  ) ;
                consultaRequests.setAutenticacion(aut);
                                
                consulta =  port.consultaProcesoTituloElectronico(consultaRequests);
                
                log.info (consulta.getMensaje() );
                historicoEnvio.setMensaje(consulta.getMensaje());
                historicoEnvio.setIdestaustitulo(2L);
                heSrv.guardar(historicoEnvio);
                
                 
            }
            
              if( "descarga".equals(accion) ){
                 DescargaTituloElectronicoRequest Requests = new DescargaTituloElectronicoRequest();
                 Requests.setNumeroLote( new BigInteger( historicoEnvio.getLote().toString() ) ) ;
                 Requests.setAutenticacion(aut);
        
                 descarga =  port.descargaTituloElectronico(Requests); //llamado a descargaws
                 byte[] archivo;
                 archivo = descarga.getTitulosBase64();
                 ArchivoDescarga( archivo );
                
                 
                 log.info( descarga.getMensaje() );
                 
                 historicoEnvio.setMensaje(descarga.getMensaje());
                 historicoEnvio.setIdestaustitulo(3L);
                 heSrv.guardar(historicoEnvio);
                 
                
            
            }
                if( "cancela".equals(accion) ){
                    CancelaTituloElectronicoRequest Requests = new CancelaTituloElectronicoRequest();
                    Requests.setFolioControl( titulo.getTituloxml() ) ;
                    Requests.setAutenticacion(aut);
                
                    cancela =  port.cancelaTituloElectronico(Requests);
                    
                    log.info ( cancela.getMensaje() );
                    titulo.setTituloxml(null);
                    titsrv.guardar(titulo);
            
            }
            
           
        
    }
    
    public static String encoder(String filePath) {
        String base64File = "";
        File file = new File(filePath);
        try (FileInputStream imageInFile = new FileInputStream(file)) {
            // Reading a file from file system
            byte fileData[] = new byte[(int) file.length()];
            imageInFile.read(fileData);
            //base64File = Base64.getEncoder().encodeToString(fileData);
        } catch (FileNotFoundException e) {
            log.warn("File not found" + e);
        } catch (IOException ioe) {
            log.warn("Exception while reading the file " + ioe);
        }
        return base64File;
    }
    //mover a utileria
    private byte[] ArchivoCarga(String fileName){
        log.info("archivo a cargar a Bytes:" +fileName);
        byte[] retornar = null;
        try {
            
            
            RandomAccessFile f = new RandomAccessFile(fileName, "r");
            try {
                retornar = new byte[(int)f.length()];
                f.readFully(retornar);
            } catch (IOException ex) {
                log.info(ex.getMessage());
            }
            
        } catch (FileNotFoundException ex) {
            log.info(ex.getMessage());
        }
               return retornar;
       // return Base64.encode(retornar);
        
    }
  
    
    private void ArchivoDescarga(byte[]  fileName){
        
       //fileName = Base64.decode(fileName);
        String fecha = new SimpleDateFormat("ddMMyyHHss").format( new Date() );
       ArchivoDercarga = archivosZIPresp + historicoEnvio.getIdhistoricoenvio()+fecha+  ".zip";
       List<String> listadoEnZIP ; 
       File file = new File(ArchivoDercarga);
       
       try {
 
            OutputStream os = new FileOutputStream(file);
            os.write(fileName);
            log.info("Write bytes to file.");
            os.close();
            
        } catch (Exception e) {
          log.info(e.getMessage());
        }
       
       UnzipUtility zip = new UnzipUtility();
       ReaderXLS xls = new ReaderXLS();
       
       zip.unzipFile(ArchivoDercarga,archivosZIPresp+historicoEnvio.getIdhistoricoenvio()+"-"+fecha+"/");
       
       listadoEnZIP = zip.FileList(ArchivoDercarga);
       
       Iterator<String> xlsS =  listadoEnZIP.iterator();
       String archivoDescomprimido;
       
       while( xlsS.hasNext() ){
           
           archivoDescomprimido = archivosZIPresp+historicoEnvio.getIdhistoricoenvio()+"-"+fecha +"/"+ xlsS.next();
           log.info(archivoDescomprimido);
           
           File filexls = new File(archivoDescomprimido);
           
           Map<Integer,List<String>> datos;
           datos = xls.reader(filexls);
           
           guardaDatos(datos,archivoDescomprimido);
       }
       
        file.delete();
       
        
    }
        public void guardaDatos(Map<Integer,List<String>> datos,String archivo){
           HistoricoRecibo hr = new HistoricoRecibo();
           hr.setHistoricoEnvio(historicoEnvio);
           hr.setArchivo(archivo);
           hrecibo.guardar(hr);
          // log.info(hr.toString());
           
            List<String> lineaxls;
            
           for(Map.Entry m:datos.entrySet()){  
               lineaxls = (List<String>)m.getValue();
               if (lineaxls.get(1).compareTo("ESTATUS") < 0)
               {    DatoRecibo dr = new DatoRecibo();
                    dr.setArchivo(lineaxls.get(0) );//archivo
                    dr.setEstatus(lineaxls.get(1) );//Estatus
                    dr.setFolio(lineaxls.get(3) );//FOLIO titulo
                    dr.setMensaje(lineaxls.get(2));//mensaje
                    dr.setIdhistoricorecibo( hr.getIdhistoricorecibo() );
                    log.info(dr.toString());
                    drecibo.guardar(dr);
                    
               }
               
           }  
       
       }
    private SSLContext createSSLContext() throws Exception {
		
		// Create and load the truststore
	    KeyStore trustStore = KeyStore.getInstance("JKS");
	    trustStore.load(TitulosApplication.class.getClassLoader().getResourceAsStream("jks/client-truststorepem.jks"), "ciatej77".toCharArray());

	    // Create and initialize the truststore manager
	    TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
	    tmf.init(trustStore);

	    // Create and initialize the SSL context
	    SSLContext sslContext = SSLContext.getInstance("SSL");
	   // sslContext.init(null, tmf.getTrustManagers(), new SecureRandom());
           sslContext.init(null, new TrustManager[] { new ConfiarSSL() }, null);
	    return sslContext;
	}
    
    public  List<Titulo>   ValidaArchivos(HistoricoEnvio historicoenvio ){
        
        List<Titulo> titulos  =  historicoenvio.getTitulos();
        List<Titulo> titulosMal = new ArrayList();
        
        
        
         Iterator<Titulo> tits = titulos.iterator();
         Titulo rowTitulo = null;
         
         while(tits.hasNext()){
                rowTitulo = tits.next();
                if ( rowTitulo.getNombrexmlenvio() == null )
                        titulosMal.add(rowTitulo);
         }
         
         
        
        return titulosMal ;
    
    };
    
   
    
     public  Boolean  comprimeArchivos(HistoricoEnvio historicoenvio ){
         
         historicoenvio = heSrv.encontrar(historicoenvio);
        
         String fecha = new SimpleDateFormat("ddMMyy").format(new Date());
         String nombreZIP = archivosZIP + historicoenvio.getIdhistoricoenvio().toString() +"-"+fecha+".zip";
        
         log.info(nombreZIP);
        
        List<Titulo> titulos  =  historicoenvio.getTitulos();
        List<String> titulosArchivos = new ArrayList(); 
                
         Iterator<Titulo> tits = titulos.iterator();
         Titulo rowTitulo = null;
         String arch = null;
         while(tits.hasNext()){
             
                rowTitulo = tits.next();
                if (rowTitulo != null){
                        arch = archivosxml+rowTitulo.getNombrexmlenvio();
                        titulosArchivos.add(arch);
                }
                
                    
         }
         
         if ( titulosArchivos != null) {
         
                 zip.zipFiles(titulosArchivos, nombreZIP);
                 ArchivoXMLS = nombreZIP;
                 historicoenvio.setArchivo(nombreZIP);
                 heSrv.guardar(historicoenvio);
                 
         }else{
             return false;
         }

         return true;
    
    };
    
}
