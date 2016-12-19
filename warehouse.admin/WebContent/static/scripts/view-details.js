$(document).ready(function(){
	var detailsView = $( ".view-details pre" );

    $( ".view-details a" ).on("click", function() {
    	detailsView.animate({
    		opacity: "toggle",
    		height: "toggle"
    	});
    });
});
