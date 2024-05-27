<%@page import="com.chainsys.dao.ServerManager"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="com.chainsys.model.StockInfo"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Stock</title>
</head>
<style>
   body{
    margin: 0;
    padding: 0;
   }
   #navbarDiv{
        position: relative;
        background-color: rgb(70, 96, 190);
        width: 100vw;
        height: 10vh;
    }

    #back{
        position: absolute;
        color: aliceblue;
        left: 20%;
        top: 10px;
        
        text-decoration: none;
        align-items: center;
        font-size: large;
        
    }
    #back:hover{
        color: black;
        background-color: rgb(109, 135, 230);
        border-radius: 5px;
    }

    #home{
        
        position: absolute;
        font-size: large;
        color: aliceblue;
        left: 10%;
        top: 10px;
        text-decoration: none;
    }

    #home:hover{
        background-color: rgb(109, 135, 230);
        border-radius: 5px;
        color: black;
    }

   #tableDiv{
        position: absolute;
        display: flex;
        background-color: whitesmoke;
        width: 60%;
        max-height:max-content;
        left: 2%;
        padding: 30px;
        top: 15%;
        box-shadow: 5px 5px 5px 5px grey; 
        border-radius: 8px;
    }
   
   #viewStockTable
    {
        position: relative;
        left: 10%;
        top: 9%;
        width: 70%;
        height: 20%;
        justify-self: center;
        border-radius: 8px;
    }

    #viewStockTable :hover{
        cursor: pointer;

    }
   
   #cartDiv{
    background-color: #5D76A9;
    position: relative;
    width: 20vw;
    height: 60vh;
    left: 76%;
    top: 40px;
    box-shadow: 5px 5px 0px 0px grey;
    border-radius: 5px;
   }

   #selectedDetails{
    position: relative;
    left: 5%;
   }

   #submitBtn{
    position: relative;
    size: 10%;
    top: 30%;
    background-color: #4C516D;
    left: 30%;
    width: 100px;
    height: 50px;
    border-radius: 8px;

   }

   #submitBtn:hover{
    cursor: pointer;
   }
   
   #viewStockTable tr:nth-child(even){background-color: #8294C4;}
   #viewStockTable  tr:nth-child(odd) {
	background-color:#DDE6ED;}
	#viewStockTable tr:first-child{background-color: #476072;}
	#viewStockTable td{padding:5px;}
	
  #selectDepartments{
	position: relative;
    width: 150px;
    padding: 10px;
    left: 55%;
    top: 10px;
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

#departmentSelect{
	position: relative;
    width: 150px;
    padding: 10px;
    left: 55%;
    top: 10px;
    font-size: 16px;
    border: 1px solid #ccc;
    border-radius: 5px;
}

</style>
<body>
    <div id="mainDiv">
        <div id="navbarDiv">
            <nav>
                <a id="home" style="padding: 10px;" href="home.html">Home</a>
                <!-- <a id="back" style="padding: 10px;" href="functionalities.html">Back</a> -->
            </nav>
        </div>
       <div id="tableDiv">
       
        <table id="viewStockTable" border="1">
		<tr >
			<td>ID</td>
			<td>ProductName</td>
			<td>NumberOfStock</td>
			<td>StockedDate</td>
			<td>Price</td>
		</tr>
		<%
		ServerManager server = new ServerManager();
		ArrayList<StockInfo> arrList = server.readEntireStock();
		for (StockInfo user : arrList) {
			
		%>
		<tr>
			<td><%=user.getId()%></td>
			<td><%=user.getProductName()%></td>
			<td><%=user.getNumberOfStock()%></td>
			<td><%=user.getStockedDate()%></td>
			<td><%=user.getCostPrice()%></td>
		</tr>

		<%
		}
		%>
	</table>
     
     <div id="selectDepartmentDiv">
     	<form action="Departments" method="get">
 
 
     		<select id="selectDepartments" name="departments" >
				<option  value="phone" >Mobile Phones</option>
				<option  value="fruit">Fruits</option>
				<option  value="jewel">Jewels</option>
			</select>
			<br><br>
     		<input id="departmentSelect" type="submit" value="Filter" >
     	</form>
     	
     </div>  
       
   </div>
    
   </div> 
        <div id="cartDiv">
            <br>
              <div id="selectedDetails">
                <p >Selected Product is : <p id="cart"> </p>
                <p id="arr"></p>
                <p id="totalAmount"></p>
              </div>
              <button id="submitBtn" onclick="window.location.href='cart.html' ">Add To Cart</button>

        </div>
    </div>
</body>
<script>


    var cells = document.querySelectorAll("#viewStockTable tr");
   
    let totalAmount = 0;


    for (var i = 0; i < cells.length; i++) {
    cells[i].addEventListener("click", function() {
    var selected = document.getElementById("cart").innerHTML= this.innerHTML
    var selectedRow = this.cells;
    var selectedPrice = parseInt(selectedRow[4].innerText);
            
    var price = document.getElementById("arr").innerText = "Price: " + selectedPrice;
    
    totalAmount = totalAmount + selectedPrice
    document.getElementById("totalAmount").innerHTML = "Total Amount : " + totalAmount
    
 });
    }
</script>
</html>