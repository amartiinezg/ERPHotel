var botonIframe = document.getElementById("btn_statusRoom");
var zonaIframe = document.getElementById("ModuleWidget");
var btnDashboard = document.getElementById("btn_dashboard");
var btnAddBooking = document.getElementById("btn_addBooking");
var btnManageInvoices = document.getElementById("btn-manageInvoices")



botonIframe.onclick = function () {
  zonaIframe.innerHTML = '<iframe src="rooms" width="100%" height="900"></iframe>';
};
btnDashboard.onclick = function () {
  zonaIframe.innerHTML = '';
}
btnAddBooking.onclick = function (){
  zonaIframe.innerHTML = '<iframe src="hotel_booking" width="100%" height="100%"></iframe>';
}
btnManageInvoices.onclick = function (){
  zonaIframe.innerHTML = '<iframe src="invoice" width="100%" height="100%"></iframe>';
}