package com.cdm.file_poc;

import com.cdm.file_poc.service.FileService;

public class Application {

  public static void main(String[] args) {
    FileService fileService = new FileService();
    fileService.writeManyFiles();
  }

}
