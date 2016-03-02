//header jquery
$(window).scroll(function() {
if ($(this).scrollTop() > 1){  
	$('nav').addClass('sticky');
	$('img.logo').addClass('imgstick');
	$('img.gif').addClass('imgif');
	$('img.gif').removeClass('imgifg');
  }
  else{
   $('nav').removeClass('sticky');
   $('img.logo').removeClass('imgstick');
   $('img.gif').addClass('imgifg');
    $('img.gif').removeClass('imgif');
  }
});

function abc(){
	alert("hiiii");
}
function toggle(){
	$("nav").toggleClass("mbar");
}