package rainbow.commonlibrary.router;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.List;
import rainbow.commonlibrary.AppContext;
import rainbow.commonlibrary.BuildConfig;
import rainbow.commonlibrary.GsonInstance;

/**
 * Created by Nirui on 17/2/21.
 */

public class RounterBus {
  //静态map存储代理接口的实例
  private static HashMap<Class, Object> sRounterMap = new HashMap<Class, Object>();

  /**
   * 得到动态代理路由接口的实例
   *
   * @param c 接口类
   * @param <T>
   * @return
   */
  public static<T> T getRounter(Class<T> c) {
    T rounter = (T) sRounterMap.get(c);
    if (rounter == null) {
      rounter = (T) Proxy.newProxyInstance(c.getClassLoader(), new Class[] { c }, new InvocationHandler() {
        @Override public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
          //从方法注解的获取uri
          RouterUri routerUri = method.getAnnotation(RouterUri.class);
          if (routerUri == null || TextUtils.isEmpty(routerUri.value())) {
            throw new IllegalArgumentException(
                "invoke a rounter method, bug not assign a rounterUri");
          }
          Uri.Builder uriBuilder = Uri.parse(routerUri.value()).buildUpon();

          //从参数值和参数注解，获取信息，拼入uri的query
          Annotation[][] annotations = method.getParameterAnnotations();
          if (annotations != null && annotations.length > 0) {
            for (int i = 0, n = annotations.length; i < n; i++) {
              Annotation[] typeAnnotation = annotations[i];
              if (typeAnnotation == null || typeAnnotation.length == 0) {
                throw new IllegalArgumentException("method " + method.getName() + ", args at " + i + " lack of annotion RouterUri");
              }
              boolean findAnnotaion = false;
              for (Annotation a : typeAnnotation) {
                if (a != null && (a.annotationType() == RounterParam.class)) {
                  uriBuilder.appendQueryParameter(((RounterParam) a).value(), GsonInstance.getInstance().toJson(args[i]));
                  findAnnotaion = true;
                  break;
                }
              }
              if (!findAnnotaion) {
                throw new IllegalArgumentException("method " + method.getName() + " args at " + i + ", lack of annotion RouterUri");
              }
            }
          }

          Context context = AppContext.get();
          PackageManager pm = context.getPackageManager();
          Uri uri = uriBuilder.build();
          Intent intent = new Intent(Intent.ACTION_VIEW, uri);
          //查询这个intent是否能被接收用来进行跳转
          List<ResolveInfo> activities = pm.queryIntentActivities(intent, 0);
          if (activities != null && !activities.isEmpty()) {
            return intent;
          } else {
            if (BuildConfig.IS_DEBUG) {
              Toast.makeText(context, "子模块作为独立程序启动时，跳不到其他模块哟", Toast.LENGTH_SHORT).show();
            } else {
              throw new IllegalArgumentException("can't resolve uri with " + uri.toString());
            }
          }
          return null;
        }
      });
      sRounterMap.put(c, rounter);
    }
    return rounter;
  }

}
