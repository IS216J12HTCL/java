/*=========================================================================================
    File Name: fullcalendar.js
    Description: Fullcalendar
    --------------------------------------------------------------------------------------
    Item Name: Stack - Responsive Admin Theme
    Version: 1.1
    Author: PIXINVENT
    Author URL: http://www.themeforest.net/user/pixinvent
==========================================================================================*/


$(document).ready(function(){

	/****************************************
	*				Basic Views				*
	****************************************/
	$('#fc-basic-views-teacher').fullCalendar({
		header: {
			left: 'prev,next today',
			center: 'title',
			right: 'month,agendaWeek'
		},
		defaultDate: '2018-05-30',
		editable: false,
		eventLimit: true, // allow "more" link when too many events
		selectable: true,
		droppable: false,
		select: function(start, end, jsEvent, view, resource) {
			if(view.name == 'month'){
		        $('#fc-basic-views-teacher').fullCalendar('changeView', 'agendaWeek');
			}
			if(view.name == 'agendaWeek' || view.name == 'agendaDay'){
		        var title = prompt('Event Title:');
		        var eventData;
				var teacherId = document.getElementById("fc-basic-views-teacher").getAttribute('data-id');
				
		        if (title) {
		          eventData = {
		            title: "free",
		            start: start,
		            end: end
		          };
		          
		          $('#fc-basic-views-teacher').fullCalendar('renderEvent', eventData, true);
		          
		          var startTime = start.format('YYYY-MM-DD HH:mm');
		          var endTime = end.format('YYYY-MM-DD HH:mm');
		          var startDate = start.format('YYYY-MM-DD');
		          $.ajax({
					    url: pageSettings.webPath + "/workschedules/teacher_plan",
					    data: {
					    	id: teacherId,
					        title: "free",
					        startDate: startDate,
					        startTime: startTime,
					        endTime: endTime
					    },
					    type: 'POST',
					    success: function(response){
					    },
					    error: function(e){
					    	
					        console.log(e.responseText);
					    }
					});
		          
		          // alert(eventData.title);
		          // alert(eventData.start);
		        }
		        $('#fc-basic-views-teacher').fullCalendar('unselect');
		      }
		},
		
		eventClick: function(calEvent, jsEvent) {
		      var title = prompt('Event Title:', calEvent.title, {
		        buttons: {
		          Ok: true,
		          Cancel: false
		        }
		      });
		},
		
		events: function(start, end, timezone, callback) {
			var teacherId = document.getElementById("fc-basic-views-teacher").getAttribute('data-id');
			
	        $.ajax({
	            url: pageSettings.webPath + "/workschedules/teacher",
	            type: 'GET',
	            data: {
	                // our hypothetical feed requires UNIX timestamps
	            	teacher_id: teacherId//$(this).val()
	            },
	            success: function(response) {
	                var events = [];
//	                $(doc).find('event').each(function() {
	                	var workschedules = response.data;
	                	$.each(workschedules, function(index, item){
	                		events.push({
		                        title: item.name,
		                        start: item.starttime,
		                        end: item.endtime,
//		                        start: $(this).attr('start') // will be parsed
		                    });
//                        	
                        });
//	                    
//	                });
	                callback(events);
	            }
	        });
	    }
	});
});