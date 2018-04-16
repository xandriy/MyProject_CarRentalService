<%@include file = "/WEB-INF/views/taglib-file.jsp"%>

<section>
	
	<div id = "carList">
	<div class="editUserPage" >
       
        <div class="editUser"  id = "showAddPhoto">
            
            <p>Enter data to add new car</p>
            <hr>	
        <br>
        	<form:form
        		action = "/admin/car/edit"
        		method = "POST"
        		modelAttribute="car"
        		enctype = "multipart/form-data">
        		
        		<br>
        		
        		<form:input path="id" hidden = "true"/>
        		
        		<form:input path="filePath" hidden = "true"/>
        		
        		<div class="labelIn">
                	<label>Rented:</label>
					<form:select path = "rented">
            			<option value = "true">Rented</option>
            			<option value = "false">Not Rented</option>
            		</form:select>
            	</div>
            	<br>
            	
            	<div class="labelIn">
                	<label>Booked:</label>
					<form:select path = "booked">
            			<option value = "true">Booked</option>
            			<option value = "false">Not Booked</option>
            		</form:select>
            	</div>
            	<br> 
        		
        		<div class="labelIn">
                	<label for="carClass">Car Class:</label>
				
				<form:select path="carClass" items = "${carClasses}" itemLabel="carClass"></form:select> <br>
            	</div>
            	<br> 	
            	
            	<div class="labelIn">
                	<label for="make">Car Make:</label>
				
				<form:select path="make" items = "${makes}" itemLabel="make"></form:select> <br>
            	</div>
            	
            	<br>
            	
            	 <div class="labelIn">
                	<label for="model">Car model</label><br>
				</div>
            	<form:input path="model" placeholder = "Car model"/>	<br>
            	
            	<br>	
            	<div class="labelIn">
                	<label for="manufactureYear">Manufacture Year:</label>
				
				<form:select path="manufactureYear" items = "${manufactureYears}"></form:select><br>
            	</div>
            	<br>	
            	
            	<div class="labelIn">
                	<label for="fuel">Fuel:</label>
				
				<form:select path="fuel" items = "${fuel}" itemLabel="fuel"></form:select> <br>
            	</div>
            	
            	<br>
            	
            	<div class="labelIn">
                	<label for="transmission">Transmission:</label>
				
				<form:select path="transmission" items = "${transmission}" itemLabel="transmission"></form:select> <br>
            	</div>
            	
            	<br>
            	
            	<div class="labelIn">
                	<label for="power">Engine power</label><br>
				</div>
            	<form:input path="power" placeholder = "Engine Power" type = "number"/><br>
            	
            	<br>	
   
            	<div class="labelIn">
                	<label for="numberOfPlace">Number Of Place</label><br>
				</div>
            	<form:input path="numberOfPlace" placeholder = "Number Of Place" /><br>
            	
            	<br>	
            	
            	<div class="labelIn">
                	<label for="dayRent">Day Rental</label><br>
				</div>
            	<form:input path="dayRent" placeholder = "Day Rent" /><br>
            	
            	<br>
            	
            	<div class="labelIn">
                	<label for="weekRent">Week Rental</label><br>
				</div>
            	<form:input path="weekRent" placeholder = "Week Rent" /><br>
            	
            	<br>	
            	
            	<div class="labelIn">
                	<label for= "monthRent"> Month Rental</label><br>
				</div>
            	<form:input path="monthRent" placeholder = "Mounth Rent" /><br>
            	
            	<br>	
        		
        		<form:input type = "file" path = "files[0]"/><br>
        		<form:input type = "file" path = "files[1]"/><br>
        		<form:input type = "file" path = "files[2]"/><br>
        		<form:input type = "file" path = "files[3]"/><br>
        		<form:input type = "file" path = "files[4]"/><br>
        	
        	
        		<input type = "submit" value = "Edit">
        		
        	</form:form>        
                
                
		</div>
	</div>
	</div>
</section> 