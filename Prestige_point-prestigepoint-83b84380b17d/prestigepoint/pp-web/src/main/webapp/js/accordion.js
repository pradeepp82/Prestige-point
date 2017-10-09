jQuery.fn.accordion = function() {
	return this.each(function() {
		var ths = $(this);
		var icon_temp = '<i></i>';
		var trigger = $(ths).find('a:first');
		if ($(ths).find('ul').length) {
			$(this).addClass('accord').find('a:first').prepend(icon_temp);
		}
		$(trigger).on('click', function(e) {
			var dropper = $(this);
			e.preventDefault();
			if ($(dropper).next('ul').is(':not(:visible)')) {
				$('.accord').children('ul:visible').slideUp(350, function() {
					$(this).parent('li').find('i').removeClass('icon-collaps');
					$(this).parent('li').removeClass('open');
				});

				$(dropper).parent('li').addClass('open');
				$(dropper).next('ul').slideDown(350, function() {
					$(dropper).find('i').addClass('icon-collaps');
				});
			} else {
				$(dropper).next('ul').slideUp(350, function() {
					$(dropper).find('i').removeClass('icon-collaps');
					$(this).parent('li').removeClass('open');
				});

			}
		});
	});
};