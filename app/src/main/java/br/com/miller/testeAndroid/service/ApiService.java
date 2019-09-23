package br.com.miller.testeAndroid.service;

import br.com.miller.testeAndroid.model.ContactModel;
import br.com.miller.testeAndroid.model.InvestimentModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    public static final String BASE_URL = "https://floating-mountain-50292.herokuapp.com";

    @GET("/cells.json")
    Call<ContactModel> listCells();

    @GET("/fund.json")
    Call<InvestimentModel> listInvestment();
}
