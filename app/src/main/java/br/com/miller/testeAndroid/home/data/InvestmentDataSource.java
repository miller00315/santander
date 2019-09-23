package br.com.miller.testeAndroid.home.data;

import br.com.miller.testeAndroid.model.Screen;

public interface InvestmentDataSource {

    interface LoadInvestmentCallBack {
        void onInvestmentLoaded(Screen listScreen);
        void onDataNotAvailable();
    }
}
