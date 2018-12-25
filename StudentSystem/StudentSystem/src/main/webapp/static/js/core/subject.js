var subjectFunction = function() {
//public function
    var self = {
    		// init function when page load
	        initSubject: function() {

	        	if (typeof $(".class-select-box-load_subject_range").val() !== "undefined") { 	
	 		    	$(".class-select-box-load_subject").on("change", function(){
	 	                $.blockUI();
	 	                $.ajax({
	 	                    url: pageSettings.webPath + "/subjects/getSubjectByClassMateId",
	 	                    type: 'GET',
	 	                    data: {class_id: $(this).val()},
	 	                    success: function(response) {
	 	                    	 $.unblockUI();
	 	                    	 console.log("dsfasd fsdfsdfsfsd ");
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
	 	                    	 console.log("dsfasd fsdfsdfsfsd errror  ");
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