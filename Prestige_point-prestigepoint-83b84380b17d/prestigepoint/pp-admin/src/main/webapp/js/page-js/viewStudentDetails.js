function callAll() {
	if ($('#all').prop('checked')) {
		document.getElementById("courseId").disabled = true;
		document.getElementById("batchId").disabled = true;
	} else {
		document.getElementById("courseId").disabled = false;
		document.getElementById("batchId").disabled = false;
	}
}
$(document).ready(function() {
	if ($('#all').prop('checked')) {
		document.getElementById("courseId").disabled = true;
		document.getElementById("batchId").disabled = true;
	} else {
		document.getElementById("courseId").disabled = false;
		document.getElementById("batchId").disabled = false;
	}
	var courseValue = document.getElementById("courseId").value;
	if (courseValue == 0) {
		document.getElementById("all").disabled = false;
		document.getElementById("batchId").disabled = false;
		if ($('#all').prop('checked')) {
			document.getElementById("courseId").disabled = true;
			document.getElementById("batchId").disabled = true;
		}
	} else {
		document.getElementById("all").disabled = true;
		document.getElementById("batchId").disabled = true;
	}
	var batchValue = document.getElementById("batchId").value;
	if (batchValue == 0) {
		document.getElementById("all").disabled = false;
		document.getElementById("courseId").disabled = false;
		if (courseValue != 0) {
			document.getElementById("all").disabled = true;
		}
		if ($('#all').prop('checked')) {
			document.getElementById("courseId").disabled = true;
			document.getElementById("batchId").disabled = true;
		}
	} else {
		document.getElementById("all").disabled = true;
		document.getElementById("courseId").disabled = true;
	}
});


function callCourse() {
	var courseValue = document.getElementById("courseId").value;
	if (courseValue == 0) {
		document.getElementById("all").disabled = false;
		document.getElementById("batchId").disabled = false;
	} else {
		document.getElementById("all").disabled = true;
		document.getElementById("batchId").disabled = true;
	}

}
function callBatch() {
	var batchValue = document.getElementById("batchId").value;
	if (batchValue == 0) {
		document.getElementById("all").disabled = false;
		document.getElementById("courseId").disabled = false;
	} else {
		document.getElementById("all").disabled = true;
		document.getElementById("courseId").disabled = true;
	}
}

