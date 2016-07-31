package io.github.pabloezequiel.chesslab;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import io.github.pabloezequiel.chesslab.core.ChessModules;
import io.github.pabloezequiel.chesslab.store.ChessPack;
import io.github.pabloezequiel.chesslab.store.ChessPackActivity;
import io.github.pabloezequiel.chesslab.store.Const;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static String TAG = MainActivity.class.getSimpleName();

    private static final int RESULT_SETTINGS = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                superNextProblem(view);
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }


    @Override
    public void onResume()
    {
        super.onResume();

        Log.d(TAG, "onResume");

        MainContentSingleton.getInstance().doState_recover(this);
    }

    @Override
    public void onPause()
    {
        super.onPause();

        Log.d(TAG, "onPause");

        MainContentSingleton.getInstance().doState_persist(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            Intent intent = new Intent(this, UserSettingsActivity.class);
            startActivityForResult(intent, RESULT_SETTINGS);

            return true;
        }

        if (id == R.id.action_about) {

            Intent intent = new Intent(this, AboutActivity.class);
            startActivityForResult(intent, RESULT_SETTINGS);

            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        ChessPack chessPack = ChessPack.getInstance(Const.KEY_PACK_G001_001);  // Default

        boolean playChess = true;

        if (id == R.id.nav_mate1) {

            chessPack = ChessPack.getInstance(Const.KEY_PACK_G001_001);
            // MainContentSingleton.getInstance().doInit(this, ChessPack.getInstance(Const.KEY_PACK_G001_001), 0);

        } else if (id == R.id.nav_mate2) {

             chessPack = ChessPack.getInstance(Const.KEY_PACK_G001_002);

         //   MainContentSingleton.getInstance().doInit(this, ChessPack.getInstance(Const.KEY_PACK_G001_002), 0);

        } else if (id == R.id.nav_mate3) {

            chessPack = ChessPack.getInstance(Const.KEY_PACK_G001_003);


           // MainContentSingleton.getInstance().doInit(this, ChessPack.getInstance(Const.KEY_PACK_G001_003), 0);

        } else if (id == R.id.nav_mate4) {

            chessPack = ChessPack.getInstance(Const.KEY_PACK_G001_004);

           //  MainContentSingleton.getInstance().doInit(this, ChessPack.getInstance(Const.KEY_PACK_G001_004), 0);

         } else if (id == R.id.train_store) {

            chessPack = ChessPack.getInstance(Const.KEY_PACK_G002_001);

            // Main Store
            // MainContentSingleton.getInstance().doInit_Training(this, ChessPack.getInstance(Const.KEY_PACK_G002_001), 0);

        } else if (id == R.id.train_001) {


            playChess = false;

            Intent intent = new Intent(this, ChessPackActivity.class);
            startActivityForResult(intent, RESULT_SETTINGS);

            // MainContentSingleton.getInstance().doInit_Training(this, ChessPack.getInstance(Const.KEY_PACK_G002_001), 0);

        } else if (id == R.id.nav_share) {

            playChess = false;

            invokeShareIntent(this);

         //  } else if (id == R.id.nav_send) {


        }


        if (playChess) {

            MainContentSingleton.getInstance().justDoInit(chessPack,  0);

            MainContentSingleton.getInstance().doInit_ChessLab_public(this);

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }




    /*
    * Eventos Onclick
    * */
    public void firstProblem(View view) {

        MainContentSingleton.getInstance().firstProblem();
    }

    public void prevProblem(View view) {

        MainContentSingleton.getInstance().prevProblem();
    }

    public void nextProblem(View view) {

        MainContentSingleton.getInstance().nextProblem();
    }

    public void lastProblem(View view) {

        MainContentSingleton.getInstance().lastProblem();
    }


    /**
     * Boton de Next: La idea es que pase de nivel cuando se agota
     */
    public void superNextProblem(View view) {
        MainContentSingleton.getInstance().superNextProblem();
    }


    /**
     * Share button
     * @param activity
     */

    public static void invokeShareIntent(Activity activity) {

        String textToShare = "Chess Lab for Android!";
        String urlToShare = "https://play.google.com/store/apps/details?id=io.github.pabloezequiel.chesslab";
        String text = textToShare + "\n" + urlToShare;

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, text);
        activity.startActivity(intent);
    }

}



