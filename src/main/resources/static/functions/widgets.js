var zonaIframe = document.getElementById("ModuleWidget");
var btnDashboard = document.getElementById("btn_dashboard");
var btnAddBooking = document.getElementById("btn_addBooking");
var btnStatusRoom = document.getElementById("btn_statusRoom");
var btnAddRoom = document.getElementById("btn_addRoom");
var btnCleaningStatus = document.getElementById("btn_cleaningStatus");



btnStatusRoom.onclick = function () {
    window.history.pushState({}, '', 'http://localhost:8080/person');
    zonaIframe.innerHTML = '<iframe src="rooms" width="100%" height="100%"></iframe>';

};
btnAddRoom.onclick = function () {
    window.history.pushState({}, '', 'http://localhost:8080/person');
    zonaIframe.innerHTML = '<iframe src="newRoom" width="100%" height="100%"></iframe>';
};
btnCleaningStatus.onclick = function () {
    window.history.pushState({}, '', 'http://localhost:8080/person');
    zonaIframe.innerHTML = '<iframe src="cleaningStatus" width="100%" height="100%"></iframe>';
}
btnDashboard.onclick = function () {
    window.history.pushState({}, '', 'http://localhost:8080/person');
    zonaIframe.innerHTML = '';
}
btnAddBooking.onclick = function () {
    window.history.pushState({}, '', 'http://localhost:8080/person');
    zonaIframe.innerHTML = '<iframe src="hotel_booking" width="100%" height="100%"></iframe>';
}