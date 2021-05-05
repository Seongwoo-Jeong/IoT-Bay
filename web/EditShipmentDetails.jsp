<!DOCTYPE html>

<html>
    <title>IoT Bay - Edit Shipment</title>
    <meta meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
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
    <body>

        <div class="top">
            <div class="bar bar-padding" style="letter-spacing:4px;">
                <a class="bar-item" >IoT Bay</a>
                <!-- Right-sided navbar links. Hide them on small screens -->
                <div style="float:right">
                    <a href="#home" class="bar-item button">Home</a>
                    <a href="#cart" class="bar-item button">Cart</a>     
                    <a class="bar-item button">Account</a>

                </div>
            </div>
        </div>
        <div class="container">
            <p style="text-align:right">You are logged in as &lt; ${user.email} &gt; </p> 
            <table cellspacing="0" cellpadding="0" height="100%" width="10%" bgcolor="#f0efef"  padding="0px" style="width: 9%; float: right;" > 
                <tr> <td style="padding-bottom:0px"> <img src=""  padding="0px"></td> </tr>
                <tr>  <td style="padding-right: 13px; padding-bottom:0px; color:black"> <b> MY ACCOUNT </b>
                        <div>
                            <ul>
                                <li> <a href ='Account.jsp'> Contact Details </li> 
                                <li> <a href '#' > Change Passwords </li> 
                                <li>  Newsletter </li>
                                <li> Payment Details </li>
                                <li> Wishlist </li>
                                <li> Language  </li>
                            </ul> </div></td>  </tr>

                <tr>  <td style="padding-right: 13px; padding-bottom:0px; color:black"> <b> MY SHIPMENT </b> 
                        <div>
                            <ul>
                                <li> Shipment Details</li> 
                                <li> <a href ='shipment.jsp'> Find Shipment </a> </li>
                                <li> <a href ='EditShipmentDetails.jsp'> Edit Shipment </a> </li>
                            </ul> </div></td>  </tr>
                <tr>  <td style="padding-right: 13px; padding-bottom:0px; color:black"> <b> MY SHOPPING </b> 
                        <div>
                            <ul>
                                <li> <a href="shipment.jsp"> Order History </a>  </li>
                                <li> Promotion Cards </li> 
                                <li> Voucher Codes </li>                            
                                <li> Gift Cards </li>
                                <li> Contact Staff </li>
                            </ul> </div></td>  </tr></table>

            
            <table> 
            
            <table style="border-right:3px; border-left:0px; border-bottom:0px; border-top:0px; padding:4.3px; 
                
                
                
           
            </table>
                
                
            <table cellspacing="0" cellpadding="0" width="90%">
                <tr> <th> <a href="Category.jsp" > <div class="center"><img src="./Img/home.png" width="23px" height="28px"></div>Category </a> </th>
                    <th><a href="Main.jsp"><div class="center"><img src="./Img/new.png" width="23px" height="28px"> </div> New Arrivals </a></th>                
            </table>                      



        </div>

    </body>        
</html>
