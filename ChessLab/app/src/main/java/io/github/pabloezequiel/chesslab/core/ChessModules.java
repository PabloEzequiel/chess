package io.github.pabloezequiel.chesslab.core;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;

import io.github.pabloezequiel.chesslab.R;

/**
 * Created by Pablo Ezequiel on 29/7/16.
 * <p>
 * ProbarNoCuestaNada.com
 * <p>
 * https://github.com/PabloEzequiel
 * https://javaen.blogspot.com
 */
public class ChessModules {

    public static String KEY_MATE_1_COLLECTION = "KEY_MATE_1_COLLECTION";
    public static String KEY_MATE_2_COLLECTION = "KEY_MATE_2_COLLECTION";
    public static String KEY_MATE_3_COLLECTION = "KEY_MATE_3_COLLECTION";
    public static String KEY_MATE_4_COLLECTION = "KEY_MATE_4_COLLECTION";

    public static String KEY_TRAIN_01_COLLECTION = "KEY_TRAIN_01_COLLECTION";

    public static int MAX_MateEn1 = 8;    // Numeros de "00000" a "00008";
    public static int MAX_MateEn2 = 11;   // Numeros de "00000" a "00011";
    public static int MAX_MateEn3 = 16;   // Numeros de "00000" a "00016";
    public static int MAX_MateEn4 = 15;   // Numeros de "00000" a "00015";

    public static int MAX_Train_01 =17;   // Numeros de "00000" a "00017";   // chess_train_001_00003.png


    public static String getTextCollectionName(Resources resources, String MATE_COLLECTION) {


        if (MATE_COLLECTION.equals(ChessModules.KEY_MATE_1_COLLECTION)) {
            return i18n(resources, R.string.menu_mate_en_1);
        }

        if (MATE_COLLECTION.equals(ChessModules.KEY_MATE_2_COLLECTION)) {
            return i18n(resources, R.string.menu_mate_en_2);
        }

        if (MATE_COLLECTION.equals(ChessModules.KEY_MATE_3_COLLECTION)) {
            return i18n(resources, R.string.menu_mate_en_3);
        }

        if (MATE_COLLECTION.equals(ChessModules.KEY_MATE_4_COLLECTION)) {
            return i18n(resources, R.string.menu_mate_en_4);
        }

        return "";

    }


    /*
     * Pensando en el futuro
     * */

    private static String i18n(Resources resources, int id) {

        String texto = resources.getString(id);

        return texto;
    }


    public static String getImageName(String MATE_COLLECTION, int idx) {

        String sidx = String.format("%05d", idx);

        if (MATE_COLLECTION.equals(ChessModules.KEY_MATE_1_COLLECTION)) {
            return "chess_mate1_" + sidx;
        }

        if (MATE_COLLECTION.equals(ChessModules.KEY_MATE_2_COLLECTION)) {
            return "chess_mate2_" + sidx;
        }

        if (MATE_COLLECTION.equals(ChessModules.KEY_MATE_3_COLLECTION)) {
            return "chess_mate3_" + sidx;
        }

        if (MATE_COLLECTION.equals(ChessModules.KEY_MATE_4_COLLECTION)) {
            return "chess_mate4_" + sidx;
        }

        if (MATE_COLLECTION.equals(ChessModules.KEY_TRAIN_01_COLLECTION)) {
            return "chess_train_001_" + sidx;
        }

        return "chess_mate1_" + sidx;
    }


    /*
     *
     * */
    public static int getMAX_Mate(String MATE_COLLECTION) {

        if (MATE_COLLECTION.equals(ChessModules.KEY_MATE_1_COLLECTION)) {
            return ChessModules.MAX_MateEn1;
        }

        if (MATE_COLLECTION.equals(ChessModules.KEY_MATE_2_COLLECTION)) {
            return ChessModules.MAX_MateEn2;
        }

        if (MATE_COLLECTION.equals(ChessModules.KEY_MATE_3_COLLECTION)) {
            return ChessModules.MAX_MateEn3 ;
        }

        if (MATE_COLLECTION.equals(ChessModules.KEY_MATE_4_COLLECTION)) {
            return ChessModules.MAX_MateEn4;
        }

        if (MATE_COLLECTION.equals(ChessModules.KEY_TRAIN_01_COLLECTION)) {
            return ChessModules.MAX_Train_01;
        }

        return ChessModules.MAX_MateEn1;

    }

}
