
<%@include file = "/WEB-INF/views/taglib-file.jsp"%><section>



  <div class="rentCarPage">
        <div class="rentOneCar">
            <img src="data:image.png;base64,${mainPhoto}" alt="">
            <div class="info">
                <a href="#">${car.model.make.make} ${car.model.model}</a>
                <div class="mainInfo">
                    <div class="oneMainIfno">
                        <img src="/resources/img/fuel.png" alt=""> <label>${car.fuel.fuel}</label>
                    </div>
                    <div class="oneMainIfno">
                        <img src="/resources/img/shif-gear.png" alt=""><label>${car.transmission.transmission }</label>
                    </div>
                    <div class="oneMainIfno">
                        <img src="/resources/img/power.png" alt=""><label>${car.power }hp</label>
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
                            <td>${car.dayRent}$</td>
                        </tr>
                    </table>
                </div>
              



        </div>
    </div>

	<form method="POST"
	action="/cars/rent-car/${car.id}">
	 <label  class="selectDate">Select rent date</label><br>
	  <label class="days">From</label>
       <input type="date" name = "dateFrom">
       <label class="days">To</label>
       <input type="date" name = "dateTo">
       <br>
       <input type = "submit" value="Rent">
   </form>




</section>