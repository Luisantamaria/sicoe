<!DOCTYPE html>
<html lang="en" ng-app="app-eventos">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Sistema Control de Eventos, para la Universidad Peruana Unión Filial Tarapoto - 2016">
    <meta name="author" content="Ing. Luis Santa María Ticlavilca">

    <title>SICOE</title>
    <link href="../../sicoe/recursos/plugins/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../sicoe/recursos/css/eventos-admin.css" rel="stylesheet">
    <link href="../../sicoe/recursos/plugins/fontawesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
    <script src="../../sicoe/recursos/plugins/angularJs/angular.min.js"></script>
    <script src="../../sicoe/recursos/plugins/angularJs/angular-sanitize.min.js"></script>
    <script src="../../sicoe/recursos/js/angularApp.js"></script>
    <script src="../../sicoe/recursos/js/mantenimiento.js"></script>
</head>
<jsp:useBean id="usuario" scope="session" class="java.lang.String"/>
<jsp:useBean id="rol" scope="session" class="java.lang.String"/>
<body ng-controller="ctr-eventos">
    <%
        if(usuario.equals("")){
            response.sendRedirect(request.getContextPath());
        }
        
    %>
    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="dashboard.evt">SICOE</a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
                
                
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> <strong><small>Usuario:</small> ${usuario}</Strong> <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="close.evt"><i class="fa fa-fw fa-power-off"></i> Cerrar Sesión</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - se colapsan cuando el tamaño de pantalla se reduce -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li class="active">
                       <a>Sistema Control de Eventos</a>
                   </li>
                    <li class="">
                        <a href="dashboard.evt"><i class="fa fa-fw fa-dashboard"></i> Asistencia</a>
                    </li>                   
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#repAsis"><i class="fa fa-line-chart"></i> Reportes <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="repAsis" class="collapse">
                            <li>
                                <a href="./redirect.evt?rd=rpasis">Reporte Asistencia</a>
                            </li>
                        </ul>
                    </li>
                                
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                
