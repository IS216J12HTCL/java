var orderFunction = function() {
//public function
    var self = {
    		// init function when page load
	        initOrder: function() {
	        	
//	        	$(".subject-select-box-load_price").on("change", function(){
//	                $.blockUI();
//	                $.ajax({
//	                    url: pageSettings.webPath + "/subjects/getSubject",
//	                    type: 'GET',
//	                    data: {subject_id: $(this).val()},
//	                    success: function(response) {
//	                        $.unblockUI();
//	                        var subject = response.data;
//	                        
//	                        $(".load-price").html(subject.getCost());
//	                       
//	                    },
//	                    error: function(error) {
//	                        $.unblockUI();
//	                    }
//	                });
//	            });
	        	
	        	if (typeof $(".customer-select-load-student").val() !== "undefined") { 	
	    	    	$(".customer-select-load-student").on("change", function(){
	                    $.blockUI();
	                    $.ajax({
	                        url: pageSettings.webPath + "/students/getStudents",
	                        type: 'GET',
	                        data: {customer_id:$(this).val()},
	                        success: function(response) {
	                            $.unblockUI();
	                            $(".student-load-from-customer").empty();
	                            $(".student-load-from-customer").append('<option value="0">Chọn Học sinh</option>');
	                            
	                            var students = response.data;
	                            $.each(students, function(index, item){
	                            	var html = "<option value='" + item.id + "'>" + item.name + "</option>"
	                            	$(".student-load-from-customer").append(html);
	                            	
	                            });
	                            $(".student-load-from-customer").val(0);
	                            
	                        },
	                        error: function(error) {
	                            $.unblockUI();
	                        }
	                    });
	                });
	        	}
	        	
	         	if (typeof $(".student-load-from-customer").val() !== "undefined") { 	
	    	    	$(".student-load-from-customer").on("change", function(){
	                    $.blockUI();
	                    $.ajax({
	                        url: pageSettings.webPath + "/plan_studies/getPlanes",
	                        type: 'GET',
	                        data: {studentId: $(this).val()},
	                        success: function(response) {
	                        	$("#render_plan_student").html(response);
	                        	$.unblockUI();
	                            
	                        },
	                        error: function(error) {
	                            $.unblockUI();
	                        }
	                    });
	                });
	        	}
	         	
	         	if (typeof $(".teacher_load_free_time").val() !== "undefined") { 	
	    	    	$(".teacher_load_free_time").on("change", function(){
	                    $.blockUI();
	                    $.ajax({
	                        url: pageSettings.webPath + "/free_times/getFreeTime",
	                        type: 'GET',
	                        data: {teacherId: $(this).val()},
	                        success: function(response) {
	                        	$("#render_plan_teacher").html(response);
	                        	$.unblockUI();
	                            
	                        },
	                        error: function(error) {
	                            $.unblockUI();
	                        }
	                    });
	                });
	        	}
	        },
        
	        reset: function(form) {
	        	form = form || '.form';
	        	$(form)[0].reset();
	        },
	        
	        getParameterByName: function(name, url) {
	        	if (!url) url = window.location.href;
	            name = name.replace(/[\[\]]/g, "\\$&");
	            var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
	                results = regex.exec(url);
	            if (!results) return null;
	            if (!results[2]) return '';
	            return decodeURIComponent(results[2].replace(/\+/g, " "));
	        }
	    };
	return self;
}();