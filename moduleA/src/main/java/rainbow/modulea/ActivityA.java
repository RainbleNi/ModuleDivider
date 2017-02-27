package rainbow.modulea;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.squareup.picasso.Picasso;

/**
 * Created by Nirui on 17/2/21.
 */

public class ActivityA extends Activity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.a_main_layout);
    findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
/*        Intent intent = RounterBus.getRounter(RouterB.class).getIntentActivityB();
        if (intent != null) {
          startActivity(intent);
        }*/
        RounterEntry.startActivityB(ActivityA.this);
      }
    });
    ViewPager.class.getName();
    Picasso.class.getName();
  }
}
