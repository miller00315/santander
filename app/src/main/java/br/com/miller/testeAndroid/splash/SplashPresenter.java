package br.com.miller.testeAndroid.splash;


import static com.google.common.base.Preconditions.checkNotNull;

public class SplashPresenter implements SplashContract.Presenter{

    private SplashContract.View mSplashView;

    public SplashPresenter(SplashContract.View view) {

        this.mSplashView = checkNotNull(view);
        mSplashView.setPresenter(this);
    }


    @Override
    public void start() {

        loadPrincipalView();
    }

    @Override
    public void loadPrincipalView() {
        mSplashView.updateView();
    }
}
