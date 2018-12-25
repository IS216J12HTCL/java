package vn.edu.uit.dashboard.configuration;

import java.io.File;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import vn.edu.uit.dashboard.security.WebSecurityConfig;
/**
 * @author Minh Anh
 */

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	 private String TMP_FOLDER = "java.io.tmpdir"; 
		private int MAX_UPLOAD_SIZE = 5 * 1024 * 1024; 
		@Override
		protected Class<?>[] getRootConfigClasses() {
			return new Class[] { 
					AppConfig.class, 
					WebSecurityConfig.class 
			};
		}
	 
		@Override
		protected Class<?>[] getServletConfigClasses() {
			return null;
		}
	 
		@Override
		protected String[] getServletMappings() {
			return new String[] { "/" };
		}
		@Override
	    protected void customizeRegistration(ServletRegistration.Dynamic registration) {

	        // upload temp file will put here
	        File uploadDirectory = new File(System.getProperty(TMP_FOLDER));

	        // register a MultipartConfigElement
	        MultipartConfigElement multipartConfigElement =
	                new MultipartConfigElement(uploadDirectory.getAbsolutePath(),
	                		MAX_UPLOAD_SIZE, MAX_UPLOAD_SIZE * 2, MAX_UPLOAD_SIZE / 2);

	        registration.setMultipartConfig(multipartConfigElement);

	    }
}

