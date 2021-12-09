package com.inventory.exercise;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Conf {

  public final static Path fileStorePath = Paths.get("./inventory.json");
  public final static Path fileReportCsvPath = Paths.get("./inventory.csv");

  public final static String DELIMITER = ",";

}
