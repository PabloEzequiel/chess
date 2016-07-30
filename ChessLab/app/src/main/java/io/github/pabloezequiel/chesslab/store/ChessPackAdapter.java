package io.github.pabloezequiel.chesslab.store;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import io.github.pabloezequiel.chesslab.R;

/**
 * Created by Pablo Ezequiel on 29/7/16.
 * <p>
 * ProbarNoCuestaNada.com
 * <p>
 * https://github.com/PabloEzequiel
 * https://javaen.blogspot.com
 * 
 *
 * {@link BaseAdapter} para poblar ChessPacks en un grid view
 *
 */
public class ChessPackAdapter  extends BaseAdapter {
    
    private Context context;

    public ChessPackAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return ChessPack.ITEMS.length;
    }

    @Override
    public ChessPack getItem(int position) {
        return ChessPack.ITEMS[position];
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.gchess_a003_store_item, viewGroup, false);
        }


        ImageView imagenChessPack = (ImageView) view.findViewById(R.id.imagen_chess_pack);
        TextView  nombreChessPack = (TextView) view.findViewById(R.id.nombre_chess_pack);
        TextView  descrChessPack  = (TextView) view.findViewById(R.id.nombre_chess_pack_down);

        final ChessPack item = getItem(position);

        int r_draw = item.getIdDrawable();
        Drawable thumb = imagenChessPack.getContext().getResources().getDrawable(r_draw);

        imagenChessPack.setImageDrawable(thumb);


        // Primary Text
        nombreChessPack.setText(item.getNombre());

        // Secondary Text to Level
        int levelId = getLevelId(item.getLevel());

        String level = imagenChessPack.getContext().getResources().getString(levelId);

        descrChessPack.setText(level);

        return view;
    }

    /**
     * Levels
     */
    private int getLevelId(String level) {

        if (ChessPack.LEVEL_ELEMENTARY.equals(level)) {
            return R.string.level_nivel_01;
        }

        if (ChessPack.LEVEL_INTERMEDIATE.equals(level)) {
            return R.string.level_nivel_05;
        }

        if (ChessPack.LEVEL_ADVANCED.equals(level)) {
            return R.string.level_nivel_10;
        }

        return R.string.level_nivel_01;
    }

}