package com.bk.hotel.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

import com.bk.hotel.HotelApplication;
import com.bk.hotel.model.Customer;
import com.bk.hotel.service.CustomerService;
import com.bk.hotel.test.utils.SpringTestContainersExtension;

@ContextConfiguration(classes = { HotelApplication.class }, initializers = ITCustomerJUnit5Repo.Initializer.class)
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
@TestMethodOrder(OrderAnnotation.class)
public class ITCustomerJUnit5Repo {

	public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
		@Override
		public void initialize(ConfigurableApplicationContext applicationContext) {
			TestPropertyValues.of("spring.datasource.url=" + postgres.getJdbcUrl(), //
					"spring.datasource.username=" + postgres.getUsername(), //
					"spring.datasource.password=" + postgres.getPassword(),
					"spring.jpa.database-platform=org.hibernate.dialect.PostgreSQL95Dialect") //
					.applyTo(applicationContext);
		}
	}
	static DockerImageName postgresHoteldbLatest = DockerImageName.parse("postgres-hoteldb:latest").asCompatibleSubstituteFor("postgres");
	private static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(postgresHoteldbLatest);

	@RegisterExtension
	static SpringTestContainersExtension extension = new SpringTestContainersExtension(postgres, true);

	@Autowired
	private CustomerRepo repo;
	@MockBean
	private CustomerService customerService;

	@Test
	@Order(1)
	public void testCountNumberOfCustomersInDB() {
		assertEquals(2, repo.count());
	}

	@Test
	public void testRetrieveCustomerFromDatabase() {

		Customer customer = repo.findAll().iterator().next();

		assertEquals("John", customer.getFirstName());
		assertEquals("Doe", customer.getLastName());
		assertEquals("Middle", customer.getMiddleName());
		assertEquals("", customer.getSuffix());
	}

	@Test
	public void testAddCustomerToDB() throws ParseException {
		Customer customer = new Customer.CustomerBuilder().firstName("BoJack").middleName("Horse").lastName("Horseman")
				.suffix("Sr.").build();

		repo.save(customer);

		assertEquals(3, repo.count());
	}
}