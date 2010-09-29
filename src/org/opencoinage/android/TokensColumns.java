package org.opencoinage.android;
import org.opencoinage.*;

import android.provider.BaseColumns;

/**
 * Columns from the Tokens table that other tables join into themselves.
 */
public interface TokensColumns extends BaseColumns {
  /**
   * The currency of the token.
   *
   * Type: INTEGER (ID into the Currencies table)
   */
  public static final String CURRENCY_ID = "currency_id";

  /**
   * The amount of the token.
   *
   * Type: TEXT (Decimal string)
   */
  public static final String AMOUNT = "amount";

  /**
   * The expiration date of the token.
   *
   * Type: TEXT (Unix timestamp)
   */
  public static final String EXPIRES = "expires";

  /**
   * The actual data in the token.
   *
   * Type: TEXT (Base62 string)
   */
  public static final String DATA = "data";
}
