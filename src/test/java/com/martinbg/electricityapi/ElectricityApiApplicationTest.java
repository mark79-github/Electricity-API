package com.martinbg.electricityapi;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;

@SpringBootTest
class ElectricityApiApplicationTest {

    @Test
    void shouldRunApplication() {
        String[] args = {"arg_1", "arg_2"};

        try (MockedStatic<SpringApplication> mockedStatic = mockStatic(SpringApplication.class)) {
            ConfigurableApplicationContext applicationContext = mock(ConfigurableApplicationContext.class);
            assertNotNull(applicationContext);

            mockedStatic.when(() -> SpringApplication.run(ElectricityApiApplication.class, args))
                    .thenReturn(applicationContext);

            ElectricityApiApplication.main(args);

            mockedStatic.verify(() -> SpringApplication.run(ElectricityApiApplication.class, args));
        }
    }
}
