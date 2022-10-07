import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RollDice {
    static void getDiceNumber() throws InterruptedException, IOException{
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api-football-v1.p.rapidapi.com/v3/timezone"))
                .header("X-RapidAPI-Key", "a6bb8f681fmshdde8bf2f159fc25p14aafejsna03fafee8069")
                .header("X-RapidAPI-Host", "api-football-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        // HttpRequest request = HttpRequest.newBuilder()
        //         .uri(URI.create("https://roll-dice1.p.rapidapi.com/rollDice"))
        //         .header("X-RapidAPI-Key", "a6bb8f681fmshdde8bf2f159fc25p14aafejsna03fafee8069")
        //         .header("X-RapidAPI-Host", "roll-dice1.p.rapidapi.com")
        //         .method("GET", HttpRequest.BodyPublishers.noBody())
        //         .build();
        // HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
    }
}
