package io.yanmain.mycoder;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class AppConfig {
	public final static String INIT_PREFERENCE = "init_preference";
	private static volatile AppConfig instance;
	private Context ctx;
	private SharedPreferences sharedPrefs;
	
	public static AppConfig getInstance(){
		if(null == instance){
			instance = new AppConfig();
		}
		return instance;
	}
	
	private AppConfig(){
		ctx = mApplication.getContext();
		sharedPrefs = ctx.getSharedPreferences(
				INIT_PREFERENCE, Context.MODE_PRIVATE);
	}
		
	public boolean getAutoRun(){
		boolean b = sharedPrefs.getBoolean("ENABLE_AUTO_RUN", true);
		return b;
	}
	
	public boolean getQuit2StopService(){
		boolean b = sharedPrefs.getBoolean("ENABLE_QUIT_STOP_WEBSERVICE", false);
		return b;
	}
	
	public void startService(Context context) {
		Intent mintent = new Intent(context, WebService.class);
		context.startService(mintent);
	}

	public void stopService(Context context) {
		Intent mintent = new Intent(context, WebService.class);
		context.stopService(mintent);
	}
}
