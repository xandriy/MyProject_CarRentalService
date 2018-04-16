<%@include file = "/WEB-INF/views/taglib-file.jsp"%>

<section>
 <div class="carInfoPage"> 
    <div class="headerForOneCar">
        <p class = "carMake">${car.model.make.make} ${car.model.model}</p>
   		<c:if test="${car.isRented()}">
   			<div class="isRented">Is rented</div>
   		</c:if>
    </div>
    
    <div class = "carPhoto">
		<c:forEach items="${photos}" var="photo">
			<img class="oneCarPhoto" src="data:image.png;base64,${photo}">
        </c:forEach>
        <button id="leftButton"  onclick="plusDivs(-1)">&#10094;</button>
      <button id="rightButton"   onclick="plusDivs(1)">&#10095;</button>
    </div>
    <div class="infoAboutCar">
        <div class="oneMainInfo">
        <img src="/resources/img/fuel.png" alt=""> <p>${car.fuel.fuel}</p>
    </div>
    <div class="oneMainInfo">
        <img src="/resources/img/shif-gear.png" alt=""><p>${car.transmission.transmission}</p>
    </div>
    <div class="oneMainInfo">
        <img src="/resources/img/power.png" alt=""><p>${car.power }hp</p>
    </div>
     <div class="oneMainInfo">
        <img src="/resources/img/places.png" alt=""><p>${car.numberOfPlace} places</p>
    </div>
    </div>
    
      <div class="rentInfo">
                        
        <table border="0">
            <tr>
                <th>1 day</th>
                <th>1 week</th>
                <th>1 month</th>
            </tr>
            <tr>
                <td>${car.dayRent}$</td>
                <td>${car.weekRent}$</td>
                <td>${car.monthRent}$</td>
            </tr>
        </table>
        	
		<sec:authorize access="!hasRole('ROLE_ADMIN')">
       		<c:if test="${!car.isRented() || !principal}">
        		<div class="rentCar">
            		<a href="/cars/rent-car/${car.id}"> Rent </a>
        		</div>
        	</c:if>
        </sec:authorize>
    </div>
       
   </div>
   
   

</section>