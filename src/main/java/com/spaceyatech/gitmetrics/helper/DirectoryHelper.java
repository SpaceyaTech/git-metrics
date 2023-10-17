package com.spaceyatech.gitmetrics.helper;

import java.io.File;
import java.util.Scanner;

public class DirectoryHelper {
    public static void main(String[] args) {
        String homeDirectory = System.getProperty("user.home");
    		//String homeDirectory = "/Users/mac/Desktop";


        String directoryPath = homeDirectory + File.separator + "/repositoryName";

        File directory = new File(directoryPath);

        if (directory.exists()) {
        	if (deleteDirectory(directory)) {
        		System.out.println("Deleted the existing directory" + directory);
        	} else {
        		System.err.println("Failed to delete existing repository" + directory);
        		return;
        	}
        	 
        }

        boolean created = directory.mkdirs();

        if (created) {
                System.out.println("Directory created successfully." + directory);

                String filePath = directoryPath + File.separator + directory + "fileName";
                File file = new File(filePath);

                try {
                	file.getParentFile().mkdirs();
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

        private static boolean deleteDirectory(File directory) {
        	if (directory.exists()) {
                File[] files = directory.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isDirectory()) {
                            deleteDirectory(file);
                        } else {
                            file.delete();
                        }
                    }
                }
            }
            return directory.delete();        
    }
    
}

// TODO:
// remove the  System out
//and remove the prompt for input
// file.directory
// // delete directory parent and children