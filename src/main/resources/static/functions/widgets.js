var zonaIframe = document.getElementById("ModuleWidget");
var btnDashboard = document.getElementById("btn_dashboard");
var btnAddBooking = document.getElementById("btn_addBooking");
var btnStatusRoom = document.getElementById("btn_statusRoom");
var btnAddRoom = document.getElementById("btn_addRoom");
var btnCleaningStatus = document.getElementById("btn_cleaningStatus");
var btnShowPerson = document.getElementById("btn_showPersons");
var btnAddPerson = document.getElementById("btn_addPerson");



btnStatusRoom.onclick = function () {
    zonaIframe.innerHTML = '<iframe src="rooms" width="100%" height="100%"></iframe>';
};
btnAddRoom.onclick = function () {
    zonaIframe.innerHTML = '<iframe src="newRoom" width="100%" height="100%"></iframe>';
};
btnCleaningStatus.onclick = function () {
    zonaIframe.innerHTML = '<iframe src="cleaningStatus" width="100%" height="100%"></iframe>';
};
btnDashboard.onclick = function () {
    zonaIframe.innerHTML = '';
};
btnAddBooking.onclick = function () {
    zonaIframe.innerHTML = '<iframe src="hotel_booking" width="100%" height="100%"></iframe>';
};
btnShowPerson.onclick = function () {
    zonaIframe.innerHTML = '<iframe src="person" width="100%" height="100%"></iframe>';
};
btnAddPerson.onclick = function () {
    zonaIframe.innerHTML = '<iframe src="person/new" width="100%" height="100%"></iframe>';
};