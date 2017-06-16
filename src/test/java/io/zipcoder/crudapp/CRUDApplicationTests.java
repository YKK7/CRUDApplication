package io.zipcoder.crudapp;

import io.zipcoder.crudapp.controller.PersonController;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CRUDApplicationTests {

	@Autowired
	private PersonController personController;


	@Test
	public void contextLoads() throws Exception{
		assertNotNull(personController);
	}

}
