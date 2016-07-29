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

            String key = module.getKeyToHashMap(i);
            this.userSolutions.put(key, "");
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


        private String name;              // Module name: Example ChessModules.KEY_TRAIN_01_COLLECTION = "KEY_TRAIN_01_COLLECTION";
          // This is the Key in The HashMap Example "PROBLEM_TRAN_01_NRO_0000"

        private int    sizeCollection;

        private String mailSubject;

        public Module() {


            this.name      = KEY_COLLECTION;

            this.sizeCollection = ChessModules.getMAX_Mate(KEY_COLLECTION);
        }


        /**
         * Example  ChessModules.KEY_TRAIN_01_COLLECTION = "KEY_TRAIN_01_COLLECTION" + _  "00001";
         *
         * @param idx
         * @return
         */
        public String getKeyToHashMap(int idx) {

            String sidx = String.format("%05d", idx);

            String keyName = getName() + "_" + sidx;

            return keyName;
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


        /**
         * Numero de Problema para el mail
         */
        public String getProblemName(int idx) {

            String sidx = String.format("%02d", idx);

            return "Problema #" + sidx + ": ";
        }


        public String getMailSubject() {
            return mailSubject;
        }

        public void setMailSubject(String mailSubject) {
            this.mailSubject = mailSubject;
        }

        @Override
        public String toString() {
            return "Module{" +
                    "name='" + name + '\'' +
                    ", sizeCollection=" + sizeCollection +
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

        ChessTrainer instance = ChessTrainer.getInstance();

        addUserSolution(instance, problema_nro,  problema_solution);
    }

    public static void addUserSolution(String KEY_COLLECTION, int problema_nro, String problema_solution) {

        ChessTrainer instance = ChessTrainer.getInstance(KEY_COLLECTION);

        addUserSolution(instance, problema_nro,  problema_solution);
    }

    private static void addUserSolution(ChessTrainer instance, int problema_nro, String problema_solution) {

        Map<String, String> userSolutions =instance.getUserSolutions();

        String key = instance.getModule().getKeyToHashMap(problema_nro);

        Log.d(TAG, "addUserSolution(key="+key+", "+problema_nro+", "+problema_solution+")");

        userSolutions.put(key, problema_solution);


        // Loggin
        getMail_UserSolution(); // logg
    }

    /**
     * @param problema_nro
     * @return
     */
    public static String getUserSolution(int problema_nro) {

        ChessTrainer instance = ChessTrainer.getInstance();

        return getUserSolution(instance, problema_nro);
    }

    public static String getUserSolution(String KEY_COLLECTION, int problema_nro) {

        ChessTrainer instance = ChessTrainer.getInstance(KEY_COLLECTION);

        return getUserSolution(instance, problema_nro);
    }

    private static String getUserSolution(ChessTrainer instance, int problema_nro) {

        Map<String, String> userSolutions = instance.getUserSolutions();

        String key = ChessTrainer.getInstance().getModule().getKeyToHashMap(problema_nro);

        String user_solution = (String)userSolutions.get(key);

        return user_solution;
    }

    /**
     * Texto del Mail con todas las soluciones ingresadas por los usuarios
     */
    public static String getMail_UserSolution() {

        Map<String, String>  userSolutions = ChessTrainer.getInstance().getUserSolutions();

        String texto_mail = "";

        Module module = ChessTrainer.getInstance().getModule();

        for (int i=0; i< module.getSizeCollection(); i++) {

            String keyName = module.getKeyToHashMap(i);
            String value = (String) userSolutions.get(keyName);


            String problem =  (String) module.getProblemName(i);

            if ("".equals(value.trim())) {
                value = "-";
            }

            texto_mail += "\n" + problem + ": " + value;
        }

        // Log.d(TAG, "Texto del Mail: " + texto_mail);

        return texto_mail;
    }


    /**
     * @param activity
     */
    public static void enviarEmail(AppCompatActivity activity){

        String mail   = "chesslab.mobile@gmail.com";
        String titulo =  "El Titulo";

        String asunto =  "Chess Lab: Módulo de Entramiento 01";
        String texto_mail = "Sus respuestas a los ejercicios: \n\n" +ChessTrainer.getMail_UserSolution();


        //Instanciamos un Intent del tipo ACTION_SEND
        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        //Definimos la tipologia de datos del contenido dle Email en este caso text/html
        emailIntent.setType("text/html");
        // Indicamos con un Array de tipo String las direcciones de correo a las cuales enviar
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ mail });
        // Definimos un titulo para el Email
        emailIntent.putExtra(android.content.Intent.EXTRA_TITLE, titulo);
        // Definimos un Asunto para el Email
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, asunto);


        // Obtenemos la referencia al texto y lo pasamos al Email Intent
        // emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, activity.getString(R.string.chess_txt_mail));

        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, texto_mail);


        try {
            //Enviamos el Correo iniciando una nueva Activity con el emailIntent.
            activity.startActivity(Intent.createChooser(emailIntent, "Enviar E-mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(activity, "No hay ningun cliente de correo instalado.", Toast.LENGTH_SHORT).show();
        }
    }




}
