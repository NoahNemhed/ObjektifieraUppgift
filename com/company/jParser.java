package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class jParser extends parser {
    JSONParser jsonParser = new JSONParser();
    ArrayList<String> array_list = new ArrayList<String>();


    @Override
    ArrayList<String> readFile(String fileName) {
        try {
            JSONArray a = (JSONArray) jsonParser.parse(new FileReader(fileName));
            for (Object o : a) {
                JSONObject entry = (JSONObject) o;
                String Item = (String) entry.get("Item");
                String[] array = new String[8];
                array[0] = (String) entry.get("OrderDate");
                array[1] = (String) entry.get("Region");
                array[2] = (String) entry.get("Rep1");
                array[3] = (String) entry.get("Rep2");
                array[4] = (String) entry.get("Item");
                array[5] = (String) entry.get("Units").toString();
                array[6] = (String) entry.get("UnitCost");
                array[7] = (String) entry.get("Total");
                array_list.add(Arrays.toString(array).replace("[","").replace("]","").replace(" ", ""));
            }

        } catch (ParseException e) {


        } catch (FileNotFoundException e) {

            System.err.println("file not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (array_list);
    }

}


