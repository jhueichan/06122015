
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<!DOCTYPE html>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
    <link href="css/bootstrap.min.css" rel="stylesheet">   
    <link href="css/sb-admin.css" rel="stylesheet"> 
    <link href="css/plugins/morris.css" rel="stylesheet">  
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
   <style>
hr { 
    display: block;
    margin-top: 0.5em;
    margin-bottom: 0.5em;
    margin-left: auto;
    margin-right: auto;
    border-style: inset;
    border-width: 2px;
} 
</style>
    
    
    <title>Sistema Web Vialis</title>
      <sj:head jqueryui="true"/>
      <sj:head jqueryui="true" jquerytheme="blitzer"></sj:head>
    </head>
    <body>
         <div id="wrapper">
        <!-- Navigation desde el archivo menu.jspf -->
         <%@include file="menu.jspf" %>
        
        <!--  comienzo del cntenedor dinámico -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <!-- Page Heading -->
                <div class="row">
                   <div class="col-lg-12">
                      
                       <p> Bienvenido Systema VIALIS</p>
                       <hr>
                      <img src="images/maquinas.png"  height="auto" width="auto">  
                        
                        
                    </div>
                                        
                </div><!-- /.row -->   

            </div> <!-- /.container-fluid -->

        </div> <!-- /#page-wrapper -->

    </div><!-- /#wrapper -->  
    
      <%@include file="footer.txt" %>
    </body>
</html>
