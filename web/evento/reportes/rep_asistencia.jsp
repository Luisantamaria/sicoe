<%@include file="../../WEB-INF/fragmentos/topN2.jsp" %> 
<%@page import="upeu.edu.pe.model.bean.EventosViewBean"%>
<%@page import="java.util.List"%>
<%@page import="upeu.edu.pe.model.entity.view.EventosView"%>
             
<jsp:useBean id="reporteAsistente" scope="request" type="java.util.List<EventosViewBean>"/>
               <div class="row">
                    <div class="col-lg-12">
                        <h4 class="page-header">
                            Reportes
                            <small>Reporte de asistencia</small>
                        </h4>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="dashboard.evt">Reportes</a>                                
                            </li>
                            
                        </ol>
                    </div>
                   <div class="col-lg-12">
                           <div class="col-sm-4 col-md-4 col-lg-4 col-sm-offset-4 col-md-offset-4 col-lg-offset-4">
                               <div class="input-group input-group-md">
                                   <input type="text" class="form-control buscar-asis" placeholder="Ingrese busqueda">
                                    <span class="input-group-addon">
                                        <span class="glyphicon glyphicon-search"></span>
                                    </span>
                               </div>
                            </div>
                    </div>
                   <br><br>
                </div>
                <!-- /.row -->
                <div class="row">    
                    <div class="container-evt col-xs-12 col-sm-12 col-md-12 col-lg-12 col-lg-offset-0"> 
                       
                       <div class="table-responsive marco">
                            <table class="table table-bordered table-hover table-striped tabla-rep">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Voucher</th>
                                        <th>Carne</th>
                                        <th>Nombres</th>
                                        <th>Apellido Paterno</th>
                                        <th>Apellido Materno</th>
                                        <th>Dni</th>
                                        <th>EP</th>
                                        <th>Asistencia</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        String row = "danger";
                                        int count = 0;
                                      for(EventosViewBean ev: reporteAsistente){
                                          count++;
                                          
                                    %>
                                    <tr class="<%= row=ev.getEstado_cea()=='1'?"success":row %>">
                                        <td><%= count %></td>
                                        <td><%= ev.getVoucher() %></td>
                                        <td><%= ev.getCarne() %></td>
                                        <td><%= ev.getNombres() %></td>
                                        <td><%= ev.getApellidoPat() %></td>
                                        <td><%= ev.getApellidoMat() %></td>
                                        <td><%= ev.getDni() %></td>
                                        <td><%= ev.getEp() %></td>
                                        <td><%= ev.getEstado_reg_cea() %></td>
                                    </tr>
                                    
                                    <% row = "danger";}%>
                                </tbody>
                            </table>
                        </div> 
                   </div>   
               </div>                        
                                                          
                                                                             
<%@include file="../../WEB-INF/fragmentos/bottomN2.jsp" %>