package com.cdm.file_poc.service;

import static com.cdm.file_poc.utils.FileUtils.createTempDirectory;
import static com.cdm.file_poc.utils.FileUtils.renameFile;
import static com.cdm.file_poc.utils.FileUtils.renameFolder;
import static com.cdm.file_poc.utils.FileUtils.writeFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class FileService {
  private static String FILE_TEXT = "Primeira linha arquivo\nSegunda linha arquivo\n";
  private static String FOLDER_NAME = "ATESTE1";

  public boolean writeTextToFileCbl(Path filePath, String fileName, String fileText) {
    try {
      writeFile(filePath, fileText);
      Path originalFilePath = renameFile(filePath, fileName + ".cbl");
      return true;

    } catch (Exception ex) {
      ex.printStackTrace();
      return false;
    }

  }

  public void writeManyFiles() {
    List<String> files = Arrays.asList("AAAA", "BBBB", "CCCC");

    try {
      Path folderPath = createTempDirectory(FOLDER_NAME);
      Path originalFolderPath = renameFolder(folderPath, FOLDER_NAME);

      for (String file : files) {
        Path filePath = Files.createTempFile(originalFolderPath, file, ".cbl");
        String fileText = FILE_TEXT + file;
        writeTextToFileCbl(filePath, file, fileText);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
