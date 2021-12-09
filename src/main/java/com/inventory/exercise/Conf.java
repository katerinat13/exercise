package com.inventory.exercise;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Conf {

  public final static Path fileStorePath = Paths.get("src/main/resources/inventory.json");
  public final static Path fileReportCsvPath = Paths.get("src/main/resources/inventory.csv");
  public final static String fileReportHtmlPath ="src/main/resources/template.html";

  public final static String DELIMITER = ",";

}
