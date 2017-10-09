function adjust(){
	var viewport  = 	$(window).width();
	if(viewport<=1024){
		$('head').append('<link rel="stylesheet" type="text/css" href="css/small_sd_style.css">');
	}else{
		$('link[href="css/small_sd_style.css"]').remove();
	}
};
adjust();
   