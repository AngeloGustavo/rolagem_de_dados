import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RollDice {
    static int getDiceNumber() throws IOException, InterruptedException{
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://roll-dice1.p.rapidapi.com/rollDice"))
                .header("X-RapidAPI-Key", "a6bb8f681fmshdde8bf2f159fc25p14aafejsna03fafee8069")
                .header("X-RapidAPI-Host", "roll-dice1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        
        return 0;
    }
}