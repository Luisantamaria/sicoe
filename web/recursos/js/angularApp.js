//::: LT49 - 2016 :::
//
//Codigo JS puro - Valida Cajas de texto solo numeros
function txtSoloNumeros(e) {
    key = e.keyCode || e.which;
    teclado = String.fromCharCode(key);
    numeros = "0123456789.";
    especiales = "8-37-38-46";//array
    tecladoEspecial = false;

    for (var i in especiales) {
        if (key == especiales[i]) {
            tecladoEspecial = true;
        }
    }

    if (numeros.indexOf(teclado) == -1 && !tecladoEspecial) {
        return false;
    }
}

/*function validar(e) {
  tecla = (document.all) ? e.keyCode : e.which;
  if (tecla==13) limpiarText();
}*/


//Limpiar Input JS
var limpiarText = function (){
    document.getElementById("documento").value = "";
};

var validar = function (e){
    key = e.keyCode || e.which;
     if (key === 13) {
            limpiarText();
        }
};
//************************************************************************
//************************************************************************
//************************************************************************
//************************************************************************
var app = angular.module("app-eventos", ['ngSanitize']);
app.controller("ctr-eventos", function ($scope, $http, $sce, $timeout) {

//::::::::::::::::::::: Formulario Registro de Asistentes ::::::::::::::::::::::
//    $scope.intro = function(){
//        alert("Enter")        ;
//    }
    
    $scope.asistencia = {};

    //La Magia de AJAX
    $scope.asistencia.registrar = function () {
        $scope.asistencia.action = "val";
        $http.post('../sicoe/action.evt', $scope.asistencia)
                .success(function (res) {
                    switch (res.mensaje) {
                        case "si":
                            //$scope.clear();
                            $scope.mensaje(res.mensaje, res);
                            break;
                        case "no":
                            $scope.asistencia.action = "reg";
                            $http.post('../sicoe/action.evt', $scope.asistencia)
                                    .success(function (res) {
                                        if (res.mensaje === "OK") {
                                            //$scope.clear();
                                            $scope.mensaje(res.mensaje, res);
                                        } else {
                                            $scope.mensaje(res.mensaje, res);
                                        }
                                    });
                                    //$scope.clear();
                            break;
                        case "nulo":
                            $scope.mensaje(res.mensaje, res);
                            //$scope.clear();
                            break;
                    }

                });
           //$scope.asistencia.documento = "";     
    };
    
    $scope.clear = function () {
        $scope.asistencia.documento = "";
    };
    //Mensajes AJAX
    app.filter('unsafe', function($sce) {
        return function(val) {
            return $sce.trustAsHtml(val);
        };
    });
    $scope.mensaje = function (op, data) {
        switch (op) {
            case "si":
//                app.filter('unsafe', function($sce) {
//                    return function(val) {
//                        return $sce.trustAsHtml(val);
//                    };
//                });
                //ya esta registrado duplicidad
                $scope.miHtml = $sce.trustAsHtml(""+
                    "<div class='alert alert-warning alert-dismissable alert-asis'>"+
                      "<a type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;</a>"+  
                          "<div class='col-xs-12 col-sm-10 col-md-9 col-lg-10'>"+                                
                            "<i class='fa fa-exclamation-circle'></i><strong> Cuidado! Registro Duplicado.</strong>"+
                            "<hr>"+
                            "<p>Ya fue registrado:</p>"+
                            "<p> <strong>Nombre: </strong> "+data.nombres+" "+data.apellidoPat+" "+data.apellidoMat+"</p>"+
                            "<p> <strong>E.P.: </strong> "+data.ep+" | <strong>Documento: </strong>"+data.dni+"</p>"+ 
                       "</div> "+                              
                       "<div class='col-xs-4 col-sm-2 col-md-3 col-lg-2 col-xs-offset-4 col-sm-offset-0 col-md-offset-0 col-lg-offset-0'>"+
                           "<img src='../sicoe/recursos/img/00000000.jpg' alt='foto' class='img-rounded foto-asis'>"+
                       "</div>"+                                 
                    "</div>");
                break;
            case "OK":
                //"El alumno se registro correctamente.";
                $scope.miHtml = $sce.trustAsHtml(""+
                    "<div class='alert alert-success alert-dismissable alert-asis'>"+
                      "<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;</button>"+  
                          "<div class='col-xs-12 col-sm-10 col-md-9 col-lg-10'>"+                                
                            "<i class='fa fa-thumbs-o-up'></i>  <strong>Felicidades! Registro Correcto.</strong>"+
                            "<hr>"+
                            "<p>Se registro satisfactoriamente a:</p>"+
                            "<p> <strong>Nombre: </strong> "+data.nombres+" "+data.apellidoPat+" "+data.apellidoMat+"</p>"+
                            "<p> <strong>E.P.: </strong> "+data.ep+" | <strong>Documento: </strong>"+data.dni+"</p>"+ 
                       "</div> "+                              
                       "<div class='col-xs-4 col-sm-2 col-md-3 col-lg-2 col-xs-offset-4 col-sm-offset-0 col-md-offset-0 col-lg-offset-0'>"+
                           "<img src='../sicoe/recursos/img/00000000.jpg' alt='foto' class='img-rounded foto-asis'>"+
                       "</div>"+                                 
                    "</div>");
                break;
            case "nulo":
                //no existe en la DB
                $scope.miHtml = $sce.trustAsHtml(""+
                    "<div class='alert alert-danger alert-dismissable alert-asis'>"+
                      "<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;</button>"+  
                          "<div class='col-xs-12 col-sm-10 col-md-9 col-lg-10'>"+                                
                            "<i class='fa fa-warning'></i>  <strong>Error! Registro Incorrecto.</strong>"+
                            "<hr>"+
                            "<p>No se pudo registrar:</p>"+
                            "<p><strong>Documento: </strong>"+data.dni+"</p>"+ 
                            "<p>Debido aque no esta registrado en el Evento.</p>"+ 
                       "</div> "+                      
                    "</div>");
                break;
            case "NOK":
                $scope.miHtml = "Ocurrio un error al registrar el documento <Strong>"+data.dni+"</Strong. Error de Sistema.";
                break;
        }
    }

    $scope.enviarFrm = function ($event) {
        var keyCode = $event.which || $event.keyCode;
        if (keyCode === 13) {
            $scope.asistencia.registrar();
        }
    }

    
//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::  
//:::::::::::::::::::Modulo Mantenimiento ::::::::::::::::::::::::::::::::::::::::::::
    
    $scope.lsOrganizador = function($http){
        http.post("")
        .success(function(res){
            
        });
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
});