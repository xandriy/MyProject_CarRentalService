package ua.springboot.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.springboot.web.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>{
	
	/// Find all
	@Query("SELECT c FROM Car c WHERE c.dayRent > :from AND c.dayRent < :to ") 
	public List<Car> findCarByUserConfig(@Param("from")int from, @Param("to")int to);
	
	// Find by transmission
	@Query("SELECT c FROM Car c WHERE c.transmission.transmission = :transmission AND "
			+ "c.dayRent > :from AND c.dayRent < :to ") 
	public List<Car> findCarByUserConfigTransmission(@Param("from")int from, @Param("to")int to,
													@Param("transmission") String transmission);
	
	// Find by fuel
	@Query("SELECT c FROM Car c WHERE c.fuel.fuel= :fuel AND "
			+ "c.dayRent > :from AND c.dayRent < :to ") 
	public List<Car> findCarByUserConfigFuel(@Param("from")int from, @Param("to")int to,
											@Param("fuel") String fuel);
	
	// Find by fuel
	@Query("SELECT c FROM Car c WHERE c.fuel.fuel= :fuel AND c.transmission.transmission = :transmission AND "
				+ "c.dayRent > :from AND c.dayRent < :to ") 
	public List<Car> findCarByUserConfigFuelAndTransmission(@Param("from")int from, @Param("to")int to,
												@Param("fuel") String fuel, @Param("transmission") String transmission);
	
	// Find by car make
	@Query("SELECT c FROM Car c WHERE c.model.make.make = :make  AND " 
						+ "c.dayRent > :from AND c.dayRent < :to ") 
	public List<Car> findCarByUserConfigMake(@Param("from")int from, @Param("to")int to,
											@Param("make") String make);
	
	// Find by car make
	@Query("SELECT c FROM Car c WHERE c.model.make.make = :make AND c.transmission.transmission = :transmission AND " 
							+ "c.dayRent > :from AND c.dayRent < :to ") 
	public List<Car> findCarByUserConfigMakeAndTransmission(@Param("from")int from, @Param("to")int to,
												@Param("make") String make, @Param("transmission") String transmission);
	
	// Find by car make and fuel
	@Query("SELECT c FROM Car c WHERE c.model.make.make = :make  AND c.fuel.fuel = :fuel AND " 
							+ "c.dayRent > :from AND c.dayRent < :to ") 
	public List<Car> findCarByUserConfigMakeAndFuel(@Param("from")int from, @Param("to")int to,
												@Param("make") String make, @Param("fuel") String fuel);
	
	// Find by car make and fuel
	@Query("SELECT c FROM Car c WHERE c.model.make.make = :make  AND c.fuel.fuel = :fuel AND " 
								+ "c.transmission.transmission = :transmission  AND "
								+ "c.dayRent > :from AND c.dayRent < :to ") 
	public List<Car> findCarByUserConfigMakeAndFuelAndTransnission(@Param("from")int from, @Param("to")int to,
													@Param("make") String make, @Param("fuel") String fuel, 
													@Param("transmission") String transmission);
	
	// With Car Class
	/// Find all
		@Query("SELECT c FROM Car c WHERE c.carClass.carClass = :carClass AND "
				+ "c.dayRent > :from AND c.dayRent < :to ") 
		public List<Car> findCarByUserConfigCarClass(@Param("from")int from, @Param("to")int to,
													@Param("carClass")String carClass);
		
		// Find by transmission
		@Query("SELECT c FROM Car c WHERE c.carClass.carClass = :carClass AND "
				+ "c.transmission.transmission = :transmission AND "
				+ "c.dayRent > :from AND c.dayRent < :to ") 
		public List<Car> findCarByUserConfigCarClassAndTransmission(@Param("from")int from, @Param("to")int to,
														@Param("transmission") String transmission,
														@Param("carClass")String carClass);
		
		// Find by fuel
		@Query("SELECT c FROM Car c WHERE c.carClass.carClass = :carClass AND "
				+ "c.fuel.fuel= :fuel AND "
				+ "c.dayRent > :from AND c.dayRent < :to ") 
		public List<Car> findCarByUserConfigCarClassAndFuel(@Param("from")int from, @Param("to")int to,
												@Param("fuel") String fuel,
												@Param("carClass")String carClass);
		
		// Find by fuel
		@Query("SELECT c FROM Car c WHERE c.carClass.carClass = :carClass AND "
				+ "c.fuel.fuel= :fuel AND c.transmission.transmission = :transmission AND "
					+ "c.dayRent > :from AND c.dayRent < :to ") 
		public List<Car> findCarByUserConfigCarClassAndFuelAndTransmission(@Param("from")int from, @Param("to")int to,
													@Param("fuel") String fuel, @Param("transmission") String transmission,
													@Param("carClass")String carClass);
		
		// Find by car make
		@Query("SELECT c FROM Car c WHERE c.carClass.carClass = :carClass AND "
				+ "c.model.make.make = :make  AND " 
							+ "c.dayRent > :from AND c.dayRent < :to ") 
		public List<Car> findCarByUserConfigCarClassAndMake(@Param("from")int from, @Param("to")int to,
												@Param("make") String make,
												@Param("carClass")String carClass);
		
		// Find by car make
		@Query("SELECT c FROM Car c WHERE c.carClass.carClass = :carClass AND "
				+ "c.model.make.make = :make AND c.transmission.transmission = :transmission AND " 
								+ "c.dayRent > :from AND c.dayRent < :to ") 
		public List<Car> findCarByUserConfigCarClassAndMakeAndTransmission(@Param("from")int from, @Param("to")int to,
													@Param("make") String make, @Param("transmission") String transmission,
													@Param("carClass")String carClass);
		
		// Find by car make and fuel
		@Query("SELECT c FROM Car c WHERE c.carClass.carClass = :carClass AND "
				+ "c.model.make.make = :make  AND c.fuel.fuel = :fuel AND " 
								+ "c.dayRent > :from AND c.dayRent < :to ") 
		public List<Car> findCarByUserConfigCarClassAndMakeAndFuel(@Param("from")int from, @Param("to")int to,
													@Param("make") String make, @Param("fuel") String fuel,
													@Param("carClass")String carClass);
		
		// Find by car make and fuel
		@Query("SELECT c FROM Car c WHERE c.carClass.carClass = :carClass AND "
				+ "c.model.make.make = :make  AND c.fuel.fuel = :fuel AND " 
									+ "c.transmission.transmission = :transmission  AND "
									+ "c.dayRent > :from AND c.dayRent < :to ") 
		public List<Car> findCarByUserConfigCarClassAndMakeAndFuelAndTransnission(@Param("from")int from, @Param("to")int to,
														@Param("make") String make, @Param("fuel") String fuel, 
														@Param("transmission") String transmission,
														@Param("carClass")String carClass);
	
	
	
	
	
	// Find by car class
	@Query("SELECT c FROM Car c WHERE c.carClass.carClass = :carClass ") 
	public List<Car> findCarByUserConfigCarClass(@Param("carClass") String carClass);
	
	
	
	
	// Find by car class and make
	@Query("SELECT c FROM Car c WHERE c.carClass.carClass = :carClass AND "
			+ "c.model.make.make = :make") 
	public List<Car> findCarByUserConfigCarClassAndMake(@Param("carClass") String carClass,
														@Param("make") String make);
	
	// Find by car class
	@Query("SELECT c FROM Car c WHERE c.carClass.carClass = :carClass AND "
			+ "c.fuel.fuel = :fuel") 
	public List<Car> findCarByUserConfigCarClassAndFuel(@Param("carClass") String carClass, 
												@Param("fuel")String make);
	
	// Find by car class
	@Query("SELECT c FROM Car c WHERE c.carClass.carClass = :carClass AND "
			+ "c.transmission.transmission = :transmission") 
	public List<Car> findCarByUserConfigCarClassAndTransmission(@Param("carClass") String carClass, 
											@Param("transmission") String transmissionClass);
	
}
