package com.capitole.tecnicalTest;

import com.capitole.tecnicalTest.ordermanagment.logic.api.Ordermanagment;
import com.capitole.tecnicalTest.ordermanagment.logic.api.to.OrderSearchCriteria;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;


@SpringBootApplication
public class TecnicalTestApplication  /*implements CommandLineRunner */{
/*
	@Inject
	Ordermanagment ordermanagment;
*/
	public static void main(String[] args) {
		SpringApplication.run(TecnicalTestApplication.class, args);

	}


/*

	@Override
	public void run(String... args) throws Exception {

		OrderSearchCriteria criteria = new OrderSearchCriteria();
		List<HashMap> result = this.ordermanagment.getMaxOrderForEachUser(criteria);
	}
	*/


}
