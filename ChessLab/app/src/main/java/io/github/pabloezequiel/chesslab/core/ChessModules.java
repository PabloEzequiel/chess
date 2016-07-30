package io.github.pabloezequiel.chesslab.core;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;

import io.github.pabloezequiel.chesslab.R;
import io.github.pabloezequiel.chesslab.store.Const;

/**
 * Created by Pablo Ezequiel on 29/7/16.
 * <p>
 * ProbarNoCuestaNada.com
 * <p>
 * https://github.com/PabloEzequiel
 * https://javaen.blogspot.com
 */
public class ChessModules {

    /*
    public static String KEY_MATE_1_COLLECTION = "KEY_MATE_1_COLLECTION";
    public static String KEY_MATE_2_COLLECTION = "KEY_MATE_2_COLLECTION";
    public static String KEY_MATE_3_COLLECTION = "KEY_MATE_3_COLLECTION";
    public static String KEY_MATE_4_COLLECTION = "KEY_MATE_4_COLLECTION";

    public static String KEY_TRAIN_01_COLLECTION = "KEY_TRAIN_01_COLLECTION";
*/

    public static String getTextCollectionName(Resources resources, String MATE_COLLECTION) {


        if (MATE_COLLECTION.equals(Const.KEY_PACK_G001_001)) {
            return i18n(resources, R.string.menu_mate_en_1);
        }

        if (MATE_COLLECTION.equals(Const.KEY_PACK_G001_002)) {
            return i18n(resources, R.string.menu_mate_en_2);
        }

        if (MATE_COLLECTION.equals(Const.KEY_PACK_G001_003)) {
            return i18n(resources, R.string.menu_mate_en_3);
        }

        if (MATE_COLLECTION.equals(Const.KEY_PACK_G001_004)) {
            return i18n(resources, R.string.menu_mate_en_4);
        }

        if (MATE_COLLECTION.equals(Const.KEY_PACK_G002_001)) {
            return i18n(resources, R.string.menu_train_001);
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





}
