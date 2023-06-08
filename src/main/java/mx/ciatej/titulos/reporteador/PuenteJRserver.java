
package mx.ciatej.titulos.reporteador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import lombok.extern.slf4j.Slf4j;

import org.apache.http.client.HttpClient;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.auth.CredentialsProvider;
import org.apache.http.auth.Credentials;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.HttpMethod;


import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@Service
@Slf4j
public class PuenteJRserver {
    
    private String urlLogin ;
    
    private String urlws;

    public void setUrlLogin(String urlLogin) {
        this.urlLogin = urlLogin;
    }

    public void setUrlws(String urlws) {
        this.urlws = urlws;
    }
    
        
    private RestTemplate plantilla;
    
    PuenteJRserver (){
        plantilla = new RestTemplate(getClientHttpRequestFactory());
        
    }
    
    private HttpComponentsClientHttpRequestFactory getClientHttpRequestFactory() 
    {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
                          = new HttpComponentsClientHttpRequestFactory();
         
        clientHttpRequestFactory.setHttpClient(httpClient());
              
        return clientHttpRequestFactory;
    }
    
     private HttpClient httpClient() 
    {
        //UsernamePasswordCredentials cred = new  UsernamePasswordCredentials();
        
        final Credentials credentials = new UsernamePasswordCredentials("jasperadmin", "jasperadmin");
	final BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        
        
        HttpClient client = HttpClientBuilder
                                .create()
                                .setDefaultCredentialsProvider(credentialsProvider)
                                .build();
        return client;
    }
    
  
   
   public File DescagaPDF(){
        plantilla.getForObject(urlLogin, String.class );
       //MultipartFile io = plantilla.getForObject(urlws, MultipartFile.class);
       
       File file = plantilla.execute(urlws, HttpMethod.GET, null, clientHttpResponse -> {
    File ret = File.createTempFile("download", "tmp");
    StreamUtils.copy(clientHttpResponse.getBody(), new FileOutputStream(ret));
    return ret;
});
       return file;
   }
    
    
}
