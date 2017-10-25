package anative.jean.com.br.neuranative.auxiliar;

import android.util.Log;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Jean on 18/10/2017.
 */

public class ClasseAuxiliar {

    public ClasseAuxiliar(){

    }

    public void requireGET(String param1, String param2) {

        StringBuilder link = new StringBuilder();
        link.append("http://neuraapi-net.umbler.net/");
        link.append("methods/");
        link.append("sendoTobackGET.php");
        link.append("?nome=" + param1);
        link.append("&telefone=" + param2);

        Log.d("URL GERADO PELA CLASSE AUXILIAR", link.toString());

        try {
            java.net.URL conexao = new URL(link.toString());
            HttpURLConnection httpURLConnection = (HttpURLConnection) conexao.openConnection();
            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());

        } catch (Exception e) {

            //   Log.d("CAIU NA EXCEPTION", e.getMessage());
        }
    }
        public void insertClienteRemoto(String param1, String param2){

            StringBuilder link = new StringBuilder();
            link.append("http://neuraapi-net.umbler.net/");
            link.append("methods/");
            link.append("insert_cliente.php");
            link.append("?nome=" + param1);
            link.append("&telefone=" + param2);

            Log.d("URL GERADO PELA CLASSE AUXILIAR", link.toString());

            try {
                java.net.URL conexao = new URL(link.toString());
                HttpURLConnection httpURLConnection = (HttpURLConnection) conexao.openConnection();
                InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());

            } catch (Exception e) {

                //   Log.d("CAIU NA EXCEPTION", e.getMessage());
            }
    }

}
