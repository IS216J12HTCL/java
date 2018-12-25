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

	/************************************************
	*				External Dragging				*
	************************************************/

	/* initialize the calendar
	-----------------------------------------------------------------*/
	
	
	$('#fc-external-drag').fullCalendar({
		header: {
			left: 'prev,next today',
			center: 'title',
			right: 'month,agendaWeek'
		},
		editable: true,
		selectable: true,
		droppable: true, // this allows things to be dropped onto the calendar
		defaultDate: '2018-06-30',
		select: function(start, end, jsEvent, view, resource) {
			if(view.name == 'month'){
		        $('#fc-external-drag').fullCalendar('changeView', 'agendaWeek');
			}
		},
		eventClick: function(event) {
		    console.log(event);
		},
//		events: function(start, end, timezone, callback) {
//	        $.ajax({
//	            url: pageSettings.webPath + "/plan_studies/plan_study",
//	            type: 'GET',
//	            data: {
//	                // our hypothetical feed requires UNIX timestamps
//	            	student_id: studentId//$(this).val()
//	            },
//	            success: function(response) {
//	                
////	                $(doc).find('event').each(function() {
//	                	var planstudies = response.data;
//	                	$.each(planstudies, function(index, item){
//	                		events.push({
//	                			id: item.id,
//		                        title: item.name,
//		                        start: item.starttime,
//		                        end: item.endtime
////		                        start: $(this).attr('start') // will be parsed
//		                    });
//	                	$("#render_plan").html(response);
//                        });
////	                });
//	                callback(events);
//	            }
//	        });
//	    },
	   
	});

	/* initialize the external events
	-----------------------------------------------------------------*/

	$('#external-events .fc-event').each(function() {

		// Different colors for events
        $(this).css({'backgroundColor': $(this).data('color'), 'borderColor': $(this).data('color')});

		// store data so the calendar knows to render an event upon drop
		$(this).data('event', {
			title: $.trim($(this).text()), // use the element's text as the event title
			color: $(this).data('color'),
			stick: true // maintain when user navigates (see docs on the renderEvent method)
		});
		// make the event draggable using jQuery UI
		$(this).draggable({
			zIndex: 999,
			revert: true,      // will cause the event to go back to its
			revertDuration: 0  //  original position after the drag
		});

	});


});