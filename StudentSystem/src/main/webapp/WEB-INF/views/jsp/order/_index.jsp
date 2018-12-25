<%@page import="org.apache.velocity.runtime.directive.Foreach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	

<div class="row" >
	<div class="col-xs-12">
		<div class="card">
			<div class="card-header">
				<h4 class="card-title">DANH SÁCH ĐƠN HÀNG </h4>
				<a class="heading-elements-toggle"><i
					class="fa fa-ellipsis-v font-medium-3"></i></a>
				
				<div style="float: right;">
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
									<th>Số điện thoại</th>
									<th>Địa chỉ</th>
									<th>Nội dung </th>
									<th>Số tiền </th>
									<th>Người partner</th>
									<th>Trạng thái</th>
									<th>Chức năng</th>

								</tr>
							</thead>
							<tbody>
								<c:forEach items="${orderDetails}" var="item">
									<tr>
										<th scope="row">${item.getId()}</th>
										<td>${item.getOrder().getCustomer().getFullName()}</td>
										<td>${item.getOrder().getCustomer().getPhone() }</td>
										<td>${item.getOrder().getCustomer().getAddress()}</td>
										<td>${item.getDescription()}</td>
										<td>${item.getOrder().getTotalAmount()}</td>
										<td>${item.getOrder().getPartner().getFullname()}</td>
										<td>${item.getStatusHtml(item.getStatus()) }</td>
										<td>
										
										<c:choose>
							<c:when test="${item.getStatus()==0}">
								<button type="button"
									onclick="changeStatus(${item.getId()});return false;"
									class="btn mr-1 mb-1 btn-sm btn-outline-danger btn-block">
									<i class="fa fa-check"></i> Kích hoạt
								</button>
							</c:when>
							<c:otherwise>
								<button type="button"
									onclick="changeStatus(${item.getId()});return false;"
									class="btn mr-1 mb-1 btn-sm btn-outline-success btn-block">
									<i class="fa fa-check"></i> Khoá tài khoản
								</button>
							</c:otherwise>
						</c:choose> 
											<button type="button" onclick="showedit(${item.getId()})"
												class="btn mr-1 mb-1 btn-sm btn-outline-info btn-block">
												<i class="fa ft-edit"></i> Chỉnh sửa
											</button>
											<button type="button"
												onclick="showView(${item.getId()})"
												class="btn mr-1 mb-1 btn-sm btn-outline-success btn-block">
												<i class="fa fa-eye"></i> Xem chi tiết
											</button></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>					

					</div>
					
					</div>
				</div>
			</div>
		</div></html>