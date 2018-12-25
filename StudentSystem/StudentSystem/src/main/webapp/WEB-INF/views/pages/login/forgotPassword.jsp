<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}
</style>
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<div class="content-header row"></div>
		<div class="content-body">
			<section class="flexbox-container">
				<div
					class="col-md-4 offset-md-4 col-xs-10 offset-xs-1  box-shadow-2 p-0">
					<div class="card border-grey border-lighten-3 m-0">
						<div class="card-header no-border">
							<div class="card-title text-xs-center">
								<div class="p-1">
									<img src="<c:url value='/static/images/logo/stack-logo-dark.png' />"
										alt="branding logo">
								</div>
							</div>
							<h6
								class="card-subtitle line-on-side text-muted text-xs-center font-small-3 pt-2">
								<span>Khôi phục mật khẩu</span>
							</h6>
						</div>
						<div class="card-body collapse in">
							<div class="card-block">
								<div class="card-text">
									<c:if test="${not empty error}">
										<div class="error">${error}</div>
									</c:if>
									<c:if test="${not empty msg}">
										<div class="msg">${msg}</div>
									</c:if>
								</div>
								<form class="form-horizontal form-simple" action="<c:url value='/reset-password' />" method='POST' >
									<fieldset
										class="form-group position-relative has-icon-left mb-0">
										<input type="text"
											class="form-control form-control-lg input-lg" id="phone"
											placeholder="Phone" name="phone" required>
										<div class="form-control-position">
											<i class="ft-user"></i>
										</div>
									</fieldset>
									<fieldset class="form-group row">
										<div class="col-md-6 col-xs-12 text-xs-center text-md-left">
										</div>
										<div class="col-md-6 col-xs-12 text-xs-center text-md-right">
											<a href="<c:url value='/dang-nhap' />" class="card-link">Quay lại trang đăng nhập</a>
										</div>
									</fieldset>
									<button type="submit" class="btn btn-primary btn-lg btn-block">
										<i class="ft-unlock"></i> Gửi
									</button>
								</form>
							</div>
						</div>
						
					</div>
				</div>
			</section>
		</div>
	</div>
</div>