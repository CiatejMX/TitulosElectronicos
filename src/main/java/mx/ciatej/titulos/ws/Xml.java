
package mx.ciatej.titulos.ws;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import lombok.extern.slf4j.Slf4j;
import mx.ciatej.titulos.controladores.CatalogosController;
import mx.ciatej.titulos.domain.Responsable;
import mx.ciatej.titulos.domain.Titulo;
import mx.ciatej.titulos.service.LogAccionService;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.commons.ssl.PKCS8Key;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("GeneraXML")
@Slf4j
public class Xml {
       
        
        @Value("${configuracion.archivoscert}")
         private String archivoscert;
        
        @Value("${configuracion.archivosxml}")
        private String archivosxml;
        
        @Autowired
        Encriptar enc;
        
         @Autowired
    private LogAccionService loga;
         private String contenidocert = null ;
         private String contenidokey = null ;
         
        
        
    public void Genera(Titulo tituloCap, List<Responsable> responsables, boolean flagRehacer){
        
        
       
        String folio = tituloCap.getInstitucioncarrera().getCarrera().getCve_carrera().toString()+tituloCap.getCurp();
        String archivo = archivosxml+folio+".xml";
       
                log.info(folio);
                        
                TituloElectronico titulo = new TituloElectronico();
		TituloElectronico.Antecedente antecedente = new TituloElectronico.Antecedente();
		TituloElectronico.Autenticacion au = new TituloElectronico.Autenticacion();
		TituloElectronico.Carrera car = new TituloElectronico.Carrera();
		TituloElectronico.Expedicion expedicion = new TituloElectronico.Expedicion();
		TituloElectronico.FirmaResponsables firmaResponsables = new TituloElectronico.FirmaResponsables();
		TituloElectronico.Institucion inst = new TituloElectronico.Institucion();
		TituloElectronico.Profesionista prof = new TituloElectronico.Profesionista();
		
                titulo.setFolioControl(folio);
                titulo.setVersion("1.0");
                        
                for( Responsable resp: responsables){
                    
                    TituloElectronico.FirmaResponsables.FirmaResponsable row = new TituloElectronico.FirmaResponsables.FirmaResponsable();
                    row.setCurp(resp.getCurp());
                    row.setNombre( Utileria.noAcento( resp.getNombre() ) );
                    row.setPrimerApellido( Utileria.noAcento( resp.getPrimerapellido() ) );
                    row.setSegundoApellido( Utileria.noAcento( resp.getSegundoapellido() ) );
                    row.setIdCargo(BigInteger.valueOf( resp.getCargo().getId_cargo() ) );
                    row.setCargo(resp.getCargo().getCargo_firmante());
                    row.setAbrTitulo(resp.getAbrtitulo());
                    //**** activar archivos antes de usarlos
                    // enc.activaArchivo(archivoscert+"/"+resp.getCertificadoresponsable());
                    // enc.activaArchivo(archivoscert+"/"+resp.getLlaveesponsable());
                    contenidocert = Utileria.openFile(archivoscert+"/"+resp.getCertificadoresponsable()) ;
                    contenidokey = Utileria.openFile( archivoscert+"/"+resp.getLlaveesponsable());
                       
                    try {
                        row.setCertificadoResponsable( Base64.encodeBase64String( toByteArray( archivoscert+"/"+resp.getCertificadoresponsable() ) ) );
                    } catch (Exception ex) {
                        log.info(ex.getMessage());
                        
                    }
           
                    String sello = null;        
                    try {
                    
                        sello = sign(archivoscert+"/"+resp.getLlaveesponsable(), resp.getPwdkey(), cadenaOriginal( tituloCap , resp , folio));
                        loga.log("sellodetitilo"+tituloCap.getIdtitulo().toString(), sello); //.info(sello);
                        loga.log("cadenaOriginaltitulo"+tituloCap.getIdtitulo().toString(), cadenaOriginal( tituloCap , resp , folio) );
                    } catch (Exception ex) {
                       log.info( ex.getMessage()  );
                    }
                    log.info("----------key : "+contenidokey+" | path : "+archivoscert+"/"+resp.getCertificadoresponsable());
                    log.info("---------cert : "+contenidocert+"| path : "+archivoscert+"/"+resp.getLlaveesponsable());
                    row.setNoCertificadoResponsable(resp.getNumerocertificado());
                    row.setSello(sello);
                    firmaResponsables.setFirmaResponsable(row);
                    // **** activarlo 
                   // enc.desactivaArchivo(archivoscert+"/"+resp.getCertificadoresponsable());
                  // enc.desactivaArchivo(archivoscert+"/"+resp.getLlaveesponsable());
                    
                }
                titulo.setFirmaResponsables(firmaResponsables);
                
		inst.setCveInstitucion(tituloCap.getInstitucioncarrera().getInstitucion().getInstitucion_id().toString());
		inst.setNombreInstitucion( tituloCap.getInstitucioncarrera().getInstitucion().getNombre_institucion() );
		titulo.setInstitucion(inst);
                
		prof.setCurp(tituloCap.getCurp());
		prof.setNombre( Utileria.noAcento( tituloCap.getNombre() )  );
		prof.setPrimerApellido( Utileria.noAcento( tituloCap.getPrimerapellido() ) );
		prof.setSegundoApellido( Utileria.noAcento( tituloCap.getSegundoapellido()) );
                prof.setCorreoElectronico( tituloCap.getCorreoelectronico() );
                
                //prof.setNombre( tituloCap.getNombre()   );
		//prof.setPrimerApellido( tituloCap.getPrimerapellido()  );
		//prof.setSegundoApellido( tituloCap.getSegundoapellido() );
                //prof.setCorreoElectronico( tituloCap.getCorreoelectronico() );
		titulo.setProfesionista(prof);
		
                car.setIdAutorizacionReconocimiento( new BigInteger( tituloCap.getAutorizacionReconocimiento().getId_autorizacion_reconocimiento().toString() )  );
		car.setAutorizacionReconocimiento(tituloCap.getAutorizacionReconocimiento().getAutorizacion_reconocimiento());
		car.setCveCarrera(tituloCap.getInstitucioncarrera().getCarrera().getCve_carrera().toString());
		car.setNombreCarrera(tituloCap.getInstitucioncarrera().getCarrera().getNombre_carrera());
		car.setFechaInicio( Utileria.toXMLDate(  tituloCap.getFechainicio() ) );
                car.setFechaTerminacion(Utileria.toXMLDate(tituloCap.getFechaterminacion()));
		//car.setNumeroRvoe( null );
		titulo.setCarrera(car);
		 
		expedicion.setCumplioServicioSocial(new BigInteger( tituloCap.getCumplioserviciosocial() ));
		expedicion.setIdEntidadFederativa( StringUtils.leftPad( tituloCap.getEntidadFederativa().getIdentidadfederativa().toString(),2,"0" ) );
                expedicion.setEntidadFederativa( tituloCap.getEntidadFederativa().getC_nom_ent());
		expedicion.setFechaExamenProfesional(Utileria.toXMLDate( tituloCap.getFechaexamenprofesional() ));
		expedicion.setFechaExpedicion(Utileria.toXMLDate(tituloCap.getFechaexpedicion() ));
		expedicion.setFundamentoLegalServicioSocial(tituloCap.getFundamentoLegalServicioSocial().getFundamento_legal_servicio_social() );
                expedicion.setIdFundamentoLegalServicioSocial(new BigInteger( tituloCap.getFundamentoLegalServicioSocial().getId_fundamento_legal_servicio_social().toString() ) );
		expedicion.setIdModalidadTitulacion(new BigInteger( tituloCap.getModalidadtitulacion().getId_modalidad_titulacion().toString() ));
		expedicion.setModalidadTitulacion( tituloCap.getModalidadtitulacion().getModalidad_titulacion() );
		titulo.setExpedicion(expedicion);
		
		antecedente.setEntidadFederativa( tituloCap.getEntidadFederativa_procedencia().getC_nom_ent() );
		antecedente.setIdEntidadFederativa(  StringUtils.leftPad( tituloCap.getEntidadFederativa_procedencia().getIdentidadfederativa().toString(),2,"0") );
		antecedente.setFechaInicio( Utileria.toXMLDate( tituloCap.getFechainicio_procedencia()) );
		antecedente.setFechaTerminacion( Utileria.toXMLDate( tituloCap.getFechaterminacion_procedencia() ) );
		antecedente.setInstitucionProcedencia(   tituloCap.getInstitucionprocedencia().toUpperCase()  );
                antecedente.setIdTipoEstudioAntecedente(new BigInteger( tituloCap.getTipostudioAntecedente().getId_tipo_estudio_antecedente().toString() ));
		antecedente.setTipoEstudioAntecedente( tituloCap.getTipostudioAntecedente().getTipo_estudio_antecedente() );
		antecedente.setNoCedula(tituloCap.getNocedula());
		titulo.setAntecedente(antecedente);
		
                JAXBContext jContext;
		try {
		
			jContext = JAXBContext.newInstance(TituloElectronico.class);
			    
			Marshaller marshallObj = jContext.createMarshaller();

			marshallObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                        log.info("-------Archivo"+archivo);
                        
                        FileOutputStream fosArchivo = new FileOutputStream( archivo );
                        
			marshallObj.marshal(titulo, fosArchivo);
                         fosArchivo.close();
                         
                        OutputStream out = null;
			marshallObj.marshal(titulo, out );
                        
                        
                        ByteArrayOutputStream xmlbt = (ByteArrayOutputStream)out;
                        String xmlstr = new String( xmlbt.toByteArray() );
                       
                        out.close();
                        loga.log("xml"+tituloCap.getIdtitulo().toString(),xmlstr);
                        xmlbt.close();
                        
                      

		
		} catch(Exception e) {

		    log.info( e.getMessage()  );

    		}
    }
    
    public String cadenaOriginal(Titulo tituloCap, Responsable responsable, String folio){
        String separador = "|";
        String cadenaOriginal = "||"; // inicio cadena
                
        cadenaOriginal = cadenaOriginal+ "1.0" + separador;
        cadenaOriginal = cadenaOriginal+ folio + separador;
        log.info(cadenaOriginal);
        //firma resposnable
        cadenaOriginal = cadenaOriginal+ responsable.getCurp() + separador;
        cadenaOriginal = cadenaOriginal+ responsable.getCargo().getId_cargo().toString() + separador;
        cadenaOriginal = cadenaOriginal+ responsable.getCargo().getCargo_firmante() + separador;
        cadenaOriginal = cadenaOriginal+ responsable.getAbrtitulo() + separador;
        log.info(cadenaOriginal);
        //institucion
        cadenaOriginal = cadenaOriginal+ tituloCap.getInstitucioncarrera().getInstitucion().getInstitucion_id().toString()+ separador;
        cadenaOriginal = cadenaOriginal+ tituloCap.getInstitucioncarrera().getInstitucion().getNombre_institucion()+ separador;
        log.info(cadenaOriginal);
        //carrera
        cadenaOriginal = cadenaOriginal+ tituloCap.getInstitucioncarrera().getCarrera().getCve_carrera().toString()+ separador;
        cadenaOriginal = cadenaOriginal+ tituloCap.getInstitucioncarrera().getCarrera().getNombre_carrera()+ separador;
        cadenaOriginal = cadenaOriginal+ Utileria.date2String(tituloCap.getFechainicio() )+ separador;
        cadenaOriginal = cadenaOriginal+ Utileria.date2String(tituloCap.getFechaterminacion() ) + separador;
        cadenaOriginal = cadenaOriginal+ tituloCap.getAutorizacionReconocimiento().getId_autorizacion_reconocimiento().toString() + separador;
        cadenaOriginal = cadenaOriginal+ tituloCap.getAutorizacionReconocimiento().getAutorizacion_reconocimiento() + separador+ separador;  //doble sep no rvoe
        log.info(cadenaOriginal);
       
        //profesionista
        cadenaOriginal = cadenaOriginal+ tituloCap.getCurp() + separador;
        cadenaOriginal = cadenaOriginal+ Utileria.noAcento( tituloCap.getNombre()) + separador;
        cadenaOriginal = cadenaOriginal+ Utileria.noAcento( tituloCap.getPrimerapellido())+ separador;
        cadenaOriginal = cadenaOriginal+ Utileria.noAcento( tituloCap.getSegundoapellido())+ separador;
        
        //cadenaOriginal = cadenaOriginal+ tituloCap.getNombre() + separador;
        //cadenaOriginal = cadenaOriginal+ tituloCap.getPrimerapellido()+ separador;
        //cadenaOriginal = cadenaOriginal+  tituloCap.getSegundoapellido()+ separador;
        
        cadenaOriginal = cadenaOriginal+ tituloCap.getCorreoelectronico()+ separador;
        log.info(cadenaOriginal);
        //expedicion
        cadenaOriginal = cadenaOriginal+ Utileria.date2String(tituloCap.getFechaexpedicion() ) + separador;
        cadenaOriginal = cadenaOriginal+ tituloCap.getModalidadtitulacion().getId_modalidad_titulacion().toString() + separador;
        cadenaOriginal = cadenaOriginal+ tituloCap.getModalidadtitulacion().getModalidad_titulacion() + separador;
        cadenaOriginal = cadenaOriginal+ Utileria.date2String(tituloCap.getFechaexamenprofesional() ) + separador;
        cadenaOriginal = cadenaOriginal+  separador; //Utileria.date2String(tituloCap.getFechaexencionexamenprofecional() ) +
        cadenaOriginal = cadenaOriginal+ tituloCap.getCumplioserviciosocial()  + separador;
        cadenaOriginal = cadenaOriginal+ tituloCap.getFundamentoLegalServicioSocial().getId_fundamento_legal_servicio_social().toString()  + separador;
        cadenaOriginal = cadenaOriginal+ tituloCap.getFundamentoLegalServicioSocial().getFundamento_legal_servicio_social()  + separador;
        cadenaOriginal = cadenaOriginal+ StringUtils.leftPad(tituloCap.getEntidadFederativa().getIdentidadfederativa().toString(),2,"0") + separador;
        cadenaOriginal = cadenaOriginal+ tituloCap.getEntidadFederativa().getC_nom_ent()  + separador;
        log.info(cadenaOriginal);
        //antecedente
        cadenaOriginal = cadenaOriginal+ tituloCap.getInstitucionprocedencia().toUpperCase() + separador;
        cadenaOriginal = cadenaOriginal+ tituloCap.getTipostudioAntecedente().getId_tipo_estudio_antecedente().toString() + separador;
        cadenaOriginal = cadenaOriginal+ tituloCap.getTipostudioAntecedente().getTipo_estudio_antecedente() + separador;
        cadenaOriginal = cadenaOriginal+ StringUtils.leftPad(tituloCap.getEntidadFederativa_procedencia().getIdentidadfederativa().toString(),2,"0")  + separador;
        cadenaOriginal = cadenaOriginal+ tituloCap.getEntidadFederativa_procedencia().getC_nom_ent()  + separador;
        cadenaOriginal = cadenaOriginal+ Utileria.date2String(tituloCap.getFechainicio_procedencia() ) + separador;
        cadenaOriginal = cadenaOriginal+ Utileria.date2String(tituloCap.getFechaterminacion_procedencia() ) + separador;
        cadenaOriginal = cadenaOriginal+ tituloCap.getNocedula();
        log.info(cadenaOriginal);
             
        
        cadenaOriginal = cadenaOriginal + "||"; //fin cadena
        
        return cadenaOriginal;
    }
    private  byte[] toByteArray(String filePath) throws Exception {
		File f = new File(filePath);

		FileInputStream fis = new FileInputStream(f);

		byte[] fbytes = new byte[(int) f.length()];

		fis.read(fbytes);
		fis.close();

		return fbytes;
	}
		
    public  String sign(String keyPath, String password, String toSign) throws Exception {
		final PKCS8Key pkcs8Key;
        pkcs8Key = new PKCS8Key(toByteArray(keyPath), password.toCharArray());

		final PrivateKey privateKey = pkcs8Key.getPrivateKey();

		final Signature signature = Signature.getInstance("SHA256withRSA");
		signature.initSign(privateKey);
		signature.update(toSign.getBytes("UTF-8"));

		return Base64.encodeBase64String(signature.sign());
    }
    
     public static String  certSerial( String path ){
        
     
     BigInteger sn = null;
       String filtrado = null; 
        FileInputStream    inStream = null;
        try {
            inStream = new FileInputStream(path);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CatalogosController.class.getName()).log(Level.SEVERE, null, ex);
        }

        CertificateFactory cf = null;
        try {
            cf = CertificateFactory.getInstance("X.509");
        } catch (CertificateException ex) {
            Logger.getLogger(CatalogosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String serie = ""; 
        try {
            X509Certificate cert = (X509Certificate)cf.generateCertificate(inStream);
            sn = cert.getSerialNumber();
             filtrado =  sn.toString(16) ;
             //serie = filtrado.replace("3", "");
             
             for(int i=0;filtrado.length()> i;i++ ){
                 if( i==0 ){
                     continue;
                 }else{
                     if( i % 2 != 0){
                         serie += filtrado.charAt(i);
                     }
                 }
             }
        } catch (CertificateException ex) {
            Logger.getLogger(CatalogosController.class.getName()).log(Level.SEVERE, null, ex);
        }
              
        return serie;
        
    }
    
   

	
    
}
