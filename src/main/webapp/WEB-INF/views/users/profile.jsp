 <%@include file = "/WEB-INF/views/taglib-file.jsp"%>
 
 
 <section>
 <div class="profilePage">
                <div class="profile">
                    <div class="profilePhoto">
						<img src="data:image.png;base64,${photo}">
                    </div>

                    <div class="info">
                    	<span class="name">${user.firstName} ${user.lastName}</span><br>
                        <p class="contactInfo">Contact information:</p>
						<span class="email">E-mail: ${user.email}</span><br>
                    	<span class="phoneNumber">Phone number: ${user.phoneNumber }</span><br>
                       	<p class="contactInfo">Driver data:</p>
                        <span class="documents">Driver license: ${user.licenseNumber}</span><br>
                        <span class="documents">Passport number: ${user.passportNumber} </span><br>
                    </div>
                    <sec:authorize access="hasRole('ROLE_CLIENT')">
  						<a href="/user/edit" title="Edit profile"><img src="/resources/img/edit.png" alt=""></a>
					</sec:authorize>
                </div>
            </div>
</section>