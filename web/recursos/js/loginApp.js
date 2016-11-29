var app = angular.module("app-evt-login", ['ngSanitize']);
app.controller("ctr-login", function ($scope, $http) {
    
    //|||||||||||||||||| FORM LOGIN |||||||||||||||||||||||||||||||||||||||||||    
    $scope.enviarFrmA = function ($event) {
        var keyCode = $event.which || $event.keyCode;
        if (keyCode === 13) {
            $scope.data.comprobar();
        }
    }
        
    $scope.redireccionar = function () {
        var form = document.getElementById("frmlogin");
        form.submit();
    }
    //alert("Angular");
    $scope.data = {};
    $scope.data.comprobar = function () {
        //alert("Angular");
        $scope.data.action = "login";
        $http.post("login.evt", $scope.data)
                .success(function (res) {
                    //alert("Angular entro al Callback");
                    if (res == "valido") {
                        //alert("OK! Usuario Correcto");
                        $scope.redireccionar();
                    } else {
                        $scope.msj = "Usuario / Contraseña Incorrecto.";
                    }
                });
    }

   $scope.data.action = "hbn";
   $http.post("login.evt", $scope.data)
    .success(function (res) {
        if (res === "KHBN") {
            //alert("hbn Cargado");
        } else {
            //alert("hbn No se Cargo");
        }
    });
    
});