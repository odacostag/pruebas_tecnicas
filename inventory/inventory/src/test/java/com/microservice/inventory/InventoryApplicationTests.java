package com.microservice.inventory;

import com.microservice.inventory.repositories.ICompanyReposiotory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InventoryApplicationTests {

	@Autowired
	ICompanyReposiotory iCompanyReposiotory;

	@Test
	void contextLoads() {
	}

//	@Test
//	public void testCompanyAll(){
//
//
//	}
//
//	@Test
//	public void testSaveCompany(){
//
//		CompanyModel.builder().nit("15551").build();
//
//		CompanyModel company = iCompanyReposiotory.findByNit("10101");
//		when(iCompanyReposiotory.findAll()).thenReturn(Collections.emptyList());
//
//	}

}
