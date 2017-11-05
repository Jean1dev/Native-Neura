package anative.jean.com.br.neuranative;


import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;



public class CadastroActivity extends AppCompatActivity {

    private EditText nome;
    private EditText email;
    private EditText telefone;
    private EditText idade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        final AlertDialog.Builder alert = new AlertDialog.Builder(this);

        nome = (EditText) findViewById(R.id.txt_login);
        email = (EditText) findViewById(R.id.txt_telefone1);
        telefone = (EditText) findViewById(R.id.txt_tel);
        idade = (EditText) findViewById(R.id.txt_idade);

        Button send = (Button) findViewById(R.id.btn_);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nome.getText().toString().equals("")){
                    nome.setError("preencha esse campo");
                    nome.requestFocus();
                }else if(email.getText().toString().equals("")){
                    email.setError("preencha esse campo");
                    email.requestFocus();
                }else if(telefone.getText().toString().equals("")){
                    telefone.setError("preencha esse campo");
                    telefone.requestFocus();
                }else if(idade.getText().toString().equals("")){
                    idade.setError("preencha esse campo");
                    idade.requestFocus();
                }else {

                    String URL = "http://neuraapi-net.umbler.net/methods/insert_diarista.php";

                    Ion.with(getBaseContext())
                            .load(URL)
                            .setBodyParameter("nome", String.valueOf(nome.getText()))
                            .setBodyParameter("contato", String.valueOf(email.getText()))
                            .setBodyParameter("contato2", String.valueOf(telefone.getText()))
                            .setBodyParameter("idade", String.valueOf(idade.getText()))
                            .asJsonObject()
                            .setCallback(new FutureCallback<JsonObject>() {
                                @Override
                                public void onCompleted(Exception e, JsonObject result) {
                                    if (!result.get("retorno").getAsString().equals("YES")) {
                                        Toast.makeText(CadastroActivity.this, "Algum problema aconteceu, por favor tente novamente mais tarde", Toast.LENGTH_SHORT).show();
                                    } else {
                                        alert.setCancelable(false);
                                        alert.setTitle("Neura");
                                        alert.setMessage("Obrigado por se cadastrar, entraremos em contato com você");
                                        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                finish();
                                            }
                                        });
                                        alert.create().show();
                                    }
                                }
                            });
                }
            }
        });

    }
}
