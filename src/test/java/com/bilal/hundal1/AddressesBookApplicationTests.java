package com.bilal.hundal1;
import static org.junit.Assert.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;
@SpringBootTest
class AddressesBookApplicationTests {
	@Autowired
    private WebApplicationContext context;
	@Test
	void contextLoads() {
		assertNotNull(context);
	}

}
