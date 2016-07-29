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

    private static String txt_soluciones = "Las soluciones son: ";

    private static Map<String, String> userSolutions;

    /**
     * @return getInstance()
     */
    public static Map getInstance() {

        if( userSolutions == null ) {

            userSolutions  = new HashMap<String, String>();
        }

        return userSolutions;
    }


    /**
     * @param problema_nro
     * @param problema_solution
     */
    public static void addUserSolution(int problema_nro, String problema_solution) {

        Map<String, String> solutions = io.github.pabloezequiel.chesslab.core.ChessTrainer.getInstance();

        String key = "PROBLEM_NRO_" + problema_nro;

        solutions.put(key, problema_solution);
    }

    /**
     * @param problema_nro
     * @return
     */
    public static String getUserSolution(int problema_nro) {

        Map<String, String> solutions = io.github.pabloezequiel.chesslab.core.ChessTrainer.getInstance();

        String key = "PROBLEM_NRO_" + problema_nro;

        String user_solution = (String)solutions.get(key);

        return user_solution;
    }

    /**
     * Texto del Mail con todas las soluciones ingresadas por los usuarios
     */
    public static String getMail_UserSolution() {

        Log.d(TAG, "Texto del Mail");

        Map<String, String>  solutions = io.github.pabloezequiel.chesslab.core.ChessTrainer.getInstance();

        String texto_mail = "";

        for (Map.Entry<String, String> entry : solutions.entrySet()) {

            String key   = entry.getKey();
            Object value = entry.getValue();

            texto_mail += "\n" + key + ": " + value;

        }

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


}
