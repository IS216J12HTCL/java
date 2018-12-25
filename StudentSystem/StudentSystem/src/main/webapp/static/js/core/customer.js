var customerFunction = function() {
//public function
    var self = {
    		// init function when page load
	        init: function() {
	        
//	        	if (typeof $(".input-ckeditor").val() !== "undefined") {
//	        		CKEDITOR.replaceClass = 'input-ckeditor';
//	        	}
	      
	  if (typeof $(".city-select-box-load_district").val() !== "undefined") { 	
	    	$(".city-select-box-load_district").on("change", function(){
                $.blockUI();
                $.ajax({
                    url: pageSettings.webPath + "/districts",
                    type: 'GET',
                    data: {city_id: $(this).val()},
                    success: function(response) {
                        $.unblockUI();
                        $(".district-select-box-load_ward").empty();
                        $(".district-select-box-load_ward").append('<option value="0">Chọn quận/huyện</option>');
                        $(".ward-select-box-load").empty();
                        $(".ward-select-box-load").append('<option value="0">Chọn phường/xã</option>');
                        var districts = response.data;
                        $.each(districts, function(index, item){
                        	var html = "<option value='" + item.id + "'>" + item.name + "</option>"
                        	$(".district-select-box-load_ward").append(html);
                        	
                        });
                        $(".district-select-box-load_ward").val(0);
                        $(".ward-select-box-load").val(0);
                    },
                    error: function(error) {
                        $.unblockUI();
                    }
                });
            });
    		
    		$(".district-select-box-load_ward").on("change", function(){
                $.blockUI();
                $.ajax({
                    url: pageSettings.webPath + "/wards",
                    type: 'GET',
                    data: {district_id: $(this).val()},
                    success: function(response) {
                        $.unblockUI();
                        $(".ward-select-box-load").empty();
                        $(".ward-select-box-load").append('<option value="0">Chọn phường/xã</option>');
                        var wards = response.data;
                        $.each(wards, function(index, item){
                        	var html = "<option value='" + item.id + "'>" + item.name + "</option>"
                        	$(".ward-select-box-load").append(html);
                        });
                        $(".ward-select-box-load").val(0);
                    },
                    error: function(error) {
                        $.unblockUI();
                    }
                });
            });
    		
    	 	$(".subject-select-box-load_price").on("change", function(){
                $.blockUI();
                $.ajax({
                    url: pageSettings.webPath + "/subjects/getSubject",
                    type: 'GET',
                    data: {subject_id: $(this).val()},
                    success: function(response) {
                    
                        $.unblockUI();
                        var subject = response.data;
                        console.log(subject.cost);
                        $(".load-price").val(subject.cost)
                        
                       
//                        var discount = $(".discount_value").val() / 100;
//                        var vat = $(".vat_value").val()/100;
                        
                        $(".amount_label").val($(".quantity-change-load_price").val() *  $(".load-price").val());
                    },
                    error: function(error) {
                        $.unblockUI();
                    }
                });
            });
    	 	
    	 	  
    		    	 	
	    }
	  
	
//	  if (typeof $(".empId").val() !== "undefined") { 	
//			$(".empId").on("change", function(){
//				
//				if($(this).val() > 0){
//					$.blockUI();
//					$.ajax({
//							url : "<c:url value='/users/people_tags' />",
//							type : 'GET',
//							success : function(response) {
//								if (response.status === 200) {
//									var districts = response.data;
//									$('#employeeIds').empty();
//									$('#employeeIds').append("<option value='0'>Chọn nhân viên</option>");
//									$.each(districts, function(index, item) {
//										$('#employeeIds').append("<option value='" + item.id + "'>" + item.name + "</option>");
//									});
//								}
//								$.unblockUI();
//							},
//							error : function(error) {
//								alert(error);
//								$.unblockUI();
//							}
//						});
//				}
//			});
//	  }
//	  
	
	 
	  

	 	 

	    	 		$(".quantity-change-load_price").on("change", function(){
	                $(".amount_label").val($(this).val() *  $(".load-price").val());
	            });
	    	 		
	    	 		/*
	    	 		$(".discount_value").on("change", function(){
		               
                        var amount =  $(".quantity-change-load_price").val() *  $(".load-price").val();
                        
                        var discount = amount - (amount * $(this).val() / 100);
                        var vat =  amount - (amount * $(".vat_value").val()/100);
                        
                        $(".amount_label").val(amount - discount - vat);
		         });
	    	 		
	    	 		$(".vat_value").on("change", function(){
	    	 			 var amount =  $(".quantity-change-load_price").val() *  $(".load-price").val();
	                        
	                        var vat = amount - (amount * $(this).val() / 100);
	                        var discount =  amount - (amount * $(".discount_value").val()/100);
	                        
	                        $(".amount_label").val(amount - discount - vat);
                       
		         });
	    	 	
	    	 	*/
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