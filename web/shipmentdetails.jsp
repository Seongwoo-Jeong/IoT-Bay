<!DOCTYPE html>
<%@page import="uts.isd.model.ShipmentDetails"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.User_Account"%>
<html>
    <head>
    <title>IoT Bay - Shipment</title>
    <meta meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <% User_Account user = (User_Account) session.getAttribute("user");
            ArrayList<ShipmentDetails> shipmentD = (ArrayList) session.getAttribute("shipmentD");
            String existErr = (String) session.getAttribute("existErr");
            request.setAttribute("shipmentList", shipmentDet);
            
        %>
    <style>
        td {                    
            font-family:Arial;
            font-size:15px;
            font-weight:normal;
            padding: 0px;
            text-align:left;
            vertical-align: middle;
        }
        ul {
            list-style: none;
            padding-left: 0px;
            color:#3e88ff;
        }
        li {
            margin-bottom: 15px;
        }
        li a:hover{
            color: tomato;
            cursor: pointer;
        }
        li a {
            color:#3e88ff;
        }
        .no-outline:focus {
            outline: none;
        }
        input[type=int] {
            width: 300px;
        }
        input[type=password] {
            width: 300px;
        }
        input[type=checkbox] {
            width: 10px;
        }
        input[type=text] {
            width: 300px;
        }




        body {font-family: "Times New Roman", Georgia, Serif;}
        h1, h2, h3, h4, h5, h6 {
            font-family: "Playfair Display";
            letter-spacing: 5px;
        }
        .top { 
            position:absolute;
            width:100%;
            z-index:1;
            box-shadow:0 2px 5px 0 rgba(0,0,0,0.16),0 2px 10px 0 rgba(0,0,0,0.12);
        }
        .bar-padding {padding:8px 16px!important;
        }
        .bar-item{
            padding:8px 16px;
            float:left;
            width:auto;
            border:none;
            display:block;
            outline:0;
        }
        .bar{
            width:100%;
            overflow:hidden;
        }
        .dropdown
        {
            position: relative;
            display: inline-block;
        }
        .dropdown-content
        {
            display: none;
            position: absolute;
            z-index: 1;
            min-width: 20px;
            background-color: black;
            padding: 16px;
        }
        .dropdown:hover .dropdown-content
        {
            display: block;
        }
        .button{
            border:none;
            display:inline-block;
            padding:8px 16px;
            vertical-align:middle;
            overflow:hidden;
            text-decoration:none;
            color:inherit;
            background-color:inherit;
            text-align:center;
            cursor:pointer;
            white-space:nowrap;
        }
        .container{
            padding-top: 3%;
        }
     </style>
    </head>
    
    <body>
        
        <!--   Top menu category table here
     
        
        
        -->
        
        
        <table cellspacing="0" cellpadding="0" height="70%" width="8%" bgcolor="#f0efef"  padding="0px" style="width: 8%; float: left;" > 
            <tr> <td style="padding-bottom:0px"> <img src="css/account.PNG"  padding="0px"></td> </tr>
            <tr>  <td style="padding-left: 15px; padding-bottom:0px; color:black"> <b> PAST SHIPMENT <b>
                    <div>
                        <ul>
                            <li> <a href="shipment.jsp" style="color:black">  Find Shipment </a> </li>
                            <li> <a href="ShipmentDetailsServlet?userID=<%=user.getUserAccountID()%>"> Shipment Details </li> 
                            <li> <a href="ViewShipmentServlet?userID=<%=user.getUserAccountID()%>"> Shipment History </a> </li>
                        </ul> </div></td>  </tr>



        </table>
                        
                        
        <h1 style="text-align:left; margin-left:250px; margin-top:50px"> Stored Shipment Details </h1>
        <h1 style="color:orange; text-align:left; margin-left:250px;"> <%= (existErr != null ? existErr : "")%>   </h1>
        <% if (shipmentD != null ) {%> 
 
        <div style="margin-left:230px;">
            <%  for (ShipmentDetails shipmentList : shipmentD) { %>
            <div class="box">
                <%=shipmentList.getStreetNameNumber()%><br>
                <%=shipmentList.getSuburb()%>, <%=shipmentList.getState()%>, <%=shipmentList.getPostcode()%><br>
                Australia <br> <br>
                <a href="EditShipmentDetailsServlet?shipmentDetailsID=<%=shipmentList.getShipmentDetailsID()%>"><button class="button2"> <b>EDIT</b> </button></a> 
                  <a href="DeleteShipmentDetailsServlet?shipmentDetailsID=<%=shipmentList.getShipmentDetailsID()%>&userID=<%=user.getUserAccountID()%>"<button class="button3"> <b>REMOVE</b> </button></a>
            </div>
        </div>
                
            
       <% } %>
       
        <% } else { %>
        <table style="margin-left:250px; border-bottom:0px; width:800px;">
            <tr>
                <td rowspan="2"> <img src="css/locationmap.jpg"  height="150px" width="170px">  </td>
                <td> <p> <b>Save your shipment address to your account </b></p> </td>
            </tr>
            <tr> <td> <p> Add more addresses to your account for a selection before placing an order. </p> </td>
            
        </table>
         
        <% } %> 
        
        <br></br><div style="float:none; display:inline-block;"><a href="AddShipmentDetails.jsp"><button class="button" style="margin-left:50px"> <span>ADD ADDRESS </span> </button></a></div>
        
        
  
        
    </body>        
</html>