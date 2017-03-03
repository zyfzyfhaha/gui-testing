package cls.ui.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;



public class FileUtil {

	
	public static String readFile(String resource) {  
	    InputStream stream = getResourceAsStream(resource);  
	    String content = readStreamToString(stream);  
	    return content;  
	} 
	
	public static String readFileWithOneParamter(String resource, String parameter) {
		 InputStream stream = getResourceAsStream(resource);  
		    String content = readStreamToStringWithParameter(stream, parameter);  
		    return content;  
	}  
    
	
	
    public static InputStream getResourceAsStream(String resource) {  
        String stripped = resource.startsWith("/") ? resource.substring(1): resource;  
        InputStream stream = null;  
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();  
        classLoader.getResource(resource);
        if (classLoader != null) {  
            stream = classLoader.getResourceAsStream(stripped);  
        }  
        return stream;  
    }  
    
    
    
    public static String readStreamToString(InputStream stream) {  
        String fileContent = "";  
        try {  
            InputStreamReader read = new InputStreamReader(stream, "utf-8");  
            BufferedReader reader = new BufferedReader(read);  
            String line;  
            while ((line = reader.readLine()) != null) {  
                fileContent = fileContent + line.trim() + "\n";  
            }  
            read.close();  
            read = null;  
            reader.close();  
            read = null;  
        } catch (Exception ex) {  
            fileContent = "";  
        }  
        return fileContent;  
    }  
	
    public static String readStreamToStringWithParameter(InputStream stream, String parameter) {  
        String fileContent = "";  
        try {  
            InputStreamReader read = new InputStreamReader(stream, "utf-8");  
            BufferedReader reader = new BufferedReader(read);  
            String line;  
            while ((line = reader.readLine()) != null) {  
                fileContent = fileContent + line.trim() + "\n";
                fileContent = fileContent.replace("@parameter", parameter);
            }  
            read.close();  
            read = null;  
            reader.close();  
            read = null;  
        } catch (Exception ex) {  
            fileContent = "";  
        }  
        return fileContent;  
    }

	
}
