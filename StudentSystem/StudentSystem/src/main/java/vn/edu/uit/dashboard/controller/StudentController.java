/**
 * 
 */
package vn.edu.uit.dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;

import vn.edu.uit.dashboard.dao.StudentDao;

/**
 * @author Duy Linh
 *
 */
public class StudentController {
	
	@Autowired
	private StudentDao studentDao;
}
