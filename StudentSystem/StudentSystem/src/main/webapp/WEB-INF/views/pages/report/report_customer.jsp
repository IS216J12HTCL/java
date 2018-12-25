<%@page import="org.apache.velocity.runtime.directive.Foreach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld"%>


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
					<form class="form form-horizontal form-bordered"
						action="<c:url value='report_customers' />" method='GET'>
						<div class="form-body">
							<div class="form-group row">
								<label class="col-md-3 label-control">Bắt đầu</label> 
								<div class="col-md-5"><input type="date" class="form-control"
									name="fromDateString" data-toggle="tooltip"
									data-trigger="hover" data-placement="top"
									data-title="Date Opened"></div>
								<!-- <input type="date" name="fromDateString"
									class="form-control"  /> -->
							</div>
							<div class="form-group row">
								<label class="col-md-3 label-control">Kết thúc</label> 
								<div class="col-md-5"><input type="date" class="form-control"
									name="toDateString" data-toggle="tooltip" data-trigger="hover"
									data-placement="top" data-title="Date Opened"></div>
								<!-- 	<input type="date" name="toDateString"
									class="form-control"  /> -->
							</div>

							<div class="form-actions center">
								<button type="button" class="btn btn-warning mr-1"
									onclick="reset()">
									<i class="ft-x"></i> Reset
								</button>
								<button type="submit" class="btn btn-primary">
									<i class="ft-search"></i> Tìm kiếm
								</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="row">
	<div class="col-xl-12 col-lg-12">
		<div class="card">

			<div class="card-body">

				<div class="card-header">
					<h4 class="card-title">Thống kê khách hàng</h4>
					<a class="heading-elements-toggle"><i
						class="fa fa-ellipsis-v font-medium-3"></i></a>
				</div>
				<div class="card-block">

					<ul class="nav nav-tabs nav-underline no-hover-bg">
						<li class="nav-item"><a class="nav-link active"
							id="base-tab31" data-toggle="tab" aria-controls="tab31"
							href="#tab31" aria-expanded="true">THỐNG KÊ NGÀY</a></li>
						<li class="nav-item"><a class="nav-link" id="base-tab32"
							data-toggle="tab" aria-controls="tab32" href="#tab32"
							aria-expanded="false">THỐNG KÊ TUẦN</a></li>
						<li class="nav-item"><a class="nav-link" id="base-tab33"
							data-toggle="tab" aria-controls="tab33" href="#tab33"
							aria-expanded="false">THỐNG KÊ THÁNG</a></li>

						<li class="nav-item"><a class="nav-link" id="base-tab34"
							data-toggle="tab" aria-controls="tab34" href="#tab34"
							aria-expanded="false">THỐNG KÊ NĂM</a></li>

					</ul>

					<!-- ========= form tab 1 ======== -->

					<div class="tab-content px-1 pt-1">
						<div role="tabpanel" class="tab-pane active" id="tab31"
							aria-expanded="true" aria-labelledby="base-tab31">
							<section id="chartjs-line-charts">
								<!-- Line Chart -->
								<div class="row">
									<div class="col-xs-12">
										<div class="card">
											<div class="card-header">
												<!-- Pie chart -->
												<div class="col-sm-12">
									<div id="pie_chart"></div>
								</div>
								<!-- Line chart -->
								<div class="col-sm-12">
									<div id="line_chart"></div>
								</div>
								<!-- Line chart -->
								<div class="col-sm-12">
									<div id="bar_chart"></div>
								</div>
												<div class="row">
													<div class="col-xs-12">
														<div class="card">
															<div class="card-header">
																<h4 class="card-title" id="horz-layout-card-center">Thông
																	tin thống kê</h4>
															</div>
															<div class="dataTables_scroll" align="right">
																<button type="button" onclick="downloadDayTemplate()"
																	class="btn btn-icon btn-primary mr-1">
																	<i class="fa fa-download" style="color: #fff"></i>
																</button>
																<div class="card-body collapse in">
																	<div class="table-responsive">
																		<table class="table table-bordered mb-0">
																			<thead>
																				<tr>
																					<th>Ngày</th>
																					<th>Doanh thu</th>
																				</tr>
																			</thead>
																			<tbody>
																				<c:forEach items="${pieDataList}" var="entry">
																					<tr>

																						<td>${entry.key}</td>
																						<td>${entry.value}</td>
																					</tr>
																				</c:forEach>
																			</tbody>
																		</table>
																	</div>
																</div>
															</div>
														</div>
													</div>
												</div>
												<%-- 	<img alt="Google Pie Chart" src="${pieUrl}" /> --%>
												<!-- <div id="piechart_3d" style="width: 900px; height: 500px;"></div> -->
											</div>
										</div>
									</div>
								</div>
							</section>
						</div>
						<!-- end line-charts -->
						<div class="tab-pane" id="tab32" aria-labelledby="base-tab32">
							<!-- Column Chart -->

							<div class="card-header">
								<!-- The next line rotates HTML tooltips by 30 degrees clockwise. -->
								<div id="pie_chart_week"></div>
							</div>
							<hr>
							<br>
							<div class="card-header">
								<div id="line_chart_week" ></div>
							</div>
							<hr>
							<br>
							<div class="card-header">
								<div id="bar_chart_week"></div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="card">
										<div class="card-header">
											<h4 class="card-title" id="horz-layout-card-center">Thông
												tin thống kê</h4>
										</div>
										<div class="dataTables_scroll" align="right">
											<button type="button" onclick="downloadWeekTemplate()"
												class="btn btn-icon btn-primary mr-1">
												<i class="fa fa-download" style="color: #fff"></i>
											</button>
											<div class="card-body collapse in">
												<div class="table-responsive">
													<table class="table table-bordered mb-0">
														<thead>
															<tr>
																<th>Thứ</th>
																<th>Doanh thu</th>
															</tr>
														</thead>
														<tbody>
															<c:forEach items="${weekDataList}" var="entry">
																<tr>

																	<td>${entry.key}</td>
																	<td>${entry.value}</td>
																</tr>
															</c:forEach>
														</tbody>
													</table>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="tab-pane" id="tab33" aria-labelledby="base-tab33">

							<section id="chartjs-pie-charts">
								<!--  Pie Chart -->

								<div class="card-header">
									<div id="bar_chart_month"></div>
								</div>
								<hr>
								<br>
								<div class="card-header">
									<div id="pie_chart_month"></div>
								</div>
								<hr>
								<br>
								<div class="card-header">
									<div id="line_chart_month" ></div>
								</div>
								<div class="row">
									<div class="col-xs-12">
										<div class="card">
											<div class="card-header">
												<h4 class="card-title" id="horz-layout-card-center">Thông
												tin thống kê</h4>
											</div>
											<div class="dataTables_scroll" align="right">
												<button type="button" onclick="downloadMonthTemplate()"
													class="btn btn-icon btn-primary mr-1">
													<i class="fa fa-download" style="color: #fff"></i>
												</button>
												<div class="card-body collapse in">
													<div class="table-responsive">
														<table class="table table-bordered mb-0">
															<thead>
																<tr>
																	<th>Tháng</th>
																	<th>Doanh thu</th>
																</tr>
															</thead>
															<tbody>
																<c:forEach items="${monthDataList}" var="entry">
																	<tr>
																		<td>${entry.key}</td>
																		<td>${entry.value}</td>
																	</tr>
																</c:forEach>
															</tbody>
														</table>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</section>
						</div>
						<!-- bao cao khach hang nam -->
						<div class="tab-pane" id="tab34" aria-labelledby="base-tab34">
							<section id="chartjs-pie-charts">
								<!-- Simple Pie Chart -->
								<div class="card-header">
									<div id="bar_chart_year" ></div>
								</div>
								<hr>
								<br>
								<div class="card-header">
									<div id="line_chart_year" ></div>
								</div>
								<hr>
								<br>
								<div class="card-header">
									<div id="pie_chart_year" ></div>
								</div>
								<div class="row">
									<div class="col-xs-12">
										<div class="card">
											<div class="card-header">
												<h4 class="card-title" id="horz-layout-card-center">Thông
												tin thống kê</h4>
											</div>
											<div class="dataTables_scroll" align="right">
												<button type="button" onclick="downloadYearTemplate()"
													class="btn btn-icon btn-primary mr-1">
													<i class="fa fa-download" style="color: #fff"></i>
												</button>
												<div class="card-body collapse in">
													<div class="table-responsive">
														<table class="table table-bordered mb-0">
															<thead>
																<tr>
																	<th>Năm</th>
																	<th>Doanh thu</th>
																</tr>
															</thead>
															<tbody>
																<c:forEach items="${yearDataList}" var="entry">
																	<tr>
																		<td>${entry.key}</td>
																		<td>${entry.value}</td>
																	</tr>
																</c:forEach>
															</tbody>
														</table>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</section>
						</div>
					</div>
					<!-- ============ end form tab 1 ========== -->
				</div>
			</div>
		</div>
	</div>
</div>
<!--Load the AJAX API 3D Pie Chart-->
<!--  chart google  -->
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
    // Load the Visualization API and the piechart package.
    google.load('visualization', '1.0', {
        'packages' : [ 'corechart' ]
    });
    
 	// Set a callback to run when the Google Visualization API is loaded

    // Set a callback to run when the Google Visualization API is loaded.
    google.setOnLoadCallback(drawChart);

    // Set a callback to run when the Google Visualization API is loaded.
    google.setOnLoadCallback(drawChartWeek);
    // Callback that creates and populates a data table,
    // instantiates the pie chart, passes in the data and
    
     // Set a callback to run when the Google Visualization API is loaded.
    google.setOnLoadCallback(drawMonthReport);
    
    // Set a callback to run when the Google Visualization API is loaded.
    google.setOnLoadCallback(drawYearReport);
    
    
    // draws it.
    function drawChart() {

        // Create the data table.    
        var data = google.visualization.arrayToDataTable([
                                                              ['Report', 'Khách hàng mới'],
                                                              <c:forEach items="${pieDataList}" var="entry">
                                                                  [ '${entry.key}', ${entry.value} ],
                                                              </c:forEach>
                                                        ]);
        // Set chart options
        var options = {
            'title' : 'Báo Cáo Khách Hàng Theo Ngày',
            is3D : true,
            pieSliceText: 'label',
            tooltip :  {showColorCode: true},
            'width' : 900,
            'height' : 400
        };

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.PieChart(document.getElementById('pie_chart'));
        chart.draw(data, options);
        
        var line_chart = new google.visualization.LineChart(document.getElementById('line_chart'));
        line_chart.draw(data, options);
        
        var bar_chart = new google.visualization.BarChart(document.getElementById('bar_chart'));
        bar_chart.draw(data, options);
        
        
       
    }
    
    
    function drawChartWeek(){
    	 // Create the data table.    
        var data = google.visualization.arrayToDataTable([
                                                              ['Report', 'Khách hàng mới'],
                                                              <c:forEach items="${weekDataList}" var="entry">
                                                                  [ '${entry.key}', ${entry.value} ],
                                                              </c:forEach>
                                                        ]);
        // Set chart options
       var options = {
        title: "Thống kê khách hàng mới trong Tuần",
        is3D : true,
        pieSliceText: 'label',
        tooltip :  {showColorCode: true},
        'width' : 900,
        'height' : 400
      };
        // Instantiate and draw our chart, passing in some options.
         var pieChartWeek = new google.visualization.PieChart(document.getElementById("pie_chart_week"));
         pieChartWeek.draw(data, options);
       
       var lineChartWeek = new google.visualization.LineChart(document.getElementById("line_chart_week"));
       lineChartWeek.draw(data, options);
       
       var barChartWeek = new google.visualization.ColumnChart(document.getElementById("bar_chart_week"));
       barChartWeek.draw(data, options);
    }
    
    function drawMonthReport(){
   	 // Create the data table.    
       var data = google.visualization.arrayToDataTable([
                                                             ['Report', 'Doanh Thu'],
                                                             <c:forEach items="${monthDataList}" var="entry">
                                                                 [ '${entry.key}', ${entry.value} ],
                                                             </c:forEach>
                                                       ]);
       // Set chart options
      var options = {
       title: "Báo Cáo Doanh Thu Tháng",
       is3D : true,
       pieSliceText: 'label',
       tooltip :  {showColorCode: true},
       'width' : 900,
       'height' : 400
     };
       // Instantiate and draw our chart, passing in some options.
        var pieChartMonth = new google.visualization.PieChart(document.getElementById("pie_chart_month"));
        pieChartMonth.draw(data, options);
      
      var lineChartMonth = new google.visualization.LineChart(document.getElementById("line_chart_month"));
      lineChartMonth.draw(data, options);
      
      var barChartMonth = new google.visualization.ColumnChart(document.getElementById("bar_chart_month"));
      barChartMonth.draw(data, options);
   }
    
    function drawYearReport(){
      	 // Create the data table.    
          var data = google.visualization.arrayToDataTable([
                                                                ['Report', 'Doanh Thu'],
                                                                <c:forEach items="${yearDataList}" var="entry">
                                                                    [ '${entry.key}', ${entry.value} ],
                                                                </c:forEach>
                                                          ]);
          // Set chart options
         var options = {
          title: "Báo Cáo Doanh Thu Năm",
          is3D : true,
          pieSliceText: 'label',
          tooltip :  {showColorCode: true},
          'width' : 900,
          'height' : 400
        };
          // Instantiate and draw our chart, passing in some options.
         var barChartYear = new google.visualization.ColumnChart(document.getElementById("bar_chart_year"));
         barChartYear.draw(data, options);
         
         var lineChartYear = new google.visualization.LineChart(document.getElementById("line_chart_year"));
         lineChartYear.draw(data, options);
         
         var pieChartYear = new google.visualization.PieChart(document.getElementById("pie_chart_year"));
         pieChartYear.draw(data, options);
     
    }

    
    function downloadDayTemplate(){
    	$.blockUI();
    	$.ajax({
    		url : "<c:url value='/report_customers/export-CustomerDayChart-template' />",
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
    function downloadWeekTemplate(){
    	$.blockUI();
    	$.ajax({
    		url : "<c:url value='/report_customers/export-CustomerWeekChart-template' />",
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
    function downloadMonthTemplate(){
    	$.blockUI();
    	$.ajax({
    		url : "<c:url value='/report_customers/export-CustomerMonthChart-template' />",
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
    function downloadYearTemplate(){
    	$.blockUI();
    	$.ajax({
    		url : "<c:url value='/report_customers/export-CustomerYearChart-template' />",
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
    
	
    
</script>
