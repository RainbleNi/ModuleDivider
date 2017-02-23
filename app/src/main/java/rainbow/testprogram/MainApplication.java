package rainbow.testprogram;

import android.app.Application;
import rainbow.commonlibrary.AppContext;
import rainbow.modulea.ApplicationA;
import rainbow.moduleb.ApplicationB;

/**
 * Created by Nirui on 17/2/21.
 */

public class MainApplication extends Application {

  @Override public void onCreate() {
    super.onCreate();
    AppContext.init(getApplicationContext());
    ApplicationA.onCreateAsLibrary();
    ApplicationB.onCreateAsLibrary();
  }
}
