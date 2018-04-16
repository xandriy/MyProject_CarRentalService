<%@include file = "/WEB-INF/views/taglib-file.jsp"%>

<section>
        
        <div class="allCars" >
 
            <div class="carConfig">
           
           <form:form
           		method="POST"
           		modelAttribute="findCars"
           		action = "/cars"
           >
           <p class = "header">Car Configuration</p><hr>
           
           <label>Car Class</label><br>
          <form:select path="carClass">
          	<form:option value="null">Any</form:option>
          	<form:options items="${carClasses}" itemLabel="carClass"/>
          </form:select>
          <br>
          
          <label>Make</label><br>
          <form:select path="make">
          <form:option value="null">Any</form:option>
          	<form:options items="${makes}" itemLabel="make"/>
          </form:select>
          <br>
           
           <label>Fuel</label><br>
          <form:select path="fuel">
          	<form:option value="null">Any</form:option>
          	<form:options items="${fuel}" itemLabel="fuel"/>
          </form:select>
          <br>
          
          <label>Transmission</label><br>
          <form:select path="transmission">
          	<form:option value="null">Any</form:option>
          	<form:options items="${transmission}" itemLabel="transmission"/>
          </form:select>
          
          <br>
          <label>DayRent</label>
           <br>
           		<label class = "powerLabel">From:</label>
           		
           		<form:input path="dayRentFrom" class = "powerInput" min = "0"/>
            <br>
            	<label class = "powerLabel">To:</label> 
            	<form:input path="dayRentTo" class = "powerInput" min = "1"/>
            	 
            <br>     
          
          <input type = "submit" value = "Find">
           
          </form:form>
          
          
          
          
            </div> 
            
            <div class="cars">
            <c:if test="${allCars.size() == 0}">
            	 <p class="noResults">No results for your config</p>
            </c:if>
            <c:forEach items="${allCars}" var = "car" >
                <div class="oneAdv">
						<img src="data:image.png;base64,${car.mainPhoto}">                   
						<div class="info">
                        	<a href="/cars/${car.id}">${car.make} ${car.model}</a>
                        	<div class="mainInfo">
                        	<div class="oneMainInfo">
                        	    <img src="/resources/img/fuel.png" alt=""> <label >${car.fuel}</label>
                        	</div>
                        	 <div class="oneMainInfo">
                        	    <img src="/resources/img/shif-gear.png" alt=""><label>${car.transmission}</label>
                        	</div>
                        	 <div class="oneMainInfo">
                            <img src="/resources/img/power.png" alt=""><label>${car.power}hp</label>
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
                        </div>
                         <div class="rentCar">
                               <a href="/cars/rent-car/${car.id}"> Rent </a>
                            </div>
                       
                          
                           
                     </div>
                </div>   
                </c:forEach> 
            </div>
            
        </div>
   
    </section>