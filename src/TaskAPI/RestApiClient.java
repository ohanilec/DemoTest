package TaskAPI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.FileEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class RestApiClient {

    public static void main(String[] args) throws IOException{
        String fileName = "./src/TaskAPI/inputJson";
        File jsonFile = new File(fileName);
        Scanner scanner = new Scanner( jsonFile, "UTF-8" );

        String inputJSON = scanner.useDelimiter("\\A").next();
        System.out.println("1. " + inputJSON);
        JSONObject jsonObject = new JSONObject(inputJSON);

        String name = jsonObject.getString("name");
        String birthYear = jsonObject.getString("birthYear");
        String about = jsonObject.getString("about");

        System.out.println(name + " " + birthYear + " " + about);

        setPersonData(jsonFile);
    }

    public static void setPersonData(File jsonFile) throws IOException{
        HttpEntity  entity = new FileEntity(jsonFile);
        HttpPost post = new HttpPost("http://localhost:9200/people/_doc/");
        post.setEntity(entity);
        HttpClientBuilder clientBuilder = HttpClientBuilder.create();
        HttpClient client = clientBuilder.build();
        post.addHeader("content-type", "application/json");
        post.addHeader("Accept","application/json");
        HttpResponse response = client.execute(post);
        System.out.println("Response: " + response);


    }
}