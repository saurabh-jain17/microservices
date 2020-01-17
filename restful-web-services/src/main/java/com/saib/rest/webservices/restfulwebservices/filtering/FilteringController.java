package com.saib.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public SomeBean retrieveSomeBean() {
		return new SomeBean("value1", "value2", "value3");
	}
	
	@GetMapping("/filtering-list")
	public List<SomeBean> retrieveListOfSomeBean() {
		return Arrays.asList(new SomeBean("value1", "value2", "value3"),
				new SomeBean("value12", "value22", "value32"));
	}
	
	//field1, field2 need to be send
	@GetMapping("/dynamic-filtering")
	public MappingJacksonValue retrieveSomeBeanDynamic() {
		DynamicSomeBean dynamicSomeBean = new DynamicSomeBean("value1", "value2", "value3");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(dynamicSomeBean);
		mapping.setFilters(filters);
		
		return mapping;
	}
	
	@GetMapping("/dynamic-filtering-list")
	public MappingJacksonValue retrieveListOfSomeBeanDynamic() {
		List<DynamicSomeBean> list = Arrays.asList(new DynamicSomeBean("value1", "value2", "value3"),
				new DynamicSomeBean("value12", "value22", "value32"));

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");

		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(list);
		mapping.setFilters(filters);

		return mapping;
	}

}
