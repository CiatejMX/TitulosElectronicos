package mx.ciatej.titulos.ws;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Utileria {
	
	public static  XMLGregorianCalendar toXMLDate (String fecha) {
		
		XMLGregorianCalendar xmlDate = null;
		GregorianCalendar c = new GregorianCalendar();

		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			c.setTime(f.parse(fecha));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			xmlDate = DatatypeFactory.newInstance()
					.newXMLGregorianCalendar(c);
                        xmlDate.setTime(0,0,0);
         
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return xmlDate;
		
	}
        
        public static  XMLGregorianCalendar toXMLDate (Date fe) {
		
		XMLGregorianCalendar xmlDate = null;
		GregorianCalendar c = new GregorianCalendar();
        	c.setTime( fe);
                
                
		
		try {
			xmlDate = DatatypeFactory.newInstance()
					.newXMLGregorianCalendar(c);
                        xmlDate.setTime(0,0,0,0);
                        xmlDate.setTimezone(DatatypeConstants.FIELD_UNDEFINED );
                        
                        
                        
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return xmlDate;
	}
        
        public static String date2String(Date fecha){
            if (fecha == null )
                fecha = new Date();
           SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
           return formato.format(fecha);
        }
        
        public static String openFile(String path){
            
            BufferedReader br = null;
            String response = new String();
          
                File file = new File(path);
            try {
                br = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Utileria.class.getName()).log(Level.SEVERE, null, ex);
            }
               
                
            try {
                for (String line; (line = br.readLine()) != null; response += line);
            } catch (IOException ex) {
                Logger.getLogger(Utileria.class.getName()).log(Level.SEVERE, null, ex);
            }
         
             
        
            return response;
        }
        private static final String ORIGINAL
                = "ÁáÉéÍíÓóÚúÜü";
        private static final String REPLACEMENT
                = "AaEeIiOoUuUu";

        public static String noAcento(String str) {
            if (str == null) {
                return null;
            }
            char[] array = str.toCharArray();
            for (int index = 0; index < array.length; index++) {
                int pos = ORIGINAL.indexOf(array[index]);
                if (pos > -1) {
                    array[index] = REPLACEMENT.charAt(pos);
                }
            }
            return new String(array).toUpperCase();
        }
        
           public static boolean existeArchivo(String file) 
            { 


                File f = new File(file); 


                if ( f.exists() ) 
                    return true;
                else
                    return false;
            } 

           public static String encripta(String str){
               
               BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
               
               Pattern patron = Pattern.compile("\\A\\$2a?\\$\\d\\d\\$[./0-9A-Za-z]{53}");

            if (!patron.matcher(str).matches()) {
                str = encoder.encode(str);
            }
               
               return str;
           }
        

}
