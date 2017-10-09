function callAll() {
	if ($('#all').prop('checked')) {
		document.getElementById("subjectId").disabled = true;
		

	} else {
		document.getElementById("subjectId").disabled = false;
		
	}
}
$(document).ready(function() {
	if ($('#all').prop('checked')) {
		document.getElementById("subjectId").disabled = true;
		
	} else {
		document.getElementById("subjectId").disabled = false;
		
	}
	var subject = document.getElementById("subjectId").value;
	if (subject == 0) {
		document.getElementById("all").disabled = false;
		
		if ($('#all').prop('checked')) {
			document.getElementById("subjectId").disabled = true;
			
			
		}
	} else {
		document.getElementById("all").disabled = true;
		
	}
	



}
function callSubject() {
	var subject = document.getElementById("batchId").value;
	if (subject == 0) {
		document.getElementById("all").disabled = false;
		
	} else {
		document.getElementById("all").disabled = true;
		
	}
}
