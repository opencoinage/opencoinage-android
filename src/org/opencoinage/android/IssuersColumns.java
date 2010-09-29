package org.opencoinage.android;
import org.opencoinage.*;

import android.provider.BaseColumns;

/**
 * Columns from the Issuers table that other tables join into themselves.
 */
public interface IssuersColumns extends BaseColumns {
  /**
   * The URI identifying the issuer.
   *
   * Type: TEXT (URI of the issuer)
   */
  public static final String URI = "uri";

  /**
   * The name of the issuer.
   *
   * Type: TEXT
   */
  public static final String NAME = "name";
}
