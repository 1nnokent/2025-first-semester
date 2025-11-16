package com.mipt.hw11;

import java.util.HashMap;
import java.util.Optional;

public class CachingDecorator implements DataService {
  private DataService dataService;
  private HashMap<String, Optional<String>> cache;

  public CachingDecorator () {
    this.dataService = new SimpleDataService();
    cache = new HashMap<>();
  }

  public CachingDecorator (DataService original) {
    this.dataService = original;
    cache = new HashMap<>();
  }

  @Override
  public Optional<String> findDataByKey(String key) {
    Optional<String> ret = dataService.findDataByKey(key);
    cache.put(key, ret);
    return ret;
  }

  @Override
  public void saveData(String key, String data) {
    dataService.saveData(key, data);
    cache.put(key, Optional.of(data));
  }

  @Override
  public boolean deleteData(String key){
    cache.put(key, Optional.empty());
    return dataService.deleteData(key);
  }
}
