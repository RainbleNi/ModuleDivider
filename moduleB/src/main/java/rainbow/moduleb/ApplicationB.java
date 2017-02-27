package rainbow.moduleb;

import android.app.Application;
import rainbow.commonlibrary.AppContext;
import rainbow.commonlibrary.BaseChildApplication;

/**
 * Created by Nirui on 17/2/21.
 */

public class ApplicationB extends BaseChildApplication {

  @Override public void onCreate() {
    super.onCreate();
    AppContext.init(getApplicationContext());
  }

  @Override public void onCreateAsLibrary(Application application) {
    super.onCreateAsLibrary(application);
  }
}
