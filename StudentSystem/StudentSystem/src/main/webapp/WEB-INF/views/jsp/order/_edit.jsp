<%@page import="org.apache.velocity.runtime.directive.Foreach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	
	<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">x</button>
				<h4 class="modal-title">Sửa đơn hàng </h4>
			</div>
			<div class="modal-body ">

				<div class="form-group row">
					<label class="col-md-4 label-control">Tên khách hàng:<span
						class="text-danger">(*)</span></label>
					<div class="col-md-7">
						<select class="form-control" id="ecustomer_id" name="customer" onchange = "load_info()">
							<option value="${orderDetail.getOrder().getCustomer().getId()}">${orderDetail.getOrder().getCustomer().getFullName() }</option>
							<c:forEach items="${customers}" var="item">
							<option value="${item.getId() }">${item.getFullName() }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div id="xuly">
				<div class="form-group row">
					<label class="col-md-4 label-control"> Số điện thoại:<span class="text-danger">(*)</span>
					</label>
					<div class="col-md-7">
						<input type="text" class="form-control" value="${orderDetail.getOrder().getCustomer().getPhone() }"
							placeholder="Nhập số điện thoại" name="phones" disabled="disabled">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-md-4 label-control"> Địa chỉ:<span class="text-danger">(*)</span>
					</label>
					<div class="col-md-7">
						<input type="text"  class="form-control" value="${orderDetail.getOrder().getCustomer().getAddress() }"
							placeholder="Nhập địa chỉ" name="address" disabled="disabled">
					</div>
				</div>
				</div>
				<div id="loadinfor"></div>

				
				<div class="form-group row">
					<label class="col-md-4 label-control">Số tiền: <span
						class="text-danger">(*)</span></label>
					<div class="col-md-7">
						<input type="text" id="eamount" class="form-control"
							placeholder="Nhập số tiền" name="email" value="${orderDetail.getOrder().getTotalAmount()}">
					</div>
				</div>
		
				<div class="form-group row">
					<label class="col-md-4 label-control">Nội dung <span
						class="text-danger">(*)</span></label>
					<div class="col-md-7">
						<textarea rows="7"  type="text" id="edescription" class="form-control"
							placeholder="Nhập nội dung " name="address">${orderDetail.getDescription()}</textarea>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-md-4 label-control">Chọn partner:<span
						class="text-danger">(*)</span></label>
					<div class="col-md-7">
					
						<select class="form-control" id="epartner_id" name="partner_id">
							<option value="${orderDetail.getOrder().getPartner().getId()}">${orderDetail.getOrder().getPartner().getFullname() }</option>
							
							<c:forEach items="${partners }" var="item">
							<option value="${item.getId() }">${item.getFullname() }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			
				<div class="form-group row">
					<label class="col-md-4 label-control">Trạng thái:<span
						class="text-danger">(*)</span></label>
					<div class="col-md-7">
						<select class="form-control" id="estatus" name="status">
						<option value="${ orderDetail.getStatus()}">${ orderDetail.getStatusHtml(orderDetail.getStatus())}</option>
							
							<option value="1">Đang hoạt động</option>
							<option value="0">Ngừng hoạt động</option>
						</select>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary"
					onclick="save_editorder(${orderDetail.getId()})">Lưu</button>
			</div>