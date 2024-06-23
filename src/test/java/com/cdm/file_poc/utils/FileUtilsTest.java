package com.cdm.file_poc.utils;



import java.nio.file.Files;
import org.junit.jupiter.api.Test;

class FileUtilsTest {

  private static final String FOLDER_NAME = "teste";
  @Test
  void givenFolderNameWhenCreateTempDirectoryThenCreateTempFolder() throws Exception {

    FileUtils.createTempDirectory(FOLDER_NAME);
    String tmpdir = Files.createTempDirectory("tmpDirPrefix").toFile().getAbsolutePath();
    String tmpDirsLocation = System.getProperty("java.io.tmpdir");
    assert(tmpdir).startsWith(tmpDirsLocation);
  }


}