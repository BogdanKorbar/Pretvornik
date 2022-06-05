package fri.uv.mobilnost;

import android.app.Instrumentation;
import android.content.Intent;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA = "vrednost";
    private final int REQUEST=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void pretvoriCB(View view) {
        Intent intent = new Intent(this, SekundarnaAktivnost.class);
        int index = ((Spinner)findViewById(R.id.spinner)).getSelectedItemPosition();
        intent.putExtra(EXTRA, index);
        startActivityForResult(intent, REQUEST);
    }

    @Override
    protected void onActivityResult(int reqC, int resC, Intent data){
        super.onActivityResult(reqC, resC, data);
        if (reqC==REQUEST){
            if (resC==RESULT_OK){
                String res = data.getStringExtra(SekundarnaAktivnost.EXTRA_R);
                ((TextView)findViewById(R.id.textView3)).setText("Pretvorjena vrednost: "+res);
            }
            else
                ((TextView)findViewById(R.id.textView3)).setText("Pretvorjena vrednost: ");
        }
    }
    public void prekliciCB(View view) {
        System.exit(0);
    }
}