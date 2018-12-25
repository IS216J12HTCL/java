///*=========================================================================================
//    File Name: advance-cards.js
//    Description: intialize advance cards
//    ----------------------------------------------------------------------------------------
//    Item Name: Stack - Responsive Admin Theme
//    Version: 1.1
//    Author: PIXINVENT
//    Author URL: http://www.themeforest.net/user/pixinvent
//==========================================================================================*/
//    // Area chart
//// ------------------------------
//$(window).on("load", function(){
//    $('#recent-buyers').perfectScrollbar({
//        wheelPropagation: true
//    });
//    /********************************************
//    *               PRODUCTS SALES              *
//    ********************************************/
//    var dataChart = [];
//    var dataName = [];
//    $.ajax({
//	    url: pageSettings.webPath + "/report_orders/getData",
//	    data: {
//	    },
//	    type: 'GET',
//	    success: function(response){
//	    	var datas = response.data;
//	    	$.each(datas, function(index, item){
//	    		dataName.push(item.name);
//            });
//	    	
//	    	
//	    	$.each(datas, function(index, item){
//	    		var object = {};
//	    		object["month"] = item.month;
//	    		$.each(dataName, function(index, i){
//		    		if (item.name == i){
//		    			object[i] = item.value;
//		    		}
//		    		else{
//		    			object[i] = 0;
//		    		}
//	            });
////	    		object[item.name] = item.value;
//	    		
//	    		dataChart.push(object);
//            });
//	    	
//	    },
//	    error: function(e){
//	    	
//	        console.log(e.responseText);
//	    }
//	});
//    var months = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
//    console.log(dataChart);
//	console.log(dataName);
//    Morris.Area({
//        element: 'products-sales',
//        data: dataChart,
//        xkey: "month",
//        ykeys: dataName,
//        labels: dataName,
//        xLabelFormat: function(x) { // <--- x.getMonth() returns valid index
//            var month = months[x.getMonth()];
//            return month;
//        },
//        dateFormat: function(x) {
//            var month = months[new Date(x).getMonth()];
//            return month;
//        },
//        behaveLikeLine: true,
//        ymax: 5,
//        resize: true,
//        pointSize: 0,
//        pointStrokeColors:['#00B5B8', '#FA8E57'],
//        smooth: true,
//        gridLineColor: '#E4E7ED',
//        numLines: 6,
//        gridtextSize: 14,
//        lineWidth: 0,
//        fillOpacity: 0.9,
//        hideHover: 'auto',
//        lineColors: ['#00B5B8', '#FA8E57']
//    });
//    
//    /********************************************
//    *               Monthly Sales               *
//    ********************************************/
//    Morris.Bar.prototype.fillForSeries = function(i) {
//      var color;
//      return "0-#fff-#f00:20-#000";
//    };
//
//    Morris.Bar({
//        element: 'monthly-sales',
//        data: [{month: 'Jan', sales: 1835 }, {month: 'Feb', sales: 2356 }, {month: 'Mar', sales: 1459 }, {month: 'Apr', sales: 1289 }, {month: 'May', sales: 1647 }, {month: 'Jun', sales: 2156 }, {month: 'Jul', sales: 1835 }, {month: 'Aug', sales: 2356 }, {month: 'Sep', sales: 1459 }, {month: 'Oct', sales: 1289 }, {month: 'Nov', sales: 1647 }, {month: 'Dec', sales: 2156 }],
//        xkey: 'month',
//        ykeys: ['sales'],
//        labels: ['Sales'],
//        barGap: 4,
//        barSizeRatio: 0.3,
//        gridTextColor: '#bfbfbf',
//        gridLineColor: '#E4E7ED',
//        numLines: 5,
//        gridtextSize: 14,
//        resize: true,
//        barColors: ['#00B5B8'],
//        hideHover: 'auto',
//    });
//    
//    /************************************************************
//    *               Social Cards Content Slider                 *
//    ************************************************************/
//    // RTL Support
//    var rtl = false;
//    if($('html').data('textdirection') == 'rtl'){
//        rtl = true;
//    }
//    if(rtl === true)
//        $(".tweet-slider").attr('dir', 'rtl');
//    if(rtl === true)
//        $(".fb-post-slider").attr('dir', 'rtl');
//
//    // Tweet Slider
//    $(".tweet-slider").unslider({
//        autoplay: true,
//        delay:3500,
//        arrows: false,
//        nav: false,
//        infinite: true
//    });
//
//    // FB Post Slider
//    $(".fb-post-slider").unslider({
//        autoplay: true,
//        delay:4500,
//        arrows: false,
//        nav: false,
//        infinite: true
//    });
//});