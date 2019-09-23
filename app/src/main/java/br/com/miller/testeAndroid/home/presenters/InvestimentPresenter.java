package br.com.miller.testeAndroid.home.presenters;

import br.com.miller.testeAndroid.home.contracts.InvestimentContract;
import br.com.miller.testeAndroid.home.data.InvestmentDataSource;
import br.com.miller.testeAndroid.home.data.source.InvestimentRemoteDataSource;
import br.com.miller.testeAndroid.model.Screen;

public class InvestimentPresenter implements InvestimentContract.Presenter, InvestmentDataSource.LoadInvestmentCallBack {

    private InvestimentContract.View mInvestimentView;
    private InvestimentRemoteDataSource mInvestimentDataSource;

    public InvestimentPresenter(InvestimentContract.View mInvestimentView) {
        this.mInvestimentView = mInvestimentView;
        this.mInvestimentView.setPresenter(this);
        this.mInvestimentDataSource = InvestimentRemoteDataSource.getInstance();
    }

    @Override
    public void start() {

    }

    @Override
    public void getInvestments() {
        mInvestimentDataSource.getDataApi(this);
    }

    @Override
    public void onInvestmentLoaded(Screen listScreen) {
        mInvestimentView.showInvestment(listScreen);
    }

    @Override
    public void onDataNotAvailable() {

    }
}
