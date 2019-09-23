package br.com.miller.testeAndroid;

public interface BaseView<T extends BasePresenter> {

    void setPresenter(T presenter);

}
