package br.com.miller.testeAndroid.model;

import com.google.gson.annotations.Expose;

public class Cell {

    @Expose
    public int id;

    @Expose
    public int type;

    @Expose
    public String message;

    @Expose
    public String typefield;

    @Expose
    public boolean hidden;

    @Expose
    public int topSpacing;

    @Expose
    public int show;

    @Expose
    public boolean required;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTypefield() {
        return typefield;
    }

    public void setTypefield(String typefield) {
        this.typefield = typefield;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public int getTopSpacing() {
        return topSpacing;
    }

    public void setTopSpacing(int topSpacing) {
        this.topSpacing = topSpacing;
    }

    public int getShow() {
        return show;
    }

    public void setShow(int show) {
        this.show = show;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }
}
