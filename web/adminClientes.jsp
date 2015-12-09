<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<html>
    <head>
        <meta charset=UTF-8"/>
        <title>Control de Asistencia</title>
        <%@include file="header.txt"%>
        <%@include file="footer.txt" %>
        <sj:head jqueryui="true" jquerytheme="start"/>

    </head>
    <body>
        <div id="wrapper">
            <%@include file="menu.jspf" %>
            <div id="page-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">

                            <sj:tabbedpanel id="tabs" cssClass="listas">

                                <sj:tab id="lista_empleados" target="tabListaEmpleados" label="Listar Empleados"/>
                                <sj:tab id="ingreso_empleados" target="tabIngresoEmpleados" label="Ingresar Empleados"/>
                                <sj:tab id="modificar_empleados" target="tabActualizarEmpleados" label="Actualizar Empleados"/>

                                <div id="tabListaEmpleados">
                                    <h3>
                                        Lista de Empleados
                                    </h3>
                                    <table class="table table-bordered">
                                        <thead>
                                        <th>Rut</th>
                                        <th>Nombre</th>
                                        <th>Apellido</th>
                                        <th>Direccion</th>
                                        <th>Teléfono</th>
                                        <th>Email</th>
                                        <th>Afp</th>
                                        <th>Previsión</th>
                                        <th>Rol</th>
                                        </thead>
                                        <tbody>
                                            <s:iterator value="records" var="dato" status="estado">
                                                <tr>
                                                    <!-- los nombre de valores de las propiedades deben ser los mismos que en la clase del modelo-->
                                                    <td ><s:property value="rut" /></td>
                                                    <td><s:property value="nombres" /></td>                                          
                                                    <td><s:property value="apellidos" /></td>
                                                    <td><s:property value="direccion" /></td>
                                                    <td><s:property value="telefono" /></td>
                                                    <td><s:property value="email" /></td>
                                                    <td><s:property value="afp_id.nombre" /></td>
                                                    <td><s:property value="prevision_id.prevision" /></td>
                                                    <td><s:property value="rol_id.nombres" /></td>
                                                    <td>
                                                        <s:url id="url" action="buscarEmpleado">
                                                            <s:param name="codigoEmpleado">
                                                                <s:property value="rut"></s:property>                                                                    
                                                            </s:param>                                                               
                                                        </s:url>
                                                        <s:a href="%{url}" cssClass="fs1" aria-hidden="true">Actualizar</s:a>

                                                        <s:a action="eliminarEmpleado">
                                                            <s:param name="rut" value="rut" />
                                                            <i class="glyphicon glyphicon-trash"></i>
                                                        </s:a>    
                                                    </td>
                                                </tr>
                                            </s:iterator>
                                        </tbody>
                                    </table>
                                    <sj:datepicker name="calendario" label="Calendario" displayFormat="dd/mm/yy"></sj:datepicker>     
                                    </div>
                                    
                                    <div id="tabIngresoEmpleados">
                                    <s:form action="ingresarEmpleado" theme="bootstrap" label="Ingrese Empleados">
                                        <s:textfield
                                            label="Rut"
                                            name="rut"/>
                                        <s:textfield
                                            label="Nombre"
                                            name="nombres"/>
                                        <s:textfield
                                            label="Apellidos"
                                            name="apellidos"/>
                                        <s:textfield
                                            label="Dirección"
                                            name="direccion"/>
                                        <s:select 
                                            label="Ciudad"
                                            list="listaCiudades"
                                            listValue="nombre"
                                            name="IdCiudad"
                                            listKey="id"
                                         /> 
                                        <s:select
                                            label="Nacionalidad"
                                            list="listaNacionalidad"
                                            listValue="pais"
                                            name="IdNacionalidad"
                                            listKey="id"
                                         />  
                                         <sj:datepicker name="fechaNac" label="Fecha Nacimiento"  displayFormat="dd/mm/yy"></sj:datepicker>
                                        <s:select
                                            label="Estado Civíl"
                                            list="listaEstadoCivil"
                                            listValue="nombre"
                                            name="IdEstadoCivil"
                                            listKey="id"
                                         /> 
                                        <sj:spinner name="cargasFam" label="Cargas Familiares"  readonly="false" max="100" min="0" tooltip="Ingresar una cantidad" />                                      
                                        <s:select
                                            label="Afp"
                                            list="listaAfp"
                                            listValue="nombre"
                                            name="IdAfp"
                                            listKey="id"
                                         /> 
                                        <s:select
                                            label="Previsión"
                                            list="listaPrevision"
                                            listValue="prevision"
                                            name="IdPrevision"
                                            listKey="id"
                                            />
                                        <s:textfield
                                            label="Teléfono"
                                            name="telefono"/>
                                        <s:textfield
                                            label="Email"
                                            name="email"/>
                                        <s:select
                                            label="Profesión"
                                            list="listaProfesion"
                                            listValue="profesion"
                                            name="IdProfesion"
                                            listKey="id"
                                            />
                                       <s:select
                                            label="Rol"
                                            list="listaRoles"
                                            listValue="nombres"
                                            name="IdRol"
                                            listKey="id"
                                            />
                                        <s:textfield
                                            label="Password"
                                            name="password"/>
                                        <br>
                                        <s:submit value="Grabar datos" cssClass="btn btn-primary"/>
                                    </s:form>

                                </div>

                                <div id="tabActualizarEmpleados">                                
                                    <s:form action="actualizarEmpleado"  theme="bootstrap">   
                                        <s:textfield name="rut" label="Rut" value="%{record.rut}"  readonly="true"></s:textfield>
                                        <s:textfield name="nombres" label="Nombre" value="%{record.nombres}"></s:textfield>
                                        <s:textfield name="apellidos" label="Apellidos" value="%{record.apellidos}"></s:textfield>            
                                        <s:textfield name="direccion" label="Direccion" value="%{record.direccion}"></s:textfield>
                                        <s:textfield name="IdCiudad" label="Ciudad" value="%{record.ciudad_id.nombre}"></s:textfield>
                                        <s:textfield name="IdNacionalidad" label="Nacionalidad" value="%{record.nacionalidad_id.pais}"></s:textfield>
                                        <s:textfield name="fechaNac" label="Fecha de Nacimiento" value="%{record.fechaNac}"></s:textfield>
                                        <s:textfield name="IdEstadoCivil" label="Estado Civil" value="%{record.estado_civil_id.nombre}"></s:textfield>
                                        <s:textfield name="cargasFam" label="Cargas Familiares" value="%{record.cargasFam}"></s:textfield>
                                        <s:textfield name="IdAfp" label="AFP" value="%{record.afp_id.nombre}"></s:textfield>
                                        <s:textfield name="IdPrevision" label="Prevision" value="%{record.prevision_id.prevision}"></s:textfield>
                                        <s:textfield name="telefono" label="Teléfono" value="%{record.telefono}"></s:textfield>
                                        <s:textfield name="email" label="Email" value="%{record.email}"></s:textfield>
                                        <s:textfield name="IdProfesion" label="Profesion" value="%{record.profesion_id.profesion}"></s:textfield>
                                        <s:textfield name="IdRol" label="Rol" value="%{record.rol_id.nombres}"></s:textfield>
                                        <s:textfield name="password" label="Contraseña" value="%{record.password}"></s:textfield>
                                        <s:submit value="Actualizar"></s:submit>
                                    </s:form>
                                </div> 

                            </sj:tabbedpanel>    
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
