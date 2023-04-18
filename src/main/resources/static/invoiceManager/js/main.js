(function ($) {
    function floatLabel(inputType) {
        $(inputType).each(function () {
            var $this = $(this);
            // on focus add class active to label
            $this.focus(function () {
                $this.next().addClass("active");
            });
            // on blur check field and remove class if needed
            $this.blur(function () {
                if ($this.val() === '' || $this.val() === 'blank') {
                    $this.next().removeClass("active");
                }
            });
            // on change check field and add class if needed
            $this.change(function() {
                if ($this.val() !== '' && $this.val() !== 'blank') {
                    $this.next().addClass("active");
                } else {
                    $this.next().removeClass("active");
                }
            });
        });
    }
    // just add a class of "floatLabel to the input field!"
    floatLabel(".floatLabel");
})(jQuery);
if (window.location.pathname.includes('/editInvoice/') || window.location.pathname.match(/\/editInvoiceLine\/\d+/)
    || window.location.pathname.match(/\/rooms\/edit\/\d+/)
    || window.location.pathname.match(/\/rooms\/cleaning\/editCleaning\/\d+/)) {
    var inputs = document.querySelectorAll(".floatLabel");


    for (var i = 0; i < inputs.length; i++) {
        var input = inputs[i];
        if (input.value !== '') {
            input.nextElementSibling.classList.add("active");
        }

    }
}



