package br.com.miller.testeAndroid.home.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import br.com.miller.testeAndroid.R;
import br.com.miller.testeAndroid.home.adapters.FragmentMessage;
import br.com.miller.testeAndroid.home.adapters.RecyclerAdapterCell;
import br.com.miller.testeAndroid.home.contracts.ContactContract;
import br.com.miller.testeAndroid.model.Cell;
import br.com.miller.testeAndroid.utils.Utils;


public class ContactFragment extends Fragment implements FragmentMessage, View.OnClickListener, ContactContract.View {

    private RecyclerAdapterCell recyclerAdapterCell;

    private View view;

    private ConstraintLayout formLayout, successLayout;

    private ContactContract.Presenter mContactPresenter;

    public ContactFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_contact, container, false);

        formLayout = view.findViewById(R.id.layout_form);

        successLayout = view.findViewById(R.id.success_layout);

        Button buttonNewMessage = view.findViewById(R.id.button_new_message);

        buttonNewMessage.setOnClickListener(this);

        createRecycler();

        mContactPresenter.getContactCells();

        return view;
    }

    private void createRecycler(){

        RecyclerView recyclerView = view.findViewById(R.id.recycler_contact);

        recyclerAdapterCell = new RecyclerAdapterCell(this);

        recyclerView.setAdapter(recyclerAdapterCell);

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(linearLayoutManager);

    }

    @Override
    public void message(View view, int position) {

        if(recyclerAdapterCell.getItemViewType(position) == Utils.TYPE_SEND){

                if(recyclerAdapterCell.validates()){
                    formLayout.setVisibility(View.GONE);
                    successLayout.setVisibility(View.VISIBLE);

                    recyclerAdapterCell.resetView();
                }
        }
    }

    @Override
    public void onClick(View view) {

         if(view.getId() == R.id.button_new_message){
             formLayout.setVisibility(View.VISIBLE);
             successLayout.setVisibility(View.GONE);
         }
    }

    @Override
    public void setPresenter(ContactContract.Presenter presenter) { mContactPresenter = presenter; }

    @Override
    public void showContactCells(ArrayList<Cell> cells) {
        recyclerAdapterCell.addAllCell(cells);
    }

    @Override
    public void onDataNotAvailable() { }
}
