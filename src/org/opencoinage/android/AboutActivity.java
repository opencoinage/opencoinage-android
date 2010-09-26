package org.opencoinage.android;
import org.opencoinage.*;

import android.app.Activity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import java.util.GregorianCalendar;

public class AboutActivity extends Activity {
  private String versionName;

  /**
   * Called when the activity is first created.
   *
   * @see http://developer.android.com/reference/android/app/Activity.html#onCreate(android.os.Bundle)
   */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.setContentView(R.layout.about);

    ((TextView)this.findViewById(R.id.app_version)).setText(getVersionNumber());
    ((TextView)this.findViewById(R.id.app_date)).setText(getBuildDate());

    ((Button)this.findViewById(R.id.close)).setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        finish();
      }
    });
  }

  /**
   * Returns the application's version number.
   */
  public String getVersionNumber() {
    String versionName = getVersionName();
    return versionName.substring(0, versionName.lastIndexOf(".")); // cut off ".yyyymmdd"
  }

  /**
   * Returns the application's build date.
   */
  public String getBuildDate() {
    String versionName = getVersionName();
    String versionDate = versionName.substring(versionName.lastIndexOf(".") + 1); // "yyyymmdd"
    int year  = Integer.parseInt(versionDate.substring(0, 4)); // "yyyy"
    int month = Integer.parseInt(versionDate.substring(4, 6)); // "mm"
    int day   = Integer.parseInt(versionDate.substring(6, 8)); // "dd"
    return DateFormat.getDateFormat(this).format(new GregorianCalendar(year, month - 1, day).getTime()).toString();
  }

  /**
   * Returns the manifest's `android:versionName` string.
   *
   * @see http://developer.android.com/guide/topics/manifest/manifest-element.html#vname
   */
  public String getVersionName() {
    if (this.versionName == null) {
      this.versionName = "x.y.z.yyyymmdd";
      try {
        this.versionName = getPackageManager().getPackageInfo("org.opencoinage.android", 0).versionName;
      }
      catch (android.content.pm.PackageManager.NameNotFoundException e) {}
    }
    return this.versionName;
  }
}
