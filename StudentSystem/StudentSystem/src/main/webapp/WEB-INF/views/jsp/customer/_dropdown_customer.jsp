<%@page import="org.apache.velocity.runtime.directive.Foreach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
					<div class="row">
	<div class="col-xs-12">
		<div class="card">
			<div class="card-header">
				<h4 class="card-title">DANH SÁCH KHÁCH HÀNG</h4>
				<a class="heading-elements-toggle"><i
					class="fa fa-ellipsis-v font-medium-3"></i></a>
				
				<div style="float: right;">

					<a title="Tải file excel dữ liệu khách hàng"
						onclick="downloadTemplate();" href="javascript:void(0);"
						class="btn btn-icon btn-primary mr-1"> <i
						class="fa fa-download"></i>
					</a> <a title="Cập nhật dữ liệu khách bằng file excel"
						onclick="uploadTemplate();" href="javascript:void(0);"
						class="btn btn-icon btn-primary mr-1"> <i class="fa fa-upload"></i>
					</a> <input type="file" id="fileCustomerExcel" style="display: none"
						accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" />
					<a title="Tạo mới gia sư" class="btn btn-icon btn-primary mr-1"
						onclick="shownew()"> <i class="ft-plus-circle"></i>
					</a>
				</div>
			</div>
			<div class="card-body collapse in">
						<div class="table-responsive">
	
						<table class="table table-bordered mb-0">
							<thead>
								<tr>
									<th>ID</th>
									<th>Tên khách hàng</th>
									<th>Giới tính</th>
									<th>Số điện thoại</th>
									<th>Email</th>
									<th>Địa chỉ</th>
									<th>Trạng thái</th>
									<th>Chức năng</th>

								</tr>
							</thead>
							<tbody>
								
									<tr>
										<th scope="row">${customer.getId()}</th>
										<td>${customer.getFullName()}</td>
										<td>${customer.getGenderHtml() }</td>
										<td>${customer.getPhone()}</td>
										<td>${customer.getEmail()}</td>
										<td>${customer.getAddress()}</td>
										<td>${customer.getStatusHtml(customer.getStatus()) }</td>
										<td>
										
										<c:choose>
							<c:when test="${customer.getStatus()==0}">
								<button type="button"
									onclick="changeStatus(${customer.getId()});return false;"
									class="btn mr-1 mb-1 btn-sm btn-outline-danger btn-block">
									<i class="fa fa-check"></i> Kích hoạt
								</button>
							</c:when>
							<c:otherwise>
								<button type="button"
									onclick="changeStatus(${customer.getId()});return false;"
									class="btn mr-1 mb-1 btn-sm btn-outline-success btn-block">
									<i class="fa fa-check"></i> Khoá tài khoản
								</button>
							</c:otherwise>
						</c:choose> 
											<button type="button" onclick="showedit(${customer.getId()})"
												class="btn mr-1 mb-1 btn-sm btn-outline-info btn-block">
												<i class="fa ft-edit"></i> Chỉnh sửa
											</button>
											<button type="button"
												onclick="location.href='<c:url value='/customers/${customer.getId()}/view' />'"
												class="btn mr-1 mb-1 btn-sm btn-outline-success btn-block">
												<i class="fa fa-eye"></i> Xem chi tiết
											</button></td>
									</tr>
							
							</tbody>
						</table>					

					</div>
					
					</div>
					</div>
					</div>
					</div>
					
		