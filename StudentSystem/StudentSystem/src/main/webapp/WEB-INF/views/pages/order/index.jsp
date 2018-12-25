<%@page import="org.apache.velocity.runtime.directive.Foreach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div class="row">
	<div class="col-xs-12">
		<div class="card">
			<div class="card-header">
				<h4 class="card-title" id="horz-layout-card-center">Tìm kiếm</h4>
				<a class="heading-elements-toggle"><i
					class="fa fa-ellipsis-v font-medium-3"></i></a>
			</div>
			<div class="card-body collapse in">
				<div class="card-block">
					<div class="form-body">
						<div class="form-group row">
								<label class="col-md-3 label-control" for="district_id">Trạng
									thái</label>
								<div class="col-md-5">
									<select class="form-control" id="statusfind" name="status"
										name="status" onchange="searchStatus()">
										<option value="-1">Chọn trạng thái</option>
										<option value="1">Đang hoạt động</option>
										<option value="0">Ngừng hoạt động</option>
							</select>
								</div>
							</div>
						
					</div>					
				</div>
			</div>
		</div>
	</div>
</div>
	<div class="row" id="order_full">
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
		</div>
	<div id = "order_list_1"></div>

<div class="modal fade" id="orderNewPopup">
	<div class="modal-dialog modal-lg">
		<div class="modal-content new-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">x</button>
				<h4 class="modal-title">Thêm đơn hàng </h4>
			</div>
			<div class="modal-body ">

				<div class="form-group row">
					<label class="col-md-4 label-control">Tên khách hàng:<span
						class="text-danger">(*)</span></label>
					<div class="col-md-7">
						<select class="form-control" id="customer_id" name="customer" onchange = "load_info()">
							<option value="0">Chọn khách hàng </option>
							<c:forEach items="${customers}" var="item">
							<option value="${item.getId() }">${item.getFullName() }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div id="loadinfor"></div>

				
				<div class="form-group row">
					<label class="col-md-4 label-control">Số tiền: <span
						class="text-danger">(*)</span></label>
					<div class="col-md-7">
						<input type="text" id="amount" class="form-control"
							placeholder="Nhập số tiền" name="email">
					</div>
				</div>
		
				<div class="form-group row">
					<label class="col-md-4 label-control">Nội dung <span
						class="text-danger">(*)</span></label>
					<div class="col-md-7">
						<textarea rows="7"  type="text" id="description" class="form-control"
							placeholder="Nhập nội dung " name="address"></textarea>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-md-4 label-control">Chọn partner:<span
						class="text-danger">(*)</span></label>
					<div class="col-md-7">
						<select class="form-control" id="partner_id" name="partner_id">
							<option value="0">Chọn partner</option>
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
						<select class="form-control" id="status" name="status">
							<option value="1">Đang hoạt động</option>
							<option value="0">Ngừng hoạt động</option>
						</select>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary"
					onclick="save_neworder()">Lưu</button>
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="orderEditPupop">
	<div class="modal-dialog modal-lg">
		<div class="modal-content edit-content"></div>
	</div>
</div>
<div class="modal fade" id="orderViewPupop">
	<div class="modal-dialog modal-lg">
		<div class="modal-content view-content"></div>
	</div>
</div>
<script type="text/javascript">

function reset() {
	// constructs unique page using name and choice of music - SECTION A.2
	$('#phone').val(status || -1);
	$('#name').val(name || "");
}
function changeStatus(id) {
	if (confirm("Bạn muốn chuyển trạng thái của danh mục này?")) {
		$.blockUI();
		$.ajax({
			url : "<c:url value='/orders/change-status' />",
			type : 'POST',
			data : {
				id : id
			},
			success : function(response) {
				if (response.status === 200) {
					location.reload();
				} else {
					$.unblockUI();
					alert(response.message);
				}
			},
			error : function(error) {
				alert(error);
				$.unblockUI();
			}
		});
	}
};
// Puop new 	
function shownew() {
	$("#orderNewPopup").modal("show");
}
function load_info() {
	var id= $("#customer_id").val();
	$("#xuly").hide();
	$.blockUI();
	$.ajax({
		url : "<c:url value='/orders/new_customer' />",
		type : 'GET',
		data : {
			id : id
		},
		success : function(response) {
			$.unblockUI();
			$("#loadinfor").html(response);
		},
		error : function(error) {
			alert("error");
			$.unblockUI();
		}
	});
}
function save_neworder() {
	$.blockUI();
	var customer_id = document.getElementById("customer_id").value;
	var amount = document.getElementById("amount").value;
	var description = document.getElementById("description").value;
	var partner_id = document.getElementById("partner_id").value;
	var status = document.getElementById("status").value;
	var formData = new FormData();
	formData.append('customer_id', customer_id);
	formData.append('amount', amount);
	formData.append('description', description);
	formData.append('partner_id', partner_id);
	formData.append('status', status);
	console.log(formData);

	$.ajax({
		url : "<c:url value ='/orders/save-new-order '/>",
		type : "POST",
		data : formData,
		contentType : false,
		processData : false,
		success : function(response) {
			if (response.status === 200) {
				location.reload();
			} else {
				alert(response.status);
			}
		},
		error : function(error) {
			alert(error);
		}
	});
}

function showedit(id) {
	$("#orderEditPupop").modal("show");
	$.blockUI();
	$.ajax({
		url : "<c:url value='/orders/edit-order-model' />",
		type : 'GET',
		data : {
			id : id
		},
		success : function(response) {
			$.unblockUI();
			$(".edit-content").html(response);
		},
		error : function(error) {
			alert("error");
			$.unblockUI();
		}
	});
}
function showView(id) {
	$("#orderViewPupop").modal("show");
	$.blockUI();
	$.ajax({
		url : "<c:url value='/orders/view-order-model' />",
		type : 'GET',
		data : {
			id : id
		},
		success : function(response) {
			$.unblockUI();
			$(".view-content").html(response);
		},
		error : function(error) {
			alert("error");
			$.unblockUI();
		}
	});
};
function save_editorder(id) {
	$.blockUI();
	var customer_id = document.getElementById("ecustomer_id").value;
	var amount = document.getElementById("eamount").value;
	var description = document.getElementById("edescription").value;
	var partner_id = document.getElementById("epartner_id").value;
	var status = document.getElementById("estatus").value;
	var formData = new FormData();
	formData.append('id', id);
	formData.append('customer_id', customer_id);
	formData.append('amount', amount);
	formData.append('description', description);
	formData.append('partner_id', partner_id);
	formData.append('status', status);

	console.log(formData);

	$.ajax({
		url : "<c:url value='/orders/save-edit-order' />",
		type : "POST",
		data : formData,
		contentType : false,
		processData : false,
		success : function(response) {
			if (response.status === 200) {
				location.reload();
			} else {
				alert(response.status);
			}
		},
		error : function(error) {
			alert(error);
		}
	});
}
$(document).ready(function() {
	$(".select2").select2();
	
});

function searchStatus() {
	$.blockUI();
	$("#order_list_1").show();
	$("#order_full").hide();
	var status = document.getElementById("statusfind").value;
	$.ajax({
		url : "<c:url value='/orders/search_status' />",
		type : 'GET',
		data : {
			status : status
		},
		success : function(response) {
			$.unblockUI();
			$("#order_list_1").html(response);
		},
		error : function(error) {
			$.unblockUI();
			alert(error);
		}
	});
}


</script>
