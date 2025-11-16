package com.mipt.hw11;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import org.junit.jupiter.api.Test;

public class MetricableDecoratorTest {
  @Test
  public void basicRequests () {
    MetricableDecorator dataService = new MetricableDecorator();
    dataService.findDataByKey("Me");
    dataService.saveData("Me", "like banana");
    dataService.findDataByKey("Me");
    dataService.deleteData("Me");
    dataService.findDataByKey("Me");
  }
}
