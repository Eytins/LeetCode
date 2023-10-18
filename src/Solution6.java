import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.net.*;

//import org.json.simple.*;
//import org.json.simple.parser.*;


class Result6 {

    /*
     * Complete the 'getCapitalCity' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING country as parameter.
     * API URL: https://jsonmock.hackerrank.com/api/countries?name=<country>
     */
    public static String getCapitalCity(String country) {
        String url = "https://jsonmock.hackerrank.com/api/countries?name=" + country;
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();
            String result = content.toString();
//            JSONParser parser = new JSONParser();
//            JSONObject jsonObject = (JSONObject) parser.parse(result);
//            JSONArray dataArray = (JSONArray) jsonObject.get("data");
//            if (dataArray != null && dataArray.size() > 0) {
//                JSONObject firstObject = (JSONObject) dataArray.get(0);
//                return (String) firstObject.get("capital");
//            }
            return "-1";
        } catch (Exception e) {
            e.printStackTrace();
            return "-1";
        }
    }

}

public class Solution6 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String country = bufferedReader.readLine();

        String result = Result6.getCapitalCity(country);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
