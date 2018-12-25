package vn.edu.uit.dashboard.model;

import java.util.Collection;
import org.springframework.security.core.userdetails.User;



public class CustomUser extends User {

   private static final long serialVersionUID = -3531439484732724601L;

   private final int  userId,roleId;
   private final String roleName;
  

   public CustomUser(int userId, String username, String password, int roleId, String roleName, Collection authorities){
           super(username, password, true, true, true, true, authorities);
           this.roleId=roleId;
           this.roleName=roleName;
           this.userId = userId;
              }

   public static long getSerialversionuid() {
      return serialVersionUID;
   }
  
   public UserRoleEnum getRole() {
		switch(this.roleId) {
		case 1:
			return UserRoleEnum.ADMIN;
		case 2:
			return UserRoleEnum.USER;
		case 3:
			return UserRoleEnum.TEACHER;
		default:
			return UserRoleEnum.UNKNOW;
		}
	}
	
	public int getRoleId() {
	return roleId;
}

public String getRoleName() {
	return roleName;
}

	public int getUserId() {
		return this.userId;
	}

	
	
}