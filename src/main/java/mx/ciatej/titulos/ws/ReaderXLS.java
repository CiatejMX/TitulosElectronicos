package mx.ciatej.titulos.ws;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.springframework.stereotype.Service;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import mx.ciatej.titulos.domain.AutorizacionReconocimiento;
import mx.ciatej.titulos.domain.FundamentoLegalServicioSocial;
import mx.ciatej.titulos.domain.ModalidadTitulacion;
import mx.ciatej.titulos.domain.TipoEstudioAntecedente;
import mx.ciatej.titulos.domain.Titulo;
import mx.ciatej.titulos.domain.carrera;
import mx.ciatej.titulos.domain.entidadFederativa;
import mx.ciatej.titulos.domain.institucioncarrera;
import mx.ciatej.titulos.service.AutorizacionReconocimientoServiceImp;
import mx.ciatej.titulos.service.FundamentoLegalServicioSocialServiceImp;
import mx.ciatej.titulos.service.ModalidadTitulacionServiceImp;
import mx.ciatej.titulos.service.TipoEstudioAntecedenteServiceImp;
import mx.ciatej.titulos.service.TituloServiceImp;
import mx.ciatej.titulos.service.carreraServiceImp;
import mx.ciatej.titulos.service.entidadFederativaServiceImp;
import mx.ciatej.titulos.service.institucioncarrreraServiceImp;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Data
@Slf4j
public class ReaderXLS {
	
	
	

	
	public Map<Integer, List<String>> reader(File excelFile) {
		
		FileInputStream file = null;
		
		try {
			file = new FileInputStream(excelFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Workbook workbook = null ;
		
		try {
			//rkbook = new XSSFWorkbook(file); //xml
			workbook = new HSSFWorkbook(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Sheet sheet ;
		sheet = workbook.getSheetAt(0);
		 
		Map<Integer, List<String>> data = new HashMap<>();
		int i = 0;
		
		for (Row row : sheet) {
		    data.put(i, new ArrayList<String>());
		    for (Cell cell : row) {
		    	
		        switch (cell.getCellTypeEnum()) {
		            case STRING:
		            	data.get(new Integer(i)).add(cell.getRichStringCellValue().getString());
		            	log.info(data.get(new Integer(i)).toString() );
		            	break;
		            case NUMERIC:
		            	if (DateUtil.isCellDateFormatted(cell)) {
		            	    data.get(i).add(cell.getDateCellValue() + "");
		            	} else {
		            	    data.get(i).add(cell.getNumericCellValue() + "");
		            	}
		            	break;
		            case BOOLEAN:
		            	data.get(i).add(cell.getBooleanCellValue() + "");
		            	break;
		            case FORMULA:
		            	data.get(i).add(cell.getCellFormula() + "");
		            	break;
		            default: data.get(new Integer(i)).add(" ");
		        }
		    }
		    i++;
		}
		
		

		return data;
		
	}
	
	@Autowired
        AutorizacionReconocimientoServiceImp reconocimientoDAO;
        
        @Autowired
        institucioncarrreraServiceImp carreraDAO;
        
        @Autowired
        FundamentoLegalServicioSocialServiceImp fundamentossDAO;
        
        @Autowired
        entidadFederativaServiceImp entidadFederativaDAO;
        
        @Autowired
        TipoEstudioAntecedenteServiceImp tipoEstudioDAO;
        
        @Autowired
        ModalidadTitulacionServiceImp modalidadTitulacionDAO;
	
        @Autowired
        TituloServiceImp tituloDao;
	public void ReadCSV(Path fileCSV ) throws FileNotFoundException, IOException, ParseException{
            
            List<TituloCsvDTO> records = new ArrayList<>();
            
            String formatoFecha = "dd/MM/yyyy";
            String errores = "";
            try (BufferedReader br = new BufferedReader(new FileReader(fileCSV.toFile()))) {
                String line;
                 while ((line = br.readLine()) != null) {
                    String COMMA_DELIMITER = ",";
                    String[] values = line.split(COMMA_DELIMITER);
                    errores = "";
                    //records.add(Arrays.asList(values));
                 
                    List<Titulo> titulo = tituloDao.buscaCurp(values[3]);
                    
                    if (titulo.size() > 0) 
                        continue;
                    
                    Titulo tit = new Titulo();
                    
                    tit.setNombre(values[0].trim());
                    tit.setPrimerapellido(values[1].trim());
                    tit.setSegundoapellido(values[2].trim());
                    tit.setCurp(values[3].replaceAll("\\s","").replaceAll("\"",""));
                    tit.setCorreoelectronico(values[4].trim());
                    
                    institucioncarrera carrera= carreraDAO.encontrarIdCarrera(Long.parseLong(values[5]));
                    tit.setInstitucioncarrera(carrera);
                    
                    if ( carrera == null ){
                        errores += "ERR IDCarrera";
                    
                                            }
                     
                    AutorizacionReconocimiento reconocimiento = reconocimientoDAO.encontrarId(Long.parseLong(values[6]));
                    tit.setAutorizacionReconocimiento(reconocimiento);
                    
                    if ( reconocimiento == null ){
                        errores +="ERR IDAutorizacionrec";
                    }
                    Date fechaExamenProfesional = new SimpleDateFormat(formatoFecha).parse(values[9]);
                    tit.setFechaexamenprofesional(fechaExamenProfesional);
                    
                    Date fechaExpedicion = new SimpleDateFormat(formatoFecha).parse(values[10]);
                    tit.setFechaexpedicion(fechaExpedicion);
                    
                    Date fechaInicioCarrera = new SimpleDateFormat(formatoFecha).parse(values[11]);
                    tit.setFechainicio(fechaInicioCarrera);
                    
                    Date fechaTerminacionCarrera = new SimpleDateFormat(formatoFecha).parse(values[12]);
                    tit.setFechaterminacion(fechaTerminacionCarrera);
                    
                   int result =  fechaTerminacionCarrera.compareTo(fechaExamenProfesional);
                   
                   if ( result >= 0  ){
                    errores +="ERR Fechaterminacion>fechaexamenprof";
                    
                   }
                   
                   
                            
                    ModalidadTitulacion modalidadTitulacion = modalidadTitulacionDAO.encontrarId(Long.parseLong(values[13]));
                    tit.setModalidadtitulacion(modalidadTitulacion);
                    
                    if ( modalidadTitulacion == null ){
                        errores +="ERR IDmodalidadTitulacion";
                    
                    }
                    
                    tit.setCumplioserviciosocial(values[15]);
                    
                    FundamentoLegalServicioSocial funcdamentoss = fundamentossDAO.encontrarId(Long.parseLong(values[16]));
                    tit.setFundamentoLegalServicioSocial(funcdamentoss);
                    
                    if ( funcdamentoss == null ){
                        errores +="ERR IDfuncdamentoss";
                    
                    }
                    
                    entidadFederativa entidadfed =   entidadFederativaDAO.encontrarId(Long.parseLong(values[18]));
                    tit.setEntidadFederativa(entidadfed);
                    
                    if ( entidadfed == null ){
                        errores +="ERR IDentidadfed";
                    
                    }
                    
                    tit.setInstitucionprocedencia(values[20].trim());
                    
                    Date fechaInicioProcedencia = new SimpleDateFormat(formatoFecha).parse(values[21]);
                    tit.setFechainicio_procedencia(fechaInicioProcedencia);
                    
                    Date fechaFinProcedencia = new SimpleDateFormat(formatoFecha).parse(values[22]);
                    tit.setFechaterminacion_procedencia(fechaFinProcedencia);
                    
                     TipoEstudioAntecedente tipoEstudio = tipoEstudioDAO.encontrarId(Long.parseLong(values[23]));
                     tit.setTipostudioAntecedente(tipoEstudio);
                     
                     if ( tipoEstudio == null ){
                        errores +="ERR IDtipoEstudioantecedente";
                    
                    }
                     
                    entidadFederativa entidadFedAntecedente =   entidadFederativaDAO.encontrarId(Long.parseLong(values[25]));
                    tit.setEntidadFederativa_procedencia(entidadFedAntecedente);
                    
                     if ( entidadFedAntecedente == null ){
                        errores +="ERR IDentidadFedAntecedente";
                    
                    }
                    
                     if (errores != ""){
                         tit.setCorreoelectronico(errores);
                         tit.setLote(Long.parseLong("0"));
                     }
                    tit.setNocedula(values[27]);
                    
                    tituloDao.guardar(tit);
                    
                    
                    
                }
            }
        
        }
	

}
