package ravi.com.instashop.ApiResponse;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Parth on 23-Feb-18.
 */

public class registerResponse {

    @SerializedName("user_id")
    private String user_id;
    @SerializedName("full_name")
    private String full_name;
    @SerializedName("c_address1")
    private String c_address1;
    @SerializedName("c_address2")
    private String c_address2;
    @SerializedName("success")
    private int success;
    @SerializedName("message")
    private String message;

    public registerResponse(int success, String message, String user_id, String full_name, String c_address1, String c_address2) {
        this.success = success;
        this.message = message;
        this.user_id = user_id;
        this.full_name = full_name;
        this.c_address1 = c_address1;
        this.c_address2 = c_address2;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getC_address1() {
        return c_address1;
    }

    public void setC_address1(String c_address1) {
        this.c_address1 = c_address1;
    }

    public String getC_address2() {
        return c_address2;
    }

    public void setC_address2(String c_address2) {
        this.c_address2 = c_address2;
    }
}
