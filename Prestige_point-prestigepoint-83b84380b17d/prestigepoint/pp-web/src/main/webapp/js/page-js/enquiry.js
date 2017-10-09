function saveEnquiry() {
	emptyValidation();
	if (isValid) {
		var name = $('#name1').val();
		var emailId = $('#emailId1').val();
		var mobileNo = $('#mobileNo1').val();
		var comment = $('#comment1').val();
		$.ajax({
			type : "POST",
			url : "enquiryAction.do",
			data : "name=" + name + "&emailId=" + emailId + "&mobileNo="
					+ mobileNo + "&comment=" + comment,
			success : function(response) {
				// we have the response
				$('#info').html(response);
				$('#info').show();
				$('#name1').val('');
				$('#emailId1').val('');
				$('#mobileNo1').val('');
				$('#comment1').val('');
				clearMessage();
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
}
function emptyValidation() {
	$('input[type="text"]')
			.each(
					function() {
						if (($.trim($('#name1').val()) == '')
								&& ($.trim($('#emailId1').val()) == '')
								&& ($.trim($('#mobileNo1').val()) == '')
								&& ($.trim($('#comment1').val()) == '')) {
							$('#nameMsg').attr('style',
									'display:block;color:red;');
							$('#emailMsg').attr('style',
									'display:block;color:red;');
							$('#mobileMsg').attr('style',
									'display:block;color:red;');
							$('#commentMsg').attr('style',
									'display:block;color:red;');
							$('#info').hide();
							isValid = false;
						} else if ($.trim($('#name1').val()) == '') {
							$('#nameMsg').attr('style',
									'display:block;color:red;');
							$('#emailMsg').attr('style', 'display:none;');
							$('#mobileMsg').attr('style', 'display:none;');
							$('#commentMsg').attr('style', 'display:none;');
							isValid = false;
						} else if ($.trim($('#emailId1').val()) == '') {
							$('#nameMsg').attr('style', 'display:none;');
							$('#emailMsg').attr('style',
									'display:block;color:red;');
							$('#mobileMsg').attr('style', 'display:none;');
							$('#commentMsg').attr('style', 'display:none;');
							isValid = false;
						} else if ($.trim($('#mobileNo1').val()) == '') {
							$('#nameMsg').attr('style', 'display:none;');
							$('#emailMsg').attr('style', 'display:none;');
							$('#mobileMsg').attr('style',
									'display:block;color:red;');
							$('#commentMsg').attr('style', 'display:none;');
							isValid = false;
						} else if ($.trim($('#comment1').val()) == '') {
							$('#nameMsg').attr('style', 'display:none;');
							$('#emailMsg').attr('style', 'display:none;');
							$('#mobileMsg').attr('style', 'display:none;');
							$('#commentMsg').attr('style',
									'display:block;color:red;');
							isValid = false;
						} else {
							var emailText2 = document
									.getElementById('emailId1').value;
							var contactNo = document
							.getElementById('mobileNo1').value;
							var pattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
							if (!pattern.test(emailText2)) {
								$('#nameMsg').attr('style', 'display:none;');
								$('#emailMsg1').attr('style',
										'display:block;color:red;');
								$('#mobileMsg').attr('style', 'display:none;');
								$('#commentMsg').attr('style', 'display:none;');
								$('#emailMsg').attr('style','display:none;');
								isValid = false;
							}else if(contactNo.length <10)
								{
								$('#nameMsg').attr('style', 'display:none;');
								$('#emailMsg1').attr('style', 'display:none;');
								$('#mobileMsg').attr('style', 'display:none;');
								$('#commentMsg').attr('style', 'display:none;');
								$('#contact').attr('style', 'display:block;color:red;');
								isValid = false;
								} else {
								$('#emailMsg1').attr('style', 'display:none;');
								isValid = true;
							}
						}
					});
}
function clearMessage() {
	$('#nameMsg').attr('style', 'display:none;');
	$('#emailMsg').attr('style', 'display:none;');
	$('#mobileMsg').attr('style', 'display:none;');
	$('#commentMsg').attr('style', 'display:none;');
	$('#emailMsg1').attr('style', 'display:none;');
	$('#contact').attr('style', 'display:none;');
}
function num(evt, e) {
	var keyCode = evt.keyCode;
	if (keyCode < 37 || keyCode > 40) {
		e.value = e.value.replace(/[^0-9+-]+/g, '');
	}
	return false;
}