package io.github.pabloezequiel.chesslab.store;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import io.github.pabloezequiel.chesslab.R;

/**
 * Created by Pablo Ezequiel on 29/7/16.
 * <p>
 * ProbarNoCuestaNada.com
 * <p>
 * https://github.com/PabloEzequiel
 * https://javaen.blogspot.com
 */
public class ChessPackActivity  extends AppCompatActivity 
    implements AdapterView.OnItemClickListener {


    public static String TAG = ChessPackActivity.class.getSimpleName();

    private GridView gridView;
    private ChessPackAdapter adaptador;
    

    @Override
    public void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);

        Log.d(TAG, "ChessPackActivity :: Creado");

        setContentView(R.layout.gchess_a003_store);

        gridView = (GridView) findViewById(R.id.grid);
        adaptador = new ChessPackAdapter(this);
        gridView.setAdapter(adaptador);
        gridView.setOnItemClickListener(this);

    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        ChessPack item = (ChessPack) parent.getItemAtPosition(position);

        Log.d(TAG, "itemClick " + item);

        /*
        Intent intent = new Intent(this, ActividadDetalle.class);
        intent.putExtra(ActividadDetalle.EXTRA_PARAM_ID, item.getId());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            ActivityOptionsCompat activityOptions =
                    ActivityOptionsCompat.makeSceneTransitionAnimation(
                            this,
                            new Pair<View, String>(view.findViewById(R.id.imagen_chess_pack),
                                    ActividadDetalle.VIEW_NAME_HEADER_IMAGE)
                    );

            ActivityCompat.startActivity(this, intent, activityOptions.toBundle());
        } else {
            startActivity(intent);
        }
        */

    }
}

