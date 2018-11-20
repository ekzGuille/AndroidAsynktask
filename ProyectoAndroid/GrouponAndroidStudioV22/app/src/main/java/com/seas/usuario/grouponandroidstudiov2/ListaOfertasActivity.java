package com.seas.usuario.grouponandroidstudiov2;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.seas.usuario.grouponandroidstudiov2.adaptadores.AdaptadorLocales;
import com.seas.usuario.grouponandroidstudiov2.beans.Cliente;
import com.seas.usuario.grouponandroidstudiov2.beans.Local;
import com.seas.usuario.grouponandroidstudiov2.datos.GrouponData;
import com.seas.usuario.grouponandroidstudiov2.tools.IPGetter;
import com.seas.usuario.grouponandroidstudiov2.tools.Post;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;

public class ListaOfertasActivity extends Activity {
    private ArrayList<Local> m_locals = new ArrayList<Local>();
    private AdaptadorLocales adaptadorLocales;
    private ListView lv;
    private TextView tx;

    //private final String IP_LOCAL_SERVIDOR = "192.168.20.129";
    private final String IP_LOCAL_SERVIDOR = IPGetter.getInstance().getIP();
    private final String URL_FOTO = IP_LOCAL_SERVIDOR + ":8080/AndroidAsynktaskBack/images/pelicula/";


    private static ListaOfertasActivity listaOfertasActivity = null;

    public static ListaOfertasActivity getInstance() {
        return listaOfertasActivity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView tx = (TextView) findViewById(R.id.textLoggedUser);

        Cliente cliente = (Cliente) getIntent().getSerializableExtra("cliente");

        tx.setText("Logged as: " + cliente.getEmail());

        setContentView(R.layout.activity_lista_ofertas);
        listaOfertasActivity = this;
        lv = (ListView) findViewById(R.id.listView);
        lv.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Local local = (Local) parent.getItemAtPosition(position);

                // Almaceno el Local seleccionado para que sea accesible
                // desde cualquier punto de la aplicacion
                GrouponData.setLocalSeleccionado(local);
            }
        });
        HashMap<String, String> parametros = new HashMap<String, String>();
        parametros.put("ACTION", "Pelicula.listAll");

        TareaSegundoPlano tarea = new TareaSegundoPlano(parametros);
        tarea.
                execute("http://" + IP_LOCAL_SERVIDOR + ":8080/AndroidAsynktaskBack/Controller");


    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    class TareaSegundoPlano extends AsyncTask<String, Integer, Boolean> {
        private ArrayList<Local> listaLocales = null;
        private HashMap<String, String> parametros = null;


        public TareaSegundoPlano(HashMap<String, String> parametros) {
            this.parametros = parametros;
        }

        /*
         * doInBackground().
         * Contendrá el código principal de nuestra tarea.
         * */
        @Override
        protected Boolean doInBackground(String... params) {
            // URL
            String url_select = params[0];
            try {
                Post post = new Post();

                JSONArray result = post.
                        getServerDataPost(parametros, url_select);
                listaLocales = Local.getArrayListFromJSon(result);
            } catch (Exception e) {
                Log.e("log_tag", "Error in http connection " + e.toString());
                //messageUser = "Error al conectar con el servidor. ";
            }

            return true;
        }

        /*
         * onPostExecute().
         * Se ejecutará cuando finalice nuestra tarea, o dicho de otra forma,
         * tras la finalización del método doInBackground().
         * */
        @Override
        protected void onPostExecute(Boolean resp) {
            try {
                if (resp && listaLocales != null && listaLocales.size() > 0) {
                    for (Local local : listaLocales) {
                        local.
                                setUrlImagen(URL_FOTO + local.getUrlImagen());
                    }
                    adaptadorLocales = new
                            AdaptadorLocales(getBaseContext(), listaLocales);
                    lv.setAdapter(adaptadorLocales);
                } else {
                    Toast.makeText(ListaOfertasActivity.getInstance().getBaseContext(), "" +
                            "Lista incorrecta. ", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                // TODO: handle exception
                Log.e("log_tag", "Error parsing data " + e.toString());
            }
        }
    }
}
