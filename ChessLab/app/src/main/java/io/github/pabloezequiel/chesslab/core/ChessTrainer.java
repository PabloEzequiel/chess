package io.github.pabloezequiel.chesslab.core;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Pablo Ezequiel on 28/7/16.
 * <p>
 * ProbarNoCuestaNada.com
 * <p>
 * https://github.com/PabloEzequiel
 * https://javaen.blogspot.com
 */
public class ChessTrainer {


    public static String TAG = ChessTrainer.class.getSimpleName();

    private Map<String, String> userSolutions;

    private Module module;

    private String KEY_COLLECTION;

    private static ChessTrainer instance;


    /**
     * @return getInstance()
     */
    private static ChessTrainer getInstance() {

        return getInstance(ChessModules.KEY_TRAIN_01_COLLECTION);   // Default Train Coll
    }

    public static ChessTrainer getInstance(String KEY_COLLECTION) {

        if( instance == null ) {

            instance  = new ChessTrainer(KEY_COLLECTION);

        }

        return instance;
    }


    private ChessTrainer (String KEY_COLLECTION) {

        this.KEY_COLLECTION = KEY_COLLECTION;

        this.userSolutions  = new HashMap<String, String>();

        this.module  = new Module();

        init();
    }

    /**
     * I do some initialization to clean the collection
     */
    private void init() {

        for (int i=0; i<module.getSizeCollection(); i++) {

            String key = getKeyName(this.KEY_COLLECTION, i);
            this.userSolutions.put(key, "-");
        }
    }

    public Map<String, String> getUserSolutions() {

        return userSolutions;
    }

    public Module getModule() {

        return module;
    }


    /**
     * Modulo
     **/
    class Module {


        private String name;
        private int    sizeCollection;

        private String mailSubject;

        public Module() {


            this.name = KEY_COLLECTION;

            this.sizeCollection = ChessModules.getMAX_Mate(KEY_COLLECTION);
        }


        public int getSizeCollection() {
            return sizeCollection;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMailSubject() {
            return mailSubject;
        }

        public void setMailSubject(String mailSubject) {
            this.mailSubject = mailSubject;
        }

        @Override
        public String toString() {
            return "ChessTrainerModule{" +
                    "name='" + name + '\'' +
                    ", mailSubject='" + mailSubject + '\'' +
                    '}';
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }
    }

    /**
     * @param problema_nro
     * @param problema_solution
     */
    public static void addUserSolution(int problema_nro, String problema_solution) {

        Map<String, String> userSolutions = ChessTrainer.getInstance().getUserSolutions();

        String key = "PROBLEM_NRO_" + problema_nro;

        userSolutions.put(key, problema_solution);
    }

    /**
     * @param problema_nro
     * @return
     */
    public static String getUserSolution(int problema_nro) {

        Map<String, String> userSolutions = ChessTrainer.getInstance().getUserSolutions();

        String key = "PROBLEM_NRO_" + problema_nro;

        String user_solution = (String)userSolutions.get(key);

        return user_solution;
    }

    /**
     * Texto del Mail con todas las soluciones ingresadas por los usuarios
     */
    public static String getMail_UserSolution() {

        Log.d(TAG, "Texto del Mail");

        Map<String, String>  userSolutions = ChessTrainer.getInstance().getUserSolutions();

        String texto_mail = "";

        Module module = ChessTrainer.getInstance().getModule();

        for (int i=0; i< module.getSizeCollection(); i++) {

            String key   = getKeyName(module.getName(), i);
            String value = (String) userSolutions.get(key);

            texto_mail += "\n" + key + ": " + value;
        }

        /*
        for (Map.Entry<String, String> entry : userSolutions.entrySet()) {

            String key   = entry.getKey();
            Object value = entry.getValue();

            texto_mail += "\n" + key + ": " + value;

        }
        */

        Log.d(TAG, "Texto del Mail: " + texto_mail);

        return texto_mail;
    }


    /**
     * @param activity
     */
    public static void enviarEmail(AppCompatActivity activity){

        //Instanciamos un Intent del tipo ACTION_SEND
        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        //Definimos la tipologia de datos del contenido dle Email en este caso text/html
        emailIntent.setType("text/html");
        // Indicamos con un Array de tipo String las direcciones de correo a las cuales enviar
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"chesslab.mobile@gmail.com"});
        // Definimos un titulo para el Email
        emailIntent.putExtra(android.content.Intent.EXTRA_TITLE, "El Titulo");
        // Definimos un Asunto para el Email
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "El Asunto");


        // Obtenemos la referencia al texto y lo pasamos al Email Intent
        // emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, activity.getString(R.string.chess_txt_mail));

        String texto_mail = io.github.pabloezequiel.chesslab.core.ChessTrainer.getMail_UserSolution();

        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Texto extra para el mail ..." +texto_mail);


        try {
            //Enviamos el Correo iniciando una nueva Activity con el emailIntent.
            activity.startActivity(Intent.createChooser(emailIntent, "Enviar E-mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(activity, "No hay ningun cliente de correo instalado.", Toast.LENGTH_SHORT).show();
        }
    }


    private static String getKeyName(String MATE_COLLECTION, int idx) {

        String sidx = String.format("%02d", idx);


        if (MATE_COLLECTION.equals(ChessModules.KEY_TRAIN_01_COLLECTION)) {
            return "Problem " + sidx + ":";
        }

        return "Problem " + sidx;
    }

}
