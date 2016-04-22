$(function() {
	$('.js-toggle').bind('click', function(event) {
		$('.js-sidebar, .js-content').toggleClass('is-toggled');
		event.preventDefault();
	});	
	
	$('.js-selected').bind('click', function(event) {
		//$('.js-selected').toggleClass('is-selected');		
		//event.preventDefault();
	});	
});
