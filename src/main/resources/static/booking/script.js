(function($){
	function floatLabel(inputType){
		$(inputType).each(function(){
			var $this = $(this);
			// on focus add cladd active to label
			$this.focus(function(){
				$this.next().addClass("active");
			});
			//on blur check field and remove class if needed
			$this.blur(function(){
				if($this.val() === '' || $this.val() === 'blank'){
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
var guestSelector = document.getElementById("guestSelection");
guestSelector.addEventListener("change", () => {
  var nameText = guestSelector.options[guestSelector.selectedIndex].text.split(" ")[0];
  var surnameText = guestSelector.options[guestSelector.selectedIndex].text.split(" ")[1];
  if (nameText !== '') {
    nameid.value = nameText;
	surname.value = surnameText;
    nameid.nextElementSibling.classList.add("active");
	surname.nextElementSibling.classList.add("active");
  } else {
    nameid.value = '';
	surname.value = '';
    nameid.nextElementSibling.classList.remove("active");
	surname.nextElementSibling.classList.remove("active");
  }
});