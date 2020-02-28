package com.mostafijur.samplemvvmproject.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Students {
    @SerializedName("result")
    @Expose
    private List<Result> result = null;
    public List<Result> getResult() {
        return result;
    }
    public void setResult(List<Result> result) {
        this.result = result;
    }
}
