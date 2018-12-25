/**
 * 
 */
package vn.edu.uit.dashboard.configuration;



 
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
 
/**
 * @author kelvin.nguyen
 *
 */

@Component
public class ApplicationProperties {
	
	@Value("${google.jsonKeyPath}")
	private String jsonKeyPath;

	@Value("${print.resourcePath}")
	private String resourcePath;
	
	@Value("${print.tempPath}")
	private String tempPath;
	

	
    public String getJsonKeyPath() {
    		return jsonKeyPath;
    }
    
    public String getResourcePath() {
		return resourcePath;
}

	public String getTempPath() {
		return tempPath;
	}

	
}