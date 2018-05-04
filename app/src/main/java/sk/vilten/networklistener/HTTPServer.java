package sk.vilten.networklistener;

import android.util.Log;

import java.io.IOException;

import fi.iki.elonen.NanoHTTPD;

public class HTTPServer extends NanoHTTPD {

    public HTTPServer() throws IOException {
        super(9909);
        start(NanoHTTPD.SOCKET_READ_TIMEOUT);
        Log.i("vilten","NanoHTTP started");
    }

    @Override
    public Response serve(IHTTPSession session) {
        if (session.getMethod().equals(Method.POST)) {
            Log.i("vilten","POST");
        } else if (session.getMethod().equals(Method.GET)) {
            Log.i("vilten","GET");
        }
        

        String msg = "{\"status\":true,\"message\":\"it is working\"}";
        return newFixedLengthResponse(msg);
    }
}
