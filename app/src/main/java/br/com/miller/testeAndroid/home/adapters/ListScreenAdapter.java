package br.com.miller.testeAndroid.home.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;

import br.com.miller.testeAndroid.R;
import br.com.miller.testeAndroid.home.viewHolders.ListScreenViewHolder;
import br.com.miller.testeAndroid.model.Infos;
import br.com.miller.testeAndroid.model.Screen;

public class ListScreenAdapter extends RecyclerView.Adapter<ListScreenViewHolder> {

    private static final String TAG = ListScreenAdapter.class.getSimpleName();
    private ArrayList<Screen> screens;
    private FragmentMessage fragmentMessage;
    private InfoAdapter infoAdapter;

    public ListScreenAdapter(FragmentMessage fragmentMessage, Context context) {

        this.fragmentMessage = fragmentMessage;
        this.screens = new ArrayList<>();
        infoAdapter = new InfoAdapter();
    }

    @NonNull
    @Override
    public ListScreenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.frame_layout_invest, parent, false);

        return new ListScreenViewHolder(root, fragmentMessage);
    }

    @Override
    public void onBindViewHolder(@NonNull ListScreenViewHolder listScreenViewHolder, int position) {

        Screen screen = screens.get(position);
        Resources res = listScreenViewHolder.itemView.getContext().getResources();

        listScreenViewHolder.getButtonInvest().setText(res.getString(R.string.investir));

        listScreenViewHolder.getInvestTitle().setText(screen.getTitle());
        listScreenViewHolder.getInvestTitle().setPadding(0, ((int) res.getDimension(R.dimen.lMargin)), 0, 0);

        listScreenViewHolder.getInvestFundName().setText(screen.getFundName());
        listScreenViewHolder.getInvestFundName().setPadding(0, ((int) res.getDimension(R.dimen.mMargin)), 0, 0);

        listScreenViewHolder.getWhatIs().setText(screen.getWhatIs());
        listScreenViewHolder.getWhatIs().setPadding(0, ((int) res.getDimension(R.dimen.sMargin)), 0, 0);

        listScreenViewHolder.getDefinition().setText(screen.getDefinition());
        listScreenViewHolder.getDefinition().setPadding(0, ((int) res.getDimension(R.dimen.sMargin) / 2), 0, 0);

        listScreenViewHolder.getRiskTitle().setText(screen.getRiskTitle());
        listScreenViewHolder.getRiskTitle().setPadding(0, ((int) res.getDimension(R.dimen.sMargin)), 0, 0);

        ArrayList<Infos> listInfo = screen.getInfo();

        listInfo.addAll(screen.getDownInfo());

        setRisk(listScreenViewHolder, screen.getRisk());

        listScreenViewHolder.getInfoTitle().setText(screen.getInfoTitle());
        listScreenViewHolder.getMoreInfo_fundo_month().setText(screen.getMoreInfo().getMonth().getFund().toString().concat("%"));
        listScreenViewHolder.getMoreInfo_cdi_month().setText(screen.getMoreInfo().getMonth().getCDI().toString().concat("%"));
        listScreenViewHolder.getMoreInfo_fundo_year().setText(screen.getMoreInfo().getYear().getFund().toString().concat("%"));
        listScreenViewHolder.getMoreInfo_cdi_year().setText(screen.getMoreInfo().getYear().getCDI().toString().concat("%"));
        listScreenViewHolder.getMoreInfo_fundo_12months().setText(screen.getMoreInfo().getMonths12().getFund().toString().concat("%"));
        listScreenViewHolder.getMoreInfo_cdi_12months().setText(screen.getMoreInfo().getMonths12().getCDI().toString().concat("%"));

        infoAdapter.addListInfo(listInfo);

        listScreenViewHolder.getRecyclerViewInfo().setAdapter(infoAdapter);

        listScreenViewHolder.getRecyclerViewInfo().setHasFixedSize(true);

        listScreenViewHolder.getRecyclerViewInfo().setLayoutManager(new LinearLayoutManager(listScreenViewHolder.itemView.getContext()));

    }

    public void setRisk(ListScreenViewHolder listScreenViewHolder, int risk){

        switch (risk){
            case 1:{
                listScreenViewHolder.getRisk1().setVisibility(View.VISIBLE);
                listScreenViewHolder.getRisk2().setVisibility(View.INVISIBLE);
                listScreenViewHolder.getRisk3().setVisibility(View.INVISIBLE);
                listScreenViewHolder.getRisk4().setVisibility(View.INVISIBLE);
                listScreenViewHolder.getRisk5().setVisibility(View.INVISIBLE);
            }
                break;

            case 2:{
                listScreenViewHolder.getRisk1().setVisibility(View.INVISIBLE);
                listScreenViewHolder.getRisk2().setVisibility(View.VISIBLE);
                listScreenViewHolder.getRisk3().setVisibility(View.INVISIBLE);
                listScreenViewHolder.getRisk4().setVisibility(View.INVISIBLE);
                listScreenViewHolder.getRisk5().setVisibility(View.INVISIBLE);
            }
                break;

            case 3:{
                listScreenViewHolder.getRisk1().setVisibility(View.INVISIBLE);
                listScreenViewHolder.getRisk2().setVisibility(View.INVISIBLE);
                listScreenViewHolder.getRisk3().setVisibility(View.VISIBLE);
                listScreenViewHolder.getRisk4().setVisibility(View.INVISIBLE);
                listScreenViewHolder.getRisk5().setVisibility(View.INVISIBLE);
            }
                break;

            case 4:{
                listScreenViewHolder.getRisk1().setVisibility(View.INVISIBLE);
                listScreenViewHolder.getRisk2().setVisibility(View.INVISIBLE);
                listScreenViewHolder.getRisk3().setVisibility(View.INVISIBLE);
                listScreenViewHolder.getRisk4().setVisibility(View.VISIBLE);
                listScreenViewHolder.getRisk5().setVisibility(View.INVISIBLE);
            }
                break;

            case 5:{
                listScreenViewHolder.getRisk1().setVisibility(View.INVISIBLE);
                listScreenViewHolder.getRisk2().setVisibility(View.INVISIBLE);
                listScreenViewHolder.getRisk3().setVisibility(View.INVISIBLE);
                listScreenViewHolder.getRisk4().setVisibility(View.INVISIBLE);
                listScreenViewHolder.getRisk5().setVisibility(View.VISIBLE);
            }
                break;

                default:
                    break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return screens.size();
    }

    public void addListScreen(Screen listScreen) {
        screens.addAll(Collections.singleton(listScreen));
        notifyDataSetChanged();
    }
}
