package rainbow.testprogram;

import android.app.Application;
import java.util.ArrayList;
import java.util.List;
import rainbow.commonlibrary.AppContext;
import rainbow.commonlibrary.ApplicationAsLibrary;
import rainbow.modulea.ApplicationA;
import rainbow.moduleb.ApplicationB;

/**
 * Created by Nirui on 17/2/21.
 */

public class MainApplication extends Application {
  private List<ApplicationAsLibrary> mChildApplicationList = new ArrayList<>();

  @Override public void onCreate() {
    super.onCreate();
    AppContext.init(getApplicationContext());
    mChildApplicationList.add(new ApplicationA());
    mChildApplicationList.add(new ApplicationB());


    for (ApplicationAsLibrary app : mChildApplicationList) {
      app.onCreateAsLibrary(this);
    }
  }

  @Override public void onTrimMemory(int level) {
    super.onTrimMemory(level);
    for (ApplicationAsLibrary app : mChildApplicationList) {
      app.onTrimMemoryAsLibrary(this, level);
    }
  }

  @Override public void onLowMemory() {
    super.onLowMemory();
    for (ApplicationAsLibrary app : mChildApplicationList) {
      app.onLowMemoryAsLibrary(this);
    }
  }
}
