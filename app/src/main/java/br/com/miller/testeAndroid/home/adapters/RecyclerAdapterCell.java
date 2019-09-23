package br.com.miller.testeAndroid.home.adapters;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;

import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import java.util.ArrayList;
import java.util.Objects;

import br.com.miller.testeAndroid.R;
import br.com.miller.testeAndroid.home.viewHolders.CellsViewHolder;
import br.com.miller.testeAndroid.model.Cell;
import br.com.miller.testeAndroid.utils.Mask;
import br.com.miller.testeAndroid.utils.Utils;
import br.com.miller.testeAndroid.utils.Validations;

import static br.com.miller.testeAndroid.utils.Mask.FORMAT_PHONE1;
import static br.com.miller.testeAndroid.utils.Mask.FORMAT_PHONE2;

public class RecyclerAdapterCell extends RecyclerView.Adapter<CellsViewHolder> {

    private ArrayList<Cell> cells;

    private FragmentMessage fragmentMessage;

    private Validations validations;

    public static final String TAG = RecyclerAdapterCell.class.getSimpleName();

    private ArrayList<CellsViewHolder> views;

    public RecyclerAdapterCell(FragmentMessage fragmentMessage) {

        this.cells = new ArrayList<>();

        this.fragmentMessage = fragmentMessage;

        views = new ArrayList<>();

        validations = new Validations();
    }

    @NonNull
    @Override
    public CellsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;

        switch (viewType){

            case Utils.TYPE_CHECKBOX:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_check_box, parent, false);
                break;

                case Utils.TYPE_SEND:
                    view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.item_button_rounded, parent, false);
                    break;

            case Utils.TYPE_TEXT:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_text, parent, false);
                break;

                default:
                    view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_text_input, parent, false);
                    break;

        }

        return new CellsViewHolder(view, fragmentMessage);

    }

    @Override
    public void onBindViewHolder(@NonNull final CellsViewHolder cellsViewHolder, final int position) {

        final Cell cell = cells.get(position);

        Resources resources = cellsViewHolder.itemView.getContext().getResources();

        switch (cell.getType()){

            case Utils.TYPE_FIELD:{

                cellsViewHolder.getInputTextLayout().setPadding(0, cell.getTopSpacing(), 0, cell.getTopSpacing());
                cellsViewHolder.getInputTextLayout().setHint(cell.getMessage());
                cellsViewHolder.getInputTextEditText().clearFocus();
                cellsViewHolder.getInputTextEditText().setImeOptions(EditorInfo.IME_ACTION_DONE);

                if(cell.getTypefield().equals(String.valueOf(Utils.TYPEFIELD_TEXT_T))){
                    cellsViewHolder.getInputTextEditText().setInputType(InputType.TYPE_CLASS_TEXT);
                    cellsViewHolder.getInputTextEditText().addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {
                            validations.nameValidation(cellsViewHolder.getInputTextEditText());
                        }
                    });

                }else if(cell.getTypefield().equals(String.valueOf(Utils.TYPEFIELD_EMAIL_T))){

                    cellsViewHolder.getInputTextEditText().setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
                    cellsViewHolder.getInputTextEditText().addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {
                           validations.emailValidation(cellsViewHolder.getInputTextEditText());
                        }
                    });

                }else if(cell.getTypefield().equals(Utils.TYPEFIELD_TELNUMBER_T)){
                    cellsViewHolder.getInputTextEditText().setInputType(InputType.TYPE_CLASS_PHONE);
                    cellsViewHolder.getInputTextEditText().addTextChangedListener(new TextWatcher() {

                          boolean isUpdating;
                          String old = "";

                          @Override
                          public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                          }

                          @Override
                          public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
/*
                              final String str = Mask.unmask(charSequence.toString());
                              String maskeradeString = "";

                              if( isUpdating ){

                                  old = str;
                                  isUpdating = false;
                                  return;
                              }

                              int i = 0;

                              String mask;

                              if(str.length() <= 10){
                                  mask = FORMAT_PHONE2;
                              }else{
                                  mask = FORMAT_PHONE1;
                              }

                              for (final char m: mask.toCharArray()){

                                  if( m != '#' && str.length() > old.length()){
                                      maskeradeString += m;
                                      continue;
                                  }
                                  try{
                                      maskeradeString += str.charAt(i);
                                  }catch (final  Exception e){
                                      break;
                                  }
                                  i++;
                              }

                              isUpdating = true;

                              try{
                                  cellsViewHolder.getInputTextEditText().setText(maskeradeString);
                              }catch (Exception e){
                                  e.printStackTrace();
                              }
                              /*

                              cellsViewHolder.getInputTextEditText().setSelection(maskeradeString.length());
*/
                          }

                          @Override
                          public void afterTextChanged(Editable editable) {
                             validations.phoneValidation(cellsViewHolder.getInputTextEditText());
                          }
                      }

                    );



                }

                views.add(cellsViewHolder);

                break;
            }

            case Utils.TYPE_CHECKBOX:{

                cellsViewHolder.getCheckBox().setText(cell.getMessage());
                cellsViewHolder.getCheckBox().setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.txtRegular));
                cellsViewHolder.getCheckBox().setTypeface(ResourcesCompat.getFont(cellsViewHolder.itemView.getContext(), R.font.din_pro_medium));
                cellsViewHolder.getCheckBox().setPadding(0, cell.getTopSpacing(), 0, cell.getTopSpacing());
                cellsViewHolder.getCheckBox().setChecked(cell.isHidden());

                cellsViewHolder.getCheckBox().setOnClickListener(cellsViewHolder);

                views.add(cellsViewHolder);

                break;
            }

            case Utils.TYPE_SEND:{
                cellsViewHolder.getRoundedButton().setText(cell.getMessage());
                cellsViewHolder.getRoundedButton().setPadding(0, cell.topSpacing, 0,cell.getTopSpacing());
                cellsViewHolder.getRoundedButton().setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.txtRegular));
                cellsViewHolder.getRoundedButton().setOnClickListener(cellsViewHolder);

                break;
            }

            case Utils.TYPE_TEXT:{

                cellsViewHolder.getTextView().setText(cell.getMessage());
                cellsViewHolder.getTextView().setPadding(0, cell.topSpacing, 0,cell.getTopSpacing());
                cellsViewHolder.getTextView().setTypeface(ResourcesCompat.getFont(cellsViewHolder.itemView.getContext(),
                        R.font.din_pro_medium));
                cellsViewHolder.getTextView().setVisibility(cell.isHidden() ? View.GONE : View.VISIBLE);

                break;

            }
        }

    }

    @Override
    public int getItemViewType(int position) {
        Cell cell = cells.get(position);

        return cell.getType();
    }

    @Override
    public int getItemCount() {
        return cells.size();
    }

    public void addAllCell(ArrayList<Cell> cells){

        this.cells.addAll(cells);
        notifyDataSetChanged();
    }

    public void resetView(){

        for(CellsViewHolder viewHolder: views){
            if(viewHolder.getInputTextEditText() != null){
                viewHolder.getInputTextEditText().setText(null);
            }else if( viewHolder.getCheckBox() != null){
                viewHolder.getCheckBox().setChecked(false);
            }
        }
    }

    public boolean validates(){

        boolean isValid = true;

       for(CellsViewHolder view: views)
           if(view.getInputTextEditText() != null)
              if( Objects.requireNonNull(view.getInputTextEditText().getText()).toString().trim().isEmpty()){
                  view.getInputTextEditText().setError("Campo vazio");
                  if(isValid)
                    isValid = false;
              }else if( view.getInputTextEditText().getError() != null ){

                  if(isValid)
                      isValid = false;
              }

       return isValid;
    }



}
