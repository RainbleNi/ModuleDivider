package rainbow.commonlibrary.router;

import android.content.Intent;

/**
 * Created by Nirui on 17/2/21.
 */

public interface RouterB {

  @RouterUri("test://host_b")
  public Intent getIntentActivityB();
}
