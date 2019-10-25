package io.yanmain.mycoder;

import io.yanmain.mycoder.R;
import android.os.Bundle;
import android.preference.PreferenceActivity;

public class SettingActivity extends PreferenceActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPreferenceManager().setSharedPreferencesName(AppConfig.INIT_PREFERENCE);
        this.addPreferencesFromResource(R.xml.setting_preference);
    }
}
