package com.cdm.file_poc.utils;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {

  public static Path createTempDirectory(String folderName) throws Exception {
    String tmpdir = System.getProperty("java.io.tmpdir");
    Path path = Paths.get(tmpdir).resolve(folderName);
    System.out.println("path " + path.getParent());
    if (!Files.exists(path))
      return Files.createTempDirectory(folderName);
    else
      return path;

  }

  public static Path createTempFile(Path folderName,String fileName) throws Exception {
    return Files.createTempFile(folderName, fileName, ".cbl");
  }

  public static Path renameFile(Path filePath, String originalName) throws Exception {
    Path originalPath = filePath.resolveSibling(originalName);
    Files.deleteIfExists(originalPath);
    return Files.move(filePath, originalPath);
  }

  public static Path renameFolder(Path filePath, String originalName) throws Exception {
    Path originalPath = filePath.resolveSibling(originalName);
    return Files.move(filePath, originalPath);
  }

  public static void writeFile(Path filePath, String text) throws Exception {
    Files.write(filePath, text.getBytes(StandardCharsets.UTF_8));
  }
}
