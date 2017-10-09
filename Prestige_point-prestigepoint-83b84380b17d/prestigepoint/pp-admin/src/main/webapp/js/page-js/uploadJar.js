function ValidateExtension() {
	var allowedFiles = [ ".jar" ];
	var fileUpload = document.getElementById("file");
	var lblError = document.getElementById("lblError");
	var regex = new RegExp("([a-zA-Z0-9\s_\\.\-:])+(" + allowedFiles.join('|')
			+ ")$");
	if (!regex.test(fileUpload.value.toLowerCase())) {
		lblError.innerHTML = "Please upload files having extensions: <b>"
				+ allowedFiles.join(', ') + "</b> only.";
		return false;
	}
	lblError.innerHTML = "";
	return true;
}
