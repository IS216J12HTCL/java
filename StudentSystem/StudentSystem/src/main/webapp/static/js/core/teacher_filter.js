var requestClassFunction = function() {
//public function
    var self = {
    		// init function when page load
	        initRequestClass: function() {
	        
//	        	if (typeof $(".input-ckeditor").val() !== "undefined") {
//	        		CKEDITOR.replaceClass = 'input-ckeditor';
//	        	}
		    	
	  if (typeof $(".class-select-box-load_subject").val() !== "undefined") { 	
	    	$(".class-select-box-load_subject").on("change", function(){
                $.blockUI();
                $.ajax({
                    url: pageSettings.webPath + "/filterTeacher/getSubjectByClassId",
                    type: 'GET',
                    data: {class_id: $(this).val()},
                    success: function(response) {
                        $.unblockUI();
                        $(".subject-select-box-load_teacher").empty();
                        $(".subject-select-box-load_teacher").append('<option value="0">Chọn Môn học</option>');
                        var subjects = response.data;
                        $.each(subjects, function(index, item){
                        	var html = "<option value='" + item.id + "'>" + item.name + "</option>"
                        	$(".subject-select-box-load_teacher").append(html);
                        	
                        });
                        $(".subject-select-box-load_teacher").val(0);
                     
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