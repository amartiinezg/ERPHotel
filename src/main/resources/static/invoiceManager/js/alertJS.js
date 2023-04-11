function deleteInvoice(id) {
    console.log(id);
    swal({
        title: "Eliminar Factura",
        text: "Si eliminas una factura se eliminaran las lineas de factura que contiene, quieres continuar?",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((OK) => {
            if (OK) {
                $.ajax({
                    url:"/deleteInvoice/"+id,
                    success: function(res) {
                        console.log(res);
                    },
                });
                swal("La factura se ha eliminado correctamente", {
                    icon: "success",
                }).then((ok)=>{
                    if(ok){
                        location.reload();
                    }
                });
            }
        });


}

function deleteInvoiceLine(invoice_line_id) {
    console.log(invoice_line_id);
    swal({
        title: "Esta seguro de Eliminar?",
        text: "Una vez eliminado no se prodra restablecer!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((OK) => {
            if (OK) {
                $.ajax({
                    url:"/deleteInvoiceLine/"+invoice_line_id,
                    success: function(res) {
                        console.log(res);
                    },
                });
                swal("La linea factura se ha eliminado correctamente", {
                    icon: "success",
                }).then((ok)=>{
                    if(ok){
                        location.reload();
                    }
                });
            }
        });
}

function containLinesError(title, text){

    Swal.fire({
        icon: 'error',
        title: title,
        text: text,
    })
}
