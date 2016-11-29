<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@include file="../../WEB-INF/fragmentos/topN2.jsp" %> 
<%@page import="upeu.edu.pe.model.entity.EventoSesion"%>
<jsp:useBean id="listaEventoSesion" scope="request" type="java.util.List<EventoSesion>"/>
                <div class="row">
                    <div class="col-lg-12">
                        <h4 class="page-header">
                            Asistencia
                            <small>Gestionar asistencia</small>
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
                        
                        
                        
                        
                       <div class="col-xs-12 col-sm-12 col-md-12 col-lg-10 col-md-offset-1"> 
                         <div class="table-responsive marcocasis">                         
                              
                               
                                <table class="table table-bordered table-hover table-striped tabla-rep">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Sesión</th>
                                            <th>Fecha</th>
                                            <th>Hora</th>
                                            <th>Descripción</th>
                                            <th>estado</th>
                                            <th>Acción</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                    <%
                        int count = 0;
                        String label = "<span class='label label-danger'>inactivo</span>";
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
                                        <td><%=evs.getEstado()=='1'?"<span class='label label-success'>activo</span>":label%></span></td>
                                        <td>
                                              <div class="orm-control pull-left">
                                                  <a href="action?op=updtgesasis&ideventoSesion=<%= evs.getIdeventoSesion() %>&estadoSesion=<%= evs.getEstado()%>" class="btn btn-block btn-warning btn-xs eliminar" title="Cambiar Estado"> 
                                                    <i class="fa fa-refresh"></i>
                                                  </a>
                                              </div>
                                             <!-- <div class="orm-control pull-left">
                                                  <a id="<%= evs.getIdeventoSesion() %>" class="btn btn-block btn-danger btn-xs eliminar" data-toggle="modal" data-target="#eliminarModulo<%= evs.getIdeventoSesion() %>" title="Eliminar"> 
                                                    <i class="fa fa-trash-o"></i>
                                                  </a>
                                              </div>-->
                                        </td>
                                    </tr>
                                    
                    <!-- Modal Eliminar Modulo -->
                      <div class="modal animated lightSpeedIn" id="eliminarModulo<%= evs.getIdeventoSesion() %>" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                        <div class="modal-dialog" role="document">
                          <div class="modal-content">
                              
                            <form action="action" method="POST">  
                                <div class="modal-header">  
                                    <input type="hidden" name="ideventoSesion"  value="<%= evs.getIdeventoSesion() %>">
                                    <input type="hidden" name="estadoSesion"  value="<%= evs.getEstado()%>">
                                    <input type="hidden" name="op"  value="updtgesasis">
                                  <h4 class="modal-title">
                                    
                                    <img src="../../sicoe/recursos/img/Warning.png" width="70" height="70">
                                      ¿Esta seguro que desea cambiar de estado a la Sesión '"<strong><%= evs.getSesion() %></strong>"'?
                                  </h4>

                                </div>

                                <div class="modal-footer">
                                  <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>                                      

                                  <input type="submit" class="btn btn-danger" data-dismiss="modal" value="Si, Cambiar">
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
                        
                        
                        
                    </div>     
                </div>
                
<%@include file="../../WEB-INF/fragmentos/bottomN2.jsp" %>
