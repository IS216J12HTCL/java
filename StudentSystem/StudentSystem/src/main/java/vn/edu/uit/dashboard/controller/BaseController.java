package vn.edu.uit.dashboard.controller;

import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletResponse;
//import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import vn.edu.uit.dashboard.dao.EmployeeDao;
import vn.edu.uit.dashboard.model.CustomUser;
import vn.edu.uit.dashboard.utils.Constants;


@Controller
public class BaseController {
	protected final String defaultPage = "DEFAULT";
	
	protected String locale;
	protected int numberPage = Constants.PAGE_NUMBER;
	
	@Autowired
	EmployeeDao userDao;
	
	@Autowired
	private InternalResourceViewResolver viewResolver;
	
	
	@PostConstruct
	public void initialize() {
		this.numberPage = Constants.PAGE_NUMBER;
	}
	
	public CustomUser currentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		CustomUser currentUser = (CustomUser)auth.getPrincipal();
		return currentUser;
	}
	
	public String renderViewToHtml(String viewName, Map<String, ?> model, HttpServletRequest request) {
		String viewStringContent = "";
		try {
			View resolvedView = this.viewResolver.resolveViewName(viewName, Locale.US);
			MockHttpServletResponse mockResp = new MockHttpServletResponse();
			resolvedView.render(model, request, mockResp);
			viewStringContent = mockResp.getContentAsString();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return viewStringContent;
	}
	
	
	public int getNumberPage() {
		return this.numberPage;
	}
	
	public void setLanguage(String locale) {
		this.locale = locale;
	}
	
}