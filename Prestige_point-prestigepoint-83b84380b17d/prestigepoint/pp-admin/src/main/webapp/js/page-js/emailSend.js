function disablefields() {
	if (document.getElementById('student').checked == 1 || document.getElementById('allEnquiry').checked == 1)
	{ 
		document.getElementById("emailId").disabled=true;
		document.getElementById("emailId").value=" "; 
   }else
   { 
	   document.getElementById("emailId").disabled = false;
	 } 
	
	} 