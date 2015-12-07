<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   
    <head>           
        <%@include file="header.txt" %>
        <%@include file="footer.txt" %>
        <sj:head jqueryui="true" jquerytheme="start"/> 
        <meta charset=UTF-8">
        <title>Gestion de Maquinaria</title>
    </head>
    <body>
        <div id="wrapper">
            <%@include file="menu.jspf" %>
            <div id="page-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                    
                        <sj:tabbedpanel id="tabs" cssClass="list">
                                <sj:tab id="lista_maquinaria" target="tabListaMaquinaria" label="lista de Maquinarias" />
                                <sj:tab id="ingreso_maquinaria" target="tabIngresarMaquinaria" label="Ingresar Maquinaria"/>
                                <sj:tab id="modificacion_maquinaria" target="tabModificarMaquinaria" label="Modificar Maquinaria" ondblclick=""/>    

                                <div id="tabListaMaquinaria">
                                  <h3>Maquinarias de Construcción</h3>
                                    <table class="table table-borderd">
                                        <thead>
                                        <th>Patente</th>
                                        <th>Tipo Maquinaria</th>
                                        <th>Año</th>
                                        <th>Propia</th>
                                        <th>Valor Hora</th>
                                        <th>Acciones</th>
                                        </thead>
                                        <tbody>

                                            <s:iterator value="records" var="dato" status="estado">
                                                <tr>
                                                    <!-- los nombre de valores de las propiedades deben ser los mismos que en la clase del modelo-->
                                                    <td><s:property value="patente" /></td>
                                                    <td><s:property value="tipo_maq.tipo" /></td>                                          
                                                    <td><s:property value="anio" /></td>
                                                    <td><s:property value="propia" /></td>
                                                    <td><s:property value="valor_hora" /></td>
                                                    <td>
                                                           <s:url id="url" action="buscaMaqPorPatente">
                                                                <s:param name="patente">
                                                                    <s:property value="patente"></s:property>                                                                    
                                                                </s:param>                                                               
                                                            </s:url>
                                                           <s:a href="%{url}" cssClass="fs1" aria-hidden="true"  >Actualizar</s:a>
                                                            
                                                            
                                                        <s:a action="eliminarMaquinariaAccion">
                                                            <s:param name="patente" value="patente" />
                                                            <i class="glyphicon glyphicon-trash"></i>
                                                        </s:a>    
                                                    </td>
                                                </tr>
                                            </s:iterator>
                                        </tbody>
                                    </table>  
                                </div>
                                
                                
                                <div id="tabIngresarMaquinaria">
                          
                                    <s:form action="IngresarMaquinaria" theme="bootstrap" label="Ingrese los datos">
                                        <s:textfield
                                            label="Patente"
                                            name="patente"/>
                                        <s:textfield
                                            label="Tipo Maquinaria"
                                            name="tipoMaquinaria"/>
                                       <s:textfield
                                            label="Año de la maquinaria"
                                            name="ano"/>
                                       <s:textfield
                                            label="Propia/Arrendada"
                                            name="propia"/>
                                       <s:textfield
                                            label="Valor Hora"
                                            name="valor_hora"/>
                                        <br>
                                        <s:submit value="Grabar datos" cssClass="btn btn-primary"/>
                                    </s:form>
                         
                               </div>
                                
                                
                             <div id="tabModificarMaquinaria">                                
                               
                                 <s:form action="actualizaMaquinaria"  theme="bootstrap">   
                                    <s:textfield name="patente" label="Patente" value="%{record.patente}"  readonly="true"></s:textfield>
                                    <s:textfield name="tipoMaquinaria" label="Tipo de Maquinaria" value="%{record.tipo_maq.tipo}"></s:textfield>
                                    <s:textfield name="ano" label="Año" value="%{record.ano}"></s:textfield>            
                                    <s:textfield name="propia" label="Propia/Arrendada" value="%{record.propia}"></s:textfield>
                                    <s:textfield name="valorHora" label="Valor Hora" value="%{record.valor_hora}"></s:textfield>
                                    <s:submit value="Actualizar"></s:submit>
                                 </s:form>
                               <!---  < //s:url var="remoteurl" action="jsontable"/>
                                    <#/ sjg:grid
                                        id="gridtable"
                                        caption="Customer Examples"
                                        dataType="json"
                                        href="%{remoteurl}"
                                        pager="true"
                                        gridModel="gridModel"
                                        rowList="10,15,20"
                                        rowNum="15"
                                        rownumbers="true"
                                        >
                                        <#sjg:gridColumn name="codigo" index="codigo" title="Código" formatter="integer" sortable="false"/>
                                        <#/sjg:grid>
                                  -->
                                </div> 
                                    
                                    
                               </sj:tabbedpanel>              
                         
                        </div>

                    </div><!-- /.row -->  
                </div> <!-- /.container-fluid -->
            </div> <!-- /#page-wrapper -->
        </div>  <!-- /#wrapper -->
 
    </body>
</html>