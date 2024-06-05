<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	
<title>Home</title>
</head>
<style>
	body{
		padding: 0;
		margin: 0;
		overflow-x: hidden; 
	}
	
	#navbarDiv{
		position: sticky;
		display: flex;
		width: 110vw;
		height: 90px;
		box-shadow: 5px 5px 3px 0px grey;
	}
	
	#logoDiv{
		position: relative;
		left: 5%;
		top: 5%;
		width: 100px;
		height: 80px;
	}
	
	#dropDown{
		position: relative;
		width: 10%;
		height: 50%;
		left: 20%;
		top: 30%;
	}
	
	#optionsDiv{
		position: relative;
		width: 55%;
		height: 90px;
		left: 5%;
		
		
	}
	
	#contentDiv{
	
		font-size: x-large;
		position: relative;
		display:flex;
		width: 70%;
		height: 50%;
		gap: 70px;	
		left: 40%;
		top: 20%;
		justify-content: space-around;
		color: #3c445c;
	}
	
	#help:hover, #login:hover{
		cursor: pointer;
		color: black;
	}
	
	#registerBtn {
	  background-color: #3c445c;
	  border: none;
	  color: white;
	  width: 30%;
	  height: 50px;
	  padding: 10px 20px;
	  text-align: center;
	  text-decoration: none;
	  display: inline-block;
	  font-size: 16px;
	  margin: 4px 2px;
	  cursor: pointer;
	  border-radius: 5px;
}


	#registerBtn:hover {
	  background-color: black;
	}


	#registerBtn:active {
	  background-color: #3c445c;
	}
	
	#logoutBtn{
		background-color: #3c445c;
		  border: none;
		  color: white;
		  width: 100%;
		  height: 50px;
		  padding: 10px 20px;
		  text-align: center;
		  text-decoration: none;
		  display: inline-block;
		  font-size: 16px;
		  margin: 4px 2px;
		  cursor: pointer;
		  border-radius: 5px;
	}
	
	#logoutBtn:hover {
	  background-color: black;
	}


	#logoutBtn:active {
	  background-color: #3c445c;
	}
	
	#login{
		text-decoration: none;
		color: #3c445c;
	}
	
	#secondDiv{
		background-color: #F5F5F5;
		height: 60vh;
		width: 110vw;
	}
	
	#text1{
		font-size: xxx-large;
		font-weight: bolder;
		font-style: italic;
		position: relative;
		top: 15%;
		left: 5%;
		width: 50%;
            transition: ease-in 600ms;
	}
	#text1 {
	  animation: 2s slide-right;
	}
	@keyframes slide-right {
	  from {
	    margin-left: -100%;
	  }
	  to {
	    margin-left: 0%;
	  }
	}
	
	#text2{
		font-style: italic;
		position: relative;
		top: 20%;
		left: 5%;
		width: 60%;
	}
	
	#parallelogramDiv{
		height: 60vh;
		position: absolute;
		background-color: white;
		width: 60%;
		left: 45%;
		bottom: 25%;
		height: 59%;
		transform: skew(-20deg);
		border-left: 5px solid #3c445c;
		
	}
	
	#innerSignUp, #innerLearnMore{
		 width: 10%;
		 position: relative;
		 left: 10%;
		 top: 20%;
         padding: 10px;
         border: none;
         border-radius: 3px;
         background-color: #3c445c;
         color: #fff;
         cursor: pointer;
	}
	
	#innerSignUp:hover, #innerLearnMore:hover{
		 background-color: black;
	}
	
	#innerBtns {
	  animation: 3s slide-right;
	  position: relative;
	  top: 20%;
	}
	@keyframes slide-left {
	  from {
	    margin-left: 100%;
	  }
	  to {
	    margin-left: 0%;
	  }
	}
	
	#parallelogramImg{
		position: relative;
		background-color: aqua;
		width: 60%;
		height: 60%;
		top: 10%;
		left: 25%;
	}
	
	#functionalities{
		position: relative;
		height: 100vh;
		width: 100vw;
		padding: 50px;
	}
	
	
/* 	#functionalitiesInnerDiv{
		background-color: white;
		position: relative;
		left: 50px;
		top: 20px;
		height: 90%;
		width: 90%;
		box-shadow: 5px 5px 3px 4px #3c445c;
		border-radius: 10px; 
	} */
	
	
	#row:hover{
		cursor: pointer;
		border-width: 2px;
		border-color: #3c445c;
	}
	
	#row1{
		position: relative;
		top: 20px;
	}
	
	#footerDiv{
    background-color: aqua;
    height: 30vh;
    width: 99vw;
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
    padding-right: 60px;
}

#copyRightsText{
    position: relative;
    top: 25%;
}
	
</style>
<body>
	
<%
	
	
	if (session == null) {
        response.sendRedirect("LoginPage.jsp");
      
    }
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
response.setHeader("Expires", "0");
%> 
	
	<div id="navbarDiv">
	
		<div id="logoDiv">
			<img alt="image not working" src="images/DigiPayLogo.png" width="100px" height= "80px" >
		</div>
		<!-- <div id="dropDown">
				<div class="dropdown">
				  <button style="background-color: #3c445c; width: 100%; height: 100%; " class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
				    Services
				  </button>
				  <ul class="dropdown-menu">
				    <li><button class="dropdown-item" type="button">Transfer Money</button></li>
				    <li><button class="dropdown-item" type="button">Pay Online</button></li>
				    <li><button class="dropdown-item" type="button">Buy and Sell Crypto</button></li>
				  </ul>
				</div>
			</div> -->
		<div id="optionsDiv">
			<div id="contentDiv">
				<a id="help" style="padding-top: 10px;">Help</a>
				<a id="login" href="LoginPage.jsp" style="padding-top: 10px;">LogIN</a>
				<button id="registerBtn" onclick="window.location.href='RegistrationForm.jsp'" >Register</button>
				<form action="Logout" method="post">
					<button id="logoutBtn" >Logout</button>
				</form>
			
			 <p id="welcomeNote" >Hi, <%= session.getAttribute("userName") %></p>
			</div>
		</div>
	</div>
	<div id="secondDiv">
			<div id="text1" >
				<h2 id="text1" >Make Your</h2>
				<h2 id="text1">Money Move</h2>
				<h5 id="text2">Pay online, send money and buy crypto </h5>
				<h5 id="text2">with a digital wallet used by millions.</h5>	
			</div>
			
			<div id="innerBtns">
				<button id="innerSignUp" onclick="window.location.href='RegistrationForm.jsp'" >SignUP</button>
				<button id="innerLearnMore">Learn More</button>
			</div>
			
			<div id="parallelogramDiv">
				<div id="parallelogramImg">
					<img alt="image not working" src="images/frontpagebg.jpg" width="100%" height="100%">
				</div>
			</div>
	</div>
	<div id="functionalities" >
		<div id="row" class="row">
			  <div class="col-sm-6 mb-3 mb-sm-0">
			    <div id="row" class="card">
			      <div class="card-body" >
			        <h5 class="card-title"><img alt="icon not working" src="images/bankaccounticon.png" width="20px" height="20px">&nbsp; Create Bank Account</h5>
			        <p class="card-text">Create a bank account with Digipay quickly.</p>
			        <a href="CreateBankAccount.jsp" style="background-color: #3c445c; border-color: black;" class="btn btn-primary">Open Account</a>
			        <a href="DepositAmount.jsp" style="background-color: #3c445c; border-color: black;" class="btn btn-primary">Deposit Amount</a>
			      </div>
			    </div>
			  </div>
			  <div id="row" class="col-sm-6">
			    <div id="row" class="card">
			      <div class="card-body">
			        <h5 class="card-title"><img alt="icon not working" src="images/moneytransfericon.png" width="21px" height="21px">&nbsp;Send Money</h5>
			        <p class="card-text">to any Digipay User or Bank Account.</p>
			       <!-- <a onclick="openTransferDialog()" style="background-color: #3c445c; border-color: black;" class="btn btn-primary">Transfer</a>  --> 
			      <button onclick="openTransferDialog()" style="background-color: #3c445c; border-color: black;" class="btn btn-primary">Transfer</button>
			      
			      </div>
			    </div>
			  </div>
			   <div id="row1" class="col-sm-6">
			    <div  id="row" class="card">
			      <div class="card-body">
			        <h5 class="card-title">Special title treatment</h5>
			        <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
			        <a href="#" style="background-color: #3c445c; border-color: black;" class="btn btn-primary">Go somewhere</a>
			      </div>
			    </div>
			  </div>
		</div>
	</div>
	 
	<div id="footerDiv">
        <div id="mediaTag">
                <div>
                    <h2 style="height: 50%; color: white; position: relative;top: 20px; left: 40px;">Follow Us on :</h2>
                </div>
                <div id="icons">
                    <img src="images/youtube.png" alt="image not working" width="30px" height="30px">
                    <img src="images/facebook.png" alt="image not working" width="30px" height="30px">
                    <img src="images/linkedin.png" alt="image not working" width="30px" height="30px">
                    <img src="images/instagram.png" alt="image not working" width="30px" height="30px">
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
                    <p><img src="images/addressgif.gif" alt="image not working" width="15px" height="15px">123,South Street, Chennai-28</p>
                    <p><img src="images/mailgif.gif" alt="gif not working" width="15px" height="15px">naveensudhakaran@gmail.com</p>
                    <p><img src="images/phonegif.gif" alt="image not working" width="15px" height="15px">6382401736</p>
                </div>
            </div>
        </div>
</body>
<script>
function openTransferDialog() {
    Swal.fire({
        icon: 'info',
        title: 'Enter Account Number',
        html: '<input id="amountInput" class="swal2-input" placeholder="Enter Account Number">',
        showCancelButton: true,
        confirmButtonText: 'Ok',
        cancelButtonText: 'Cancel',
        showLoaderOnConfirm: true,
        preConfirm: () => {
            const amount = document.getElementById('amountInput').value;
            
            console.log('Account Number:', amount);
        }
    });
}
</script>

</html>