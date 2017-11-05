package anative.jean.com.br.neuranative;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class ChoseActivity extends AppCompatActivity {

    private ImageView diarista;
    private ImageView cliente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose);

        diarista = (ImageView) findViewById(R.id.diarista);
        cliente = (ImageView) findViewById(R.id.cliente);

        diarista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getBaseContext(), CadastroActivity.class);
                startActivity(it);
            }
        });

        cliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), NavigationDrawerActivity.class);
                startActivity(intent);
            }
        });
    }
}
