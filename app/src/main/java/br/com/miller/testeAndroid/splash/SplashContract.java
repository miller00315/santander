package br.com.miller.testeAndroid.splash;

import br.com.miller.testeAndroid.BasePresenter;
import br.com.miller.testeAndroid.BaseView;

public interface SplashContract{

    interface View extends BaseView<Presenter> {

        void drawView();

        void updateView();

        boolean isActive();

    }

    interface Presenter extends BasePresenter {

        void loadPrincipalView();
    }

}
