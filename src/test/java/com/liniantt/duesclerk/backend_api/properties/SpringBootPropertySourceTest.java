package com.liniantt.duesclerk.backend_api.properties;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "/application-dev.properties")
public class SpringBootPropertySourceTest {

  @Value("${foo}")
  String foo;

  @Test
  void test() {
    assertThat(foo).isEqualTo("bar");
  }
}
