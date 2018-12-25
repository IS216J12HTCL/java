var requestClassFunction = function() {
//public function
    var self = {
    		// init function when page load
	        initRequestClass: function() {
	        
//	        	if (typeof $(".input-ckeditor").val() !== "undefined") {
//	        		CKEDITOR.replaceClass = 'input-ckeditor';
//	        	}
	        if(typeof $(".class-select-box-load_subject_range").val() !== "undefined"){
				$(".class-select-box-load_subject_range").on("change", function(){
					        		
					        		
					                $.blockUI();
					                $.ajax({
					                    url: pageSettings.webPath + "/subjects/getSubjectByClassId",
					                    type: 'GET',
					                    data: {class_id: $(this).val()},
					                    success: function(response) {
					                        $.unblockUI();
					                        $(".subject-select-box-load").empty();
					                        
					                        $(".subject-select-box-load").append('<option value="0">Chọn môn học</option>');
				
					                        var subjects = response.data;
					                        console.log("sdf sadfsd afsad");
					                        $.each(subjects, function(index, item){
					                        	var html = "<option value='" + item.id + "'>" + item.name + "</option>"
					                        	
					                        	$(".subject-select-box-load").append(html);
					                        	
					                        });
					                        $(".subject-select-box-load").val(0);
					                       
					                    },
					                    error: function(error) {
					                        $.unblockUI();
					                    }
					                });
					            });
	        }	
	        
	       
		    	
	  if (typeof $(".class-select-box-load_subject").val() !== "undefined") { 	
	    	$(".class-select-box-load_subject").on("change", function(){
                $.blockUI();
                $.ajax({
                    url: pageSettings.webPath + "/subjects/getSubjectByClassId",
                    type: 'GET',
                    data: {class_id: $(this).val()},
                    success: function(response) {
                        $.unblockUI();
                        $(".subject-select-box-load_teacher").empty();
                        $(".subject-select-box-load_teacher").append('<option value="0">Chọn Môn học</option>');
                        $(".teacher-select-box-load").empty();
                        $(".teacher-select-box-load").append('<option value="0">Chọn Gia sư</option>');
                        var subjects = response.data;
                        $.each(subjects, function(index, item){
                        	var html = "<option value='" + item.id + "'>" + item.name + "</option>"
                        	$(".subject-select-box-load_teacher").append(html);
                        	
                        });
                        $(".subject-select-box-load_teacher").val(0);
                        $(".teacher-select-box-load").val(0);
                    },
                    error: function(error) {
                        $.unblockUI();
                    }
                });
            });
	    	
    		
	    	$(".subject-select-box-load_teacher").on("change", function(){
                $.blockUI();
                $.ajax({
                    url: pageSettings.webPath + "/teachers/getTeacherBySubjectId",
                    type: 'GET',
                    data: {subject_id: $(this).val()},
                    success: function(response) {
                        $.unblockUI();
                        $(".teacher-select-box-load").empty();
                        $(".teacher-select-box-load").append('<option value="0">Chọn Gia sư</option>');
                        var teachers = response.data;
                        $.each(teachers, function(index, item){
                        	var html = "<option value='" + item.id + "'>" + item.name + "</option>"
                        	$(".teacher-select-box-load").append(html);
                        });
                        $(".teacher-select-box-load").val(0);
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