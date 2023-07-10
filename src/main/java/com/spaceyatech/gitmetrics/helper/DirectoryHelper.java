package com.spaceyatech.gitmetrics.helper;

import java.io.File;
import java.util.Scanner;

public class DirectoryHelper {
    public static void main(String[] args) {
        String homeDirectory = System.getProperty("user.home");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        System.out.print("Enter the repository name for the cloned folder: ");
        String repositoryName = scanner.nextLine();

        String directoryPath = homeDirectory + File.separator + repositoryName;

        File directory = new File(directoryPath);

        if (directory.exists()) {
            System.out.println("Directory already exists.");
        } else {
            boolean created = directory.mkdir();

            if (created) {
                System.out.println("Directory created successfully.");

                String filePath = directoryPath + File.separator + fileName;
                File file = new File(filePath);

                try {
                    if (file.createNewFile()) {
                        System.out.println("File created successfully.");
                    } else {
                        System.err.println("Failed to create file.");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.err.println("Failed to create directory.");
            }
        }

        scanner.close();
    }
}
