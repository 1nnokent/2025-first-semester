package com.mipt.hw11;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import org.junit.jupiter.api.Test;

public class LoggingDecoratorTest {
  @Test
  public void basicRequests () {
    LoggingDecorator dataService = new LoggingDecorator();
    dataService.findDataByKey("Me");
    dataService.saveData("Me", "like banana");
    dataService.findDataByKey("Me");
    dataService.deleteData("Me");
    dataService.findDataByKey("Me");
  }
}
