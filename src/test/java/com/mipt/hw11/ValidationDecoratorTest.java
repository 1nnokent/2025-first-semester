package com.mipt.hw11;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import org.junit.jupiter.api.Test;

public class ValidationDecoratorTest {
  @Test
  public void basicRequests () {
    ValidationDecorator dataService = new ValidationDecorator();
    dataService.saveData("Me", "like banana");
    dataService.findDataByKey("Me");
    dataService.deleteData("Me");
    dataService.findDataByKey("Me");

    assertThrows(IllegalArgumentException.class,
        () -> dataService.findDataByKey(null));
    assertThrows(IllegalArgumentException.class,
        () -> dataService.saveData(null, "like banana"));
    assertThrows(IllegalArgumentException.class,
        () -> dataService.saveData("Me", null));
    assertThrows(IllegalArgumentException.class,
        () -> dataService.saveData(null, null));
    assertThrows(IllegalArgumentException.class,
        () -> dataService.deleteData(null));
  }
}
