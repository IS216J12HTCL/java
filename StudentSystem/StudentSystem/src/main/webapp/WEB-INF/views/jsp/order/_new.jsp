
<%@page import="org.apache.velocity.runtime.directive.Foreach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	
<div class="form-group row">
					<label class="col-md-4 label-control"> Số điện thoại:<span class="text-danger">(*)</span>
					</label>
					<div class="col-md-7">
						<input type="text" class="form-control" value="${customer.getPhone() }"
							placeholder="Nhập số điện thoại" name="phones" disabled="disabled">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-md-4 label-control"> Địa chỉ:<span class="text-danger">(*)</span>
					</label>
					<div class="col-md-7">
						<input type="text"  class="form-control" value="${customer.getAddress() }"
							placeholder="Nhập địa chỉ" name="address" disabled="disabled">
					</div>
				</div>