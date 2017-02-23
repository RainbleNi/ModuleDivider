package rainbow.commonlibrary;

import com.google.gson.Gson;

/**
 * Created by Nirui on 17/2/21.
 */

public class GsonInstance {

  private static Gson sInstance;

  public static Gson getInstance() {
    if (sInstance != null) {
      return sInstance;
    }
    synchronized (GsonInstance.class) {
      if (sInstance == null) {
        sInstance = new Gson();
      }
    }
    return sInstance;
  }

}
