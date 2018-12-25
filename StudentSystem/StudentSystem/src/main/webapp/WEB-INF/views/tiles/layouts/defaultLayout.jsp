<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i"
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
	href="<c:url value='/static/vendors/css/extensions/unslider.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/vendors/css/weather-icons/climacons.min.css' />">

<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/vendors/css/pickers/daterange/daterangepicker.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/vendors/css/pickers/datetime/bootstrap-datetimepicker.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/vendors/css/pickers/pickadate/pickadate.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/fonts/meteocons/style.css' />">

<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/vendors/css/calendars/fullcalendar.min.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/vendors/css/forms/selects/select2.min.css' />">

<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/vendors/css/forms/tags/tagging.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/vendors/css/forms/tags/bootstrap-tagsinput.css' />">

<link rel="stylesheet" type="text/css" media="screen"
	href="<c:url value='/static/css/multi-select.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/vendors/css/charts/morris.css' />">
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
	href="<c:url value='/static/css/plugins/pickers/daterange/daterange.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/fonts/simple-line-icons/style.min.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/fonts/meteocons/style.min.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/css/pages/users.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/vendors/css/forms/toggle/switchery.min.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/css/plugins/forms/switch.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/vendors/css/plugins/calendars/fullcalendar.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/css/pages/timeline.css' />">

<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/vendors/css/kanban/jkanban.css' />">
	
	<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/vendors/css/kanban/jkanban.min.css' />">
	
	<!-- define css kanban board  -->
	
	<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/css/style.css' />">
	
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/css/plugins/forms/wizard.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/static/css/core/menu/menu-types/horizontal-menu.css' />">
<!--  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/easy-autocomplete/1.3.5/easy-autocomplete.min.css"> 
	-->
<!-- END Page Level CSS-->

<title><tiles:getAsString name="title" /> -Student System</title>

<style type="text/css">
.error {
	color: #ff0000;
	font-style: italic;
}
</style>



	<script type="text/javascript">
		var pageSettings = {
				webPath : '<c:url value='http://localhost:8080' />',
				apiPath : '<c:url value='/' />'
		    };
	</script>
	
 <script src="https://www.gstatic.com/firebasejs/5.0.0/firebase.js"></script>
	 <script>
		// Initialize Firebase
		var config = {
			apiKey : "AIzaSyApTBf0cOrcJ8bdWCbWbdfEiAw5hEnsdYI",
			authDomain : "eteacher-2018.firebaseapp.com",
			databaseURL : "https://eteacher-2018.firebaseio.com",
			projectId : "eteacher-2018",
			storageBucket : "",
			messagingSenderId : "595576417077"
		};
		firebase.initializeApp(config);
	</script>

</head>

<body data-open="click" data-menu="vertical-menu" data-col="2-columns"
	class="vertical-layout vertical-menu 2-columns   menu-expanded fixed-navbar">	
	
		<sec:authorize access="isAuthenticated()"> 
		<section id="header">
			<tiles:insertAttribute name="header" />
		</section>
	
			<section id="sidemenu">
			<sec:authorize access="hasAuthority('ADMIN')">
				<tiles:insertAttribute name="menu" />
			</sec:authorize>
			<sec:authorize access="hasAuthority('USER')">
				<tiles:insertAttribute name="menu_user" />
			</sec:authorize>
			
		</section>
	</sec:authorize>
	
	
	
<!-- BEGIN VENDOR JS-->

	<script src="<c:url value='/static/vendors/js/vendors.min.js'/>"
		type="text/javascript"></script>

	<script src="<c:url value='/static/vendors/js/extensions/moment.min.js'/>"
		type="text/javascript"></script>

	<script src="<c:url value='/static/vendors/js/charts/raphael-min.js'/>"
		type="text/javascript"></script>
		
		<script src="<c:url value='/static/vendors/js/pickers/dateTime/moment-with-locales.min.js' />" type="text/javascript"></script>
    <script src="<c:url value='/static/vendors/js/pickers/dateTime/bootstrap-datetimepicker.min.js' />" type="text/javascript"></script>
    <script src="<c:url value='/static/vendors/js/pickers/pickadate/picker.js' />" type="text/javascript"></script>
    <script src="<c:url value='/static/vendors/js/pickers/pickadate/picker.date.js' />" type="text/javascript"></script>
    <script src="<c:url value='/static/vendors/js/pickers/pickadate/picker.time.js' />" type="text/javascript"></script>
    <script src="<c:url value='/static/vendors/js/pickers/pickadate/legacy.js' />" type="text/javascript"></script>
    <script src="<c:url value='/static/vendors/js/pickers/daterange/daterangepicker.js' />" type="text/javascript"></script>
		<script src="<c:url value='/static/vendors/js/ckeditor/ckeditor.js'/>" type="text/javascript"></script>
  <%--  <script src="<c:url value='/static/vendors/js/charts/morris.min.js'/>"
		type="text/javascript"></script> --%>
		
	<script src="<c:url value='/static/vendors/js/extensions/unslider-min.js'/>"
		type="text/javascript"></script>
	<script src="<c:url value='/static/vendors/js/timeline/horizontal-timeline.js'/>"
		type="text/javascript"></script>

	<script src="<c:url value='/static/vendors/js/forms/toggle/bootstrap-checkbox.min.js'/>"
		type="text/javascript"></script>
	<script src="<c:url value='/static/vendors/js/forms/toggle/switchery.min.js'/>"
		type="text/javascript"></script>
	<script src="//maps.googleapis.com/maps/api/js?key=AIzaSyBDkKetQwosod2SZ7ZGCpxuJdxY3kxo5Po"
		type="text/javascript"></script>

	<script src="<c:url value='/static/vendors/js/charts/gmaps.min.js'/>"
		type="text/javascript"></script>
		
		
	<script src="<c:url value='/static/vendors/js/extensions/jquery.knob.min.js'/>"
		type="text/javascript"></script>


	<script src="<c:url value='/static/vendors/js/ui/jquery.sticky.js'/>"
		type="text/javascript"></script>
		
	<script src="<c:url value='/static/vendors/js/charts/jquery.sparkline.min.js'/>"
		type="text/javascript"></script>


	<script src="<c:url value='/static/vendors/js/forms/select/select2.full.min.js'/>"
		type="text/javascript"></script>
		

	<script src="<c:url value='/static/vendors/js/extensions/fullcalendar.min.js'/>"
		type="text/javascript"></script>
	<script src="<c:url value='/static/vendors/js/ui/jquery-ui.min.js'/>"
		type="text/javascript"></script>
		
	<script src="<c:url value='/static/vendors/js/forms/tags/tagging.min.js'/>"
		type="text/javascript"></script>
	<script src="<c:url value='/static/vendors/js/charts/echarts/echarts.js'/>"
		type="text/javascript"></script>

	<script src="<c:url value='/static/vendors/js/forms/repeater/jquery.repeater.min.js'/>"
		type="text/javascript"></script>
			<script src="<c:url value='/static/js/jquery.blockUI.js' />" type="text/javascript"></script>
		

	

<script src="<c:url value='/static/vendors/js/extensions/jquery.steps.min.js'/>"
		type="text/javascript"></script>
	<!-- END PAGE VENDOR JS-->


	<!-- BEGIN STACK JS-->
	<script src="<c:url value='/static/js/core/app-menu.js'/>"
		type="text/javascript"></script>
	<script src="<c:url value='/static/js/core/app.js'/>"
		type="text/javascript"></script>
	<!-- END STACK JS-->



	<!-- BEGIN PAGE JS -->
<script src="<c:url value='/static/js/core/dashboard-ecommerce.js'/>"
		type="text/javascript"></script>
	<%--<script src="<c:url value='/static/js/scripts/pages/dashboard-ecommerce.js'/>"
		type="text/javascript"></script> --%>
	<script src="<c:url value='/static/js/core/jquery.multi-select.js'/>"
		type="text/javascript"></script>

	<script src="<c:url value='/static/js/scripts/forms/tags/tagging.js'/>"
		type="text/javascript"></script>

	<script src="<c:url value='/static/js/scripts/forms/form-repeater.js'/>"
		type="text/javascript"></script>

	<script src="<c:url value='/static/js/scripts/forms/select/form-select2.js'/>"
		type="text/javascript"></script>


	<script src="<c:url value='/static/js/core/customer.js'/>"
		type="text/javascript"></script>

	<script src="<c:url value='/static/js/core/order.js'/>"
		type="text/javascript"></script>

	<script src="<c:url value='/static/js/core/project.js'/>"
		type="text/javascript"></script>

	<script src="<c:url value='/static/js/core/request_class.js'/>"
		type="text/javascript"></script>
	
	<script src="<c:url value='/static/js/core/report.js'/>"
		type="text/javascript"></script>

	<script src="<c:url value='/static/js/core/task.js'/>"
		type="text/javascript"></script>
	
	<script src="<c:url value='/static/js/core/subject.js'/>"
		type="text/javascript"></script>
		
		
		
		

	<script src="<c:url value='/static/js/scripts/ui/breadcrumbs-with-stats.js'/>"
		type="text/javascript"></script>
		
	<script src="<c:url value='/static/js/core/pipelinestage.js'/>"
		type="text/javascript"></script>
		
		
		<!-- define js kanban board -->
		<script src="<c:url value='/static/js/scripts/kanban/jkanban.js'/>"
		type="text/javascript"></script>
		
		<script src="<c:url value='/static/js/scripts/kanban/jkanban.min.js'/>"
		type="text/javascript"></script>
		
		

	<!-- END PAGE JS -->

	

	<div class="app-content content container-fluid">
		<div class="content-wrapper">
			<div class="content-header row"></div>
			<div class="content-body">
				<section id="site-content">
					<tiles:insertAttribute name="body" />
				</section>
			</div>
		</div>
	</div>
	
	<footer id="footer">
			<tiles:insertAttribute name="footer" />
	</footer>
<script type="text/javascript">
		$(function() {
			if (typeof $(".input-ckeditor").val() !== "undefined") {
                CKEDITOR.replaceClass = 'input-ckeditor';
            }
			customerFunction.init();
			taskFunction.initTask();
			requestClassFunction.initRequestClass();
			orderFunction.initOrder();
			reportFunction.initReport();
			subjectFunction.initSubject(); 
			pipelineFunction.initPipeline();
			// run pre selected options
			if (typeof $("#callbacks").val() != "undefined") {
				var save_value=  $('#callbacks').val() ;
				$('#callbacks').multiSelect({
					afterSelect : function(values) {
						/*alert("Select value: "+values);*/
						save_value= save_value +"," + values  ; 
						document.getElementById("mytext").value = save_value;
						console.log(values);
						
					},
					afterDeselect : function(values) {
						/* alert("Deselect value: "+values); */
						save_value = save_value - values -"," ; 
					}
				});
			}

			// run pre selected options
			if (typeof $("#callbackTask").val() != "undefined") {
				$('#callbackTask').multiSelect({
					afterSelect : function(values) {
						//alert("Select value: "+values); //
					},
					afterDeselect : function(values) {
						/* alert("Deselect value: "+values); */
						
						
					}
				});
			}

		});
	</script>

	<script type="text/javascript">
		$(function() {
			var database = firebase.database();
			var notifyOrderRef = database
					.ref('repair_service/orders');
			var notifyTaskRef = database
					.ref('repair_service/tasks');

			notifyOrderRef
					.on(
							'child_changed',
							function(data) {
								if (data.val().status == 1) {
									toastr
											.warning(
													'<a style="color: white;" href="${ordersUrl}?status=1" target="_blank">Chờ thanh toán</a>',
													'<a style="color: white;" href="${ordersUrl}?status=1" target="_blank">Đơn hàng #'
															+ data.key + '</a>',
													{
														"showDuration" : 500,
														"hideDuration" : 5000
													});
								}
							});
			notifyOrderRef.on('child_added', function(data) {
				if (data.val().status == 0) {
					getOrderDetailNotification();
				}
			});

			notifyTaskRef.on('child_added', function(data) {
				if (data.val().status == 0) {
					getNewTaskNotification();
				}
			});

		});

		function getOrderDetailNotification() {
			$.ajax({
				url : "<c:url value='/orders/count-new-order-detail' />",
				type : 'GET',
				success : function(response) {
					$("#orderDetailNotification").html(response);
				},
				error : function(error) {
				}
			});
		};
		function getNewTaskNotification() {
			$.ajax({
				url : "<c:url value='/tasks/notification-new-task' />",
				type : 'GET',
				success : function(response) {
					$("#taskNotification").html(response);
				},
				error : function(error) {
				}
			});
		};

		function getParameterByName(name, url) {
			if (!url)
				url = window.location.href;
			name = name.replace(/[\[\]]/g, "\\$&");
			var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"), results = regex
					.exec(url);
			if (!results)
				return null;
			if (!results[2])
				return '';
			return decodeURIComponent(results[2].replace(/\+/g, " "));
		};
		function copyInputValueToClipboard(inputElement) {
			var $temp = $("<input>");
			$("body").append($temp);
			$temp.val($(inputElement).val()).select();
			document.execCommand("copy");
			$temp.remove();
		};

		function downloadFile(url, extension) {
			url = document.location.origin + url;
			var fullfilename = url.substring(url.lastIndexOf('/') + 1).split(
					'?')[0];
			var filename = fullfilename.split('.')[0];
			//var extension = '.xlsx';
			var filename_tosave = filename + extension;
			var xhr = new XMLHttpRequest();
			xhr.responseType = 'blob';
			xhr.onload = function() {
				var a = document.createElement('a');
				a.href = window.URL.createObjectURL(xhr.response); // xhr.response is a blob
				a.download = filename_tosave;
				a.style.display = 'none';
				document.body.appendChild(a);
				a.click();
				delete a;
			};
			xhr.open('GET', url);
			xhr.send();
		}
	</script>

</body>
</html>