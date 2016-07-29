package io.github.pabloezequiel.chesslab;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import io.github.pabloezequiel.chesslab.core.ChessModules;
import io.github.pabloezequiel.chesslab.core.ChessSolutions;
import io.github.pabloezequiel.chesslab.core.ChessTrainer;

/**
 * Created by Pablo Ezequiel on 7/6/16.
 * <p>
 * ProbarNoCuestaNada.com
 * <p>
 * https://github.com/PabloEzequiel
 * https://javaen.blogspot.com
 */
public class MainContentSingleton {

    public static String TAG = MainContentSingleton.class.getSimpleName();
    // public static String TAG = "MainContentSingleton";


    public static String THEME_STYLE_INDIGO = "THEME_STYLE_INDIGO";
    public static String THEME_STYLE_GREEN  = "THEME_STYLE_GREEN";






    // puntero
    private static String MATE_COLLECTION = ChessModules.KEY_MATE_1_COLLECTION;
    private static int idx = 0;


    private MainContent mainContent;

    /**
     * Los objetos del MainContent
     */
     class MainContent {


        private  SeekBar   seekBar;
        private  TextView  textView;
        private  TextView  textViewLeft;
        private  ImageView image;             // Chess Diagram Image
        private  ImageView buttonSolution;    // Icon Question Solution
        private  TextView  chessSolution;

        private  EditText  userSolution;        // Only for training mode
        private  ImageView sendMailSolution;    // Icon Send Mail with Solutions


        private  AppCompatActivity activity;

        public MainContent(AppCompatActivity activity) {
            this.activity = activity;

            seekBar        = (SeekBar)   activity.findViewById(R.id.seekBar1);
            textViewLeft   = (TextView)  activity.findViewById(R.id.seekBar1_text_left);
            textView       = (TextView)  activity.findViewById(R.id.seekBar1_text);
            image          = (ImageView) activity.findViewById(R.id.chess_board_image);
            buttonSolution = (ImageView) activity.findViewById(R.id.navigation_05_info);
            chessSolution  = (TextView)  activity.findViewById(R.id.chess_solution);


            userSolution      = (EditText)  activity.findViewById(R.id.chess_txt_mail);
            sendMailSolution  = (ImageView) activity.findViewById(R.id.send_mail);

        }


        public AppCompatActivity getActivity() {
            return activity;
        }

        public void setActivity(AppCompatActivity activity) {
            this.activity = activity;
        }

        public SeekBar getSeekBar() {
            return seekBar;
        }

        public TextView getTextViewLeft() {
            return textViewLeft;
        }

        public TextView getTextView() {
            return textView;
        }

        public ImageView getImage() {
            return image;
        }

        public ImageView getButtonSolution() {
            return buttonSolution;
        }

        public TextView getChessSolution() {
            return chessSolution;
        }


        // Training Mode
        public EditText  getUserSolution() {
            return userSolution;
        }

        public ImageView getSendMailSolution() {
            return sendMailSolution;
        }
    }



    // Singleton
    private static MainContentSingleton instance;

    private MainContentSingleton() {}

    public static MainContentSingleton getInstance() {

        if(instance == null) {

            instance = new MainContentSingleton();

        }

        return instance;
    }



    //--[Init]------------------------------------------------------------

    private static final String MY_SETTINGS_NAME           = "ChessLab03";
    private static final String MY_SETTINGS_KEY_COLLECTION = "ChessProblem_Collection";
    private static final String MY_SETTINGS_KEY_IDX        = "ChessProblem_Idx";


    public  void doState_persist(AppCompatActivity activity) {

        Log.d(TAG, "doState_persist()");

        SharedPreferences mySettings = activity.getSharedPreferences(MY_SETTINGS_NAME, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = mySettings.edit();

        editor.putString(MY_SETTINGS_KEY_COLLECTION, MATE_COLLECTION);
        editor.putInt(MY_SETTINGS_KEY_IDX, idx);

        Log.d(TAG, "doState_persist(): ["+MATE_COLLECTION+", "+idx+"]");

        editor.apply();  // commit in an async way
    }


    public  void doState_recover(AppCompatActivity activity) {

        Log.d(TAG, "doState_recover()");

        SharedPreferences mySettings = activity.getSharedPreferences(MY_SETTINGS_NAME, Context.MODE_PRIVATE);

        String SAVED_COLLECTION = mySettings.getString(MY_SETTINGS_KEY_COLLECTION, ChessModules.KEY_MATE_1_COLLECTION);
        int    SAVED_IDX        = mySettings.getInt(MY_SETTINGS_KEY_IDX, 0);

        Log.d(TAG, "doState_recover(): ["+SAVED_COLLECTION+", "+SAVED_IDX+"]");

        doInit(activity, SAVED_COLLECTION, SAVED_IDX);
    }


    /**
     * desde el onCreate onResume, toma los valores default o de la calse
     * o de las shared preferences si fueron llamadas previamente.
     *
     * click desde el punto de menu
     **/
    public void doInit(AppCompatActivity activity, String MATE_COLLECTION_SELECTED, int SAVED_IDX) {

        // puntero
        MATE_COLLECTION = MATE_COLLECTION_SELECTED;
        idx = SAVED_IDX;

        doInit_ChessLab(activity);

    }

    public void doInit_Training(AppCompatActivity activity, String MATE_COLLECTION_SELECTED, int SAVED_IDX) {

        // puntero
        MATE_COLLECTION = MATE_COLLECTION_SELECTED;
        idx = SAVED_IDX;

        // Setup
        ChessTrainer trainerModulo = (ChessTrainer) ChessTrainer.getInstance(ChessModules.KEY_TRAIN_01_COLLECTION);

        doInit_ChessLab(activity);

    }



    private void doInit_ChessLab(AppCompatActivity activity) {


        mainContent = new MainContentSingleton.MainContent(activity);




        Drawable thumb = getImageCollection();
        mainContent.getSeekBar().setThumb(thumb);
        mainContent.getSeekBar().setProgress(idx);
        mainContent.getSeekBar().setMax(ChessModules.getMAX_Mate(MATE_COLLECTION));


        Resources resources = mainContent.getActivity().getResources();

        mainContent.getTextViewLeft().setText(ChessModules.getTextCollectionName(resources, MATE_COLLECTION));
        mainContent.getTextView().setText(getTextProgressBar(MATE_COLLECTION, idx));



        //Al final parece que no lo uso ...
        mainContent.getChessSolution().setText("");


        // listener

        mainContent.getSeekBar().setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = idx;


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Toast.makeText(getApplicationContext(), "Started tracking SeekBar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;

                // Cambio el problema mientras se desliza la SeekBar
                mainContent.getTextView().setText("[ " + progress + "/" + seekBar.getMax() + " ]");
                idx = progresValue;
                navigate();
            }


            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                // Cambio el problema cuando se suelta la seekBar
                mainContent.getTextView().setText("[ " + progress + "/" + seekBar.getMax() + " ]");
                idx = progress;
                navigate();

            }
        });


        if (esTraining()) {

            // final
            final AppCompatActivity finalActivity = activity;


            switchTrainigMode(true);

            // Edit text
            EditText editText = mainContent.getUserSolution();


            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                    // TODO Auto-generated method stub
                }

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    // TODO Auto-generated method stub
                }

                @Override
                public void afterTextChanged(Editable s) {

                    String userSolution = s.toString();
                    Log.d(TAG, "TRAIN user[Problem "+idx+"]:"  + userSolution);

                    ChessTrainer.addUserSolution(idx, userSolution);

                }
            });


            // Listeners

            mainContent.getSendMailSolution().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    // Envio mail
                    ChessTrainer.enviarEmail(finalActivity);
                }
            });


        } else {

            switchTrainigMode(false);

            // Listeners

            mainContent.getButtonSolution().setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    String chessSolution = ChessSolutions.getSolution(getImageName());

                    Snackbar.make(view, chessSolution, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });

        }

        // init;
        // firstProblem();

        goToProblem(MATE_COLLECTION, idx);

    }



    /**
     * Switch traing mode ON y OFF
     * Train Mode OFF: User only watch the solution when press the question icon.
     * Train Mode ON:  User write the solution and the user can send a mail to chesslab
     */
    private void switchTrainigMode(boolean trainMode) {

        Log.d(TAG, "switchTrainigMode(...)");

        if (trainMode) {

            // Training Mode ON:
            mainContent.getUserSolution().setVisibility(View.VISIBLE);
            mainContent.getSendMailSolution().setVisibility(View.VISIBLE);
            mainContent.getButtonSolution().setVisibility(View.GONE);

        } else {

            // Training Mode OFF:
            mainContent.getUserSolution().setVisibility(View.GONE);
            mainContent.getSendMailSolution().setVisibility(View.GONE);
            mainContent.getButtonSolution().setVisibility(View.VISIBLE);

        }

    }


    //--[Navigate] ----------------------------------------------------------

    private void goToProblem(String CUSTOM_MATE_COLLECTION, int custom_idx) {

        Log.d(TAG, "goToProblem("+CUSTOM_MATE_COLLECTION+", "+custom_idx+") ");

        // puntero =
        MATE_COLLECTION = CUSTOM_MATE_COLLECTION;
        idx = custom_idx;

        navigate();
    }

    public void firstProblem() {

        Log.d(TAG, "firstProblem("+MATE_COLLECTION+"): " + idx);

        idx = 0;
        navigate();
    }

    public void lastProblem() {

        Log.d(TAG, "lastProblem("+MATE_COLLECTION+"): " + idx);

        idx = ChessModules.getMAX_Mate(MATE_COLLECTION);
        navigate();
    }

    public void prevProblem() {

        Log.d(TAG, "prevProblem("+MATE_COLLECTION+"): " + idx);

        if (idx > 0) {
            idx--;
        }

        navigate();
    }

    public void nextProblem() {

        Log.d(TAG, "nextProblem("+MATE_COLLECTION+"): " + idx);

        if (hayNextProblem()) {
            idx++;
        }

        navigate();
    }

    private boolean hayNextProblem() {

        boolean hayNext = (idx < ChessModules.getMAX_Mate(MATE_COLLECTION));

        return hayNext;
    }


    /**
     * Si hay next problem, lo muestra
     * Si es el ultimo problem: sube de nivel
     * Si es el ultimo probleme del ultimo nive ... Toast
     */
    public void superNextProblem_old() {
        showAvisoDialog();
    }

    public void superNextProblem() {

        Log.d(TAG, "superNextProblem("+MATE_COLLECTION+"): " + idx);


        if (hayNextProblem()) {
            nextProblem();
            return;
        }

        if (hayNext_MATE_COLLECTION()) {

            String NEXT_MATE_COLLECTION = getNext_MATE_COLLECTION();

            MainContentSingleton.getInstance().doInit(mainContent.getActivity(), NEXT_MATE_COLLECTION, 0);

            showAvisoDialog();
            return;
        }

        Resources resources = mainContent.getActivity().getResources();

        // TOAST: LLego al final ...
        // showAviso("LLego al Final");
        showAvisoDialog("", i18n(resources, R.string.txt_finish), getImageFromId(R.drawable.pieza05_caballo), THEME_STYLE_GREEN);

        Log.d(TAG, "LLEGO AL FINAL");
        return;
    }


        /*
     * Pensando en el futuro
     * */

    private static String i18n(Resources resources, int id) {


        String texto = resources.getString(id);

        return texto;
    }


    private void navigate() {

        Log.d(TAG, "navigate("+MATE_COLLECTION+"): " + idx);

        mainContent.getSeekBar().setProgress(idx);
        setImageResource(MATE_COLLECTION, idx);
    }



    //--[Utiles] ----------------------------------------------------------

    private void setImageResource(String MATE_COLLECTION, int idx)
    {

        String imagename = ChessModules.getImageName(MATE_COLLECTION, idx);

        int res = mainContent.getActivity().getResources().getIdentifier(imagename, "drawable",
                mainContent.getActivity().getPackageName());

        mainContent.getImage().setImageResource(res);

    }


    private String getTextProgressBar(String MATE_COLLECTION, int idx) {

        // String res = i18n("Ejercicio: ") + "0"+ "/" + this.mainContent.getSeekBar().getMax();
        String res =  "[ " + idx+ "/" + this.mainContent.getSeekBar().getMax() + " ]";

        return res;

    }


    private String getTextCollectionName() {

        Resources resources = mainContent.getActivity().getResources();

        return ChessModules.getTextCollectionName(resources, MATE_COLLECTION);
    }



    private String getImageName() {

        return ChessModules.getImageName(MATE_COLLECTION, idx);
    }



    /**
     * Retorna la coleccion siguiente.
     * Si es la última, se retona a si misma
     * Si no se identifica, retorna la primera
     * */
    private String getNext_MATE_COLLECTION() {

        Log.d(TAG, "getNext_MATE_COLLECTION("+MATE_COLLECTION+") ");

        if (MATE_COLLECTION.equals(ChessModules.KEY_MATE_1_COLLECTION)) {
            return ChessModules.KEY_MATE_2_COLLECTION;
        }

        if (MATE_COLLECTION.equals(ChessModules.KEY_MATE_2_COLLECTION)) {
            return ChessModules.KEY_MATE_3_COLLECTION;
        }

        if (MATE_COLLECTION.equals(ChessModules.KEY_MATE_3_COLLECTION)) {
            return ChessModules.KEY_MATE_4_COLLECTION;
        }

        if (MATE_COLLECTION.equals(ChessModules.KEY_MATE_4_COLLECTION)) {
            return ChessModules.KEY_MATE_4_COLLECTION;
        }

        if (MATE_COLLECTION.equals(ChessModules.KEY_TRAIN_01_COLLECTION)) {
            return ChessModules.KEY_TRAIN_01_COLLECTION;
        }

        return ChessModules.KEY_MATE_1_COLLECTION;
    }


    /*
    * Indica si es la última coleccion de problemas.
    * */
    private boolean hayNext_MATE_COLLECTION() {

        return (MATE_COLLECTION != getNext_MATE_COLLECTION());

    }




    private Drawable getImageCollection() {

        return getImageCollection(true);
    }

    private Drawable getImageCollection(boolean small) {


        int r_draw = R.drawable.seekbar_24_peon;


        if (MATE_COLLECTION.equals(ChessModules.KEY_MATE_1_COLLECTION)) {
            r_draw = (small)
                    ? R.drawable.seekbar_24_peon
                    : R.drawable.pieza06_peon;
        }

        if (MATE_COLLECTION.equals(ChessModules.KEY_MATE_2_COLLECTION)) {
            r_draw = (small)
                    ? R.drawable.seekbar_32_torre
                    : R.drawable.pieza03_torre;
        }

        if (MATE_COLLECTION.equals(ChessModules.KEY_MATE_3_COLLECTION)) {
            r_draw = (small)
                    ? R.drawable.seekbar_34_dama
                    : R.drawable.pieza02_dama;

        }

        if (MATE_COLLECTION.equals(ChessModules.KEY_MATE_4_COLLECTION)) {
            r_draw = (small)
                    ? R.drawable.seekbar_36_rey
                    : R.drawable.pieza01_rey;
        }

        if (MATE_COLLECTION.equals(ChessModules.KEY_TRAIN_01_COLLECTION)) {
            r_draw = (small)
                    ? R.drawable.seekbar_36_rey
                    : R.drawable.pieza01_rey;
        }

        Drawable thumb = mainContent.getActivity().getResources().getDrawable(r_draw);

        return thumb;
    }


    private Drawable getImageFromId(int r_draw) {

        Drawable thumb = mainContent.getActivity().getResources().getDrawable(r_draw);

        return thumb;
    }





    /**
     * Esta es una absraccion para mostrar mensajes
     * @param message
     */
    private void showAviso(String message) {

        Toast toast = Toast.makeText(mainContent.getActivity(), message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }

    private void showAvisoDialog() {

        showAvisoDialog("", getTextCollectionName(), getImageCollection(false), THEME_STYLE_INDIGO);
    }

    private void showAvisoDialog(String titulo, String message, Drawable image, String THEME_STYLE) {

        Activity context = mainContent.getActivity();


        // custom dialog
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.gchess_a001_aviso);


        // image
        ImageView di = (ImageView) dialog.findViewById(R.id.gchess_a001_img);
        di.setImageDrawable(image);

        di.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


        // text
        TextView tv = (TextView) dialog.findViewById(R.id.gchess_a001_txt);
        tv.setText(message);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


        // Layout Text
        if (THEME_STYLE_GREEN.equals(THEME_STYLE)) {
            LinearLayout ll = (LinearLayout) dialog.findViewById(R.id.gchess_a001_txt_layout);
            ll.setBackgroundColor(context.getResources().getColor(R.color.green_color_500));
            tv.setTextColor(context.getResources().getColor(R.color.colorPrimaryText));
        }
        // show
        dialog.show();

    }


    private void showAvisoDialogOLD(String titulo, String message) {

        Activity context = mainContent.getActivity();

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        // set title
        alertDialogBuilder.setTitle(titulo);

        // set dialog message
        alertDialogBuilder
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton("DONE",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, close
                        // current activity
                        // MainActivity.this.finish();
                    }
                })
        ;

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }




    /**
     *
     * @return true en Training Mpde
     */
    private boolean esTraining() {

        if (MATE_COLLECTION.equals(ChessModules.KEY_TRAIN_01_COLLECTION)) {
            return true;
        }

        return false;
    }




}


