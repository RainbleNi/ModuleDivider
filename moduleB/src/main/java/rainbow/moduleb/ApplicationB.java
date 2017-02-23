package rainbow.moduleb;

import android.app.Application;
import rainbow.commonlibrary.AppContext;

/**
 * Created by Nirui on 17/2/21.
 */

public class ApplicationB extends Application {

  @Override public void onCreate() {
    super.onCreate();
    AppContext.init(getApplicationContext());
  }

  public static void onCreateAsLibrary() {

  }
}
