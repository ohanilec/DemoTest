package TaskAPI;

import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

public class RestApiClient {

    public static void main(String[] args) throws IOException{

        String inputJSON = "{\"name\": \"Jed I. Knight\",\"birthYear\": \"2563\",\"about\": \"The force is strong with this one\"}";
        Scanner scanner = new Scanner(System.in);

        System.out.println("input JSON string");
        String jsonString = inputJSON;
        System.out.println(jsonString);
        JSONObject jsonObject = new JSONObject(jsonString);
        scanner.close();

        String name = jsonObject.getString("name");
        String birthYear = jsonObject.getString("birthYear");
        String about = jsonObject.getString("about");
        System.out.println(name + " " + birthYear + " " + about);

        setPersonData(name, birthYear, about );
    }

    public static void setPersonData(String name, String birthYear, String about) throws IOException{
        HttpURLConnection connection = (HttpURLConnection) new URL("http://localhost:9200/people/" + name).openConnection();

        connection.setRequestMethod("POST");

        String postData = "name=" + URLEncoder.encode(name, "UTF-8");
        postData += "&about=" + URLEncoder.encode(about, "UTF-8");
        postData += "&birthYear=" + birthYear;

        connection.setDoOutput(true);
        OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
        wr.write(postData);
        wr.flush();

        int responseCode = connection.getResponseCode();
        if(responseCode == 200){
            System.out.println("POST was successful.");
        }
        else if(responseCode == 401){
            System.out.println("Wrong password.");
        }
        else{
            System.out.println("Just wrong");
        }
    }
}