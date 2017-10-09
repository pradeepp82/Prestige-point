/**
 * 
 */
$(document)
			.ready(
					function() {
						var firstName = "${fname}";
						if (document.getElementById('fcheck').checked) {
							$("#year").hide();
						} else {
							$("#year").hide();
						}
						if (document.getElementById('echeck').checked) {
							$("#year").show();
						}
						$("#fcheck").click(function() {
							$("#year").hide();
						});
						$("#echeck").click(function() {
							$("#year").show();
						});
						if (firstName != null && firstName != '') {
							document.getElementById("firstName").value = "${fname}";
							document.getElementById("lastName").value = "${lname}";
							document.getElementById("registrationId").value = "${registrationId}";
						}
					});