var zonaIframe = document.getElementById("ModuleWidget");
var btnDashboard = document.getElementById("btn_dashboard");
var btnAddBooking = document.getElementById("btn_addBooking");
var btnStatusRoom = document.getElementById("btn_statusRoom");



btnStatusRoom.onclick = function () {
  zonaIframe.innerHTML = '<iframe src="rooms" width="100%" height="100%"></iframe>';
};
btnDashboard.onclick = function () {
  zonaIframe.innerHTML = '';
}
btnAddBooking.onclick = function (){
  zonaIframe.innerHTML = '<iframe src="hotel_booking" width="100%" height="100%"></iframe>';
}