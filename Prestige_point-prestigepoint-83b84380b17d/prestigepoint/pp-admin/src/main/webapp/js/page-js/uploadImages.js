function enableUploadImageStatus(uploadImage) {
	var uploadImageId= uploadImage.id;
	var uploadImageValue = uploadImage.value;//value is getting the id
	var  uploadImageIdValue = document.getElementById(uploadImageId).checked;//it is getting the value
	
	$.ajax({
		url : "activeUploadImagesStatus.do?uploadImageValue=" + uploadImageValue
				+ "&uploadImageIdValue=" + uploadImageIdValue,
		type : "GET",
		contentType : "application/json; charset=utf-8",
		success : function(call) {
		},
		error : function() {
		}
	})
}