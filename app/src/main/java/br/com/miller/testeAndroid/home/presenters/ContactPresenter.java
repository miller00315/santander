package br.com.miller.testeAndroid.home.presenters;

import android.util.Log;

import java.util.ArrayList;

import br.com.miller.testeAndroid.home.contracts.ContactContract;
import br.com.miller.testeAndroid.home.data.ContactDataSource;
import br.com.miller.testeAndroid.home.data.source.ContactRemoteDataSource;
import br.com.miller.testeAndroid.model.Cell;

import static com.google.common.base.Preconditions.checkNotNull;

public class ContactPresenter implements ContactContract.Presenter, ContactDataSource.LoadContactCallBack {

    private ContactContract.View mContactView;
    private ContactRemoteDataSource mContactRemoteDataSource;

    public ContactPresenter(ContactContract.View mContactView) {
        this.mContactView = checkNotNull(mContactView);
        this.mContactView.setPresenter(this);
        this.mContactRemoteDataSource = ContactRemoteDataSource.getInstance();
    }

    @Override
    public void start() {

    }

    @Override
    public void getContactCells() {
        mContactRemoteDataSource.getDataApi(this);
    }

    @Override
    public void onContactLoaded(ArrayList<Cell> cells) {
        mContactView.showContactCells(cells);
    }

    @Override
    public void onDataNotAvailable() {

    }
}
