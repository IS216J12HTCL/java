/**
 * 
 */
package vn.edu.uit.dashboard.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vn.edu.uit.dashboard.dao.EmployeeDao;
import vn.edu.uit.dashboard.helper.EmailHelper;
import vn.edu.uit.dashboard.model.User;
import vn.edu.uit.dashboard.utils.Utils;

/**
 * @author Minh Anh
 *
 */
@Controller
@RequestMapping("")
public class LoginController extends BaseController{
	@Autowired
	EmployeeDao employeeDao;
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public ModelAndView loginPage(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Username hoặc mật khẩu không chính xác!");
		}

		if (logout != null) {
			model.addObject("msg", "Đăng xuất thành công.");
		}
		model.setViewName("loginPage");

		return model;

	}
	
	//Spring Security see this :
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Username hoặc mật khẩu không chính xác!");
		}

		if (logout != null) {
			model.addObject("msg", "Đăng xuất thành công.");
		}
		model.setViewName("loginPage");
		return model;

	}
	
	@RequestMapping(value = "/dang-xuat", method = RequestMethod.GET)
	public String logout(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session= request.getSession(false);
	    SecurityContextHolder.clearContext();
        session= request.getSession(false);
        if(session != null) {
            session.invalidate();
        }
        for(Cookie cookie : request.getCookies()) {
            cookie.setMaxAge(0);
        }
        return "loginPage";

	}
	
	@RequestMapping(value = "/quen-mat-khau", method = RequestMethod.GET)
	public String forgotPassword(ModelMap model, HttpServletRequest request) {
		model.addAttribute("user", new User());
		return "forgotPassword";
	}
	
	@RequestMapping(value = "/reset-password", method = RequestMethod.POST)
	public String resetPassword(@RequestParam("phone") String phone, ModelMap model) {
		User employee = employeeDao.findByPhone(phone);
		if (employee == null) {
			model.addAttribute("error", "Số điện thoại không hợp lệ hoặc không tồn tại trong hệ thống");
		} else { 
			String newPassword = Utils.createRandomString(6);
			employee.setPassword(Utils.encodePassword(newPassword));
			employeeDao.update(employee);
			String content = "Mật khẩu mới của bạn là " + newPassword;
			model.addAttribute("msg", "Mật khẩu mới của bạn đã được gửi tới hòm thư, vui lòng kiểm tra trong Inbox, Junk và Spam");
		}  
		return "forgotPassword";
	}
	
}
