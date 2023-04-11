var dropdown = document.getElementById("myDropdown");

// Agregar un evento 'click' a cada opción en el Dropdown
var options = dropdown.querySelectorAll(".dropdown-item");
for (var i = 0; i < options.length; i++) {
    options[i].addEventListener("click", function() {
        // Obtener el texto de la opción que se hizo clic
        var selectedText = this.textContent;

        // Actualizar el texto del botón Dropdown con el texto de la opción seleccionada
        var dropdownToggle = dropdown.querySelector(".dropdown-toggle");
        dropdownToggle.innerHTML = selectedText + '<span class="caret"></span>';
        dropdownToggle.setAttribute('aria-expanded', false);
    });
}