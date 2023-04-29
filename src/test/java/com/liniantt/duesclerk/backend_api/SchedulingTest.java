package com.liniantt.duesclerk.backend_api;

import com.liniantt.duesclerk.backend_api.configs.SchedulingConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(properties = "com.liniantt.duesclerk.backend_api.scheduling.enabled=false")
class SchedulingTest {

  @Autowired(required = false)
  private SchedulingConfiguration schedulingConfiguration;

  @Test
  void test() {
    assertThat(schedulingConfiguration).isNull();
  }
}
