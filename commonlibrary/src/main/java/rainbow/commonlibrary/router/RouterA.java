package rainbow.commonlibrary.router;

import android.content.Intent;
import rainbow.commonlibrary.model.Phones;

/**
 * Created by Nirui on 17/2/21.
 */

public interface RouterA {

  @RouterUri("test://host_a")
  public Intent getIntentActivityA(@RounterParam("name") String name, @RounterParam("age") int age,
      @RounterParam("phones") Phones phones);
}
