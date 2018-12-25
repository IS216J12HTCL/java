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
							<label class="col-md-3 label-control" for="city_id">Tên
								giáo viên</label>
							<div class="col-md-5">
								<select class="select2 form-control" id="teacher_id_ser"
									onchange="search_name()">
									<option value="0">Chọn tên giáo viên</option>
									<c:forEach items="${teachers}" var="item">
										<option value="${item.getId()}">${item.getName()}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<span>Hoặc</span>
						<br>
						<div class="form-group row">
							<label class="col-md-3 label-control">Số điện thoại giáo viên</label>
							<div class="col-md-5">
								<select class="select2 form-control" id="phone_id_ser"
									onchange="search_phone()">
									<option value="0">Chọn số điện thoại</option>
									<c:forEach items="${teachers}" var="item">
										<option value="${item.getId()}">${item.getPhone()}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						
					</div>					
				</div>
			</div>
		</div>
	</div>
</div>
	<div class="row" id="teacher_full">
	<div class="col-xs-12">
		<div class="card">
			<div class="card-header">
				<h4 class="card-title">DANH SÁCH GIÁO VIÊN</h4>
				<a class="heading-elements-toggle"><i
					class="fa fa-ellipsis-v font-medium-3"></i></a>
				
				<div style="float: right;">

					<a title="Tải file excel dữ liệu giáo viên"
						onclick="downloadTemplate();" href="javascript:void(0);"
						class="btn btn-icon btn-primary mr-1"> <i
						class="fa fa-download"></i>
					</a> <a title="Cập nhật dữ liệu giáo viên bằng file excel"
						onclick="uploadTemplate();" href="javascript:void(0);"
						class="btn btn-icon btn-primary mr-1"> <i class="fa fa-upload"></i>
					</a> <input type="file" id="fileteacherExcel" style="display: none"
						accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" />
					<a title="Tạo mới giáo viên" class="btn btn-icon btn-primary mr-1"
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
									<th>Tên giáo viên</th>
									<th>Số điện thoại</th>
									<th>Email</th>
									<th>Địa chỉ</th>
									<th>Trạng thái</th>
									<th>Chức năng</th>

								</tr>
							</thead>
							<tbody>
								<c:forEach items="${teachers}" var="teacher">
									<tr>
										<th scope="row">${teacher.getId()}</th>
										<td>${teacher.getName()}</td>
										<td>${teacher.getPhone()}</td>
										<td>${teacher.getEmail()}</td>
										<td>${teacher.getAddress()}</td>
										<td>${teacher.getStatusHtml(teacher.getStatus()) }</td>
										<td>
										
										<c:choose>
							<c:when test="${teacher.getStatus()==0}">
								<button type="button"
									onclick="changeStatus(${teacher.getId()});return false;"
									class="btn mr-1 mb-1 btn-sm btn-outline-danger btn-block">
									<i class="fa fa-check"></i> Kích hoạt
								</button>
							</c:when>
							<c:otherwise>
								<button type="button"
									onclick="changeStatus(${teacher.getId()});return false;"
									class="btn mr-1 mb-1 btn-sm btn-outline-success btn-block">
									<i class="fa fa-check"></i> Khoá tài khoản
								</button>
							</c:otherwise>
						</c:choose> 
											<button type="button" onclick="showedit(${teacher.getId()})"
												class="btn mr-1 mb-1 btn-sm btn-outline-info btn-block">
												<i class="fa ft-edit"></i> Chỉnh sửa
											</button>
											<button type="button"
												onclick="showView(${teacher.getId()})"
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
	<div id = "teacher_list_1"></div>

<div class="modal fade" id="teacherNewPopup">
	<div class="modal-dialog modal-lg">
		<div class="modal-content new-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">x</button>
				<h4 class="modal-title">Thêm giáo viên</h4>
			</div>
			<div class="modal-body ">

				<div class="form-group row">
					<label class="col-md-4 label-control">Tên giáo viên:<span
						class="text-danger">(*)</span></label>
					<div class="col-md-7">
						<input type="text" id="newfullName" class="form-control"
							placeholder="Nhập họ tên giáo viên" name="fullname">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-md-4 label-control">Tên đăng nhập(Chính
						là số điện thoại):<span class="text-danger">(*)</span>
					</label>
					<div class="col-md-7">
						<input type="text" id="newphones" class="form-control"
							placeholder="Nhập số điện thoại" name="phones">
					</div>
				</div>

				<div class="form-group row">
					<label class="col-md-4 label-control">Mật khẩu:<span
						class="text-danger">(*)</span></label>
					<div class="col-md-7">
						<input type="text" id="newpassword" class="form-control"
							placeholder="Nhập mật khẩu" name="password">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-md-4 label-control">Email:<span
						class="text-danger">(*)</span></label>
					<div class="col-md-7">
						<input type="text" id="newmail" class="form-control"
							placeholder="Nhập email" name="email">
					</div>
				</div>
		
				<div class="form-group row">
					<label class="col-md-4 label-control">Địa chỉ:<span
						class="text-danger">(*)</span></label>
					<div class="col-md-7">
						<input type="text" id="newaddress" class="form-control"
							placeholder="Nhập địa chỉ" name="address">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-md-4 label-control">Chọn giới tính:<span
						class="text-danger">(*)</span></label>
					<div class="col-md-7">
						<select class="form-control" id="newsgender" name="status">
							<option value="1">Nam</option>
							<option value="0">Nữ</option>
						</select>
					</div>
				</div>
			
				<div class="form-group row">
					<label class="col-md-4 label-control">Trạng thái:<span
						class="text-danger">(*)</span></label>
					<div class="col-md-7">
						<select class="form-control" id="newstatus" name="status">
							<option value="1">Đang hoạt động</option>
							<option value="0">Ngừng hoạt động</option>
						</select>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary"
					onclick="save_newteacher()">Lưu</button>
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="teacherEditPupop">
	<div class="modal-dialog modal-lg">
		<div class="modal-content edit-content"></div>
	</div>
</div>
<div class="modal fade" id="teacherViewPupop">
	<div class="modal-dialog modal-lg">
		<div class="modal-content view-content"></div>
	</div>
</div>
<script type="text/javascript">
function downloadTemplate() {
	$.blockUI();
	$.ajax({
		url : "<c:url value='/teachers/export-teacher-template'/>",
		type : 'GET',
		success : function(response) {
			if (response.status === 200) {
				downloadFile(response.data, ".xlsx");
				$.unblockUI();
			} else {
				$.unblockUI();
				alert(response.message);
			}
		},
		error : function(error) {
			$.unblockUI();
			alert(error);
		}
	});
};

function reset() {
	// constructs unique page using name and choice of music - SECTION A.2
	$('#phone').val(status || -1);
	$('#name').val(name || "");
}
function changeStatus(id) {
	if (confirm("Bạn muốn chuyển trạng thái của danh mục này?")) {
		$.blockUI();
		$.ajax({
			url : "<c:url value='/teachers/change-status' />",
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
function uploadTemplate() {
	$('#fileteacherExcel').trigger('click');
}

$(function() {
	$("#fileteacherExcel")
			.change(
					function() {
						if (confirm("Bạn muốn cập nhật dữ liệu giáo viên bằng file excel này?")) {
							if ($("#fileteacherExcel").val() != '') {
								var data = new FormData();
								$.each($("#fileteacherExcel")[0].files,
										function(i, file) {
											data.append('file', file);
										});

								$.blockUI();
								$.ajax({
											url : "<c:url value='/teachers/import-teacher-template'/>",
											cache : false,
											contentType : false,
											processData : false,
											type : 'POST',
											data : data,
											success : function(response) {
												alert(response.message);
												if (response.status === 200) {
													location.reload();
												} else {
													$.unblockUI();
												}
											},
											error : function(error) {
												$.unblockUI();
											}
										})
							}
						}
					});
});
// Puop new 	
function shownew() {
	$("#teacherNewPopup").modal("show");
}
function save_newteacher() {
	$.blockUI();
	var newfullName = document.getElementById("newfullName").value;
	var newphones = document.getElementById("newphones").value;
	var newpassword = document.getElementById("newpassword").value;
	var newmail = document.getElementById("newmail").value;
	var newaddress = document.getElementById("newaddress").value;
	var newsgender = document.getElementById("newsgender").value;
	var newstatus = document.getElementById("newstatus").value;
	var formData = new FormData();
	formData.append('name', newfullName);
	formData.append('phone', newphones);
	formData.append('pass', newpassword);
	formData.append('email', newmail);
	formData.append('address', newaddress);
	formData.append('gender', newsgender);
	formData.append('status', newstatus);

	console.log(formData);

	$.ajax({
		url : "<c:url value ='/teachers/save-new-teacher '/>",
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
	$("#teacherEditPupop").modal("show");
	$.blockUI();
	$.ajax({
		url : "<c:url value='/teachers/edit-teacher-model' />",
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
	$("#teacherViewPupop").modal("show");
	$.blockUI();
	$.ajax({
		url : "<c:url value='/teachers/view-teacher-model' />",
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
function save_editteacher(id) {
	$.blockUI();
	var edtfullName = document.getElementById("edtfullName").value;
	var edtphones = document.getElementById("edtphones").value;
	var edtmail = document.getElementById("edtmail").value;
	var edtaddress = document.getElementById("edtaddress").value;
	var edtgender = document.getElementById("edtgender").value;

	var edtstatus = document.getElementById("edtstatus").value;
	var formData = new FormData();
	formData.append('id', id);
	formData.append('name', edtfullName);
	formData.append('phone', edtphones);
	formData.append('email', edtmail);
	formData.append('address', edtaddress);
	formData.append('gender', edtgender);
	
	formData.append('status', edtstatus);

	console.log(formData);

	$.ajax({
		url : "<c:url value='/teachers/save-edit-teacher' />",
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

function search_name() {
	$.blockUI();
	$("#teacher_list_1").show();
	$("#teacher_full").hide();
	var teacher_id = document.getElementById("teacher_id_ser").value;
	$.ajax({
		url : "<c:url value='/teachers/search_name' />",
		type : 'GET',
		data : {
			id : teacher_id
		},
		success : function(response) {
			$.unblockUI();
			$("#teacher_list_1").html(response);
		},
		error : function(error) {
			$.unblockUI();
			alert(error);
		}
	});
}
function search_phone() {
	$.blockUI();
	$("#teacher_list_1").show();
	$("#teacher_full").hide();
	var teacher_id = document.getElementById("phone_id_ser").value;
	$.ajax({
		url : "<c:url value='/teachers/search_phone' />",
		type : 'GET',
		data : {
			id : teacher_id
		},
		success : function(response) {
			$.unblockUI();
			$("#teacher_list_1").html(response);
		},
		error : function(error) {
			$.unblockUI();
			alert(error);
		}
	});
}

</script>
