package rainbow.modulea;

import android.app.Application;
import rainbow.commonlibrary.AppContext;
import rainbow.commonlibrary.BaseChildApplication;
import rainbow.commonlibrary.communication.FunctionA;
import rainbow.commonlibrary.communication.FunctionBus;

/**
 * Created by Nirui on 17/2/21.
 */

public class ApplicationA extends BaseChildApplication {

  @Override public void onCreate() {
    super.onCreate();
    //给底层library设置context
    AppContext.init(getApplicationContext());
  }

  /**
   * 作为library时需要初始化的内容
   */
  @Override public void onCreateAsLibrary(Application application) {
    super.onCreateAsLibrary(application);
    //给FunctionBus传入已实现的公开方法的实例
    FunctionBus.setFunction(new FunctionA() {
      @Override public String getData(String key) {
        return "xixi";
      }
    });
  }
}
