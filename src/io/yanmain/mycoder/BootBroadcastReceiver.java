package io.yanmain.mycoder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		if(AppConfig.getInstance().getAutoRun()){
			AppConfig.getInstance().startService(context);
		}
	}

}
