<%@page import="org.apache.velocity.runtime.directive.Foreach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="modal-header">
	<button type="button" class="close" data-dismiss="modal"
		aria-hidden="true">x</button>
	<h4 class="modal-title">Xem khách hàng</h4>
</div>
<div class="modal-body ">
	<div class="form-group row">
		<label class="col-md-4 label-control">Tên khách hàng:<span
			class="text-danger">(*)</span></label>
		<div class="col-md-7">
			<input type="text" id="edtfullName" class="form-control"
				placeholder="Nhập họ tên khách hàng" name="fullname" value="${customer.getFullName()}" disabled="disabled">
		</div>
	</div>
	<div class="form-group row">
		<label class="col-md-4 label-control">Tên đăng nhập(Chính là
			số điện thoại):<span class="text-danger">(*)</span>
		</label>
		<div class="col-md-7">
			<input type="text" id="edtphones" class="form-control"
				placeholder="Nhập số điện thoại" name="phones" value="${customer.getPhone()}" disabled="disabled">
		</div>
	</div>

	<div class="form-group row">
		<label class="col-md-4 label-control">Email:<span
			class="text-danger">(*)</span></label>
		<div class="col-md-7">
			<input type="text" id="edtmail" class="form-control"
				placeholder="Nhập email" name="email" value ="${customer.getEmail()}" disabled="disabled">
		</div>
	</div>


	<div class="form-group row">
		<label class="col-md-4 label-control">Địa chỉ:<span
			class="text-danger">(*)</span></label>
		<div class="col-md-7">
			<input type="text" id="edtaddress" class="form-control"
				placeholder="Nhập địa chỉ" name="address" value ="${customer.getAddress()}" disabled="disabled">
		</div>
	</div>
	<div class="form-group row">
		<label class="col-md-4 label-control">Chọn giới tính:<span
			class="text-danger">(*)</span></label>
		<div class="col-md-7">
			<select class="form-control" id="edtgender" name="status" disabled="disabled">
		
				<option value="1">Nam</option>
				<option value="0">Nữ</option>
			</select>
		</div>
	</div>
 
	
	<div class="form-group row">
		<label class="col-md-4 label-control">Trạng thái:<span
			class="text-danger">(*)</span></label>
		<div class="col-md-7">
			<select class="form-control" id="edtstatus" name="status" disabled="disabled">
				<option value="1">Đang hoạt động</option>
				<option value="0">Ngừng hoạt động</option>
			</select>
		</div>
	</div> 
</div>
<div class="modal-footer">
	<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	
</div>
