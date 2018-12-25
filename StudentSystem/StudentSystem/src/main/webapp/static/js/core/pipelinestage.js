    var pipelineFunction = function() {
    	//public function
    	    var self = {
    	    		// init function when page load
    		        initPipeline: function() { 
    		        	$(".pipelinestage-select-box-load-pipeline").on("change", function(){	
    		        	
    		                $.blockUI();
    		                $.ajax({
    		                    url: pageSettings.webPath + "/deals/reloadpipeline",
    		                    type: 'GET',
    		                    data: {pipeline_id: $(this).val()},
    		                    success: function(response) 
    		                    {
    		                        $.unblockUI();
    		                       $(".pipelinestage-select-box-load").empty();
    		                        $(".pipelinestage-select-box-load").append('<option value="0">Chọn bước bắt đầu của pipeline</option>');
    		                        var pipelineStages = response.data;
    		                        $.each(pipelineStages, function(index, item){
    		                        	var html = "<option value='" + item.id + "'>" + item.name + "</option>"
    		                        	$(".pipelinestage-select-box-load").append(html);
    		                        	
    		                        });

    		                        $(".pipelinestage-select-box-load").val(0);
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