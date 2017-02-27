package rainbow.modulea;

import android.content.Context;
import android.content.Intent;
import rainbow.commonlibrary.router.RounterBus;
import rainbow.commonlibrary.router.RouterB;

/**
 * Created by Nirui on 17/2/27.
 */

public class RounterEntry {

  public static void startActivityB(Context context) {
    Intent intent = RounterBus.getRounter(RouterB.class).getIntentActivityB();
    if (intent != null) {
      context.startActivity(intent);
    }
  }
}
