package br.com.miller.testeAndroid.home.viewHolders;

import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import br.com.miller.testeAndroid.R;
import br.com.miller.testeAndroid.home.adapters.FragmentMessage;
import br.com.miller.testeAndroid.splash.SplashContract;
import br.com.miller.testeAndroid.utils.Validations;

public class CellsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextInputLayout inputTextLayout;
    private TextInputEditText inputTextEditText;
    private TextView textView;
    private Button roundedButton;
    private CheckBox checkBox;
    private FragmentMessage fragmentMessage;

    public CellsViewHolder(@NonNull View itemView, FragmentMessage fragmentMessage) {
        super(itemView);

        this.fragmentMessage = fragmentMessage;

        itemView.setOnClickListener(this);

        inputTextLayout = itemView.findViewById(R.id.input_text_layout);
        inputTextEditText = itemView.findViewById(R.id.input_text_edit_text);
        textView = itemView.findViewById(R.id.text_view);
        roundedButton = itemView.findViewById(R.id.button);
        checkBox = itemView.findViewById(R.id.check_box);

    }

    public TextInputLayout getInputTextLayout() {
        return inputTextLayout;
    }

    public TextInputEditText getInputTextEditText() {
        return inputTextEditText;
    }

    public TextView getTextView() {
        return textView;
    }


    public Button getRoundedButton() {
        return roundedButton;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }

    @Override
    public void onClick(View view) {

        fragmentMessage.message(view, getAdapterPosition()); }
}
