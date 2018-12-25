<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div data-scroll-to-active="true"
	class="main-menu menu-fixed menu-light menu-accordion">
	<div class="main-menu-content">
		<ul id="main-menu-navigation" data-menu="menu-navigation"
			class="navigation navigation-main">
			
<li class="nav-item"><a href="<c:url value='/customers' />"><i
					class="ft-users"></i><span data-i18n="" class="menu-title">Khách hàng</span></a></li>
		<li class="nav-item"><a href="<c:url value='/orders' />"><i
					class="ft-shopping-cart"></i><span data-i18n="" class="menu-title">Đơn hàng</span></a></li>
			
			
<li class="nav-item"><a href="<c:url value='' />"><i
					class="ft-users"></i><span data-i18n="" class="menu-title">Nhân viên</span></a></li>
			
<li class="nav-item"><a href="<c:url value='' />"><i
					class="ft-calendar"></i><span data-i18n="" class="menu-title">Bảo hành</span></a></li>
<li class="nav-item"><a href="<c:url value='' />"><i
					class="fa fa-newspaper-o"></i><span data-i18n="" class="menu-title">Phân quyền</span></a></li>

					
			<li class="nav-item"><a
				href="<c:url value='/revenue_activities' />"><i
					class="fa fa-line-chart"></i><span data-i18n="" class="menu-title">Báo
						cáo</span></a>
				<ul class="menu-content">
					
					<li><a href="<c:url value='/report_customers' />"
						class="menu-item">Thống kê khách hàng</a></li>
						<li><a href="<c:url value='' />"
						class="menu-item">Thống kê Doanh thu</a></li>
						<li><a href="<c:url value='' />"
						class="menu-item">Thống kê chi phí</a></li>
						<li><a href="<c:url value='' />"
						class="menu-item">Thống kê đơn hàng</a></li>
					
				</ul></li>
			
		</ul>


	</div>
</div>