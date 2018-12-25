<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div data-scroll-to-active="true"
	class="main-menu menu-fixed menu-light menu-accordion">
	<div class="main-menu-content">
		<ul id="main-menu-navigation" data-menu="menu-navigation"
			class="navigation navigation-main">
			
<li class="nav-item"><a href="<c:url value='/teachers' />"><i
					class="ft-users"></i><span data-i18n="" class="menu-title">Giáo viên</span></a></li>
		<li class="nav-item"><a href="<c:url value='/students' />"><i
					class="ft-shopping-cart"></i><span data-i18n="" class="menu-title">Học sinh</span></a></li>
			
			
<li class="nav-item"><a href="<c:url value='/class' />"><i
					class="ft-users"></i><span data-i18n="" class="menu-title">Lớp</span></a></li>
			
<li class="nav-item"><a href="<c:url value='/scores' />"><i
					class="ft-calendar"></i><span data-i18n="" class="menu-title">Bảng điểm</span></a></li>
<li class="nav-item"><a href="<c:url value='/decentralizations' />"><i
					class="fa fa-newspaper-o"></i><span data-i18n="" class="menu-title">Phân quyền</span></a></li>

					
			<li class="nav-item"><a
				href="<c:url value='/revenue_activities' />"><i
					class="fa fa-line-chart"></i><span data-i18n="" class="menu-title">Báo
						cáo</span></a>
				<ul class="menu-content">
					
					<li><a href="<c:url value='/report_customers' />"
						class="menu-item">Thống kê điểm của học sinh</a></li>
						<li><a href="<c:url value='' />"
						class="menu-item">Thống kê xếp loại học sinh</a></li>
						
					
				</ul></li>
			
		</ul>


	</div>
</div>