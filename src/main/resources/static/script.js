const loginBtn = document.getElementById("login-btn");
const registerBtn = document.getElementById("register-btn");
const loginForm = document.getElementById("login-form");
const registerForm = document.getElementById("register-form");

// Mostrar formulario de inicio de sesión y ocultar registro
loginBtn.addEventListener("click", () => {
    loginBtn.classList.add("active");
    registerBtn.classList.remove("active");
    loginForm.classList.add("active");
    registerForm.classList.remove("active");
});

// Mostrar formulario de registro y ocultar inicio de sesión
registerBtn.addEventListener("click", () => {
    loginBtn.classList.remove("active");
    registerBtn.classList.add("active");
    loginForm.classList.remove("active");
    registerForm.classList.add("active");
});