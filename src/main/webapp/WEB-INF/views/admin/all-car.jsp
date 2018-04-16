
<%@include file = "/WEB-INF/views/taglib-file.jsp"%>

<section>
<div class="allInfo">
    <div>
    <table>
    <thead>
        <tr>
           <th>id</th>
			<th>Car type</th>
			<th>Make</th>
			<th>Model</th>
			<th>Year</th>
			<th>Fuel</th>
			<th>Power</th>
			<th>Gear</th>
			<th>Places</th>
			<th>Day Rent</th>
			<th>weekRent</th>
			<th>monthRent</th>	
            <th colspan="3">Action</th>
        </tr>
    </thead>
            <c:forEach var="car" items = "${allCar}">
		<tr>	
			<td>${car.id }</td>
			<td>${car.carClass.carClass }</td>
			<td>${car.model.make.make }</td>
			<td>${car.model.model }</td>
			<td>${car.manufactureYear }</td>
			<td>${car.fuel.fuel }</td>
			<td>${car.power }</td>
			<td>${car.transmission.transmission}</td>
			<td>${car.numberOfPlace}</td>
			<td>${car.dayRent}</td>
			<td>${car.weekRent}</td>
			<td>${car.monthRent}</td>
			
			<td><a href = "/admin/car/all/${car.id}/edit" class = "edit">Edit</a></td>
			<td><a href = "/cars/${car.id}" class = "profileButton">Details</a></td>
			<td><a href = "/admin/car/all/${car.id}/delete" class = "delete">Delete</a></td>
		</tr>
         </c:forEach>  
           
    </table>
    </div> 
    </div>
</section>