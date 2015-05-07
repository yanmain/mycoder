package io.yanmain.mycoder;
import java.io.File;
import java.io.IOException;

import fi.iki.elonen.SimpleWebServer;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;


public class WebService extends Service{
	final static String TAG = WebService.class.getSimpleName();
	SimpleWebServer mserver;
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
    public void onCreate() {
    	runService();
    }
    
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		return START_STICKY;
	}

    public void onDestroy() {
    	if(null != mserver)
    		mserver.stop();
    }
    
    private void runService(){
        mserver = new SimpleWebServer(null,8080, new File("."), false,this);
        try {
			mserver.start();
		} catch (IOException e) {
			Log.e(TAG, e.getMessage());
		}
    }
}
