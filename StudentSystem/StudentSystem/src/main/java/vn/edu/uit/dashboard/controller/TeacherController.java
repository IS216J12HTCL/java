package vn.edu.uit.dashboard.controller;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.IteratorUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import vn.edu.uit.dashboard.dao.TeacherDao;
import vn.edu.uit.dashboard.helper.ResponseStatusEnum;
import vn.edu.uit.dashboard.model.BaseResponse;
import vn.edu.uit.dashboard.model.Teacher;
import vn.edu.uit.dashboard.utils.ExcelHelper;
import vn.edu.uit.dashboard.utils.Utils;

@Controller
@RequestMapping(value = "/teachers")
public class TeacherController  extends BaseController{
	@Autowired
	ServletContext context;
	
	@Autowired
	TeacherDao teacherDao; 
	
	@RequestMapping(value = { "" }, method = RequestMethod.GET)
	public String index(Model model) {
		List<Teacher> teachers = teacherDao.findAll();
		model.addAttribute("teachers", teachers);
		return "teachers";
	}
	@RequestMapping(value = { "/change-status" }, method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> changeteacherStatus(int id, ModelMap model) {
		BaseResponse response = new BaseResponse();
		response.setStatus(ResponseStatusEnum.SUCCESS);
		response.setMessage(ResponseStatusEnum.SUCCESS);
		response.setData(null);
		try {
			if (id > 0) {
				Teacher teacher = teacherDao.findOne(id);
				if (teacher != null) {
					teacher.setStatus(teacher.getStatus() == 0 ?(byte) 1 :  0);
					teacherDao.update(teacher);
				} else {
					response.setStatus(ResponseStatusEnum.FAIL);
					response.setMessage(ResponseStatusEnum.FAIL);
				}
			} else {
				response.setStatus(ResponseStatusEnum.FAIL);
				response.setMessage(ResponseStatusEnum.FAIL);
			}
		} catch (Exception ex) {
			response.setStatus(ResponseStatusEnum.FAIL);
			response.setMessageError(ex.getMessage());
		}

		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}


	@RequestMapping(value = { "/export-teacher-template" }, method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> exportteacherTemplate(ModelMap model) {
		BaseResponse response = new BaseResponse();
		response.setStatus(ResponseStatusEnum.SUCCESS);
		response.setMessage(ResponseStatusEnum.SUCCESS);
		response.setData(null);
		try {
			List<Teacher> teacherList = teacherDao.findAll();

			String savePath = "/static/documents";
			String filePath = context.getRealPath(savePath);

			Object[] header = { "Mã KH", "Tên khách hàng", "Số ĐT", "Email", "Địa chỉ", "Mã chi nhánh",
					"Mã trạng thái(1=Hoạt động, 0=Không hoạt động)" };
			Object[][] data = new Object[teacherList.size() + 1][header.length];
			data[0] = header;
			int indexRow = 1;
			for (Teacher teacher : teacherList) {
				String teacherName = teacher.getName();
				String teacherPhone = teacher.getPhone();
				String teacherMail = teacher.getEmail();
				String teacherAddress = teacher.getAddress();
				int teacherStatus = teacher.getStatus();
				Object[] teacherData = {  teacherName, teacherPhone, teacherMail, teacherAddress,
						 teacherStatus };
				if (teacherData.length == header.length) {
					data[indexRow] = teacherData;
				}
				indexRow++;
			}

			String fileName = ExcelHelper.writeExcel(data, "teacher_template", filePath);
			if (!fileName.isEmpty()) {
				response.setData(String.format("%s/%s", savePath, fileName));
			}
		} catch (Exception ex) {
			response.setStatus(ResponseStatusEnum.FAIL);
			response.setMessageError(ex.getMessage());
		}

		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/import-teacher-template", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> importteacherTemplate(@RequestParam("file") MultipartFile file) {
		BaseResponse response = new BaseResponse();
		response.setStatus(ResponseStatusEnum.SUCCESS);
		response.setMessage(ResponseStatusEnum.SUCCESS);
		response.setData(null);
		try {
			Workbook workbook = new XSSFWorkbook(file.getInputStream());
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> iteratorRow = datatypeSheet.iterator();
			List<Row> rows = IteratorUtils.toList(iteratorRow);
			int indexRow = 0;
			for (Row row : rows) {
				if (indexRow > 0) {
					Iterator<Cell> cellIterator = row.iterator();
					List<Cell> myList = IteratorUtils.toList(cellIterator);
					int teacherId = (int) myList.get(0).getNumericCellValue();

					Teacher teacher = new Teacher();
					String fullName = myList.get(2).getStringCellValue() + "";
					String phone = myList.get(3).getStringCellValue() + "";
					String email = myList.get(4).getStringCellValue() + "";
					String address = myList.get(5).getStringCellValue() + "";
					byte status = (byte) myList.get(7).getNumericCellValue();

						teacher.setId(teacherId);
						teacher.setName(fullName);
						teacher.setPhone(phone);
						teacher.setEmail(email);
						teacher.setAddress(address);
						teacher.setStatus(status);
						teacherDao.create(teacher);
					
				}
				indexRow++;

			}

		} catch (Exception ex) {
			response.setStatus(ResponseStatusEnum.FAIL);
			response.setMessageError(ex.getMessage());
		}

		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);

	}
	

	@RequestMapping(value = { "/save-new-teacher" }, method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> saveNewteacher(HttpServletRequest request,
			@RequestParam(value = "file", required = false) MultipartFile file,
			String name, String phone, String pass, String email, 
			String address, byte gender, byte status, ModelMap model) {
		BaseResponse response = new BaseResponse();
		response.setStatus(ResponseStatusEnum.SUCCESS);
		response.setMessage(ResponseStatusEnum.SUCCESS);

		response.setData(null);
		Teacher teachernew = new Teacher();
		teachernew.setName(name);
		teachernew.setPhone(phone);
		teachernew.setPassword(Utils.encodePassword(pass));
		teachernew.setEmail(email);
		teachernew.setPhone(phone);
			teachernew.setAddress(address);
		teachernew.setStatus(status);
		
		teacherDao.create(teachernew);
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}
	@RequestMapping(value = { "/edit-teacher-model" }, method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ModelAndView geteEditCutomer(int id, Model model) {
		Teacher teacher = teacherDao.findOne(id);
		model.addAttribute("teacher", teacher);
		return new ModelAndView("teacher/_edit");
	}
	
	@RequestMapping(value = { "/view-teacher-model" }, method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ModelAndView geteviewCutomer(int id, Model model) {
		Teacher teacher = teacherDao.findOne(id);
		model.addAttribute("teacher", teacher);
		return new ModelAndView("teacher/_view");
	}
	
	
	@RequestMapping(value = { "/save-edit-teacher" }, method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> saveEditteacher(HttpServletRequest request,
			@RequestParam(value = "file", required = false) MultipartFile file, int id, String name, String phone,
			String pass, String email, String address, byte gender, byte status,
			ModelMap model) {
		BaseResponse response = new BaseResponse();
		response.setStatus(ResponseStatusEnum.SUCCESS);
		response.setMessage(ResponseStatusEnum.SUCCESS);

		response.setData(null);
		Teacher teacheredit = teacherDao.findOne(id);
		teacheredit.setName(name);
		teacheredit.setPhone(phone);
		teacheredit.setEmail(email);
		teacheredit.setPassword(Utils.encodePassword(pass));
			teacheredit.setAddress(address);
		teacheredit.setStatus(status);
		
			teacherDao.update(teacheredit);

		
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = { "/search_name" }, method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ModelAndView listteacher(Model model, int id) {
		Teacher teacher = teacherDao.findOne(id);	
		model.addAttribute("teacher", teacher);

		return new ModelAndView("teacher/_dropdown_teacher");
	}
	@RequestMapping(value = { "/search_phone" }, method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ModelAndView listteacherPhone(Model model, int id) {
		Teacher teacher = teacherDao.findOne(id);	
		model.addAttribute("teacher", teacher);

		return new ModelAndView("teacher/_dropdown_teacher");
	}
	
}

	

