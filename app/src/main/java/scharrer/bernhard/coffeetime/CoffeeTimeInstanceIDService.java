package scharrer.bernhard.coffeetime;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class CoffeeTimeInstanceIDService extends FirebaseInstanceIdService {

    private static final String USER_AGENT = "-";

    @Override
    public void onTokenRefresh() {
        try {
            String token = FirebaseInstanceId.getInstance().getToken();
            URL url = new URL("http://4ahel.at/fcm/insert.php?fcm_token="+token);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            con.getResponseCode();

        } catch (IOException e) {
            e.printStackTrace();
        }
        super.onTokenRefresh();
    }
}
