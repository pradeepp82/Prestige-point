/**
 * 
 */
function enableMarqueeStatus(marqueeDetails) {
	var marqueeId =marqueeDetails.id;
	var marqueeValue =marqueeDetails.value;
	var marqueeIdValue = document.getElementById(marqueeId).checked;
	
	$.ajax({
		url : "changeMarqueeStatusAction.do?marqueeValue=" +marqueeValue
				+ "&marqueeIdValue=" + marqueeIdValue,
		type : "GET",
		contentType : "application/json; charset=utf-8",
		success : function(call) {
		},
		error : function() {
		}
	})
}
