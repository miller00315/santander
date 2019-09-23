package br.com.miller.testeAndroid.home.adapters;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import br.com.miller.testeAndroid.R;
import br.com.miller.testeAndroid.home.viewHolders.InfoViewHolder;
import br.com.miller.testeAndroid.model.Infos;

public class InfoAdapter extends RecyclerView.Adapter<InfoViewHolder> {

    private ArrayList<Infos> dataSet;

    public InfoAdapter() {
        this.dataSet = new ArrayList<>();
    }

    @NonNull
    @Override
    public InfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View viewInfo = LayoutInflater.from(parent.getContext()).inflate(R.layout.invest_info, parent, false);

        return new InfoViewHolder(viewInfo);
    }

    @Override
    public void onBindViewHolder(@NonNull InfoViewHolder infoViewHolder, int position) {
        Infos info = dataSet.get(position);
        Resources res = infoViewHolder.itemView.getContext().getResources();

        infoViewHolder.getInfo_title().setText(info.getName());

        if(info.getData() != null)
            infoViewHolder.getInfo_content().setText(info.getData());
        else{
            infoViewHolder.getInfo_content().setText(res.getString(R.string.baixar));
            infoViewHolder.getInfo_content().setTextColor(res.getColor(R.color.santanderRed));
            infoViewHolder.getInfo_content().setCompoundDrawablesWithIntrinsicBounds( res.getDrawable(R.drawable.ic_download_red), null, null, null);
            infoViewHolder.getInfo_content().setCompoundDrawablePadding(12);

        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void addListInfo(ArrayList<Infos> listInfos) {

        dataSet.addAll(listInfos);
        notifyDataSetChanged();
    }
}
