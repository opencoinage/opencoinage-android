package org.opencoinage.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AboutActivity extends Activity {
  private Button closeButton;

  /**
   * Called when the activity is first created.
   *
   * @see http://developer.android.com/reference/android/app/Activity.html#onCreate(android.os.Bundle)
   */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.setContentView(R.layout.about);
    this.closeButton = (Button)this.findViewById(R.id.close);
    this.closeButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        finish();
      }
    });
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
