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
        <title>Asignar Tareas</title>
    </head>
    <body>
        <div id="wrapper">
            <%@include file="menu.jspf" %>
            <div id="page-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                    
                        <sj:tabbedpanel id="tabs" cssClass="list">
                                
                            
                           <sj:tab id="lista_materiales" target="tabListaMateriales" label="Asignacion de Tareas" />
                 
                             <div id="tabListaMateriales"> 
                         
                             
                             
                             
                             </div>
                                
                           </sj:tabbedpanel>              
                         
                        </div>

                    </div><!-- /.row -->  
                </div> <!-- /.container-fluid -->
            </div> <!-- /#page-wrapper -->
        </div>  <!-- /#wrapper -->
 
    </body>
</html>
