package org.opencoinage.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {
  /**
   * Called when the activity is first created.
   *
   * @see http://developer.android.com/reference/android/app/Activity.html#onCreate(android.os.Bundle)
   */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
  }

  /**
   * Called the first time the options menu is displayed.
   *
   * @see http://developer.android.com/reference/android/app/Activity.html#onCreateOptionsMenu(android.view.Menu)
   * @see http://developer.android.com/guide/topics/ui/menus.html
   */
  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    super.onCreateOptionsMenu(menu);
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  /**
   * Called whenever an item in the options menu is selected.
   *
   * @see http://developer.android.com/reference/android/app/Activity.html#onOptionsItemSelected(android.view.MenuItem)
   * @see http://developer.android.com/guide/topics/ui/menus.html
   */
  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.settings:
        // TODO: start the Settings activity
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
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
