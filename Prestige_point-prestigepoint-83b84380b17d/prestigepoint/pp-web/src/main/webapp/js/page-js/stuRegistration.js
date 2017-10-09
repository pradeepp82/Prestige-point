function validate() {
    var e = document.getElementById("password").value,
        d = document.getElementById("confirmPassword").value;
    return e != d ? (alert("Password and Confirm Password Should be Same"), !1) : !0
}
   /*function emailVarification(p) {
    var emailId = p.value;
  var submit  = document.getElementById("Submit").disabled = true; 
 $.ajax({
		url : "verifyUserEmailId.do?emailId=" + emailId,
		type : "GET",
		contentType : "application/json; charset=utf-8",
		success : function(call) {
			alert("hiiiiiiii");
		},
		error : function() {
		}
	})
}   
  } */