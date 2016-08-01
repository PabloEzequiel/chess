package io.github.pabloezequiel.chesslab.core;

import android.content.res.Resources;

import io.github.pabloezequiel.chesslab.R;
import io.github.pabloezequiel.chesslab.store.Const;

/**
 * Created by Pablo Ezequiel on 31/7/16.
 * <p/>
 * ProbarNoCuestaNada.com
 * <p/>
 * https://github.com/PabloEzequiel
 * https://javaen.blogspot.com
 */
public class Util {


    /*
    private Resources resources;

    private Util getInstace() {

        if (resources == null) {
            this.resources = new Resources();
        }
    }
    */


    /**
     * Levels
     */
    public static String  getLevelString(Resources resources, String cLevel) {

        int levelId =  getLevelId(cLevel);

        return resources.getString(levelId);
    }


    private static int getLevelId(String cLevel) {

        if (Const.LEVEL_ELEMENTARY.equals(cLevel)) {
            return R.string.level_nivel_01;
        }

        if (Const.LEVEL_INTERMEDIATE.equals(cLevel)) {
            return R.string.level_nivel_05;
        }

        if (Const.LEVEL_ADVANCED.equals(cLevel)) {
            return R.string.level_nivel_10;
        }

        return R.string.level_nivel_01;
    }


    /**
     * Collection Name
     */
    public static String getTextCollectionName(Resources resources, String MATE_COLLECTION) {

        if (MATE_COLLECTION.equals(Const.KEY_PACK_G001_001)) {
            return resources.getString(R.string.menu_mate_en_1);
        }

        if (MATE_COLLECTION.equals(Const.KEY_PACK_G001_002)) {
            return resources.getString(R.string.menu_mate_en_2);
        }

        if (MATE_COLLECTION.equals(Const.KEY_PACK_G001_003)) {
            return resources.getString(R.string.menu_mate_en_3);
        }

        if (MATE_COLLECTION.equals(Const.KEY_PACK_G001_004)) {
            return resources.getString(R.string.menu_mate_en_4);
        }

        if (MATE_COLLECTION.equals(Const.KEY_PACK_G002_001)) {
            return resources.getString(R.string.menu_train_001);
        }

        if (MATE_COLLECTION.equals(Const.KEY_PACK_G002_002)) {
            return resources.getString(R.string.menu_train_002);
        }

        if (MATE_COLLECTION.equals(Const.KEY_PACK_G002_003)) {
            return resources.getString(R.string.menu_train_003);
        }

        if (MATE_COLLECTION.equals(Const.KEY_PACK_G002_004)) {
            return resources.getString(R.string.menu_train_004);
        }

        return "";

    }




}