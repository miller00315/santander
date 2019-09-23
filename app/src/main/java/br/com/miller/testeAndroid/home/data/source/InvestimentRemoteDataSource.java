package br.com.miller.testeAndroid.home.data.source;

import android.support.annotation.NonNull;
import android.util.Log;

import br.com.miller.testeAndroid.home.data.InvestmentDataSource;
import br.com.miller.testeAndroid.model.InvestimentModel;
import br.com.miller.testeAndroid.model.Screen;
import br.com.miller.testeAndroid.service.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InvestimentRemoteDataSource {

    private static InvestimentRemoteDataSource INSTANCE;

    public static final String TAG = InvestimentRemoteDataSource.class.getSimpleName();

    public static  InvestimentRemoteDataSource getInstance(){

        if(INSTANCE == null){

            INSTANCE = new InvestimentRemoteDataSource();
        }

        return INSTANCE;

    }

    public void getDataApi(final InvestmentDataSource.LoadInvestmentCallBack callBack){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService service = retrofit.create(ApiService.class);
        final Call<InvestimentModel> requestCells = service.listInvestment();

        requestCells.enqueue(new Callback<InvestimentModel>() {
            @Override
            public void onResponse(@NonNull Call<InvestimentModel> call, @NonNull Response<InvestimentModel> response) {

                if(response.isSuccessful()) {
                    InvestimentModel investmentModel = response.body();
                    Screen listScreen = null;

                    if (investmentModel != null) {

                        listScreen = investmentModel.getScreen();

                        if(listScreen != null)
                            callBack.onInvestmentLoaded(listScreen);
                        else
                            callBack.onDataNotAvailable();
                    }else{
                        callBack.onDataNotAvailable();
                    }

                } else {
                    callBack.onDataNotAvailable();
                }
            }

            @Override
            public void onFailure(@NonNull Call<InvestimentModel> call, @NonNull Throwable t) {
                Log.e(TAG, "Error Failure " + t.getMessage());
            }
        });

    }

}
