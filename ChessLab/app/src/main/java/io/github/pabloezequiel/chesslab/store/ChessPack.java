package io.github.pabloezequiel.chesslab.store;

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

    private String nombre;
    private int idDrawable;

    public ChessPack(String nombre, int idDrawable) {
        this.nombre = nombre;
        this.idDrawable = idDrawable;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdDrawable() {
        return idDrawable;
    }

    public int getId() {
        return nombre.hashCode();
    }

    public static ChessPack[] ITEMS = {


        new ChessPack("Mates en #1", R.drawable.pieza_06_peon),
        new ChessPack("Mates en #2", R.drawable.pieza_03_torre),
        new ChessPack("Mates en #3", R.drawable.pieza_02_dama),
        new ChessPack("Mates en #4", R.drawable.pieza_01_rey),
        new ChessPack("Training",    R.drawable.pieza_05_caballo),

        new ChessPack("Mates en #1", R.drawable.pieza01_rey),
        new ChessPack("Mates en #2", R.drawable.pieza03_torre),
        new ChessPack("Mates en #3", R.drawable.pieza02_dama),
        new ChessPack("Mates en #4", R.drawable.pieza05_caballo),
    };

    /**
     * Obtiene item basado en su identificador
     *
     * @param id identificador
     * @return Coche
     */
    public static ChessPack getItem(int id) {
        for (ChessPack item : ITEMS) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}

