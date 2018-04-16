<%@include file = "/WEB-INF/views/taglib-file.jsp"%>

<section>
	
	<div id = "carList">
	<div class="editUserPage" >
       
        <div class="editUser"  id = "showAddPhoto">
            
            <p>Enter data to add new car</p>
            <hr>	
        <br>
        	<form:form
        		action = "/admin/car/add"
        		method = "POST"
        		modelAttribute="newCar"
        		enctype = "multipart/form-data">
        		
        		<br>
        		<div class="labelIn">
                	<label for="carClass">Car Class:</label>
				
				<form:select path="carClass" items = "${carClasses}" itemLabel="carClass"></form:select> <br>
            		<form:errors path = "carClass" cssClass = "error"></form:errors>
            	</div>
            	<br> 	
            	
            	<div class="labelIn">
                	<label for="make">Car Make:</label>
				
				<form:select path="make" items = "${makes}" itemLabel="make"></form:select> <br>
            		<form:errors path = "make" cssClass = "error"></form:errors>
            	</div>
            	
            	<br>
            	
            	 <div class="labelIn">
                	<label for="model">Car model</label><br>
				</div>
            	<form:input path="model" placeholder = "Car model"/>	<br>
            		<form:errors path = "model" cssClass = "error"></form:errors>
            	
            	<br>	
            	<div class="labelIn">
                	<label for="manufactureYear">Manufacture Year:</label>
				
				<form:select path="manufactureYear" items = "${manufactureYears}"></form:select><br>
            		<form:errors path = "manufactureYear" cssClass = "error"></form:errors>
            	</div>
            	<br>	
            	
            	<div class="labelIn">
                	<label for="fuel">Fuel:</label>
				
				<form:select path="fuel" items = "${fuel}" itemLabel="fuel"></form:select> <br>
            		<form:errors path = "fuel" cssClass = "error"></form:errors>
            	</div>
            	
            	<br>
            	
            	<div class="labelIn">
                	<label for="transmission">Transmission:</label>
				
				<form:select path="transmission" items = "${transmission}" itemLabel="transmission"></form:select> <br>
            		<form:errors path = "transmission" cssClass = "error"></form:errors>
            	</div>
            	
            	<br>
            	
            	<div class="labelIn">
                	<label for="power">Engine power</label><br>
				</div>
            	<form:input path="power" placeholder = "Engine Power" type = "number"/><br>
            		<form:errors path = "power" cssClass = "error"></form:errors>
            	
            	<br>	
   
   				
    
   
   
            	<div class="labelIn">
                	<label for="numberOfPlace">Number Of Place</label><br>
				</div>
            	<form:input path="numberOfPlace" placeholder = "Number Of Place" /><br>
            		<form:errors path = "numberOfPlace" cssClass = "error"></form:errors>
            	
            	<br>	
            	
            	<div class="labelIn">
                	<label for="dayRent">Day Rental</label><br>
				</div>
            	<form:input path="dayRent" placeholder = "Day Rent" /><br>
            		<form:errors path = "dayRent" cssClass = "error"></form:errors>
            	
            	<br>
            	
            	<div class="labelIn">
                	<label for="weekRent">Week Rental</label><br>
				</div>
            	<form:input path="weekRent" placeholder = "Week Rent" /><br>
            		<form:errors path = "weekRent" cssClass = "error"></form:errors>
            	
            	<br>	
            	
            	<div class="labelIn">
                	<label for= "monthRent"> Month Rental</label><br>
				</div>
            	<form:input path="monthRent" placeholder = "Mounth Rent" /><br>
            		<form:errors path = "monthRent" cssClass = "error"></form:errors>
            	
            	<br>	
        		
        		<form:input type = "file" path = "files[0]"/><br>
        		<form:input type = "file" path = "files[1]"/><br>
        		<form:input type = "file" path = "files[2]"/><br>
        		<form:input type = "file" path = "files[3]"/><br>
        		<form:input type = "file" path = "files[4]"/><br>
        	
        	
        		<input type = "submit" value = "Add car">
        		
        	</form:form>        
                
                
		</div>
	</div>
	</div>
</section> 