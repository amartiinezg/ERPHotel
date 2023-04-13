(function ($) {
	function floatLabel(inputType) {
		$(inputType).each(function () {
			var $this = $(this);
			// on focus add cladd active to label
			$this.focus(function () {
				$this.next().addClass("active");
			});
			//on blur check field and remove class if needed
			$this.blur(function () {
				if ($this.val() === '' || $this.val() === 'blank') {
					$this.next().removeClass();
				}
			});
		});
	}
	// just add a class of "floatLabel to the input field!"
	floatLabel(".floatLabel");
})(jQuery);

var nameid = document.getElementById("name");
var surname = document.getElementById("surname");
var phone_number = document.getElementById("phone");
var dni = document.getElementById("dni");
var guestSelector = document.getElementById("guestSelection");
guestSelector.addEventListener("change", () => {
	if (guestSelector.selectedIndex !== 0) {
		nameid.value = guestSelector.options[guestSelector.selectedIndex].getAttribute("name");
		surname.value = guestSelector.options[guestSelector.selectedIndex].getAttribute("surname");
		phone_number.value = guestSelector.options[guestSelector.selectedIndex].getAttribute("phone_number");
		dni.value = guestSelector.options[guestSelector.selectedIndex].getAttribute("dni");

		nameid.nextElementSibling.classList.add("active");
		surname.nextElementSibling.classList.add("active");
		phone_number.nextElementSibling.classList.add("active");
		dni.nextElementSibling.classList.add("active");
	} else {
		nameid.value = '';
		surname.value = '';
		phone_number.value = '';
		dni.value = '';
		nameid.nextElementSibling.classList.remove("active");
		surname.nextElementSibling.classList.remove("active");
		phone_number.nextElementSibling.classList.remove("active");
		dni.nextElementSibling.classList.remove("active");
	}
});