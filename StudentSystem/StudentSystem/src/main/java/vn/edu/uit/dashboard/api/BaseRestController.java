/**
 * 
 */
package vn.edu.uit.dashboard.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import vn.edu.uit.dashboard.helper.ResponseStatusEnum;
import vn.edu.uit.dashboard.model.BaseResponse;
/**
 * @author kelvin
 *
 */
@RestController
public class BaseRestController {
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<BaseResponse> handleMissingParams(MissingServletRequestParameterException ex) {
	    // Actual exception handling
	    BaseResponse response = new BaseResponse();
		response.setStatus(ResponseStatusEnum.MISSING_PARAMS);
		response.setMessageError(String.format("%s is required!", ex.getParameterName()));
		response.setData(null);
		
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}
}
