package anative.jean.com.br.neuranative;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.support.design.widget.FloatingActionButton;
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

import anative.jean.com.br.neuranative.auxiliar.ClasseAuxiliar;


public class MainActivity extends AppCompatActivity {

    Button entrar;
    FloatingActionButton sobre;
    EditText nome;
    EditText telefone;
    String nome_final;
    String telefone_final;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


/*

        Button teste = (Button) findViewById(R.id.button__);
        teste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), CadastroActivity.class);
                startActivity(intent);
            }
        });


        sobre = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        sobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), NavigationDrawerActivity.class);
                startActivity(intent);
            }
        });*/


        final AlertDialog.Builder alert = new AlertDialog.Builder(this);

        entrar = (Button) findViewById(R.id.btn_);
        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entrar.setEnabled(false);
                nome = (EditText) findViewById(R.id.txt_login);
                telefone = (EditText) findViewById(R.id.txt_tel);


                System.out.println("*************************" + nome.getText().toString());

                if (nome.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Ops, voce não colocou o nome", Toast.LENGTH_SHORT).show();
                    nome.setError("aqui :)");
                    nome.requestFocus();

                } else if (telefone.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Ops, voce não colocou o telefone", Toast.LENGTH_SHORT).show();
                    telefone.setError("aqui :)");
                    telefone.requestFocus();

                } else {

                    ConnectivityManager conexao = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                    if (conexao.getNetworkInfo(1).isConnected() || conexao.getNetworkInfo(0).isConnected()) {
                        nome_final = nome.getText().toString();
                        telefone_final = telefone.getText().toString();

                        String URL = "http://neuraapi-net.umbler.net/methods/sendToback.php";
                        //String URL = "http://neuraapi-net.umbler.net/methods/insert_cliente.php";

                        //*************************** AKI VAI PRA CLASSE AUXILIAR ATE EU RESOLVE ESSE PACOTE ION
                        //ClasseAuxiliar classeAuxiliar = new ClasseAuxiliar();
                        //classeAuxiliar.requireGET(nome_final, telefone_final);
                        //classeAuxiliar.insertClienteRemoto(nome_final, telefone_final);

                        Ion.with(getBaseContext())
                                .load(URL)
                                .setBodyParameter("nome", nome_final)
                                .setBodyParameter("telefone", telefone_final)
                                .asJsonObject()
                                .setCallback(new FutureCallback<JsonObject>() {
                                    @Override
                                    public void onCompleted(Exception e, JsonObject result) {

                                        alert.setCancelable(false);
                                        alert.setTitle("Neura");
                                        alert.setMessage("Obrigado " + nome_final + " agora é so esperar entrarmos em contato");
                                        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                finish();
                                            }
                                        });
                                        alert.create().show();
/*
                                        if (result.get("retorno").getAsString().equals("YES")) {
                                            System.out.println("********** FOI PORRRAAAAAAAAAAAAAAAAAAA");
                                            System.out.println(nome_final);
                                            System.out.println(telefone_final);

                                            alert.setCancelable(false);
                                            alert.setTitle("Neura");
                                            alert.setMessage("Obrigado " + nome_final + " agora é so esperar entrarmos em contato");
                                            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    finish();
                                                }
                                            });
                                            alert.create().show();
                                        } else {
                                            Toast.makeText(MainActivity.this, "Desculpe não conseguimos enviar, verifique sua internet", Toast.LENGTH_SHORT).show();
                                        }
*/
                                    }

                                });

                    } else {

                        alert.setCancelable(false);
                        alert.setTitle("Neura");
                        alert.setMessage("Desculpe, mas você precisa estar conectado a internet para usar este serviço");
                        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        }).setNegativeButton("Conectar a internet", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                                wifi.setWifiEnabled(true);
                                Toast.makeText(MainActivity.this, "Conctando a wifi mais proxima", Toast.LENGTH_SHORT).show();
                            }
                        });
                        alert.create().show();
                    }
                }
            }
        });
    }
}
