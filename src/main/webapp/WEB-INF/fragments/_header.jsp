<%@include file = "/WEB-INF/views/taglib-file.jsp" %>

 <header>
		
		<div class="nav">
                <div class="mainSiteLogo">

                    <a href="/" title="Home">
                    <img id="imgMain" src="/resources/img/log.png" alt="">
                </a>
                    <p>Easy <span>Car Rental</span></p>
                </div>

                <a href="/cars">
                    <div class="onePartHeader">
                        <span>Cars</span>
                    </div>
                </a>
                 <a href="">
                    <div class="onePartHeader">
                        <span>News</span>
                    </div>
                </a>
                <a href="">
                    <div class="onePartHeader">
                        <span>Reviews</span>
                    </div>
                </a>
                <a href="">
                    <div class="onePartHeader">
                        <span>About us</span>
                    </div>
                </a>
		 </div>
	
     <sec:authorize access="!isAuthenticated()">
     
     	 <div class="goToForms" id="app">
     	 	<c:if test="${param.fail}">
     	 		<p hidden="true">{{see = true}}</p>
     	 	</c:if>
     	 	
               <div class="registerAndLogin">
                    <a href="/registration">Registration</a>
                    <span> | </span>
                    <button @click = "see = !see">Log in</button>
                </div>
     			<div v-if= "see" class="dropdownLogin" >
                
                <c:if test="${param.fail}" >	
                	<a href = "/">hide</a><br>
               		<span id = "error" v-model="see">Fail to login</span>
               		
          	
                </c:if>     
                        
            	<form
            	action = "/"
            	method = "POST">
            
            		<div class="labelIn">
                		<label for="email">E-mail</label><br>
            		</div>
            		<input type="text"  name = "email" placeholder="Enter e-mail"><br>
                         
            		<div class="labelIn">
               		 	<label for="email">Password</label>
               			<br>
            		</div>
            		<input type="password"  name = "password" placeholder="Enter password"><br>
            		<a href="/forgot-password" class="forgotPasswordLabel">Forgot password?</a>
            		<br>
                        
            		<input type="submit" value="Login"><br>
            		<input type = "checkbox" name = "remember-me">
                	<label for="" class= "rememberMe">Remember me</label><br> 
    			</form>
    		</div>
     	</div> 
    
         </sec:authorize>
        
        <sec:authorize access="isAuthenticated()"> 
       	<div class="userAndLogout">
       		<sec:authorize access="hasRole('ROLE_ADMIN')">
  				 <a href = "/admin/admin-page">Admin page</a>
			</sec:authorize>
        	<sec:authentication property="principal.username" var = "user"/>
        	<a href="/user/profile" title = "Your profile">${user}</a>
        	<form:form action = "/logout" method = "POST">
        		 <input type="submit" value="Log out">
        	</form:form>
        </div>  
        </sec:authorize> 
        
    
	     
</header>  