package ravi.com.instashop.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nikpatel on 08/03/18.
 */

public class catModel {
    @SerializedName("category_id")
    String category_id;
    @SerializedName("category_name")
    String category_name;
    @SerializedName("category_photo")
    String category_photo;

    public catModel() {
    }

    public catModel(String category_id, String category_name, String category_photo) {
        this.category_id = category_id;
        this.category_name = category_name;
        this.category_photo = category_photo;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_photo() {
        return category_photo;
    }

    public void setCategory_photo(String category_photo) {
        this.category_photo = category_photo;
    }
}
