package io.github.pabloezequiel.chesslab.store;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import io.github.pabloezequiel.chesslab.MainActivity;
import io.github.pabloezequiel.chesslab.MainContentSingleton;
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

        ChessPack itemChessPack = (ChessPack) parent.getItemAtPosition(position);

        Log.d(TAG, "itemClick " + itemChessPack);


        MainContentSingleton.getInstance().justDoInit(itemChessPack,  0);

        // LLamado tambien en onPause() ...
        MainContentSingleton.getInstance().doState_persist(this);

        // Do a refresh to Main Activity
        Intent refresh = new Intent(this, MainActivity.class);
        refresh.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(refresh);
        finish();


    }
}

