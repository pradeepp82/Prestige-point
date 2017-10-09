(function($) {
    $(document).ready(function() {
        var closed = true;
        var toggle = function formToggle() {
            if (closed) {
                $('.enquiry-form:not(:animated)').animate({
                    right: "0"
                }, {
                    easing: "easeOutSine",
                    duration: 500
                });
                if (!$('.black-overlay').length) {
                    $('body').append(("<div class='black-overlay'></div>"));
                    $('.black-overlay').fadeIn(500);
                }
                closed = false;
            }
            else {
                $('.enquiry-form:not(:animated)').animate({
                    right: "-350px"
                }, {
                    easing: "easeOutSine",
                    duration: 500
                });
                $('.black-overlay').fadeOut(500, function() {
                    $(this).remove();
                });
                closed = true;
            }
        };
        $('.enquiry-open').on('click', toggle);
		
		
		function blinking(){
			$('.registration-alert').find('img').fadeToggle({easing: "easeInBack"});				   
		};
		setInterval(blinking, 100);
		
    });
    /* optional triggers
	
	$(window).load(function() {
		
	});
	
	$(window).resize(function() {
		
	});
	
	*/
})(window.jQuery);