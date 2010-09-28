package org.opencoinage.android;
import org.opencoinage.*;

import android.content.Context;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.res.AssetManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class CurrencyAdapter extends SimpleAdapter {
  public static final String CURRENCY_DIR = "currencies";
  public static final String KEY_LABEL    = "label";
  public static final String KEY_BALANCE  = "balance";

  public static List<Map<String, String>> currencies;

  public static List<Map<String, String>> getCurrencies(Context context) {
    if (currencies == null) {
      currencies = new ArrayList<Map<String, String>>();
      AssetManager assets = context.getAssets();
      try {
        for (String fileName: assets.list(CURRENCY_DIR)) {
          BufferedReader in = new BufferedReader(new InputStreamReader(
            assets.open(CURRENCY_DIR + "/" + fileName), "UTF-8"), 1024);
          String line;
          if ((line = in.readLine()) != null) {
            String[] columns = line.split(";", 3);
            Map<String, String> currency = new HashMap<String, String>();
            currency.put(KEY_LABEL,   columns[1]);
            currency.put(KEY_BALANCE, columns[2]);
            currencies.add(currency);
          }
        }
      }
      catch (IOException e) {
        e.printStackTrace(); // FIXME
      }
    }
    return currencies;
  }

  public CurrencyAdapter(Context context) {
    super(context, getCurrencies(context), android.R.layout.simple_list_item_2,
      new String[] { KEY_LABEL, KEY_BALANCE },
      new int[] { android.R.id.text1, android.R.id.text2 });
  }
}
