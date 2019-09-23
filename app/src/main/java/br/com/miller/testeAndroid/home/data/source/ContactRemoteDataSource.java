package br.com.miller.testeAndroid.home.data.source;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;

import br.com.miller.testeAndroid.home.data.ContactDataSource;
import br.com.miller.testeAndroid.model.Cell;
import br.com.miller.testeAndroid.model.ContactModel;
import br.com.miller.testeAndroid.service.ApiService;
import br.com.miller.testeAndroid.service.GetApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ContactRemoteDataSource {

    private static ContactRemoteDataSource INSTANCE;

    public static final String TAG = ContactRemoteDataSource.class.getSimpleName();

    public static ContactRemoteDataSource getInstance(){

        if(INSTANCE == null){

            INSTANCE = new ContactRemoteDataSource();
        }

        return INSTANCE;

    }

    public void getDataApi(final ContactDataSource.LoadContactCallBack callBack){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GetApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService service = retrofit.create(ApiService.class);

        final Call<ContactModel> resquestCells = service.listCells();

        resquestCells.enqueue(new Callback<ContactModel>() {
            @Override
            public void onResponse(@NonNull Call<ContactModel> call, @NonNull Response<ContactModel> response) {

                if(response.isSuccessful()){

                    ContactModel contactModel = response.body();

                    if(contactModel != null){
                        ArrayList<Cell> cells = contactModel.getCells();

                        callBack.onContactLoaded(cells);

                    }else{
                        callBack.onDataNotAvailable();
                    }

                }else{
                    callBack.onDataNotAvailable();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ContactModel> call, @NonNull Throwable t) {
                callBack.onDataNotAvailable();
            }
        });
    }
}
