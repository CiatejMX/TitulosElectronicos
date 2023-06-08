
package mx.ciatej.titulos.reporteador;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import mx.ciatej.titulos.domain.Titulo;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Slf4j
public class UseReport {
    
   //  AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    //    ctx.register(JasperRerportsSimpleConfig.class);
    //    ctx.refresh();
    
    @Autowired
            SimpleReportFiller simpleReportFiller;
    @Autowired 
            SimpleReportExporter simpleExporter;
    
     @Value("${configuracion.titulosPDF}")
        private String dirPDF;
 
        String jasperXML;
        String dataxmljasperL;

    public void setDataxmljasperL(String dataxmljasperL) {
        this.dataxmljasperL = dataxmljasperL;
    }

    public String getDataxmljasperL() {
        return dataxmljasperL;
    }
       

    public void setJasperXML(String jasperXML) {
        this.jasperXML = jasperXML;
    }

    public String getJasperXML() {
        return jasperXML;
    }
        
        
       // SimpleReportFiller simpleReportFiller = ctx.getBean(SimpleReportFiller.class);
      public  String  run( Titulo titulo){
            String report = dirPDF + titulo.getIdtitulo().toString() + titulo.getCurp()+".PDF";
            
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("id", titulo.getIdtitulo());
            
            simpleReportFiller.setReportFileName(jasperXML);
            simpleReportFiller.setDataxmlFileName(dataxmljasperL);
            simpleReportFiller.compileReport();
            simpleReportFiller.setParameters(parameters);
            simpleReportFiller.fillReport();
            
            simpleExporter.setJasperPrint(simpleReportFiller.getJasperPrint());
            simpleExporter.exportToPdf(report, "crojo");
        
            return report;
        }
        
      @Autowired
        PuenteJRserver puenteJasper;
      public String usaREST(Titulo titulo){
          
          puenteJasper.setUrlLogin("http://localhost:8081/jasperserver/rest_v2/login?j_username=jasperadmin&j_password=jasperadmin");
          puenteJasper.setUrlws("http://localhost:8081/jasperserver/rest_v2/reports/reports/titulo2_2.pdf?Parameter1="+titulo.getIdtitulo());
          
          
          File io = puenteJasper.DescagaPDF();
          log.info(io.toString());
        
          File ArchivoPDF  = new File(  dirPDF + titulo.getIdtitulo().toString() + titulo.getCurp()+".PDF" );
        
        try {
            java.nio.file.Files.copy(io.toPath(), ArchivoPDF.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(UseReport.class.getName()).log(Level.SEVERE, null, ex);
        }
         return ArchivoPDF.toString();
      }
    
}
