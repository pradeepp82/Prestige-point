jQuery.fn.placeholder = function() {
    return this.each(function() {
        //var outer = $(this);
        var mainEl = $(this);
       
		var label = $(mainEl).attr("placeholder");
		var placeholder_outer = ("<div class='placeholder-outer'></div>");
		var placeholder_lbl = ("<span class='placeholder-lbl'>"+label+"</span>");

        $(mainEl).wrap(placeholder_outer);
		$(placeholder_lbl).insertBefore(mainEl);
		var lbl = $(this).siblings('.placeholder-lbl');
		function checkValue(ths) {
            if ($(ths).val().length > 0) {
                $(ths).siblings('span, .placeholder-lbl').hide();
            } else {
                $(ths).siblings('span, .placeholder-lbl').show();
            }
        }            

        $(mainEl).on({
            keydown: function() {
                $(this).siblings('span, .placeholder-lbl').hide();
            },
            blur: function() {
                checkValue($(this));
            },
			change: function() {
            	checkValue($(this));
        	}
        });
		checkValue(mainEl);  
		
		setTimeout(function(){checkValue(mainEl)},500);		
		
        $(lbl).on('click', function() {
            var lbl_input = $(this).next('.inputControl');
            $(lbl_input).focus();
        });
    });
};