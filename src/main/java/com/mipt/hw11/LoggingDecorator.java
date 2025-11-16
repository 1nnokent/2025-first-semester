package com.mipt.hw11;

import java.util.HashMap;
import java.util.Optional;

public class LoggingDecorator implements DataService {
  private DataService dataService;

  public LoggingDecorator () {
    this.dataService = new SimpleDataService();
  }

  public LoggingDecorator (DataService original) {
    this.dataService = original;
  }

  @Override
  public Optional<String> findDataByKey(String key) {
    Optional<String> ret = dataService.findDataByKey(key);
    System.out.println("Выполнен поиск по ключу: " + key + ". Возвращено: " + ret.toString());
    return ret;
  }

  @Override
  public void saveData(String key, String data) {
    dataService.saveData(key, data);
    System.out.println("Выполнено сохранение пары ключ-значение: " + key + ", " + data);
  }

  @Override
  public boolean deleteData(String key){
    boolean ret = dataService.deleteData(key);
    System.out.println("Выполнено удаление по ключу: " + key + ". Код удаления: " + ret);
    return ret;
  }
}
