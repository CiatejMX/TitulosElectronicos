package mx.ciatej.titulos.ws;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.springframework.stereotype.Service;

import lombok.Data;

 
@Service
@Data
public class UnzipUtility {
	String path = "";
 
	    public void unzipFile(String filePath,String dirDestino){
	         
	    	File dir = new File(dirDestino); 
                
                if(!dir.exists() )
                    dir.mkdirs();
                
	        FileInputStream fis = null;
	        ZipInputStream zipIs = null;
	        ZipEntry zEntry = null;
	        try {
	            fis = new FileInputStream(filePath);
	            zipIs = new ZipInputStream(new BufferedInputStream(fis));
	            while((zEntry = zipIs.getNextEntry()) != null){
	                try{
	                    byte[] tmp = new byte[4*1024];
	                    FileOutputStream fos = null;
	                    String opFilePath = dirDestino+zEntry.getName();
	                    System.out.println("Extracting file to "+opFilePath);
	                    fos = new FileOutputStream(opFilePath);
	                    int size = 0;
	                    while((size = zipIs.read(tmp)) != -1){
	                        fos.write(tmp, 0 , size);
	                    }
	                    fos.flush();
	                    fos.close();
	                } catch(Exception ex){
	                     
	                }
	            }
	            zipIs.close();
	        } catch (FileNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
    

	
 
			public void zipFiles(List<String> files,String zipFile){
			    
			    FileOutputStream fos = null;
			    ZipOutputStream zipOut = null;
			    FileInputStream fis = null;
			    try {
			        fos = new FileOutputStream(path + zipFile);
			        zipOut = new ZipOutputStream(new BufferedOutputStream(fos));
			        for(String filePath:files){
			            File input = new File(filePath);
			            fis = new FileInputStream(input);
			            ZipEntry ze = new ZipEntry(input.getName());
			            System.out.println("Zipping the file: "+input.getName());
			            zipOut.putNextEntry(ze);
			            byte[] tmp = new byte[4*1024];
			            int size = 0;
			            while((size = fis.read(tmp)) != -1){
			                zipOut.write(tmp, 0, size);
			            }
			            zipOut.flush();
			            fis.close();
			        }
			        zipOut.close();
			        System.out.println("Done... Zipped the files...");
			    } catch (FileNotFoundException e) {
			        // TODO Auto-generated catch block
			        e.printStackTrace();
			    } catch (IOException e) {
			        // TODO Auto-generated catch block
			        e.printStackTrace();
			    } finally{
			        try{
			            if(fos != null) fos.close();
			        } catch(Exception ex){
			             
			        }
			    }
			}
			
			public List<String> FileList(String filePath){
		         
                         List<String> listado =new  ArrayList();   
		        FileInputStream fis = null;
		        ZipInputStream zipIs = null;
		        ZipEntry zEntry = null;
		        try {
		            fis = new FileInputStream(filePath);
		            zipIs = new ZipInputStream(new BufferedInputStream(fis));
		            while((zEntry = zipIs.getNextEntry()) != null){
		                System.out.println(zEntry.getName());
                                listado.add( zEntry.getName() );
		            }
		            zipIs.close();
		        } catch (FileNotFoundException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        } catch (IOException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
                        
                        return listado;
		    }
     
	   /* public static void main(String a[]){
	         
	        UnzipUtility mfe = new UnzipUtility();
	        mfe.unzipFile("Archive.zip");
	        
	           UnzipUtility mfe = new UnzipUtility();
	        mfe.FileList("Archive.zip");
	        
	        UnzipUtility mfe = new UnzipUtility();
	        List<String> files = new ArrayList<String>();
	        files.add("C:/test.txt");
	        files.add("C:/test.sh");
	        files.add("C:/port-chn.txt");
	        mfe.zipFiles(files,"tmp.zip");
	    }*/
}