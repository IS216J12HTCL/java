var taskFunction = function() {
//public function
    var self = {
    		// init function when page load
	        initTask: function() {
	        
	        	if (typeof $(".input-ckeditor").val() !== "undefined") {
	        		CKEDITOR.replaceClass = 'input-ckeditor';
//	        		CKEDITOR.config.customConfig =  '/static/vendors/js/ckeditor/config.js';
	        	}
	      
//	    	 	Load ajax for new form task
	   	 	 if (typeof $(".task-select-box-load_users").val() !== "undefined") {
	   	 		 
	   			 	$(".task-select-box-load_users").on("change", function(){
	   		             $.blockUI();
	   		             $.ajax({
	   		                 url: pageSettings.webPath + "/tasks/viewers",
	   		                 type: 'GET',
	   		                 data: {task_id: $(this).val()},
	   		                 success: function(response) {
	   		                     $.unblockUI();
	   		                     
	   		                     $(".task-select-box-load_create_by").empty();
	   		                     $(".task-select-box-load_create_by").append('<option value="0">Thực hiện bởi</option>');
	   		                     //=================== ===================
	   		                     
	   		                     $(".task-select-box-load_viewers").empty();
	   		                     $(".task-select-box-load_viewers").append('<option value="0"></option>');
	   		
	   		                     var users = response.data;
	   		                     $.each(users, function(index, item){
	   		                    	 
	   		                    	 var html_users = "<option value='" + item.id + "'>" + item.name + "</option>"
	   			                  $(".task-select-box-load_create_by").append(html_users);
	   		                    	 
	   		                     	var html = "<option value='" + item.id + "'>" + item.name + "</option>"
	   		                     	$(".task-select-box-load_viewers").append(html);
	   		                     	
	   		                     });
	   		                     $(".task-select-box-load_create_by").val(0);
	   		                     $(".task-select-box-load_viewers").val(0);
	   		                    
	   	                 },
	   	                 error: function(error) {
	   	                     $.unblockUI();
	   	                 }
	   		            });
	   			 	});
	   	 	 }
	        },
	    };
	return self;
}();


//var adminFunction = function() {
//	//public function
//	    var self = {
//	    		// init function when page load
//		        init: function() {
//		        
//		        	if (typeof $(".input-ckeditor").val() !== "undefined") {
//		        		CKEDITOR.replaceClass = 'input-ckeditor';
//		        	}
////		      
//		        	$(".task-select-box-load_users").on("change", function(){
//		                $.blockUI();
//		                $.ajax({
//		                    url: pageSettings.webPath + "/tasks/viewers",
//		                    type: 'GET',
//		                    data: {task_id: $(this).val()},
//		                    success: function(response) {
//		                        $.unblockUI();
//		                        $(".task-select-box-load_viewers").empty();
//		                        
//		                        $(".task-select-box-load_viewers").append('<option value="0">Chọn quận/huyện</option>');
//
//		                        var users = response.data;
//		                        $.each(users, function(index, item){
//		                        	var html = "<option value='" + item.id + "'>" + item.name + "</option>"
//		                        	$(".task-select-box-load_viewers").append(html);
//		                        	
//		                        });
//		                        $(".task-select-box-load_viewers").val(0);
//		                       
//		                    },
//		                    error: function(error) {
//		                        $.unblockUI();
//		                    }
//		                });
//		            });
//		        },
//	        
//		        reset: function(form) {
//		        	form = form || '.form';
//		        	$(form)[0].reset();
//		        },
//		        
//		        getParameterByName: function(name, url) {
//		        	if (!url) url = window.location.href;
//		            name = name.replace(/[\[\]]/g, "\\$&");
//		            var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
//		                results = regex.exec(url);
//		            if (!results) return null;
//		            if (!results[2]) return '';
//		            return decodeURIComponent(results[2].replace(/\+/g, " "));
//		        }
//		    };
//		return self;
//	}();
