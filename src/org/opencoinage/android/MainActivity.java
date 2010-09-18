package org.opencoinage.android;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
  /**
   * Called when the activity is first created.
   */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
  }

  /**
   * Returns the application version number string.
   */
  public String getVersion() {
    String version = "x.y.z";
    try {
      version = getPackageManager().getPackageInfo("org.opencoinage.android", 0).versionName;
    }
    catch (android.content.pm.PackageManager.NameNotFoundException e) {}
    return version;
  }
}
