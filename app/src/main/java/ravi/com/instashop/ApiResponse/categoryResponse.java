package ravi.com.instashop.ApiResponse;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import ravi.com.instashop.model.catModel;

/**
 * Created by Parth on 23-Feb-18.
 */

public class categoryResponse {




    @SerializedName("status")
    private int status;
    @SerializedName("categories")
    private List<catModel> categories;

    public categoryResponse(int status, List<catModel> categories) {
        this.status = status;
        this.categories = categories;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<catModel> getCategories() {
        return categories;
    }

    public void setCategories(List<catModel> categories) {
        this.categories = categories;
    }
}