package br.com.miller.testeAndroid.home.data;

import java.util.ArrayList;

import br.com.miller.testeAndroid.model.Cell;

public interface ContactDataSource {

    interface LoadContactCallBack {
        void onContactLoaded(ArrayList<Cell> cells);
        void onDataNotAvailable();
    }
}
