package com.mipt.hw11;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import org.junit.jupiter.api.Test;

public class CachingDecoratorTest {
  @Test
  public void manySimilarRequests () {
    MetricableDecorator dataService = new MetricableDecorator(new CachingDecorator());
    dataService.saveData("Me", "like banana");
    var firstRequest = dataService.findDataByKey("Me");
    Duration first = dataService.lastRequestTime();
    var secondRequest = dataService.findDataByKey("Me");
    Duration second = dataService.lastRequestTime();
    assertTrue(first.compareTo(second) >= 0);
  }
}
