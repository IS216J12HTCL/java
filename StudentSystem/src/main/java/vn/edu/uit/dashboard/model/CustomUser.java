package vn.edu.uit.dashboard.model;

import java.util.Collection;
import org.springframework.security.core.userdetails.User;



public class CustomUser extends User {

   private static final long serialVersionUID = -3531439484732724601L;

   private final String  userCode;

  

   public CustomUser(String userCode, String username, String password, Collection authorities){
           super(username, password, true, true, true, true, authorities);
           this.userCode = userCode;
              }

   public static long getSerialversionuid() {
      return serialVersionUID;
   }
  
  

	
	
}