<%@include file = "/WEB-INF/views/taglib-file.jsp" %>

<section>
<div class="editUserPage">
	<div class="editUser">
			<p>Enter your registered email</p>
			<hr><br>
		<span id="messageInfo">We will send you secure code to recover your password</span>
		<br><br>
		<form
		action = "/forgot-password"
		method = "POST"
		>
			<c:if test="${error != null}">
					<span class = "error" style = "color:red'">${error}</span>
					<br><br>
			</c:if> 
			<div class="labelIn">
                <label for="email">E-mail</label><br>
            </div>
			<input name = "email" type = "email" placeholder="Enter email">
			<br>
			<input type = "submit" value = "Send">
		</form>
	</div>
</div>  
</section>
    