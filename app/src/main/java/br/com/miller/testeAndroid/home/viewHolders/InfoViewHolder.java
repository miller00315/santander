package br.com.miller.testeAndroid.home.viewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.com.miller.testeAndroid.R;

public class InfoViewHolder extends RecyclerView.ViewHolder {

    private TextView info_title;
    private TextView info_content;

    public InfoViewHolder(@NonNull View itemView) {
        super(itemView);

        info_title = itemView.findViewById(R.id.info_title);
        info_content = itemView.findViewById(R.id.info_content);
    }

    public TextView getInfo_title() {
        return info_title;
    }

    public TextView getInfo_content() {
        return info_content;
    }
}
