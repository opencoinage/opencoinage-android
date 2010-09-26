package org.opencoinage.android;
import org.opencoinage.*;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class SettingsActivity extends PreferenceActivity {
  /**
   * Called when the activity is first created.
   *
   * @see http://developer.android.com/reference/android/app/Activity.html#onCreate(android.os.Bundle)
   */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    addPreferencesFromResource(R.xml.settings);
  }
}
