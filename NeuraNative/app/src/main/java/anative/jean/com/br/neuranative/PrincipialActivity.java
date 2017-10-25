package anative.jean.com.br.neuranative;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import anative.jean.com.br.neuranative.R;

public class PrincipialActivity extends AppCompatActivity {

    String URL = "https://neuraapp.com";
    TextView nome;
    FloatingActionButton btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principial);

        Toast.makeText(getBaseContext(), "Só um momento, estamos preparando tudo", Toast.LENGTH_SHORT).show();
        WebView browser = (WebView) findViewById(R.id.web);
        browser.setWebViewClient(new WebViewClient());
        browser.loadUrl(URL);

       /* final Intent intent = getIntent();
        nome = (TextView) findViewById(R.id.textView_nome);
        nome.setText("Oi " + intent.getStringExtra("nome") + " arrumaremos uma faxina, só clicar aki ->");

        btn = (FloatingActionButton) findViewById(R.id.floatingActionButton2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getBaseContext(), CadastroActivity.class);
                startActivity(it);
            }
        });*/
    }
}
