/*jQuery.fn.fullBanner = function() {
    return this.each(function() {
        var el = $(this);
        var runner = 0;
        var container_width = parseInt($(el).find('li').outerWidth() * $(el).find('li').size());
	    var window_width = parseInt($(window).outerWidth());
        $(el).find('li').css('width', window_width);
        var left_margin = parseInt($(el).css('left')) - $(el).find('li').outerWidth();
        $(el).css({
            'width': container_width,
            'left': left_margin
			
		});
		
        function slideShow() {
            var left_indent = parseInt($(el).css('left')) - $(el).find('li').outerWidth();
            $('#banner:not(:animated)').animate({
                'left': left_indent
            }, 1000, function() {
                $(el).find('li:last').after($(el).find('li:first'));
                $(el).css({
                    'left': left_margin
                });
            });
        }

        function reversSlideShow() {
            var left_indent = parseInt($(el).css('left')) + $(el).find('li').outerWidth();
            $('#banner:not(:animated)').animate({
                'left': left_indent
            }, 1000, function() {
                $(el).find('li:first').before($(el).find('li:last'));
                $(el).css({
                    'left': left_margin
                });
            });
        }
        starter(true);

        function starter(check) {
            if (check) {
                runner = setInterval(slideShow, 4000);
            }
            else {
                clearInterval(runner);
            }
        }
        $('.prev').on('click', function() {
            reversSlideShow();
            starter(false);
            starter(true);
        });
        $('.next').on('click', function() {
            slideShow();
            starter(false);
            starter(true);
        });
        $(el).hover(function() {
            starter(false);
        }, function() {
            starter(true);
        });
    });
};*/
jQuery(document).ready(function ($) {

 
    setInterval(function () {
        moveRight();
    }, 3500);
  
  
	var slideCount = $('#slider ul li').length;
	var slideWidth = $('#slider ul li').width();
	var slideHeight = $('#slider ul li').height();
	var sliderUlWidth = slideCount * slideWidth;
	
	$('#slider').css({ width: slideWidth, height: slideHeight });
	
	//$('#slider ul').css({ width: sliderUlWidth, marginLeft: - slideWidth });
	
    $('#slider ul li:last-child').prependTo('#slider ul');

    function moveLeft() {
        $('#slider ul').animate({
            left: + slideWidth
        }, 400, function () {
            $('#slider ul li:last-child').prependTo('#slider ul');
            $('#slider ul').css('left', '');
        });
    };

    function moveRight() {
        $('#slider ul').animate({
            left: - slideWidth
        }, 400, function () {
            $('#slider ul li:first-child').appendTo('#slider ul');
            $('#slider ul').css('left', '');
        });
    };

    $('a.control_prev').click(function () {
        moveLeft();
    });

    $('a.control_next').click(function () {
        moveRight();
    });

});  