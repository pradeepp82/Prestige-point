jQuery(document).ready(
		function() {
			jQuery.datepicker.setDefaults(jQuery
					.extend(jQuery.datepicker.regional['']));
			/* jQuery('#datepick').datepicker(); */
			$("#datepick").datepicker({
				dateFormat : 'dd-mm-yy',
				changeMonth : true,
				changeYear : true,
				yearRange : '-70:+10',
				constrainInput : false,
				duration : '',
				gotoCurrent : true
			}).datepicker();
			$("#picker").datepicker({
				dateFormat : 'dd-mm-yy',
				changeMonth : true,
				changeYear : true,
				yearRange : '-70:+10',
				constrainInput : false,
				duration : '',
				gotoCurrent : true
			}).datepicker();
		});
			
			
		