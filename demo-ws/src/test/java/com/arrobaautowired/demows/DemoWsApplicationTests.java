package com.arrobaautowired.demows;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.arrobaautowired.demows.client.HelloWorldClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class DemoWsApplicationTests {

	@Autowired
	private HelloWorldClient helloWorldClient;
	
	@Test
	  public void testSayHello() {
	    assertThat(helloWorldClient.hola("José", "Matarán")).isEqualTo("José ¡HOLA!");
	  }

}
