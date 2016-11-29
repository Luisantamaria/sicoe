
<%@page import="upeu.edu.pe.model.entity.EventoSesion"%>
<%@include file="../../WEB-INF/fragmentos/topN2.jsp" %> 
<jsp:useBean id="listaEventoSesion" scope="request" type="java.util.List<EventoSesion>"/>
                <div class="row">
                    <div class="col-lg-12">
                        <h4 class="page-header">
                            Asistencia
                            <small>Crear asistencia</small>
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
                    <div class="container-evt col-xs-12 col-sm-12 col-md-12 col-lg-12 col-lg-offset-0">
                        
                        
                      <!--<div class="col-xs-12 col-md-4 col-md-offset-4 "> 
                          <button type="button" id="agregarModal" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#agregarSesion" title="Agregar Sesión">
                              <i class="fa fa-user-plus"></i>
                              Nueva Sesión
                          </button>
                      </div> -->
                        
                        
                        <script type="text/javascript">
                            $(function () {
                                $('#datetimepicker1').datetimepicker();
                            });
                        </script> 
                        
                       <div class="col-xs-12 col-sm-12 col-md-12 col-lg-10 col-md-offset-1"> 
                         <div class="table-responsive marcocasis">  
                             <button type="button" id="agregarModal" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#agregarSesion" title="Agregar Sesión">
                                <i class="fa fa-user-plus"></i>
                                Nuevo Evento Sesión
                            </button>
                              <form class="form-horizontal col-xs-12 col-md-6 col-md-offset-3">
                                  <div class="form-group">
                                    <label for="organizador" class="col-sm-3 control-label">Organizador</label>
                                    <div class="col-sm-9">
                                       <select id="organizador" class="form-control">
                                            <option>FIA</option>
                                            <option>FCE</option>
                                            <option>FCS</option>
                                        </select>
                                    </div>
                                  </div>
                                  <div class="form-group">
                                    <label for="evento" class="col-sm-3 control-label">Evento</label>
                                    <div class="col-sm-9">
                                       <select id="evento" class="form-control">
                                            <option>evento1</option>
                                            <option>evento2</option>
                                        </select>
                                    </div>
                                  </div>
                                </form>   
                               
                                <table class="table table-bordered table-hover table-striped tabla-rep">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Sesión</th>
                                            <th>Fecha</th>
                                            <th>Hora</th>
                                            <th>Descripción</th>
                                            <th>Acción</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                    <%
                        int count = 0;
                        for(EventoSesion evs: listaEventoSesion){
                            count++;
                            String hour = evs.getHora().toString();
                            String fecha = evs.getFecha().toString();
                    %>        
                                    <tr>
                                        <td><%= count %></td>
                                        <td><%= evs.getSesion()%></td>
                                        <td><%= fecha.substring(0,10) %></td>
                                        <td><%= hour.substring(10,16) %></td>
                                        <td><%= evs.getDescripcion()%></td>
                                        <td>
                                             

                                              <div class="orm-control pull-left">
                                                  <a id="<%%>" class="btn btn-block btn-danger btn-xs eliminar" data-toggle="modal" data-target="#eliminarSesion<%= evs.getIdeventoSesion() %>" title="Eliminar"> 
                                                    <i class="fa fa-trash-o"></i>
                                                  </a>
                                              </div>
                                        </td>
                                    </tr>
                                    
                   <!-- Modal Eliminar Modulo -->
                              <div class="modal animated lightSpeedIn" id="eliminarSesion<%= evs.getIdeventoSesion()%>" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                <div class="modal-dialog" role="document">
                                  <div class="modal-content">
                                    <div class="modal-header">                  
                                      <h4 class="modal-title" id="dell">
                                        <input type="hidden" name="moduloHide" id="nombreDell<% %>" value="<% %>">
                                        <img src="../../sicoe/recursos/img/Warning.png" width="70" height="70">
                                          ¿Esta seguro que desea eliminar la Sesión "<strong><%= evs.getSesion() %></strong>"?</h4>
                                       
                                    </div>
                                  <form action="#" method="POST">
                                        <div class="modal-footer">
                                          <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>                                      

                                          <button type="submit" class="btn btn-danger" data-dismiss="modal" id="delete">Si, eliminar</button>
                                        </div>
                                  </form>        
                                          
                                  </div>
                                </div>
                              </div>

                    <!-- ****************************************************************************************** -->                 
                                    
                                    
                                    
                   <%}%>
                                    
                                    
                                    </tbody>
                                </table>
                            </div>
                       </div>
                        
         <!-- Modal Agregar EventoSesion -->
          <div class="modal fade" id="agregarSesion" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
              <div class="modal-content">
                <div class="modal-header">                  
                  <h4 class="modal-title" id="Agregar Modulo"><i class="fa fa-user-plus"></i> Nueva Sesión</h4>
                </div>
              <form class="form-horizontal" id="frmagregar" action="action?op=addcreasis" method="POST">
                <div class="modal-body">
                  
                    <!-- formulario -->
                      <p>*Debe llenar todos los campos</p>
                      
                      
                        <div class="form-group">
                          <label for="nombre" class="col-sm-2 control-label">Sesión</label>
                          <div class="col-sm-10">
                            <input type="text" class="form-control" name="sesion" id="nombreAdd" placeholder="Nombre de la Sesión">
                          </div>
                        </div>
                          
                        <div class="form-group">
                          <label for="icono" class="col-sm-2 control-label">Fecha</label>
                          <div class="col-sm-10">
                                <div class='input-group date' id='datetimepicker1'>
                                    <input type='text' class="form-control" name="fecha" placeholder="Ingrese la fecha"/>
                                    <span class="input-group-addon">
                                        <span class="glyphicon glyphicon-calendar"></span>
                                    </span>
                                </div>
                          </div>
                        </div>
                        <div class="form-group">
                          <label for="nombre" class="col-sm-2 control-label">Descripción</label>
                          <div class="col-sm-10">
                              <textarea class="form-control" name="descripcion" placeholder="Descripción de la Sesión"></textarea>
                          </div>
                        </div>
                          
                     
                    <!-- fin formulario -->

                </div>
                <div class="modal-footer">
                  <a href="#" class="btn btn-default" data-dismiss="modal" id="cerrarAdd"><i class="fa fa-close"></i> Cerrar</a>
                  <button type="submit" class="btn btn-primary"><i class="fa fa-save"></i> Guardar</button>
                </div>
               </form>
              </div>
            </div>
          </div>
        <!-- fin Modal Agregar --> 
                                                    
                                                    
                                                    
                                                    
                                                    
                                                    
                                                    
                                                    
                                                    
                        
                    </div>     
                </div>
               
<%@include file="../../WEB-INF/fragmentos/bottomN2.jsp" %>
