package rainbow.testprogram;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import rainbow.commonlibrary.model.Phones;
import rainbow.commonlibrary.router.RounterBus;
import rainbow.commonlibrary.router.RouterA;
import rainbow.moduleb.ActivityB;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button_a).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                //startActivity(new Intent(MainActivity.this, ActivityA.class));
                Intent intent = RounterBus.getRounter(RouterA.class).getIntentActivityA("heihei", 23, new Phones());
                if (intent != null) {
                    MainActivity.this.startActivity(intent);
                }
            }
        });
        findViewById(R.id.button_b).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ActivityB.class));
            }
        });
    }
}
