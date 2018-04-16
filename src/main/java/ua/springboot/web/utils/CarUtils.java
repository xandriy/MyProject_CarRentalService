package ua.springboot.web.utils;

import java.util.ArrayList;
import java.util.List;

public class CarUtils {
	
	public static List<Integer> generateManufactureYear() {
		List<Integer> list = new ArrayList<>();
		for(int i = 2003;i < 2019; i++) {
			list.add(i);
		}
		
		return list;
	}
	
}
