package br.com.renowe.pagseguro;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import br.com.renowe.objetos.*;

public class Propriedades {
	
	public Configuracao getPropriedades(String caminho){
		
		try{
		  String osName= System.getProperty("os.name");
		  
		  osName = osName.toLowerCase();
		  
		  if(osName.contains("linux")){
			  caminho = caminho + "/META-INF/config";
		  }else{
			  caminho = caminho + "\\META-INF\\config";
		  }
		}catch (Exception e){
		  System.out.println("Exception caught ="+e.getMessage());
		}

		System.out.println(caminho);
		
		Configuracao config = null;
		try {
			File file = new File(caminho);      
			Properties props = new Properties();  
			FileInputStream fis = null;  
			fis = new FileInputStream(file);  
			//lê os dados que estão no arquivo  
			props.load(fis);    
			fis.close();

			config  = new Configuracao();
			
		    fis = new FileInputStream(file);  
		    //lê os dados que estão no arquivo  
		    props.load(fis); 
		    
		    config.setRedirectURL(props.getProperty("RedirectURL"));
		    config.setEmail(props.getProperty("email"));
		    config.setToken(props.getProperty("token"));   
		    
		    fis.close();  
		}catch (IOException ex) {  
		    System.out.println(ex.getMessage());  
		    ex.printStackTrace();  
		}
		return config;
	}
}
