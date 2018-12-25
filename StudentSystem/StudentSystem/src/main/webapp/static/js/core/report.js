var reportFunction = function() {
//public function
    var self = {
    		// init function when page load
	        initReport: function() {
	        	if (typeof $("#branch-select-box-load-user").val() !== "undefined") { 	
	    	    	$("#user-role-select-box-load-user").on("change", function(){
	    	    		$.blockUI();
	                    $.ajax({
	                        url: pageSettings.webPath + "/revenue_employee/getUsers",
	                        type: 'GET',
	                        data: {branch_id: $("#branch-select-box-load-user").val(),
	                        	user_role_id: $("#user-role-select-box-load-user").val()
	                        },
	                        success: function(response) {
	                            $.unblockUI();
	                            $("#user-load-from-branch-user-role").empty();
	                            $("#user-load-from-branch-user-role").append('<option selected value="0">Chọn Nhân viên</option>');
	                            var users = response.data;
	                            $.each(users, function(index, item){
	                            	var html = "<option value='" + item.id + "'>" + item.name + "</option>"
	                            	$("#user-load-from-branch-user-role").append(html);
	                            	
	                            });
	                            $("#user-load-from-branch-user-role").val(0);
	                        },
	                        error: function(error) {
	                            $.unblockUI();
	                        }
	                    });
	                });
	        	}
	        	if (typeof $("#user-role-select-box-load-user").val() !== "undefined") { 	
	    	    	$("#branch-select-box-load-user").on("change", function(){
	    	    		$.blockUI();
	                    $.ajax({
	                        url: pageSettings.webPath + "/revenue_employee/getUsers",
	                        type: 'GET',
	                        data: {branch_id: $("#branch-select-box-load-user").val(),
	                        	user_role_id: $("#user-role-select-box-load-user").val()
	                        },
	                        success: function(response) {
	                            $.unblockUI();
	                            $("#user-load-from-branch-user-role").empty();
	                            $("#user-load-from-branch-user-role").append('<option selected value="0">Chọn Nhân viên</option>');
	                            var users = response.data;
	                            $.each(users, function(index, item){
	                            	var html = "<option value='" + item.id + "'>" + item.name + "</option>"
	                            	$("#user-load-from-branch-user-role").append(html);
	                            	
	                            });
	                            $("#user-load-from-branch-user-role").val(0);
	                        },
	                        error: function(error) {
	                            $.unblockUI();
	                        }
	                    });
	                });
	        	}
	        	
//	        	$.ajax({
//		                 url: pageSettings.webPath + "/revenue_activies/viewers",
//		                 type: 'GET',
////		                 data: {project_id: $(this).val()},
//		                 success: function(response) {
//		                     $.unblockUI();
//		                     
//		                   
//		                     var users = response.data;
//		                     $.each(users, function(index, item){
//		                     	// handle data here....
//		                    	 	
//		                    	 
//		                     });
//		                    
//		                    
//	                 },
//	                 error: function(error) {
//	                     $.unblockUI();
//	                 }
//		            });
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