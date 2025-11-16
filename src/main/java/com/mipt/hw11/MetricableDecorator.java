package com.mipt.hw11;

import java.time.Duration;
import java.time.Instant;
import java.util.Optional;

public class MetricableDecorator implements DataService {

  public static class MetricService {

    Duration lastRequestTime;

    public MetricService() {
      this.lastRequestTime = null;
    }

    public void sendMetric(Duration duration) {
      this.lastRequestTime = duration;
      System.out.println("Метод выполнялся: " + duration.toString());
    }
  }

  private DataService dataService;
  private MetricService metricService;

  public MetricableDecorator () {
    this.dataService = new SimpleDataService();
    metricService = new MetricService();
  }

  public MetricableDecorator (DataService original) {
    this.dataService = original;
    metricService = new MetricService();
  }

  @Override
  public Optional<String> findDataByKey(String key) {
    Instant startTime = Instant.now();
    Optional<String> ret = dataService.findDataByKey(key);
    Instant endTime = Instant.now();
    metricService.sendMetric(Duration.between(startTime, endTime));
    return ret;
  }

  @Override
  public void saveData(String key, String data) {
    Instant startTime = Instant.now();
    dataService.saveData(key, data);
    Instant endTime = Instant.now();
    metricService.sendMetric(Duration.between(startTime, endTime));
  }

  @Override
  public boolean deleteData(String key) {
    Instant startTime = Instant.now();
    boolean code = dataService.deleteData(key);
    Instant endTime = Instant.now();
    metricService.sendMetric(Duration.between(startTime, endTime));
    return code;
  }

  public Duration lastRequestTime() {
    return this.metricService.lastRequestTime;
  }
}
