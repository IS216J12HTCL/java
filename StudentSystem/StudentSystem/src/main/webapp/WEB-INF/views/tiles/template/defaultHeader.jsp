<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!-- top navigation -->
<nav
	class="header-navbar navbar navbar-with-menu navbar-fixed-top navbar-light navbar-border">
	<div class="navbar-wrapper">
		<div class="navbar-header">
			<ul class="nav navbar-nav">
				<li class="nav-item mobile-menu hidden-md-up float-xs-left"><a
					href="#" class="nav-link nav-menu-main menu-toggle hidden-xs"><i
						class="ft-menu font-large-1"></i></a></li>
			<li class="nav-item"><a href="<c:url value='/' />" class="navbar-brand"></a></li>
				<li class="nav-item"><a href="<c:url value='/' />"
					class="navbar-brand"><img
						alt="Student System"
						style="max-width: 30px; max-height: 30px;"
						src="<c:url value='/static/images/logo/stack-logo.png' />"
						class="brand-logo">
						<h2 class="brand-text">
							Student System</h2>
						</a>
						 </li>
				<li class="nav-item hidden-md-up float-xs-right"><a
					data-toggle="collapse" data-target="#navbar-mobile"
					class="nav-link open-navbar-container"><i
						class="fa fa-ellipsis-v"></i></a></li>
			</ul>
		</div>
		<div class="navbar-container content container-fluid">
			<div id="navbar-mobile" class="collapse navbar-toggleable-sm">
				<ul class="nav navbar-nav">
					<li class="nav-item hidden-sm-down"><a href="#"
						class="nav-link nav-menu-main menu-toggle hidden-xs"><i
							class="ft-menu"></i></a></li>
					<li class="dropdown nav-item mega-dropdown"><a
						href="javascript:void(0);" class="nav-link">
					</a></li>
				</ul>
				<ul class="nav navbar-nav float-xs-right">

				<li class="dropdown dropdown-notification nav-item" id="orderDetailNotification">
						
					</li>

					<li class="dropdown dropdown-user nav-item"><a href="#"
						data-toggle="dropdown"
						class="dropdown-toggle nav-link dropdown-user-link"><span
							class="avatar avatar-online"><img
								src="<c:url value='/static/images/portrait/small/avatar-s-1.png' />"
								alt="avatar"><i></i></span><span class="user-name"> : <strong>${pageContext.request.userPrincipal.name}</strong>
						</span></a>
						<div class="dropdown-menu dropdown-menu-right">

							<a href="<c:url value='/profile' />" class="dropdown-item"><i class="ft-user"></i>
								Tài khoản</a><a href="<c:url value='/doi-mat-khau' />"  class="dropdown-item">
								<i class="ft-mail"></i> Đổi mật khẩu
							</a>
							<div class="dropdown-divider"></div>
							<a href="<c:url value='/dang-xuat' />" class="dropdown-item"><i
								class="ft-power"></i> Đăng xuất</a>
						</div></li>
				</ul>
			</div>
		</div>
	</div>
</nav>
<!-- /top navigation -->