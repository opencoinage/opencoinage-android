package org.opencoinage.android;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity implements OnItemClickListener {
  static final String[] CURRENCIES = new String[] {
    "Gold Grams",     // GAU
    "Monopoly Money", // MMX
    "Bernanke Bucks", // BBX
  };

  /**
   * Called when the activity is first created.
   *
   * @see http://developer.android.com/reference/android/app/Activity.html#onCreate(android.os.Bundle)
   */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, CURRENCIES)); // TODO
    ListView listView = getListView();
    listView.setTextFilterEnabled(true);
    listView.setOnItemClickListener(this);
  }

  /**
   * Called when an item in the list view has been clicked.
   *
   * @see http://developer.android.com/reference/android/widget/AdapterView.OnItemClickListener.html#onItemClick(android.widget.AdapterView<?>, android.view.View, int, long)
   */
  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    Toast.makeText(this, ((TextView)view).getText(), Toast.LENGTH_SHORT).show(); // TODO
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
      case R.id.about:
        startActivity(new Intent(MainActivity.this, AboutActivity.class));
        return true;
      case R.id.settings:
        startActivity(new Intent(MainActivity.this, SettingsActivity.class));
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }
}
