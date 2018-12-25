<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- Meta, title, CSS, favicons, etc. -->
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title><tiles:getAsString name="title" /></title>
	
	<!-- Bootstrap core CSS -->
	
	<link href="<c:url value='/static/css/bootstrap.min.css' />" rel="stylesheet">
	
	<link href="<c:url value='/static/fonts/css/font-awesome.min.css' />" rel="stylesheet" >
	<link href="<c:url value='/static/css/animate.min.css' />" rel="stylesheet">
	
	<!-- Custom styling plus plugins -->
	<link href="<c:url value='/static/css/custom.css' />" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="<c:url value='/static/css/maps/jquery-jvectormap-2.0.3.css' />" />
	<link href="<c:url value='/static/css/icheck/flat/green.css' />" rel="stylesheet" />
	<link href="<c:url value='/static/css/floatexamples.css' />" rel="stylesheet" type="text/css" />
	
	<script src="<c:url value='/static/js/jquery.min.js' />"></script>
	<script src="<c:url value='/static/js/jquery.blockUI.js' />"></script>
	<script src="<c:url value='/static/js/nprogress.js' />"></script>
	
	<%-- <link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link> --%>
</head>
 
<body style="background-color: white">
	<tiles:insertAttribute name="body" />

  <script src="<c:url value='/static/js/bootstrap.min.js' />"></script>

  <!-- gauge js -->
  <%-- <script type="text/javascript" src="<c:url value='/static/js/gauge/gauge.min.js' />"></script>
  <script type="text/javascript" src="<c:url value='/static/js/gauge/gauge_demo.js' />"></script> --%>
  <!-- bootstrap progress js -->
  <script src="<c:url value='/static/js/progressbar/bootstrap-progressbar.min.js' />"></script>
  <script src="<c:url value='/static/js/nicescroll/jquery.nicescroll.min.js' />"></script>
  <!-- icheck -->
  <script src="<c:url value='/static/js/icheck/icheck.min.js' />"></script>
  <!-- daterangepicker -->
  <script type="text/javascript" src="<c:url value='/static/js/moment/moment.min.js' />"></script>
  <script type="text/javascript" src="<c:url value='/static/js/datepicker/daterangepicker.js' />"></script>
  <!-- chart js -->
  <script src="<c:url value='/static/js/chartjs/chart.min.js' />"></script>

  <script src="<c:url value='/static/js/custom.js' />"></script>
  
  <script>
    NProgress.done();
  </script>
  <!-- /datepicker -->
  
</body>
</html>