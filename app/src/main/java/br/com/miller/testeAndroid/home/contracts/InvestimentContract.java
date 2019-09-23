package br.com.miller.testeAndroid.home.contracts;

import br.com.miller.testeAndroid.BasePresenter;
import br.com.miller.testeAndroid.BaseView;
import br.com.miller.testeAndroid.model.Screen;

public interface InvestimentContract {

    interface View extends BaseView<Presenter>{
        void showInvestment(Screen listScreen);
        void onDataNotAvaliable();
    }

    interface  Presenter extends BasePresenter{
        void getInvestments();
    }
}
