<%@ page session="true" %>
<%@ page import="org.apache.velocity.runtime.directive.Foreach" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="row">
	<div class="col-xs-12">
		<div class="card">
			<div class="card-header">
				<h4 class="card-title" id="horz-layout-card-center">
					Thay đổi mật khẩu
				</h4>
				<a class="heading-elements-toggle"><i
					class="fa fa-ellipsis-v font-medium-3"></i></a>
			</div>
			<div class="card-body collapse in">
				<div class="card-block">
					<div class="card-text" style="margin-left: 40%;margin-bottom: 20px;">
						<c:if test="${not empty msg}">
							<div class="msg">${msg}</div>
						</c:if>
					</div>
					<form class="form form-horizontal" action="<c:url value='admin/changePassword' />" method='POST' >
						<div class="form-body">
							<div class="form-group row">
								<label class="col-md-3 label-control" for="username">Nhập mật khẩu cũ(*)</label>
								<div class="col-md-9">
									<input type="password" class="form-control" id="oldPassword" placeholder="Mật khẩu cũ" name="oldPassword" required>
									<c:if test="${not empty errorOldPassword}">
										<span class="error">${errorOldPassword}</span>
									</c:if>
								</div>
							</div>
							<div class="form-group row">
								<label class="col-md-3 label-control" for="username">Nhập mật khẩu mới(*)</label>
								<div class="col-md-9">
									<input type="password" class="form-control" id="newPassword" placeholder="Mật khẩu mới" name="newPassword" required>
									<c:if test="${not empty errorNewPassword}">
										<span class="error">${errorNewPassword}</span>
									</c:if>
								</div>
							</div>
							<div class="form-group row">
								<label class="col-md-3 label-control" for="username">Xác nhận mật khẩu mới(*)</label>
								<div class="col-md-9">
									<input type="password" class="form-control" id="confirmPassword" placeholder="Xác nhận mật khẩu" name="confirmPassword" required>
									<c:if test="${not empty errorConfirmPassword}">
										<span class="error">${errorConfirmPassword}</span>
									</c:if>
								</div>
							</div>
							
						<div class="form-actions center">
							<button onclick="location.href='<c:url value='' />'" type="button" class="btn btn-warning mr-1">
								<i class="ft-arrow-left"></i> Quay lại
							</button>
							<button type="submit" class="btn btn-primary">
								<i class="ft-save"></i> Thay đổi
							</button>
						</div>
					</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>