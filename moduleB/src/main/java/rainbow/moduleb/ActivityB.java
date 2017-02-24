package rainbow.moduleb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import rainbow.commonlibrary.communication.FunctionA;
import rainbow.commonlibrary.communication.FunctionBus;
import rainbow.commonlibrary.router.RouterA;
import rainbow.commonlibrary.router.RounterBus;
import rainbow.commonlibrary.model.Phones;

/**
 * Created by Nirui on 17/2/21.
 */

public class ActivityB extends Activity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.b_main_layout);
    findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Intent intent = RounterBus.getRounter(RouterA.class).getIntentActivityA("xixi", 1, new Phones());
        if (intent != null) {
          startActivityForResult(intent, 0);
        }
      }
    });
    FunctionA f = FunctionBus.getFunction(FunctionA.class);
    if (f != null) {
      Toast.makeText(this, f.getData("hi"), Toast.LENGTH_SHORT).show();
    }
  }
}
