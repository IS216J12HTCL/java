/**
 * 
 */
package vn.edu.uit.dashboard.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vn.edu.uit.dashboard.dao.StudentDao;
import vn.edu.uit.dashboard.model.Student;

/**
 * @author Duy Linh
 *
 */
public class StudentController {
	
	@Autowired
	private StudentDao studentDao;
	
	@RequestMapping(value = { "" }, method = RequestMethod.GET)
	public String getCustomer(ModelMap model, HttpServletRequest request) {
		
	
		List<Student> students = studentDao.findAll();
		model.addAttribute("customers", students);
		return "customers";
	}

}
