package br.com.miller.testeAndroid.home.viewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.miller.testeAndroid.R;
import br.com.miller.testeAndroid.home.adapters.FragmentMessage;

public class ListScreenViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView investTitle;
    private TextView investFundName;
    private TextView whatIs;
    private TextView definition;
    private TextView riskTitle;

    private TextView infoTitle;
    private TextView moreInfo_fundo_month;
    private TextView moreInfo_cdi_month;
    private TextView moreInfo_fundo_year;
    private TextView moreInfo_cdi_year;
    private TextView moreInfo_fundo_12months;
    private TextView moreInfo_cdi_12months;
    private ImageView risk1, risk2, risk3, risk4, risk5;

    //public ListView infosView;
    private RecyclerView recyclerViewInfo;
  //  private TextView info_title;
    private TextView info_content;

    private Button buttonInvest;

    private FragmentMessage fragmentMessage;

    public ListScreenViewHolder(@NonNull View itemView, FragmentMessage fragmentMessage) {
        super(itemView);

        itemView.setOnClickListener(this);

        this.fragmentMessage = fragmentMessage;

        investTitle = itemView.findViewById(R.id.investTitle);
        investFundName = itemView.findViewById(R.id.investFundName);
        whatIs = itemView.findViewById(R.id.whatIs);
        definition = itemView.findViewById(R.id.definition);
        riskTitle = itemView.findViewById(R.id.riskTitle);

        infoTitle = itemView.findViewById(R.id.more_info_title);
        moreInfo_fundo_month = itemView.findViewById(R.id.moreInfo_fundo_month);
        moreInfo_cdi_month = itemView.findViewById(R.id.moreInfo_cdi_month);
        moreInfo_fundo_year = itemView.findViewById(R.id.moreInfo_fundo_year);
        moreInfo_cdi_year = itemView.findViewById(R.id.moreInfo_cdi_year);
        moreInfo_fundo_12months = itemView.findViewById(R.id.moreInfo_fundo_12months);
        moreInfo_cdi_12months = itemView.findViewById(R.id.moreInfo_cdi_12months);

        risk1 = itemView.findViewById(R.id.risk1);
        risk2 = itemView.findViewById(R.id.risk2);
        risk3 = itemView.findViewById(R.id.risk3);
        risk4 = itemView.findViewById(R.id.risk4);
        risk5 = itemView.findViewById(R.id.risk5);

        //infosView = itemView.findViewById(R.id.infos);
        recyclerViewInfo = itemView.findViewById(R.id.recycleViewInfos);

      //  info_title = itemView.findViewById(R.id.info_title);
        info_content = itemView.findViewById(R.id.info_content);

        buttonInvest = itemView.findViewById(R.id.button);
    }

    public Button getButtonInvest() {
        return buttonInvest;
    }

    public ImageView getRisk1() {
        return risk1;
    }

    public ImageView getRisk2() {
        return risk2;
    }

    public ImageView getRisk3() {
        return risk3;
    }

    public ImageView getRisk4() {
        return risk4;
    }

    public ImageView getRisk5() {
        return risk5;
    }

    public TextView getInvestTitle() {
        return investTitle;
    }

    public TextView getInvestFundName() {
        return investFundName;
    }

    public TextView getWhatIs() {
        return whatIs;
    }

    public TextView getDefinition() {
        return definition;
    }

    public TextView getRiskTitle() {
        return riskTitle;
    }

    public TextView getInfoTitle() {
        return infoTitle;
    }

    public TextView getMoreInfo_fundo_month() {
        return moreInfo_fundo_month;
    }

    public TextView getMoreInfo_cdi_month() {
        return moreInfo_cdi_month;
    }

    public TextView getMoreInfo_fundo_year() {
        return moreInfo_fundo_year;
    }

    public TextView getMoreInfo_cdi_year() {
        return moreInfo_cdi_year;
    }

    public TextView getMoreInfo_fundo_12months() {
        return moreInfo_fundo_12months;
    }

    public TextView getMoreInfo_cdi_12months() {
        return moreInfo_cdi_12months;
    }

    public RecyclerView getRecyclerViewInfo() {
        return recyclerViewInfo;
    }

  //  public TextView getInfo_title() {
  //      return info_title;
 //   }

    public TextView getInfo_content() {
        return info_content;
    }

    @Override
    public void onClick(View view) {
        fragmentMessage.message(view, getAdapterPosition());
    }
}
