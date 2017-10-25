package anative.jean.com.br.neuranative;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import anative.jean.com.br.neuranative.R;

public class CadastroActivity extends AppCompatActivity {

    ImageSwitcher switcher;
    Button btn;
    TextView texto;
   // private static final int[] IMAGES = {R.drawable.mur, R.drawable.mur2, R.drawable.mur3, R.drawable.mur4};
    //private static final String[] XINGAMETNO = {"#EU QUERO MINHA API", "TE MANDEI EM PHP PORRA", "MURILO VAI TOMA NO CU", "#MVP"};
    //private int Sposition = 0;
    private int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        texto = (TextView) findViewById(R.id.zuar_o_murilo);

        switcher = (ImageSwitcher) findViewById(R.id.swicher);
        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,
                        ActionBar.LayoutParams.WRAP_CONTENT));
                return imageView;
            }
        });

       // switcher.setBackgroundResource(IMAGES[position]);
       // texto.setText(XINGAMETNO[position]);

        btn = (Button) findViewById(R.id.botao_proximo);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("***********************************" + position);
                if(position == 3){
                    Toast.makeText(CadastroActivity.this, "CHEGAAAAAAAAAA !!!!!!", Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    position++;
                    //switcher.setBackgroundResource(IMAGES[position]);
                   // texto.setText(XINGAMETNO[position]);
                }
            }
        });
    }
}
