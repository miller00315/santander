package br.com.miller.testeAndroid.home.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import br.com.miller.testeAndroid.R;
import br.com.miller.testeAndroid.home.adapters.FragmentMessage;
import br.com.miller.testeAndroid.home.adapters.ListScreenAdapter;
import br.com.miller.testeAndroid.home.contracts.InvestimentContract;
import br.com.miller.testeAndroid.model.Screen;


public class InvestimentFragment extends Fragment implements FragmentMessage, InvestimentContract.View {

    private static final String TAG = InvestimentFragment.class.getSimpleName();

    private RecyclerView recyclerView;

    private ListScreenAdapter listScreenAdapter;

    private InvestimentContract.Presenter mInvestimentPresenter;

    private Button invest;

    public InvestimentFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void setRecycler(View view){
        recyclerView = view.findViewById(R.id.recycler_investiment);
        listScreenAdapter = new ListScreenAdapter(this, getContext());
        recyclerView.setAdapter(listScreenAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_investiment, container, false);

        setRecycler(view);

        mInvestimentPresenter.getInvestments();

        return view;
    }

    @Override
    public void message(View view, int position) { }

    @Override
    public void setPresenter(InvestimentContract.Presenter presenter) { mInvestimentPresenter = presenter; }

    @Override
    public void showInvestment(Screen listScreen) { listScreenAdapter.addListScreen(listScreen); }

    @Override
    public void onDataNotAvaliable() { }
}
