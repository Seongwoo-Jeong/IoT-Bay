<!DOCTYPE html>
<%@page import="uts.isd.model.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.User_Account"%>
<%@page import="uts.isd.model.Shipment"%>
<html>
    <head>
    <title>IoT Bay - Shipment</title>
    <meta meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
         <% User_Account user = (User_Account) session.getAttribute("user");
           String searchErr = (String)session.getAttribute("searchErr");
           Shipment shipment = (Shipment) session.getAttribute("shipment");
           String dateErr = (String) session.getAttribute("dateErr");
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
        
        <!--   Top menu category
        <div class="top">
            <div class="bar-padding" style="letter-spacing:4px;">
                <a class="bar-item" >IoT Bay</a>
                <div style="float:right">
                    <a href="main.jsp" <div class="bar-item button">Home</a>
                    <a href="main.jsp" <div class="bar-item button">Cart</a>     
                    <a href="account.jsp" <div class="bar-item button">Account</a>
                </div>
            </div>
        </div>

        <div style="padding-top: 5%">
        <table cellspacing="0" cellpadding="0" width="90%">
            <tr> 
                <th><a href="main.jsp"><div class="center"><img src="./css/home.png" width="23px" height="28px"></div>Category</a></th>
                <th><a href="main.jsp"><div class="center"><img src="./css/new.png" width="23px" height="28px"> </div>New Arrivals</a></th>   
        </table>
        </div>
        
        
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

        
        
    <h1 style="text-align:center; margin-center:20px; margin-top:50px;"> &nbsp; &nbsp; Find Your Shipment &nbsp; &nbsp; <div style="color:lightsalmon; float:right;"> <%= (searchErr != null ? searchErr: "") %> </div></h1> <hr>
        <form method="post" action="ShipmentServlet"> 
            <table class="no-outline" style="margin-left:250px; border-bottom: 0pt;">
                <tr><td>Shipping ID </td></tr>
                <tr ><td style="border-bottom: 1px; border-left:0px; border-right: 0px; border-top: 0px">
                        <input type ="int" class="no-outline" name="shipmentID" placeholder="Enter Shipping ID" required></td></tr>
                <tr></tr>
                <tr><td> Date of Shipment</td></tr> 
                <tr><td> <input type ="text" class="no-outline" name="shipmentDate" placeholder=" %=(dateErr!=null ? dateErr : "dd/mm/yyyy")%>" required></td></tr> 
                <tr><td> <button style="margin-right:45%" type="submit"> Search </button>  </td> 
                    
            </table>
        </form>
        
                 
                <% if (shipment != null) { %>
                <table style="border: 0px solid #f0efef; border-collapse: collapse; border-color: black; margin-left: 250px;" cellspacing="120"> 
                    <tr style="padding: 20px; border-bottom: 1px solid #f0efef;">
                        <td style="border-bottom: 1px solid #f0efef; border-color:gray; color:black; padding:10px;"> Shipment ID </td>
                        <td style="border-bottom: 1px solid #f0efef; border-color:gray; color:black; padding:10px;"> Shipment Date </td> 
                        <td style="border-bottom: 1px solid #f0efef; border-color:gray; color:black; padding:10px;"> Shipment Status </td>                         
                        <td style="border-bottom: 1px solid #f0efef; border-color:gray; color:black; padding:10px;"> Courier Name </td> 
                        <td style="border-bottom: 1px solid #f0efef; border-color:gray; color:black; padding:10px;"> Tracking Number </td> 
                        <td style="border-bottom: 1px solid #f0efef; border-color:gray; color:black; padding:10px;"> Shipment Address </td> 
                        <td style="border-bottom: 1px solid #f0efef; border-color:gray; color:black; padding:10px;"> Order ID </td>
                    </tr>
                    <tr style="border: 0px">
                        <td style="border-bottom: 0px solid #f0efef; border-color:gray; color:black; padding:10px;">${shipment.shipmentID} </td>
                        <td style="border-bottom: 0px solid #f0efef; border-color:gray; color:black; padding:10px;"> ${shipment.shipmentDate} </td> 
                        <td style="border-bottom: 0px solid #f0efef; border-color:gray; color:black; padding:10px;"> ${shipment.shipmentStatus}</td>                       
                        <td style="border-bottom: 0px solid #f0efef; border-color:gray; color:black; padding:10px;">${shipment.courierName} </td>
                        <td style="border-bottom: 0px solid #f0efef; border-color:gray; color:black; padding:10px;"> ${shipment.trackingNumber} </td>
                        <td style="border-bottom: 0px solid #f0efef; border-color:gray; color:black; padding:10px;"> ${shipmentD.streetNameNumber}, ${shipmentD.suburb}, ${shipmentD.postcode}, ${shipmentD.state} </td>
                        <td style="border-bottom: 0px solid #f0efef; border-color:gray; color:black; padding:10px;"> ${shipment.orderID} </td>
                    </tr> 
                </table>
                    <%  } else {} %>
                        
        
    </body>        
</html>