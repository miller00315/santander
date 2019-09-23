package br.com.miller.testeAndroid.service;

import br.com.miller.testeAndroid.model.ContactModel;
import br.com.miller.testeAndroid.model.InvestimentModel;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class GetApiService {

    public static final String BASE_URL = "https://floating-mountain-50292.herokuapp.com";

    public interface Service{
        @GET("/cells.json")
        Call<ContactModel> listCells();

        @GET("/fund.json")
        Call<InvestimentModel> listInvestiments();
    }

    public Service getApiService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Service.class);
    }

}
