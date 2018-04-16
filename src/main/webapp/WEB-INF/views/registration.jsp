<%@include file = "/WEB-INF/views/taglib-file.jsp" %>

<section>

	<div class="registractionForm">
        
            <div class="registration">
            <span class = "formHeader">Fill the form to create account</span>
				<hr>
            	 <form:form
            		action = "${pageContext.request.contextPath}/registration"
            		method = "POST"
            		modelAttribute="registerRequest"
            	>
            	<br>
            	
            	
				<c:if test="${error != null}">
					<span class = "error">${error}</span>
				</c:if>            	
            	<div class="labelIn">
                	<label for="firstName">First Name</label><br>
				</div>
            	<form:input path="firstName" placeholder = "First Name" required="required"/> <br>
            		<form:errors path = "firstName" cssClass = "error"></form:errors>
            	<br>
            	
            	<div class="labelIn">
                	<label for="lastName">Last Name</label><br>
				</div>
            	<form:input path="lastName" placeholder = "Last Name" required="required"/>	<br>
            		<form:errors path = "lastName" cssClass = "error"></form:errors>
            	
            	
            	<br>
            	<div class="labelIn">
                	<label for="email">E-mail</label><br>
                </div>
            	<form:input type = "email" path="email" placeholder = "Enter e-mail" required="required"/><br>
            		<form:errors path = "email" cssClass = "error"></form:errors>	
            	<br>
            	
            	<div class="labelIn">
					<label for="password">Password</label><br>
  				</div>	
            	<form:password path = "password"  placeholder = "Enter password"  required="required"/><br>
            		<form:errors path = "password" cssClass = "error"></form:errors>
            	
            	
            		<form:errors path = "" cssClass = "error"></form:errors>
            		
            	<br>
            	<div class="labelIn">
                	<label for="passwordConfirm">Repeat password</label><br>
                </div>	
            	<form:password path = "passwordConfirm"  placeholder = "Repeat password" required="required"/><br>
            		<form:errors path = "passwordConfirm" cssClass = "error"></form:errors>	
            	<br>
            		
            	
            	<form:checkbox path="agreement" required = "true"/>
            	<label for="agreement" class= "rulesAgree" >I agree with <a target = "_blank" href="https://drive.google.com/file/d/12E7mTeNdL_9cIQpjJ481uIsttoF6wLwF/view">service rules</a></label><br>
            	
            	<input type = "submit" value = "Registration">
            	
            	</form:form> 
            
                 
            </div>
        </div>
	
</section>