<%@include file = "/WEB-INF/views/taglib-file.jsp"%>

<section>
	<div class="editUserPage">
       
        <div class="editUser" >
            
            <p>Enter data to add new user</p>
            <hr>	
        <br>
        	<form:form
        		action = "/admin/users/add"
        		method = "POST"
        		modelAttribute="newUser"
        		enctype = "multipart/form-data">
        		
        		<br>
        		<form:input path="oldPassword" hidden = "true"/>

				<c:if test="${error != null}">
					<span class = "error">${error}</span>
				</c:if>
            	
            	<div class="labelIn">
                	<label for="email">E-mail</label><br>
				</div>
            	<form:input path="email" placeholder = "Email" required = "true"/> <br>
            		<form:errors path = "email" cssClass = "error"></form:errors>
            	<br>
            	
            	<div class="labelIn">
                	<label for="">Password</label><br>
				</div>
            	<form:password path="newPassword" placeholder = "Enter Password" />
            		<form:errors path = "newPassword" cssClass = "error"></form:errors>
            	
            	<br>	
            	
            	<div class="labelIn">
                	<label for= "confirmNewPassword">Password Confirm</label><br>
				</div>
            	<form:password path="confirmNewPassword" placeholder = "Reapeat Password" />
            		<form:errors path = "confirmNewPassword" cssClass = "error"></form:errors>
            	
            	<br>	
            	
            	<div class="labelIn">
                	<label for="role">User Role:</label>
				
				<form:select path="role" items = "${roles}" ></form:select> <br>
            		<form:errors path = "role" cssClass = "error"></form:errors>
            	</div>
            	<br>
            	
            	<div class="labelIn">
                	<label for="firstName">First Name</label><br>
				</div>
            	<form:input path="firstName" placeholder = "First Name" required = "true"/> <br>
            		<form:errors path = "firstName" cssClass = "error"></form:errors>
            	<br>
            	
            	<div class="labelIn">
                	<label for="lastName">Last Name</label><br>
				</div>
            	<form:input path="lastName" placeholder = "Last Name" required = "true"/>	<br>
            		<form:errors path = "lastName" cssClass = "error"></form:errors>
            	
            	<br>	
            	<div class="labelIn">
                	<label for="phoneNumber">Phone Number</label><br>
				</div>
            	<form:input path="phoneNumber" placeholder = "Phone number" />
            		<form:errors path = "phoneNumber" cssClass = "error"></form:errors>
            	
            	<br>	
            	
            	<div class="labelIn">
                	<label for="yearOfBith">Year of birth</label><br>
				</div>
            	<form:input path="yearOfBith" placeholder = "Year of bith" type = "number"/>
            		<form:errors path = "yearOfBith" cssClass = "error"></form:errors>
            	
            	<br>	
            	<div class="labelIn">
                	<label for="licenseNumber">License Number</label><br>
				</div>
            	<form:input path="licenseNumber" placeholder = "License Number" />
            		<form:errors path = "licenseNumber" cssClass = "error"></form:errors>
            	
            	<br>	
            	
            	<div class="labelIn">
                	<label for="passportNumber">Passport Number</label><br>
				</div>
            	<form:input path="passportNumber" placeholder = "Passport Number" />
            		<form:errors path = "passportNumber" cssClass = "error"></form:errors>
            	
            	<br>
            	
            	
        		
        		<form:input path="file" type = "file"/><br>
        	
        		<input type = "submit" value = "Registration">
        		
        	</form:form>        
                
                
		</div>
	</div>
</section> 