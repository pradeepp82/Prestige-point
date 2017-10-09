 function myexecuteProgram() {
    	 var editor = $('#content').val(); 
    $.ajax({
    	 type : "GET",   
		 url : "editorAction.do",
		 data : "editor=" +  editor ,
		 contentType : "application/json; charset=utf-8",
		 success : function(response) {  
			 alert(response);
		      for (var i = 0; i < response.length; i++) {
		    	  
		    	/*  response.append(response.get(i));*/
		    	    $('#output').val("Output- "+response[i]); 
		    	}
		   /*   $('#output').val("Output- "+response[i]); */
		     },  
		     error : function(e) {  
		     } 
	});
}

	