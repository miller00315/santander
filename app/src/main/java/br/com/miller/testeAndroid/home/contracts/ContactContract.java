package br.com.miller.testeAndroid.home.contracts;

import java.util.ArrayList;

import br.com.miller.testeAndroid.BasePresenter;
import br.com.miller.testeAndroid.BaseView;
import br.com.miller.testeAndroid.model.Cell;

public interface ContactContract {

    interface View extends BaseView<Presenter>{
        void showContactCells(ArrayList<Cell> cells);
        void onDataNotAvailable();
    }

    interface Presenter extends BasePresenter{
        void getContactCells();
    }
}
