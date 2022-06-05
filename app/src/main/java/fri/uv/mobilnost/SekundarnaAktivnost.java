package fri.uv.mobilnost;

import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class SekundarnaAktivnost extends AppCompatActivity {
    public static final String EXTRA_R = "rezultat";
    private int idx;
    private Spinner spn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sekundarna_aktivnost);
        Intent intent = getIntent();
        idx = intent.getIntExtra(MainActivity.EXTRA, 0);
        if (idx==0) ((TextView)findViewById(R.id.textView4)).setText("Izberi vrednost: cm=>inč");
        else ((TextView)findViewById(R.id.textView4)).setText("Izberi vrednost: inč=>cm");
        spn = ((Spinner) findViewById(R.id.spinner2));
        List<Double> lst = new ArrayList<>();
        for (int i=0;i<100;i++) lst.add(i/10.0);
        ArrayAdapter<Double> adp = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lst);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn.setAdapter(adp);
    }

    public void pretvoriCB(View view) {
        spn = ((Spinner) findViewById(R.id.spinner2));
        double val = (Double)(spn.getSelectedItem());
        if (idx==0) val/=2.54;
        else val*=2.54;
        String result="";
        if (((Switch)findViewById(R.id.switch1)).isChecked())
            result = String.format("%.2f %s",val, (idx==0?"inč":"cm"));
        else
            result = String.format("%.2f",val);
        Intent res = new Intent();
        res.putExtra(EXTRA_R, result);
        setResult(RESULT_OK, res);
        finish();
    }

    public void prekliciCB(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }
}