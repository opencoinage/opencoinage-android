package org.opencoinage.android;
import org.opencoinage.*;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

public class Assets {
  public static final Charset UTF_8 = Charset.forName("UTF-8");
  public static AssetManager manager;

  /**
   * Returns the asset manager.
   *
   * @return the asset manager
   * @see http://developer.android.com/reference/android/content/res/AssetManager.html
   */
  public static AssetManager getManager() {
    assert manager != null;
    return manager;
  }

  /**
   * Sets the context from which assets are retrieved.
   *
   * This must be called before any of the other methods in this class can
   * be used.
   *
   * @param context the application context
   * @see http://developer.android.com/reference/android/content/Context.html#getAssets()
   */
  public static void setContext(Context context) {
    manager = context.getAssets();
  }

  /**
   * Returns a list of the asset files in the given directory path.
   *
   * @param dirPath a relative directory path under <code>assets/</code>
   * @return an array of file names
   * @see http://developer.android.com/reference/android/content/res/AssetManager.html#list(java.lang.String)
   */
  public static String[] list(String dirPath) throws IOException {
    return getManager().list(dirPath);
  }

  /**
   * Reads and returns the contents of the given plain-text asset file.
   *
   * The default text encoding assumed is UTF-8.
   *
   * @param filePath the asset file path (omitting "assets/")
   * @return the file contents
   * @see http://developer.android.com/reference/android/content/res/AssetManager.html#openFd(java.lang.String)
   */
  public static String readTextFile(String filePath) throws IOException {
    return readTextFile(getManager().openFd(filePath));
  }

  /**
   * Reads and returns the contents of the given plain-text asset file.
   *
   * The default text encoding assumed is UTF-8.
   *
   * @param input an already opened asset file descriptor
   * @return the file contents
   * @see http://developer.android.com/reference/android/content/res/AssetFileDescriptor.html
   */
  public static String readTextFile(AssetFileDescriptor input) throws IOException {
    return readTextFile(input, UTF_8);
  }

  /**
   * Reads and returns the contents of the given plain-text asset file.
   *
   * @param input an already opened asset file descriptor
   * @param charset the text encoding to use
   * @return the file contents
   * @see http://developer.android.com/reference/android/content/res/AssetFileDescriptor.html
   */
  public static String readTextFile(AssetFileDescriptor input, Charset charset) throws IOException {
    return readTextFile(input.createInputStream(), charset);
  }

  /**
   * Reads and returns the contents of the given plain-text asset file.
   *
   * The default text encoding assumed is UTF-8.
   *
   * @param input an already opened input file stream
   * @return the file contents
   * @see http://developer.android.com/reference/java/io/FileInputStream.html
   */
  public static String readTextFile(FileInputStream input) throws IOException {
    return readTextFile(input, UTF_8);
  }

  /**
   * Reads and returns the contents of the given plain-text asset file.
   *
   * @param input an already opened input file stream
   * @param charset the text encoding to use
   * @return the file contents
   * @see http://developer.android.com/reference/java/io/FileInputStream.html
   * @see http://developer.android.com/reference/java/nio/channels/FileChannel.html
   */
  public static String readTextFile(FileInputStream input, Charset charset) throws IOException {
    try {
      FileChannel channel = input.getChannel();
      MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, channel.position(), input.available());
      return charset.decode(buffer).toString();
    }
    finally {
      input.close();
    }
  }
}
