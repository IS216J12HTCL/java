var studentFunction = function() {
//public function
    var self = {
    		// init function when page load
	        initStudent: function() {
	        
//	        	if (typeof $(".input-ckeditor").val() !== "undefined") {
//	        		CKEDITOR.replaceClass = 'input-ckeditor';
//	        	}
	      
//	    	 	Load ajax for new form student
	   	 	 if (typeof $(".subject_id_load_ajax_plan").val() !== "undefined") {
	   	 		 
	   			 	$(".subject_id_load_ajax_plan").on("change", function(){
	   		             $.blockUI();
	   		             $.ajax({
	   		                 url: pageSettings.webPath + "/student/viewers",
	   		                 type: 'GET',
	   		                 data: {project_id: $(this).val()},
	   		                 success: function(response) {
	   		                     $.unblockUI();
	   		                     $(".project-select-box-load_viewers").empty();
	   		
	   		                     var users = response.data;
	   		                     $.each(users, function(index, item){
	   		                    	 
	   		                    	 var html_users = "<option value='" + item.id + "'>" + item.name + "</option>"
	   			                  $(".project-select-box-load_create_by").append(html_users);
	   		                    	 
	   		                     	var html = "<option value='" + item.id + "'>" + item.name + "</option>"
	   		                     	$(".project-select-box-load_viewers").append(html);
	   		                     	
	   		                     });
	   		                     $(".project-select-box-load_create_by").val(0);
//	   		                     $(".project-select-box-load_viewers").val(0);
	   		                    
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