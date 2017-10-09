(function($){
	$(document).ready(function (){
		$('.enquiry-open').on('click', function(){
			$('.enquiry-form:not(:animated)').animate({right: "0"}, {easing: "easeOutSine", duration:500});
			if(!$('.black-overlay').length){
			$('body').append(("<div class='black-overlay'></div>"));
			$('.black-overlay').fadeIn(500);
			}
		});
		$('.enquiry-close').on('click', function(){
			$('.enquiry-form:not(:animated)').animate({right: "-350px"}, {easing: "easeOutSine", duration:500});
			$('.black-overlay').fadeOut(500, function(){$(this).remove();});
		});
		
	
	});
	
	
	/* optional triggers
	
	$(window).load(function() {
		
	});
	
	$(window).resize(function() {
		
	});
	
	*/

})(window.jQuery);