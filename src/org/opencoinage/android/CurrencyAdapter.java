package org.opencoinage.android;
import org.opencoinage.*;

import android.content.Context;
import android.widget.SimpleAdapter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrencyAdapter extends SimpleAdapter {
  public static final String CURRENCY_DIR = "currencies";
  public static final String KEY_LABEL    = "label";
  public static final String KEY_BALANCE  = "balance";

  public static List<Map<String, String>> currencies;

  public static List<Map<String, String>> getCurrencies() {
    if (currencies == null) {
      currencies = new ArrayList<Map<String, String>>();
      try {
        for (String fileName: Assets.list(CURRENCY_DIR)) {
          String line = Assets.readTextFile(CURRENCY_DIR + "/" + fileName);
          if (line != null) {
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
    super(context, getCurrencies(), android.R.layout.simple_list_item_2,
      new String[] { KEY_LABEL, KEY_BALANCE },
      new int[] { android.R.id.text1, android.R.id.text2 });
  }
}
