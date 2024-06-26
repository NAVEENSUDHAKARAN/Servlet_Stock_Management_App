<%@ page session="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
</head>

<style>

body{
    margin: 0;
    padding: 0;
    overflow-x: hidden;
}

#navbarDiv{
    /* background-color: aquamarine; */
    position: sticky;
    top: 0;
    display: flex;
    background-color: rgb(70, 96, 190);
    width: 96.3%;
    height: 13vh;
    border-style: ridge;
    list-style-type: none;
    z-index: 1;
}
#home{
   /* background-color: cadetblue; */
    position: absolute;
    width: 4%;
    border-radius: 2px;
    color: aliceblue;
    left: 10%;
    top: 25px;   
    text-decoration: none;
    
}
#home:hover{
    color: black;
    cursor: pointer;
}

#services{
   
    position: absolute;
    width: 4%;
    border-radius: 2px;
    color: aliceblue;
    left: 20%;
    top: 25px;   
    text-decoration: none;
    
}

#services:hover{
    color: black;
    cursor: pointer;
}

#contactNav{
    position: relative;
    width: 4%;
    border-radius: 2px;
    color: aliceblue;
    left: 430%;
    top: 25px;   
    text-decoration: none;
}

#contactNav:hover{
    color: black;
    cursor: pointer;
}

#helpNav{
    position: absolute;
    width: 4%;
    border-radius: 2px;
    color: aliceblue;
    left: 41%;
    top: 25px;   
    text-decoration: none;
}

#helpNav:hover{
    color: black;
    cursor: pointer;
}

#services:hover{
    cursor: pointer;
    color: black;
    z-index: 5;
}

#menu {
    background-color: white;
    width: 10vw;
    color: black;
    position: relative;
    top: 15px;
    right: 25px;
    box-shadow: 5px 5px 5px 5px gray;
    border-radius: 5px; 
    text-decoration: none;
    list-style-type: none;
} 
#navbarDiv li:nth-child(2):hover #menu{
    display: block;
}
#menu li:hover{
    color:  rgb(70, 96, 190);
}
#navbarDiv #menu{
    display: none;
}

#entry{
    /* background-color: aquamarine; */
    position: relative;
    display: flex;
    justify-content: space-evenly;
    position: relative;
    left: 68%;
    width: 25%;
    
}

#login{
	/* background-color:aqua; */
    width: 200%;
    height: 100%;
    position: relative;
    left: 5%;
    
    
}

#loginBtn{
    position: relative;
    background-color: white;
    width: 70%;
    height: 70%;
    right: 5%;
    top: 15%;
    border-radius: 15px;
    border-style: none;

}
#loginBtn:hover{
    cursor: pointer;
    transform: scale(1.1);
}

#signUP{
    width: 200%;
    height: 100%;
  
    /* background-color: brown; */
     /* background-color: brown;  */
    /*  position: relative;
     bottom: 100%; */
}

#signupBtn{
	
    position: relative;
    background-color: black;
    color: white;
    width: 70%;
    height: 70%;
    left: 15%;
    top: 15%;
    border-radius: 15px;
    border-style: none;
}
#signupBtn:hover{
    cursor: pointer;
    transform: scale(1.1);
}

#bg{
    /* background-color: aquamarine; */
    position: relative;
    /* z-index: -2; */
    width: 100%;
    height:65vh;
    top: 30%;
    display: grid;
    grid-template-columns: repeat(4,1fr);
    
}

#card1{
    /* background-color: blueviolet; */
    position: relative;
    width: 80%;
    height: 50%;
    left: 5%;
    top: 10%;
    box-shadow: 5px 5px 5px 5px gray;
    border-radius: 8px;
    transform: translateY(0%);
    perspective: 1000px;
}

#inner{
    width: 100%;
    height: 100%;
    transform-style: preserve-3d;
    transition-duration: 1s;
}

#front
{
    position: fixed;

}

#card1 h1{
    position:absolute;
}


#card1:hover #inner{
    cursor: pointer;
    transform: rotateY(180deg);
    transition-duration: 1s; 
  
}

#back{
    backface-visibility: hidden;
    position: fixed;
    transform: rotateY(180deg);
}

#whatwedo{
    position: relative;
    left: 25%;
    top: -3.5%;
}

#featureswehave{
    position: relative;
    left: 13%;
    top: 2%;
}

#help{
    position: absolute;
    top: 20%;
    left: 25%;
    color: white;
}

#contact{
    position: relative;
    left: 18%;
    color: white;
    text-decoration: none;
}

#whythisapp1, #whythisapp2{
    position: relative;
    display: flex;
    background-color: whitesmoke;
    height: 40vh;
    justify-content: space-evenly;
   
}

#aboutAppDiv{
    background-color:whitesmoke;
    height: 60vh;
}

#aboutApp{
    /* background-color: yellow; */
    height: 80%;
    width: 50%;
    position: relative;
    left: 5%;
    top: 5%;
}

#frontbg{
    background-color: aqua;
    position: relative;
    width: 40%;
    height: 80%;
    left: 57%;
    bottom: 75%;
}

#free-forever{
    cursor: pointer;
    position: relative;
    /* background-color: blue; */
}

#free-forever #freeText{
    position: relative;
    visibility: hidden;
    background-color: transparent; 
    box-shadow: 5px 5px 5px 5px gray;
    cursor: pointer;
    z-index: 4;
    transform: scale(0);
    
} 

#free-forever #reportText {
    position: relative;
    visibility: hidden;
    background-color: transparent; 
    box-shadow: 5px 5px 5px 5px gray;
    cursor: pointer;
    z-index: 4;
    transform: scale(0);
    
} 

#free-forever #privacyText{
    position: relative;
    visibility: hidden;
    background-color: transparent; 
    box-shadow: 5px 5px 5px 5px gray;
    cursor: pointer;
    z-index: 4;
    transform: scale(0);
    
} 

#free-forever #easyText{
    position: relative;
    visibility: hidden;
    background-color: transparent; 
    box-shadow: 5px 5px 5px 5px gray;
    cursor: pointer;
    z-index: 4;
    transform: scale(0);
    
} 

#free-forever #chatText{
    position: relative;
    visibility: hidden;
    background-color: transparent; 
    box-shadow: 5px 5px 5px 5px gray;
    cursor: pointer;
    z-index: 4;
    transform: scale(0);
    
} 

 #free-forever:hover #freeText{
    transform: scale(1.2);
    transition-duration: 1s;
    cursor: pointer;
    visibility: visible;
   
}

#free-forever:hover #reportText{
    transform: scale(1.2);
    transition-duration: 1s;
    cursor: pointer;
    visibility: visible;
   
}

#free-forever:hover #privacyText{
    transform: scale(1.2);
    transition-duration: 1s;
    cursor: pointer;
    visibility: visible;
   
}

#free-forever:hover #easyText{
    transform: scale(1.2);
    transition-duration: 1s;
    cursor: pointer;
    visibility: visible;
   
}

#free-forever:hover #chatText{
    transform: scale(1.2);
    transition-duration: 1s;
    cursor: pointer;
    visibility: visible;
   
}

#footerDiv{
    background-color: aqua;
    height: 30vh;
    width: 98.6vw;
    display: flex;
    position: absolute;
}



#mediaTag{
    background-color: black;
    width: 30%;
    height: 100%;
    position: relative;
    
}

#icons{
    
    position: relative;
    width: 50%;
    height: 25%;
    left: 45px;
    top: 20px;
    
}

#copyRightDiv{
    background-color: black;
    color: white;
    width: 45%;
    height: 100%;
}

#addressDiv{
    background-color: whitesmoke;
    width: 25%;
    height: 100%;
}

#copyRightsText{
    position: relative;
    top: 25%;
}

#freeText{
    position: absolute;
    /* background-color: aqua; */
    width: 50%;
    height: 50%;
    text-align: center;
    height: 100px;
    left: 95px;
    bottom: 180px;  
    border-radius: 6px;
    
} 

#reportText{
    position: absolute;
    /* background-color: aqua; */
    width: 50%;
    height: 50%;
    text-align: center;
    height: 100px;
    left: 60px;
    bottom: 180px;  
    border-radius: 6px;
}

#privacyText{
    position: absolute;
    /* background-color: aqua; */
    width: 50%;
    height: 50%;
    text-align: center;
    height: 100px;
    left: 80px;
    bottom: 180px;  
    border-radius: 6px;
}

#easyText{
    position: absolute;
    /* background-color: aqua; */
    width: 50%;
    height: 50%;
    text-align: center;
    height: 100px;
    left: 75px;
    bottom: 180px;  
    border-radius: 6px;
}

#chatText{
    position: absolute;
    /* background-color: aqua; */
    width: 50%;
    height: 50%;
    text-align: center;
    height: 100px;
    left: 30px;
    bottom: 180px;  
    border-radius: 6px;
}

#selectDepartments{
	position: relative;
    width: 200px;
    padding: 10px;
    font-size: 16px;
    border: 1px solid #ccc;
    border-radius: 5px;
    appearance: none; /* Hide default arrow in some browsers */
    -webkit-appearance: none; /* Hide default arrow in Safari */
    -moz-appearance: none; /* Hide default arrow in Firefox */
    background-image: url('data:image/svg+xml;utf8,<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20"><path d="M5 7l5 5 5-5H5z"/></svg>'); /* Custom arrow */
    background-repeat: no-repeat;
    background-position: right 10px top 50%;
    background-size: 20px;
	
}

#serviceBtn{
    display: inline-block;
    padding: 10px 20px;
    background-color: white;
    border: 1px none #ccc;
    border-radius: 5px;
    cursor: pointer;
    font-weight: 300; 
    font-size:medium;
    font-style: italic;
}

#serviceBtn:hover {
    color: rgb(70, 96, 190);
}

/*#freetext:hover{
    /* transition-duration: 1s; 
    cursor: pointer;
    display: block;
    visibility: visible;
} */

</style>
<body>
<%

response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
response.setHeader("Expires", "0"); // Proxies.

    if (session == null || session.getAttribute("loginName") == null) {
        response.sendRedirect("loginpage.html");
        return;
    }

%>
    <div id="mainDiv">
            <ol id="navbarDiv">
                <a href="home.html"><li id="home" style="font-weight: 600; font-size: x-large;" >Home</li></a>
                <li id="services" style="font-weight: 600; font-size: x-large;">Services
                    <ul id="menu"><br>
                    	<form action="RegisterServlet" method="get">
                    		<input type="hidden"  >
                    		<button name="action" value="viewStock" id="serviceBtn">View Stock</button></center> 
                    		<!-- <a style="text-decoration: none; color: black; font-weight: 300; font-size: large;"><li>View Stock</li><br></a> -->
	                       	
                    		<button name="action" value="addStock" id="serviceBtn">Add Stock</button></center> 
	                        <!-- <a href="" style="text-decoration: none; color: black; font-weight: 300; font-size: large;"><li>Add Stock</li><br></a> -->
	                        <a href="" style="text-decoration: none; color: black; font-weight: 300; font-size: large;"><li>Remove Stock</li><br></a>
                    	</form>
                    </ul>
                </li>
                <a href="" style="text-decoration: none;"><li id="contactNav" style="font-weight: 600; font-size: x-large;">Contact</li></a>
                <a href=""><li id="helpNav" style="font-weight: 600; font-size: x-large;">Help</li></a>

                <div id="entry">
                    
                    <div id="login">
                     	<a  href="loginpage.html"><button id="loginBtn">LogIN</button></a>
                    </div>
                    <div id="signUP">
                        <a href="RegistrationForm.html"><button id="signupBtn" >SignUP</button></a>
                    </div>
                    <div id="signUP">
                        <a href="loginpage.html" name="action" value="logout" ><button id="signupBtn" >Logout</button></a>
                    </div>
                 
                </div>
            </ol>
      
        <div id="aboutAppDiv">
            <div id="aboutApp">
                <h1 style="font-size: 300%">Stock Management Software</h1>
                <h1 style="font-size: 500%; padding-bottom: -20px; color:  rgb(70, 96, 190);">For Shops</h1>
            </div>

            <div id="frontbg">
                <img src="Images/frontpagebg.jpg" alt="Image Not Working" width="100%" height="100%">
            </div> 
        </div>

        <div id="bg">
            <!-- <img src="Images/homepagebg.png" alt="Image is Not Working" height="100%" width="100%"> -->
            <div id="card1">
                <div id="inner">
                        <div id="front">
                            <img src="Images/viewstockimg.jpg" style="border-radius: 8px" alt="Image is Not Working" width="100%" height="191px">
                            
                        </div>
                        <div id="back">
                           <!--  <a href="viewstock.html"><img style="border-radius: 8px;" src="Images/view.jpg" alt="image not working" width="260px" height="191px"></a> -->
                         <select id="selectDepartments">
								<option>Mobile Phones</option>
								<option>Fruits</option>
								<option>Jewels</option>
							</select>
                        </div>
                        
                    
                </div>
                    <!-- <h1 id="whatwedo"  style="font-size: x-large; color: white;" >What We Do</h1> -->
            </div>
            <div id="card1">
                <!-- <h1 id="featureswehave" style="font-size: x-large; color: white;" >Features We Have!</h1> -->
                <div id="inner">
                    <div id="front">
                        <a href="addstock.html"><img src="Images/addstockImg.jpg" style="border-radius: 8px" alt="Image is Not Working" width="252.2px" height="191px"></a>       
                    </div>
                    <div id="back">
                        <a href="addstock.html"><img style="border-radius: 8px;" src="Images/add.png" alt="image not working" width="260px" height="191px"></a>
                    </div>    
            </div>
                
            </div>
            <div id="card1">
                <!-- <h1 id="help" style="font-size: xxx-large;" >Help?</h1> -->
                <div id="inner">
                    <div id="front">
                        <a href=""><img src="Images/removestockimg.jpg" style="border-radius: 8px" alt="Image is Not Working" width="252.2px" height="191px"></a>       
                    </div>
                    <div id="back">
                        <a href="removestock.html"><img src="Images/removestock.png" style="border-radius: 8px" alt="Image is Not Working" width="260px" height="191px"></a>
                    </div> 
                </div>    
            </div>

            <div id="card1">
                <h1 id="contact" style="font-size: xxx-large;" >Contact</h1>
                <img src="Images/contactbg.png" style="border-radius: 8px" alt="Image is Not Working" width="100%" height="100%">
               
            </div>
        </div>

        <div id="whythisapp1">
            <div id="free-forever" style=" width: 25%;">
                <img id="freeforever" style="padding-left: 95px; padding-top: 10px;" src="Images/free-forever.svg" alt="Logo Not Working" width="50%" height="50%">
                <h2 style="padding-left: 100px;  left: 20%;">Free Forever</h2>
                <div id="freeText">
                    <p>Access all the inventory, sales & purchase features for free.</p>
                </div>  
            </div>

            <div id="free-forever" style=" width: 25%;">
                <img id="freeforever" style="padding-left: 60px; padding-top: 10px;" src="Images/reports.svg" alt="Logo Not Working" width="50%" height="50%">
                <h2 style="padding-left: 40px;  left: 20%;">Real-Time Reports</h2>
                <div id="reportText" >
                    <p>Gather and share business insights in realtime.</p>
                </div>
            </div>

            <div id="free-forever" style=" width: 25%;">
                <img id="freeforever" style="padding-left: 75px; padding-top: 10px;" src="Images/security.svg" alt="Logo Not Working" width="50%" height="50%">
                <h2 style="padding-left: 60px;  left: 20%;">Privacy and Security</h2>
                <div id="privacyText" >
                    <p>Your data is secure with a world class encryption standard.</p>
                </div>
            </div>
            
        </div>
       
        <div id="whythisapp2">
            <div id="free-forever">
                <img id="freeforever" style="padding-left: 75px; padding-top: 10px;" src="Images/ease.svg" alt="Logo Not Working" width="50%" height="50%">
                <h2 style="padding-left: 82px;  left: 20%;">Easy to Use</h2>
                <div id="easyText" >
                    <p>Create any document with a few clicks.</p>
                </div>
            </div>
            
            <div id="free-forever">
                <img id="freeforever" style="padding-left: 30px; padding-top: 10px;" src="Images/support.svg" alt="Logo Not Working" width="50%" height="50%">
                <h2 style="padding-left: 10px;  left: 20%;">24/7 Chat Support</h2>
                <div id="chatText" >
                    <p>Our Average response time is less than a minute.</p>
                </div>
            </div>

            <div id="free-forever">
                <img id="freeforever" style="padding-left: 30px; padding-top: 4px;" src="Images/access.svg" alt="Logo Not Working" width="60%" height="60%">
                <h2 style="padding-left: 10px;  left: 20%;">Instant Access</h2>
            </div>
        </div>

        <div id="footerDiv">
            <div id="mediaTag">
                <div>
                    <h2 style="height: 50%; color: white; position: relative;top: 20px; left: 40px;">Follow Us on :</h2>
                </div>
                <div id="icons">
                    <img src="Images/youtube.png" alt="image not working" width="30px" height="30px">
                    <img src="Images/facebook.png" alt="image not working" width="30px" height="30px">
                    <img src="Images/linkedin.png" alt="image not working" width="30px" height="30px">
                    <img src="Images/instagram.png" alt="image not working" width="30px" height="30px">
                </div>
            </div>
            <div id="copyRightDiv">
                <div id="copyRightsText">
                    <p style="padding-left: 35px;">Copyrights &copy;2024 Stock Management System. All rights reserved.</p>
                    <p> Use of this site constitutes acceptance of our Terms of Use and Privacy Policy.</p>
                </div>
            </div>
            <div id="addressDiv">
                <div id="address" style="position: relative; left: 25%; top: 20px;">
                    <p><img src="Images/addressgif.gif" alt="image not working" width="15px" height="15px">123,South Street, Chennai-28</p>
                    <p><img src="Images/mailgif.gif" alt="gif not working" width="15px" height="15px">naveensudhakaran@gmail.com</p>
                    <p><img src="Images/phonegif.gif" alt="image not working" width="15px" height="15px">6382401736</p>
                </div>
            </div>
        </div>
    </div>
</body>
</html>