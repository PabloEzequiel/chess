package io.github.pabloezequiel.chesslab.store;

import java.util.HashMap;
import java.util.Map;

import io.github.pabloezequiel.chesslab.R;

/**
 * Created by Pablo Ezequiel on 29/7/16.
 * <p>
 * ProbarNoCuestaNada.com
 * <p>
 * https://github.com/PabloEzequiel
 * https://javaen.blogspot.com
 */
public class ChessPack {

    protected static String LEVEL_ELEMENTARY   = "01";
    protected static String LEVEL_INTERMEDIATE = "05";
    protected static String LEVEL_ADVANCED     = "10";

    private String chessPackID;    // Unique Chess Pack ID

    private String nombre;
    private String level;
    private int  size;
    private int idDrawable;
    private int idDrawable_thumb;

    private String image_prefix;


    public ChessPack(String chessPackID,
                               int size,
                           String nombre,
                          int idDrawable,
                          int idDrawable_thumb,
                          String image_prefix,
                          String level) {

        this.chessPackID = chessPackID;
        this.size = size;
        this.nombre = nombre;
        this.idDrawable = idDrawable;
        this.idDrawable_thumb = idDrawable_thumb;
        this.image_prefix = image_prefix;
        this.level = level;
    }

    public String getChessPackID() {
        return chessPackID;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdDrawable_thumb() {
        return idDrawable_thumb;
    }

    public int getIdDrawable() {
        return idDrawable;
    }

    public String getLevel() {
        return level;
    }

    /**
     * Ejemplo  "chess_mate1_" + sidx;
     * @param idx
     * @return
     */
    public String getImageName(int idx) {

        String sidx = String.format("%05d", idx);

        return this.image_prefix + sidx;
    }

    public int getSize() {
        return size;
    }


    public int getId() {
        return nombre.hashCode() + chessPackID.hashCode();
    }


    public boolean esTrainingMode() {

        if (Const.KEY_PACK_G002_001.equals(this.getChessPackID())) {
            return true;
        }

        return false;
    }

    public static ChessPack[] ITEMS = {


            ChessPack.getInstance(Const.KEY_PACK_G002_001),
        ChessPack.getInstance(Const.KEY_PACK_G001_001),
        ChessPack.getInstance(Const.KEY_PACK_G001_002),
        ChessPack.getInstance(Const.KEY_PACK_G001_003),
        ChessPack.getInstance(Const.KEY_PACK_G001_004),



    };

    @Override
    public String toString() {
        return "ChessPack{" +
                "chessPackID='" + chessPackID + '\'' +
                ", nombre='" + nombre + '\'' +
                ", level='" + level + '\'' +
                ", size=" + size +
                ", idDrawable=" + idDrawable +
                ", idDrawable_thumb=" + idDrawable_thumb +
                ", esTrainingMode=" + esTrainingMode() +
                '}';
    }

    /**
     * Obtiene item basado en su identificador
     *
     * @param id identificador
     * @return ChessPack
     */
    public static ChessPack getItem(int id) {
        for (ChessPack item : ITEMS) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }



    //---- Singleton & Builder

    // ChessPack chessPack = ChessPack.getInstance(Const.KEY_PACK_G001_002);

    private static Map<String, ChessPack> chessPackMap;

    /**
     * Retorna a Chess Pack a partir de su id de Packete.
     * @return
     */
    public static ChessPack getInstance(String chessPackID) {

        ChessPack chessPack;

        if (chessPackMap == null) {
            chessPackMap = new HashMap<String, ChessPack>();
        }

        if (chessPackMap.get(chessPackID) == null) {

             chessPack =  ChessPack.build(chessPackID);
             chessPackMap.put(chessPackID, chessPack);
        }

        chessPack = chessPackMap.get(chessPackID);

        return  chessPack;
    }


    private static ChessPack build (String chessPackID) {

        ChessPack chessPack;

        if (Const.KEY_PACK_G001_001.equals(chessPackID)) {

            chessPack = new ChessPack(
                    Const.KEY_PACK_G001_001,
                    Const.KEY_PACK_G001_001_Size,
                    "Mates en #1",
                    R.mipmap.ic_store_peon,       //R.drawable.pieza06_h550_peon,
                    R.drawable.seekbar_24_peon,
                    "chess_mate1_",
                    LEVEL_ELEMENTARY);

            return chessPack;
        }

        if (Const.KEY_PACK_G001_002.equals(chessPackID)) {

            chessPack = new ChessPack(
                    Const.KEY_PACK_G001_002,
                    Const.KEY_PACK_G001_002_Size,
                    "Mates en #2",
                    R.mipmap.ic_store_torre,       // R.drawable.pieza03_h550_torre,
                    R.drawable.seekbar_32_torre,
                    "chess_mate2_",
                    LEVEL_INTERMEDIATE);

            return chessPack;
        }

        if (Const.KEY_PACK_G001_003.equals(chessPackID)) {

            chessPack = new ChessPack(
                    Const.KEY_PACK_G001_003,
                    Const.KEY_PACK_G001_003_Size,
                    "Mates en #3",
                    R.mipmap.ic_store_dama,       // R.drawable.pieza02_h550_dama,
                    R.drawable.seekbar_34_dama,
                    "chess_mate3_",
                    LEVEL_INTERMEDIATE);

            return chessPack;
        }

        if (Const.KEY_PACK_G001_004.equals(chessPackID)) {

            chessPack = new ChessPack(
                    Const.KEY_PACK_G001_004,
                    Const.KEY_PACK_G001_004_Size,
                    "Mates en #4",
                    R.mipmap.ic_store_rey,       //  R.drawable.pieza01_h550_rey,
                    R.drawable.seekbar_36_rey,
                    "chess_mate4_",
                    LEVEL_ADVANCED);

            return chessPack;
        }

        if (Const.KEY_PACK_G002_001.equals(chessPackID)) {

            chessPack = new ChessPack(
                    Const.KEY_PACK_G002_001,
                    Const.KEY_PACK_G002_001_Size,
                    "Training",
                    R.mipmap.ic_store_caballo,      //R.drawable.pieza05_h550_caballo,
                    R.drawable.seekbar_30_caballo,
                    "chess_train_001_",
                    LEVEL_ELEMENTARY);

            return chessPack;
        }

        // Antes de que de error, entrego el paquete default
        chessPack = new ChessPack(
                Const.KEY_PACK_G001_001,
                Const.KEY_PACK_G001_001_Size,
                "Mates en #1",
                R.mipmap.ic_store_peon, // R.drawable.pieza06_h550_peon,
                R.drawable.seekbar_24_peon,
                "chess_mate1_",
                LEVEL_ELEMENTARY);

        return chessPack;
    }



}

