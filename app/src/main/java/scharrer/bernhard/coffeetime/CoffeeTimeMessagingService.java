package scharrer.bernhard.coffeetime;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class CoffeeTimeMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        createNotification(CoffeeTime.getInstance(), "CoffeeTime", remoteMessage.getNotification().getBody());

    }

    private void createNotification(Context context, String title, String description) {

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, "15")
                .setSmallIcon(R.mipmap.coffee)
                .setContentTitle(title)
                .setContentText(description)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);


        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

// notificationId is a unique int for each notification that you must define
        notificationManager.notify(15, mBuilder.build());

    }

}
