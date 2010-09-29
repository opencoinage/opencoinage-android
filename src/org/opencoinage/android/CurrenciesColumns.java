package org.opencoinage.android;
import org.opencoinage.*;

import android.provider.BaseColumns;

/**
 * Columns from the Currencies table that other tables join into themselves.
 */
public interface CurrenciesColumns extends BaseColumns {
  /**
   * The URI identifying the currency.
   *
   * Type: TEXT (URI of the currency)
   */
  public static final String URI = "uri";

  /**
   * The name of the currency.
   *
   * Type: TEXT
   */
  public static final String NAME = "name";

  /**
   * The issuer of the currency.
   *
   * Type: TEXT (URI of the issuer)
   */
  public static final String ISSUER = "issuer";
}
