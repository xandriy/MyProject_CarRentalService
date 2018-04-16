<%@include file = "/WEB-INF/views/taglib-file.jsp"%>

<section>
	<div class="editUserPage">
       
        <div class="editUser"  id = "showAddPhoto">
            
            <p>Enter data to edit your account</p>
            <hr>	
        <br>
        	<form:form
        		action = "/user/edit"
        		method = "POST"
        		modelAttribute="userEdit"
        		enctype = "multipart/form-data">
        		
        		<br>
        		
            	<form:input path="id" hidden = "true"/>
            	<form:input path="email" hidden = "true"/>
            	<form:input path="oldPassword" hidden = "true"/>
            	<form:input path="role" hidden = "true"/>
            	<form:input path="filePath" hidden = "true"/>
            	
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
            	
            	<div class="labelIn">
                	<label for="">New Password</label><br>
				</div>
            	<form:password path="newPassword" placeholder = "Enter New password" />
            		<form:errors path = "newPassword" cssClass = "error"></form:errors>
            	
            	<br>	
            	
            	<div class="labelIn">
                	<label for= "confirmNewPassword"> New Password Confirm</label><br>
				</div>
            	<form:password path="confirmNewPassword" placeholder = "RepeatNewPassword" />
            		<form:errors path = "confirmNewPassword" cssClass = "error"></form:errors>
            	
            	<br>	
        		
        		<form:input path="file" type = "file"/><br>
        	
        		<input type = "submit" value = "edit">
        		
        	</form:form>        
                
                
		</div>
	</div>
</section> 