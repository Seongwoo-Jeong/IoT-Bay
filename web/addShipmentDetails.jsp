<%@page import="uts.isd.model.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.User_Account"%>
<html>
    <head>
    <title>IoT Bay - Add Shipment</title>
    <meta meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <% User_Account user = (User_Account) session.getAttribute("user");
            String postcodeErr = (String) session.getAttribute("postcodeErr");           
            String addSuccess = (String) session.getAttribute("addSuccess");
            String addressErr = (String) session.getAttribute("addressErr");
            Customer customer = (Customer) session.getAttribute("customer");
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
        
        <!--   Top menu category (Home, My Account etc..) code needs here
    
        
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
                        
                        
        <a href="ShipmentDetailsServlet?userID=<%=user.getUserAccountID()%>"><h1 class="orangecolor"> < </h1> </a>
        <h1 style="color:lightsalmon; text-align:left; margin-left:20px;display:inline-block;font-size: 25px; color: black;"> Add Shipment Details: &nbsp; <%= (postcodeErr != null ? postcodeErr : "")%> <%= (addressErr != null ? addressErr :"")%> </div></h1>
        <form action="addShipmentDetailsServlet?userID=<%=user.getUserAccountID()%>" method="post">
            
            <table style="border-bottom:1px; border-left:0px; border-right:0px; border-top:0px; border-left:0px; padding:3.8px; margin-left:300px;">

                <tr><td>Street Address </td></tr>
                <tr><td><input type="text" class="no-outline" name="streetAddress" placeholder="Street Address" required></td></tr>
                <tr><td>Suburb</td></tr>
                <tr><td><input type="text" class="no-outline" name="suburb" placeholder="Suburb Name" required></td></tr>
                <tr><td>Postcode</td></tr>
                <tr><td><input type="int" class="no-outline" name="postcode" placeholder="Postcode" required></td></tr>

                <tr><td><label for="states"> State </state></td></tr>
                <tr><td><select id="state" name="state">
                            <option> NSW </option>
                            <option> QLD </option>
                            <option> VIC </option>
                            <option> ACT </option>
                            <option> TAS </option>
                            <option> NT </option>
                            <option> WA </option>
                            <option> SA </option>
                        </select>
                    </td></tr>                
            </table>
            <br><br>
            <a href="ShipmentDetailsServlet?&userID=<%=user.getUserAccountID()%>"><button class="button3" type="button" style="margin-left:95px;"> <b> &nbsp; CANCEL </b> </button></a>
            
            <button class="button2" type="submit" style="margin-left:0px"><b> DONE </b> </button>


        </form>

        <h1 style="color:green; text-align:left; margin-left:20px;display:inline-block;font-size: 25px;"><%= (addSuccess != null ? addSuccess : "")%>
            <% session.setAttribute("addSuccess", null);
                session.setAttribute("postcodeErr", null);
            %>

            <% } else { %>
        
   
                        
        
    </body>        
</html>