<%@include file="../WEB-INF/fragmentos/tophelper.jsp" %>
               <div class="row">
                    <div class="col-lg-12">
                        <h4 class="page-header">
                            Asistencia
                            <small>Control de Asistencia</small>
                        </h4>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="dashboard.evt">Asistencia</a>
                            </li>
                            
                        </ol>
                    </div>
                </div>
                <!-- /.row -->
                <div class="row">    
                   
                    <div class="container container-asis col-xs-12 col-sm-8 col-md-6 col-lg-4 col-sm-offset-2 col-md-offset-3 col-lg-offset-4"> 
                        <form method="post" onkeypress="validar(event)" ng-keypress="enviarFrm($event)">
                            <h4 class="text-center">Ingresar DNI / Código Universitario</h4>
                            <div class="has-feedback">
                                <input id="documento" type="text" name="dni" class="form-control input-asis" ng-model="asistencia.documento" placeholder="Ingresar numero de dni" onkeypress="return txtSoloNumeros(event)" autofocus/>
                                <span class="glyphicon glyphicon-tasks form-control-feedback"></span>
                            </div>
                            
                            <button class="btn btn-success btn-asis" onclick="limpiarText()" ng-click="asistencia.registrar()">Registrar Asistencia</button>
                        </form>
                    </div>
                    <div class="container-response">
                       <div class="col-xs-12 
                            col-sm-12 col-md-8 col-lg-6 col-md-offset-2 col-lg-offset-3 emergente-asis" ng-bind-html="miHtml">
                            
                        </div> 
                        
                        <!--<div class="col-xs-12 col-sm-12 col-md-8 col-lg-6 col-md-offset-2 col-lg-offset-3 emergente-asis">
                            <div class="alert alert-success alert-dismissable alert-asis">
                              <a type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</a>  <div class="col-xs-12 col-sm-10 col-md-9 col-lg-10">                                   
                                    <i class="fa fa-thumbs-o-up"></i>  <strong>¡Felicidades! Registro Correcto.</strong>
                                    <hr>
                                    <p>Se registro satisfactoriamente a:</p>
                                    <p> <strong>Nombre: </strong> Luis Alberto Santa MarÃ­a Ticlavilca</p>
                                    <p> <strong>E.P.: </strong> Sistemas | <strong>Documento: </strong>45448683</p> 
                               </div>                               
                               <div class="col-xs-4 col-sm-2 col-md-3 col-lg-2 col-xs-offset-4 col-sm-offset-0 col-md-offset-0 col-lg-offset-0">
                                   <img src="../recursos/img/00000000.jpg" alt="foto" class="img-rounded foto-asis">
                               </div>                                 
                            </div>
                        </div>-->
                         <!--   
                        <div class="col-xs-12 col-sm-12 col-md-8 col-lg-6 col-md-offset-2 col-lg-offset-3 emergente-asis">
                            <div class="alert alert-warning alert-dismissable alert-asis">
                              <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>  <div class="col-xs-12 col-sm-10 col-md-9 col-lg-10">                                   
                                    <i class="fa fa-exclamation-circle"></i>  <strong>¡Cuidado! Registro Duplicado.</strong>
                                    <hr>
                                    <p>Ya fue registrado:</p>                                    
                                    <p> <strong>Nombre: </strong> Luis Alberto Santa María Ticlavilca</p>
                                    <p> <strong>E.P.: </strong> Sistemas | <strong>Documento: </strong>45448683</p> 
                               </div>                               
                               <div class="col-xs-4 col-sm-2 col-md-3 col-lg-2 col-xs-offset-4 col-sm-offset-0 col-md-offset-0 col-lg-offset-0">
                                   <img src="../recursos/img/00000000.jpg" alt="foto" class="img-rounded foto-asis">
                               </div>                                 
                            </div>
                        </div>    
                            
                         <div class="col-xs-12 col-sm-12 col-md-8 col-lg-6 col-md-offset-2 col-lg-offset-3 emergente-asis">
                            <div class="alert alert-danger alert-dismissable alert-asis">
                              <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>   <i class="fa fa-warning"></i>  <strong>¡Error! Registro Incorrecto.</strong>
                                <hr>
                                <p>No se pudo registrar:</p>
                                <p><strong>Documento: </strong>45448683</p> 
                                <p>Debido aque no esta registrado en el Evento.</p>
                            </div>
                        </div> -->  
                            
                        <!--<div ng-bind-html="miHtml">sdfsdfdfdssdfdsfdsdfsdf</div>-->
                        
                    </div>
                </div>    
                    
<%@include file="../WEB-INF/fragmentos/bottom.jsp" %>                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                
