package sk.vilten.networklistener;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;

public class HTTPService extends IntentService {
    HTTPServer httpServer;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     */
    public HTTPService() {
        super("HTTPService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        try {
            Log.i("vilten","Handle intent");
        } catch (Exception e) {
            Log.e("vilten",e.getLocalizedMessage(),e);
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void onCreate() {
        Log.i("vilten","HTTP Service on create");
        try {
            httpServer = new HTTPServer();
        } catch (IOException e) {
            Log.e("vilten","Unable to start http server. error=" + e.getLocalizedMessage(), e);
        }
        Toast.makeText(this, "HTTP Service starting", Toast.LENGTH_SHORT).show();
        super.onCreate();
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }
}
