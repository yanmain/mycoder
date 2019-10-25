package io.yanmain.mycoder;

import android.app.Application;
import android.content.Context;
import android.util.Log;

public class mApplication extends Application {
	private static Context mContext;

	public mApplication() {
		mContext = this;
	}

	public static Context getContext() {
		if (mContext == null) {
			Log.e("mApplication", "APPLICATION_CONTEXT_IS_NULL");
		}
		return mContext;
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();
		mContext = getApplicationContext();
	}

	public void onCreate() {
		super.onCreate();
	}
}
