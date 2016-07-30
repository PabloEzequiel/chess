package io.github.pabloezequiel.chesslab;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import io.github.pabloezequiel.chesslab.core.ChessModules;
import io.github.pabloezequiel.chesslab.store.ChessPack;
import io.github.pabloezequiel.chesslab.store.Const;

/**
 * Created by Pablo Ezequiel on 29/7/16.
 * <p/>
 * ProbarNoCuestaNada.com
 * <p/>
 * https://github.com/PabloEzequiel
 * https://javaen.blogspot.com
 */
public class MainStoreSingleton {

    public static String TAG = MainStoreSingleton.class.getSimpleName();

    public static String THEME_STYLE_INDIGO = "THEME_STYLE_INDIGO";
    public static String THEME_STYLE_GREEN  = "THEME_STYLE_GREEN";

    private MainContent mainContent;

    // Singleton
    private static MainStoreSingleton instance;

    private MainStoreSingleton() {}

    public static MainStoreSingleton getInstance() {

        if(instance == null) {

            instance = new MainStoreSingleton();

        }

        return instance;
    }

    /**
     * Los objetos del MainContent
     */

    class MainContent {


        private AppCompatActivity activity;

        public MainContent(AppCompatActivity activity) {
            this.activity = activity;



        }


        public AppCompatActivity getActivity() {
            return activity;
        }

        public void setActivity(AppCompatActivity activity) {
            this.activity = activity;
        }

    }




    public void doInit(AppCompatActivity activity, ChessPack chessPack, int SAVED_IDX) {

        String MATE_COLLECTION_SELECTED = chessPack.getChessPackID();

        mainContent = new MainStoreSingleton.MainContent(activity);

        showAvisoDialog();

    }



    private void showAvisoDialog() {

        String message = "Store";

        int r_draw = R.drawable.pieza03_torre;
        Drawable thumb = mainContent.getActivity().getResources().getDrawable(r_draw);

        showAvisoDialog("", message, thumb, THEME_STYLE_INDIGO);
    }

    private void showAvisoDialog(String titulo, String message, Drawable image, String THEME_STYLE) {


        final AppCompatActivity appActivity = mainContent.getActivity();
        final          Activity context     = mainContent.getActivity();

        // custom dialog
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.gchess_a002_store);


        // image
        ImageView di = (ImageView) dialog.findViewById(R.id.gchess_a002_img);
        di.setImageDrawable(image);

        di.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainContentSingleton.getInstance().doInit(appActivity, ChessPack.getInstance(Const.KEY_PACK_G002_001), 0);

                dialog.dismiss();

            }
        });


        // text
        TextView tv = (TextView) dialog.findViewById(R.id.gchess_a002_txt);
        tv.setText(message);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainContentSingleton.getInstance().doInit(appActivity, ChessPack.getInstance(Const.KEY_PACK_G002_001), 0);


                dialog.dismiss();

            }
        });


        // Layout Text
        if (THEME_STYLE_GREEN.equals(THEME_STYLE)) {
            LinearLayout ll = (LinearLayout) dialog.findViewById(R.id.gchess_a002_txt_layout);
            ll.setBackgroundColor(context.getResources().getColor(R.color.green_color_500));
            tv.setTextColor(context.getResources().getColor(R.color.colorPrimaryText));
        }
        // show
        dialog.show();

    }



}
