package vn.edu.uit.dashboard.controller;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vn.edu.uit.dashboard.dao.EmployeeDao;
import vn.edu.uit.dashboard.model.User;
import vn.edu.uit.dashboard.utils.Utils;

@Controller
@RequestMapping(value = "")
public class HomeController extends BaseController{

	@Autowired
	EmployeeDao employeeDao;
	
	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public String homePage(ModelMap model, HttpServletRequest request) {
		
		return "home";
	}
	
	@RequestMapping(value = { "/profile"}, method = RequestMethod.GET)
	public String profile(ModelMap model) {
		return "profile";
	}
	
	@RequestMapping(value = { "/changeProfile"}, method = RequestMethod.GET)
	public String changeProfile(ModelMap model) {
		return "profile";
	}

	@RequestMapping(value = { "/doi-mat-khau"}, method = RequestMethod.GET)
	public String changePassword(ModelMap model) {
		return "changePassword";
	}
	
	
	
	@RequestMapping(value = { "/changePassword"}, method = RequestMethod.POST)
	public String contactUsPage(
			@RequestParam("oldPassword") String oldPassword, 
			@RequestParam("newPassword") String newPassword,
			@RequestParam("confirmPassword") String confirmPassword,
			ModelMap model) {
		Boolean isValid = true;
		if(oldPassword == null || oldPassword.length() < 6) {
			model.addAttribute("errorOldPassword", "Mật khẩu cũ không hợp lệ");
			isValid = false;
		} 
		if(newPassword == null || newPassword.length() < 6) {
			model.addAttribute("errorNewPassword", "Mật khẩu mới phải lớn hơn 6 ký tự");
			isValid = false;
		} 
		if(!newPassword.equals(confirmPassword)){
			model.addAttribute("errorConfirmPassword", "Mật khẩu xác nhận không khớp");
			isValid = false;
		} 
		if(isValid) {
			User employee = employeeDao.findOne(currentUser().getUserId());
			
			if(!employee.getPassword().equals(Utils.encodePassword(oldPassword))) {
				model.addAttribute("errorOldPassword", "Mật khẩu cũ không hợp lệ");
			} else {
				
				
				employee.setPassword(Utils.encodePassword(newPassword));
				employeeDao.update(employee);
				String content = "Mật khẩu mới của bạn là " + newPassword;
				model.addAttribute("msg", "Thay đổi mật khẩu thành công");
			}
		}
		
		return "changePassword";
	}
	
}