package com.mipt.hw11;

import java.util.Optional;

public class ValidationDecorator implements DataService {
  private DataService dataService = new SimpleDataService();

  public ValidationDecorator () {
    this.dataService = new SimpleDataService();
  }

  public ValidationDecorator (DataService original) {
    this.dataService = original;
  }

  @Override
  public Optional<String> findDataByKey(String key) throws IllegalArgumentException {
    if (key == null) {
      throw new IllegalArgumentException();
    }
    return dataService.findDataByKey(key);
  }

  @Override
  public void saveData(String key, String data) {
    if (key == null || data == null) {
      throw new IllegalArgumentException();
    }
    dataService.saveData(key, data);
  }

  @Override
  public boolean deleteData(String key){
    if (key == null) {
      throw new IllegalArgumentException();
    }
    return dataService.deleteData(key);
  }

}
