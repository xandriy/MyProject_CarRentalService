
<%@include file = "/WEB-INF/views/taglib-file.jsp"%>

<section>
<div class="allInfo">
    <div >
    <table>
    <thead>
        <tr>
            <th>id</th>
            <th>E-mail</th>
            <th>Role</th>
            <th>Is Activated</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Phone</th>
			<th>Year Of Birth</th>
			<th>License</th>
			<th>Passport</th>
			<th colspan="3">Action</th>
        </tr>
    </thead>
            <c:forEach var="user" items = "${users}">
		<tr>	
			<td>${user.id }</td>
			<td>${user.email }</td>
			<td>${user.role}</td>
			<td>${user.isActivated()}</td>
			<td>${user.userDetails.firstName }</td>
			<td>${user.userDetails.lastName }</td>
			<td>${user.userDetails.phoneNumber}</td>
			<td>${user.userDetails.yearOfBirth}</td>
			<td>${user.userDetails.licenseNumber}</td>
			<td>${user.userDetails.passportNumber}</td>
			<td><a href = "/admin/${user.id}/edit" class = "edit">Edit</a></td>
			<td><a href = "/admin/users/${user.id}/profile" class = "profileButton">Profile</a></td>
			<td><a href = "/admin/users/${user.id}/delete" class = "delete">Delete</a></td>
			
			
		</tr>
         </c:forEach>  
           
    </table>
    </div> 
    </div>
</section>