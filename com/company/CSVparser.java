package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CSVparser extends parser{


    @Override
    ArrayList<String> readFile(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));
        ArrayList<String> list = new ArrayList<>();
        //parsing a CSV file into the constructor of Scanner class
        sc.useDelimiter(",");
        //setting comma as delimiter pattern
        while (sc.hasNextLine()) {
            list.add(sc.nextLine());
        }
        sc.close();
        //closes the scanner
        return list;
    }

}
