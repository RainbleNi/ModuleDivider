package rainbow.modulea;

import android.app.Application;
import rainbow.commonlibrary.AppContext;
import rainbow.commonlibrary.communication.FunctionA;
import rainbow.commonlibrary.communication.FunctionBus;

/**
 * Created by Nirui on 17/2/21.
 */

public class ApplicationA extends Application {

  @Override public void onCreate() {
    super.onCreate();
    AppContext.init(getApplicationContext());
  }

  /**
   * 作为library时需要初始化的内容
   */
  public static void onCreateAsLibrary() {
    FunctionBus.setFunction(new FunctionA() {
      @Override public String getData(String key) {
        return "xixi";
      }
    });
  }
}
