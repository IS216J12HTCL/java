<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta name="description"
	content="Stack admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
<meta name="keywords"
	content="admin template, stack admin template, dashboard template, flat admin template, responsive admin template, web app">
<meta name="author" content="PIXINVENT">
<link rel="apple-touch-icon"
	href="<c:url value='/static/images/ico/apple-icon-120.png' />">
<link rel="shortcut icon" type="image/x-icon"
	href="<c:url value='/static/images/ico/favicon.ico' />">
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i"
	rel="stylesheet">
<!-- BEGIN VENDOR CSS-->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/css/bootstrap.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/fonts/feather/style.min.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/fonts/font-awesome/css/font-awesome.min.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/fonts/flag-icon-css/css/flag-icon.min.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/vendors/css/extensions/pace.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/vendors/css/forms/icheck/icheck.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/vendors/css/forms/icheck/custom.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/vendors/css/charts/morris.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/vendors/css/extensions/unslider.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/vendors/css/weather-icons/climacons.min.css' />">
<!-- END VENDOR CSS-->
<!-- BEGIN STACK CSS-->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/css/bootstrap-extended.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/css/app.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/css/colors.css' />">
<!-- END STACK CSS-->
<!-- BEGIN Page Level CSS-->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/css/core/menu/menu-types/vertical-menu.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/css/core/menu/menu-types/vertical-overlay-menu.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/css/core/colors/palette-climacon.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/css/core/colors/palette-gradient.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/fonts/simple-line-icons/style.min.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/fonts/meteocons/style.min.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/css/pages/users.css' />">
<!-- END Page Level CSS-->
<!-- BEGIN Custom CSS-->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/css/style.css' />">

<title><tiles:getAsString name="title" /></title>
</head>

<body data-open="click" data-menu="vertical-menu" data-col="1-column"
	class="vertical-layout vertical-menu 1-column   menu-expanded blank-page blank-page">
	<tiles:insertAttribute name="body" />

	<!-- BEGIN VENDOR JS-->
	<script src="<c:url value='/static/vendors/js/vendors.min.js' />"
		type="text/javascript"></script>
	<!-- BEGIN VENDOR JS-->
	<!-- BEGIN PAGE VENDOR JS-->
	<script
		src="//maps.googleapis.com/maps/api/js?key=AIzaSyBDkKetQwosod2SZ7ZGCpxuJdxY3kxo5Po"
		type="text/javascript"></script>
	<script
		src="<c:url value='/static/vendors/js/charts/gmaps.min.js" type="text/javascript' />"></script>
	<script
		src="<c:url value='/static/vendors/js/forms/icheck/icheck.min.js" type="text/javascript' />"></script>
	<script
		src="<c:url value='/static/vendors/js/extensions/jquery.knob.min.js" type="text/javascript' />"></script>
	<script
		src="<c:url value='/static/vendors/js/charts/raphael-min.js" type="text/javascript' />"></script>
	<script
		src="<c:url value='/static/vendors/js/charts/jquery.sparkline.min.js" type="text/javascript' />"></script>
	<script
		src="<c:url value='/static/vendors/js/extensions/unslider-min.js" type="text/javascript' />"></script>
	<script
		src="<c:url value='/static/vendors/js/charts/echarts/echarts.js" type="text/javascript' />"></script>

<!-- add more -->
	<script src="<c:url value='/static/vendors/js/ckeditor/ckeditor.js'/>"
		type="text/javascript"></script>
		
		<script src="<c:url value='/static/js/core/customer.js'/>"
		type="text/javascript"></script>
			<script src="<c:url value='/static/js/core/task.js'/>"
		type="text/javascript"></script>
		
		
		
	<!-- END PAGE VENDOR JS-->
	<!-- BEGIN STACK JS-->
	<script
		src="<c:url value='/static/js/core/app-menu.js" type="text/javascript' />"></script>
	<script
		src="<c:url value='/static/js/core/app.js" type="text/javascript' />"></script>
	<!-- END STACK JS-->

</body>
</html>

<script type="text/javascript">
		$(function() {
			customerFunction.init();
			
</script>
