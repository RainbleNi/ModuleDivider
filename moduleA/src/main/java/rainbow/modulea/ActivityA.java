package rainbow.modulea;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.squareup.picasso.Picasso;
import rainbow.commonlibrary.router.ModuleBRounter;
import rainbow.commonlibrary.router.RounterBus;

/**
 * Created by Nirui on 17/2/21.
 */

public class ActivityA extends Activity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.a_main_layout);
    findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Intent intent = RounterBus.getRounter(ActivityA.this, ModuleBRounter.class).getIntentActivityB();
        if (intent != null) {
          startActivity(intent);
        }
      }
    });
    ViewPager.class.getName();
    Picasso.class.getName();
  }
}
