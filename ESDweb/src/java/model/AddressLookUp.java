/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Eli
 */
public class AddressLookUp {

    private ArrayList<String> addressList;

    public void lookUp(String Address) {

        String apiKey = "ak_kk2v74myhq3k7JEAyVu7qrCwuUQgw";
        try {
            URL url = new URL("https://api.ideal-postcodes.co.uk/v1/autocomplete/addresses?api_key=" + apiKey + "&query=" + Address);
            System.out.println("url" + url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Getting the response code
            int responsecode = conn.getResponseCode();

            System.out.println("responsecode" + responsecode);

            if (responsecode != 200) {
                addressList = null;
                throw new RuntimeException("HttpResponseCode: " + responsecode);

            } else {
                String inline = "";
                Scanner scanner = new Scanner(url.openStream());

                //Write all the JSON data into a string using a scanner
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }
                System.out.println("inline" + inline);
                //Close the scanner
                scanner.close();

                //Using the JSON simple library parse the string into a json object
                JSONParser parse = new JSONParser();
                JSONObject allData = (JSONObject) parse.parse(inline);

                JSONObject result = (JSONObject) allData.get("result");

                JSONArray hits = (JSONArray) result.get("hits");

                JSONObject tempObj;
                addressList = new ArrayList<String>();
                String singleAddress;
                for (int i = 0; i < hits.size(); i++) {
                    tempObj = (JSONObject) hits.get(i);

                    singleAddress = (String) tempObj.get("suggestion");

                    addressList.add(singleAddress);

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String createHTML() {

        if (addressList.isEmpty()) {
           return "Please Enter a valid address";
        } else {
           
              String addressBoxHTML = "<label for=\"Address\">List Of Addreses:</label> <select id=\"Address\" name=\"address\"> ";
            for (int i = 0; i < addressList.size(); i++) {
                addressBoxHTML = addressBoxHTML + "<option value=\"" + addressList.get(i) + "\">";
                addressBoxHTML = addressBoxHTML + addressList.get(i) +"</option>";

            }
            addressBoxHTML = addressBoxHTML + "</select>";
             
            return addressBoxHTML;
        }

    }

    public ArrayList<String> getAddressList() {
        return addressList;
    }

}
