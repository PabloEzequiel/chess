package io.github.pabloezequiel.chesslab.store;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import io.github.pabloezequiel.chesslab.R;
import io.github.pabloezequiel.chesslab.core.Util;

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

        // Image
        int r_draw = item.getIdDrawable();
        Drawable thumb = imagenChessPack.getContext().getResources().getDrawable(r_draw);

        imagenChessPack.setImageDrawable(thumb);


        // Primary and Secondary Text
        Resources resources = imagenChessPack.getContext().getResources();

        String packName = Util.getTextCollectionName(resources, item.getChessPackID());
        String level    =  Util.getLevelString(resources, item.getLevel());

        nombreChessPack.setText(packName);
        descrChessPack.setText(level);

        return view;
    }


}


