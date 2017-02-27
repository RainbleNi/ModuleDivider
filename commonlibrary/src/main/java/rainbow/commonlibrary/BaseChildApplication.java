package rainbow.commonlibrary;

import android.app.Application;

/**
 * Created by Nirui on 17/2/27.
 */

public class BaseChildApplication extends Application implements ApplicationAsLibrary {

  @Override public void onCreate() {
    super.onCreate();
    onCreateAsLibrary(this);
  }

  @Override public void onLowMemory() {
    super.onLowMemory();
    onLowMemoryAsLibrary(this);
  }

  @Override public void onTrimMemory(int level) {
    super.onTrimMemory(level);
    onTrimMemoryAsLibrary(this, level);
  }

  @Override public void onCreateAsLibrary(Application application) {

  }

  @Override public void onLowMemoryAsLibrary(Application application) {

  }

  @Override public void onTrimMemoryAsLibrary(Application application, int level) {

  }
}
