
package mx.ciatej.titulos.reporteador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.query.JRXPathQueryExecuterFactory;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRSaver;
import net.sf.jasperreports.engine.util.JRXmlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;

@Slf4j
@Component
class SimpleReportFiller {
    
        @Value("${configuracion.jasper}")
        private String jasperDir;
   
    
    private String reportFileName;
    private String dataxmlFileName;

    public void setDataxmlFileName(String dataxmlFileName) {
        this.dataxmlFileName = dataxmlFileName;
    }

    private JasperReport jasperReport;

    private JasperPrint jasperPrint;

    @Autowired
    private DataSource dataSource;

    private Map<String, Object> parameters;

    public SimpleReportFiller() {
        parameters = new HashMap<>();
    }

    public void prepareReport() {
        compileReport();
        fillReport();
    }

    public void compileReport() {
        try {
            
            File fil = new File(jasperDir.concat(reportFileName));
            File dataxml = new File(jasperDir.concat(dataxmlFileName));
            
              if (fil.isFile())  {
                  
                  if (dataxml.isFile()){
                     //InputStream dataxmlStream = new FileInputStream(dataxml);
                     Document document = JRXmlUtils.parse(dataxml);
                     parameters.put(JRXPathQueryExecuterFactory.PARAMETER_XML_DATA_DOCUMENT, document);
                     //parameters.put(JRXPathQueryExecuterFactory.XML_DATE_PATTERN, "yyyy-MM-dd");
                    // parameters.put(JRXPathQueryExecuterFactory.XML_NUMBER_PATTERN, "#,##0.##");
                     //parameters.put(JRXPathQueryExecuterFactory.XML_LOCALE, Locale.ENGLISH);
                     //parameters.put(JRParameter.REPORT_LOCALE, Locale.US);

                  }
             
         
                InputStream reportStream = new FileInputStream(fil);
                  
                jasperReport = JasperCompileManager.compileReport(reportStream);
                JRSaver.saveObject(jasperReport,jasperDir+reportFileName.replace(".jrxml", ".jasper"));
           }
           
        } catch (FileNotFoundException | JRException ex) {
            //Logger.getLogger(SimpleReportFiller.class.getName()).log(Level.SEVERE, null, ex);
             log.info(ex.getMessage());
        }
    }
    
    public void fillReport() {
        
        try {
            jasperPrint = JasperFillManager.fillReport(jasperDir+reportFileName.replace(".jrxml", ".jasper"), parameters);
                    //fillReport(jasperReport, parameters, dataSource.getConnection());
        } catch (JRException  ex) {
            log.info(ex.getMessage());
        }
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    public String getReportFileName() {
        return reportFileName;
    }

    public void setReportFileName(String reportFileName) {
        this.reportFileName = reportFileName;
    }

    public JasperPrint getJasperPrint() {
        return jasperPrint;
    }
    
}
