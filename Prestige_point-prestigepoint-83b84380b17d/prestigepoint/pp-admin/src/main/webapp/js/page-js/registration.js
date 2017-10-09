$(function() {
	$('#courseId')
			.change(
					function() {
						$('#courseFee').text("");
						$('#courseFee').append(
								$("<option value='" + 0 + "'></option>").text(
										"Select"));
						var courseId = $("#courseId").val();
						$
								.ajax({
									url : 'amountByCourseTypeId.do?courseIdId='
											+ courseId,
									type : 'GET',
									contentType : "application/json; charset=utf-8",
									success : function(response) {
										var amountvalue = response;
										document.getElementById('courseFee').value = amountvalue;
									},
									error : function(error) {

									}
								});
					});
});
$(function() {
	$('#courseFee').text("");
	$('#courseFee').append(
			$("<option value='" + 0 + "'></option>").text("Select"));
	var courseId = $("#courseId").val();
	$.ajax({
		url : 'amountByCourseTypeId.do?courseIdId=' + courseId,
		type : 'GET',
		contentType : "application/json; charset=utf-8",
		success : function(response) {
			var amountvalue = response;
			document.getElementById('courseFee').value = amountvalue;
		},
		error : function(error) {

		}
	});
});
function discountAmount() {
	var courseFee = document.getElementById("courseFee").value;
	var discount = document.getElementById("discount").value;
	var rad = $('input[name="dis"]:checked').val();
	if (rad == "rs") {
		
			var total = courseFee - discount;
			if(total<0){
				alert("invalid discount");
			}
			else{
			document.getElementById("totalFee").value = total;
			} 
	}
	else {
		if (discount > 100) {
			alert("Discount Persentage is more then 100");
		} else {
			var total = courseFee - ((courseFee * discount) / 100);
			document.getElementById("totalFee").value = total;
		}
	}
}
function num(evt, e) {
	var keyCode = evt.keyCode;
	if (keyCode < 37 || keyCode > 40) {
		e.value = e.value.replace(/[^0-9+-]+/g, '');
	}
	return false;
}
function Alphabets(nkey) {
	var keyval
	if (navigator.appName == "Microsoft Internet Explorer") {
		keyval = window.event.keyCode;
	} else if (navigator.appName == 'Netscape') {
		nkeycode = nkey.which;
		keyval = nkeycode;
	}
	// For A-Z
	if (keyval >= 65 && keyval <= 90) {
		return true;
	}
	// For a-z
	else if (keyval >= 97 && keyval <= 122) {
		return true;
	}
	// For Backspace
	else if (keyval == 8) {
		return true;
	}
	// For General
	else if (keyval == 0) {
		return true;
	}
	// For Space
	else if (keyval == 32) {
		return true;
	} else {
		return false;
	}
}// End of the function
function onlyNos(e, t) {
	try {
		if (window.event) {
			var charCode = window.event.keyCode;
		} else if (e) {
			var charCode = e.which;
		} else {
			return true;
		}
		if (charCode > 31 && (charCode < 48 || charCode > 57)) {
			return false;
		}
		return true;
	} catch (err) {
		alert(err.Description);
	}
}
function imgvalue() {
	var src = $("#preview").attr("src");
	$('#imagePath').attr("value", src);
}
$(document)
		.ready(
				function() {
					if ("${Registration.registrationId}" != "") {
						document.getElementById("preview").src = "${imgPath}${Registration.registrationId}.png";
					} else {
						document.getElementById("preview").src = "${imgPath}default.jpg";
					}
				});
function emailVarification(p) {
	var emailId = p.value;
	$.ajax({
		url : "verifyUserEmailId.do?emailId=" + emailId,
		type : "GET",
		contentType : "application/json; charset=utf-8",

		success : function(t) {
			if (t) {
				alert("your emailId already existed!");
				document.getElementById("emailId").value = "";

			}

		},

		error : function() {
			alert("error");
		}
	})
}