var projectFunction = function() {
//public function
    var self = {
    		// init function when page load
	        initProject: function() {
	        
//	        	if (typeof $(".input-ckeditor").val() !== "undefined") {
//	        		CKEDITOR.replaceClass = 'input-ckeditor';
//	        	}
//	      
	        	$(".project-select-box-load_users").on("change", function(){
	                $.blockUI();
	                $.ajax({
	                    url: pageSettings.webPath + "/projects/viewers",
	                    type: 'GET',
	                    data: {project_id: $(this).val()},
	                    success: function(response) {
	                        $.unblockUI();
	                        $(".project-select-box-load_viewers").empty();
	                        
	                        $(".project-select-box-load_viewers").append('<option value="0">Chọn quận/huyện</option>');

	                        var users = response.data;
	                        $.each(users, function(index, item){
	                        	var html = "<option value='" + item.id + "'>" + item.name + "</option>"
	                        	$(".project-select-box-load_viewers").append(html);
	                        	
	                        });
	                        $(".project-select-box-load_viewers").val(0);
	                       
	                    },
	                    error: function(error) {
	                        $.unblockUI();
	                    }
	                });
	            });
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