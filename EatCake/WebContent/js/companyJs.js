/**
 * Created by vacation on 2017/3/30.
 */
$(document).ready(function () {
    $(".navbar a, footer a[href='#myPage']").on('click',function (event) {

        event.preventDefault();

        var hash = this.hash;

        $('html, body').animate({
            scrollTop: $(hash).offset().top
        }, 900, function () {

            window.location.hash = hash;
        });
    });

    $(window).scroll(function () {
        $(".slideanim").each(function () {
           var pos = $(this).offset().top;
           var winTop = $(window).scrollTop();

           if (pos < winTop + 600){
               $(this).addClass("slide");
           }else{
               $(this).removeClass("slide");
           }

        });
        if ($(window).scrollTop()>30){
            $('.clean-main-menu').addClass("minified");
        }else {
            $('.clean-main-menu').removeClass("minified");
        }
    });

    /* ===================================
     HIDE MENU ON CLICK
     ====================================== */
    jQuery(".nav a").on("click", function () {
        jQuery("#myNavbar").removeClass("in").addClass("collapse");
    });

    /* Home Slideshow Vegas
     -----------------------------------------------*/
    $(function() {
        $('body').vegas({
            slides: [
                { src: 'img/cake-slide-1.jpg' },
                { src: 'img/cake-slide-2.jpg' },
                { src: 'img/cake-slide-3.jpg' }
            ],
            timer: false,
            transition: [ 'zoomOut', ]
        });
    });

    /* wow
     -------------------------------*/
    new WOW({ mobile: false }).init();
})