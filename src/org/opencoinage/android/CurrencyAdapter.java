package org.opencoinage.android;

import android.content.Context;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrencyAdapter extends SimpleAdapter {
  public static final String KEY_LABEL   = "label";
  public static final String KEY_BALANCE = "balance";

  public static final String[][] CURRENCIES = new String[][] {
    new String[] { "GAU", "Gold Grams",     "0.00gg" },
    new String[] { "MMX", "Monopoly Money", "\u00A30.00" },
    new String[] { "BBX", "Bernanke Bucks", "$0.00" },
  };

  public static List<Map<String, String>> currencies;

  public static List<Map<String, String>> getCurrencies() {
    if (currencies == null) {
      currencies = new ArrayList<Map<String, String>>();
      for (int i = 0; i < CURRENCIES.length; i++) {
        Map<String, String> currency = new HashMap<String, String>();
        currency.put(KEY_LABEL,   CURRENCIES[i][1]);
        currency.put(KEY_BALANCE, CURRENCIES[i][2]);
        currencies.add(currency);
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
