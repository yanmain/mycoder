package io.yanmain.mycoder;

import io.yanmain.mycoder.R;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MyCoder extends Activity {
	final static String TAG = MyCoder.class.getSimpleName();

	TextView txt_title;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		txt_title = (TextView) findViewById(R.id.txt_title);

		String ip = getLocalIPAddress();
		String msg = "";
		if (ip.equals("")) {
			msg = "获取IP失败";
		} else {
			String uri = "http://" + getLocalIPAddress() + ":8080";
			msg = "访问    " + uri + "  开始编辑文件";
		}
		txt_title.setTextColor(Color.RED);
		txt_title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
		txt_title.setText(msg);

		AppConfig.getInstance().startService(this);
	}
	
	@Override
	public void onDestroy() {
		if(AppConfig.getInstance().getQuit2StopService())
			AppConfig.getInstance().stopService(this);
		super.onDestroy();
	}


	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
        	Intent mintent = new Intent(this,SettingActivity.class);
        	mintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        	startActivity(mintent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

	/**
	 * 获取本地IP函数
	 * @return
	 */
	public String getLocalIPAddress() {
		try {
			for (Enumeration<NetworkInterface> mEnumeration = NetworkInterface
					.getNetworkInterfaces(); mEnumeration.hasMoreElements();) {
				NetworkInterface intf = mEnumeration.nextElement();
				for (Enumeration<InetAddress> enumIPAddr = intf
						.getInetAddresses(); enumIPAddr.hasMoreElements();) {
					InetAddress inetAddress = enumIPAddr.nextElement();
					// 如果不是回环地址
					if (!inetAddress.isLoopbackAddress()
							&& !(inetAddress instanceof Inet6Address)) {
						// 直接返回本地IP地址
						return inetAddress.getHostAddress().toString();
					}
				}
			}
		} catch (SocketException ex) {
			Log.e("Error", ex.toString());
		}
		return "";
	}
}
