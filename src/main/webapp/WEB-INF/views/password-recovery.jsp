<%@include file = "/WEB-INF/views/taglib-file.jsp" %>

<section>
<div class="editUserPage">
	<div class="editUser">
		<p>Enter email, key and password to add new password</p>
		<hr><br>
		
		<form:form
		action = "/password-recovery"
		method = "POST"
		modelAttribute="recoveryModel"
		>
		
			<c:if test="${error != null}">
					<span class = "error">${error}</span>
					<br><br>
			</c:if> 
		
			<div class="labelIn">
                <label for="email">E-mail</label><br>
            </div>
            <form:input path="email" type = "email" placeholder="Enter email"/>
            	<form:errors path = "email" cssClass = "error"></form:errors>
			<br>
			
			
			<div class="labelIn">
                <label for="key">Key</label><br>
            </div>
            <form:input path = "key"  placeholder="Enter key"/>
				<form:errors path="key" cssClass="error"></form:errors>
				<br>
			
			
			<div class="labelIn">
                <label for="password">Password</label><br>
            </div>
            <form:password path="password" placeholder="Enter password"/>
            	<form:errors path = "password" cssClass = "error"></form:errors>
			<br>
			
			
			<div class="labelIn">
                <label for="passwordConfirm">Repeat password</label><br>
            </div>
            <form:password path="passwordConfirm" placeholder="Repeat password"/>
            	<form:errors path = "passwordConfirm" cssClass = "error"></form:errors>
			<br>
			<input type = "submit" value = "Send">
		</form:form>
	</div>
</div>  
</section>
    