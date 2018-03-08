package ravi.com.instashop.ApiResponse;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Parth on 05-Mar-18.
 */

public class updateProfileReasponse {
    @SerializedName("full_name")
    private String full_name;
    @SerializedName("c_address1")
    private String c_address1;
    @SerializedName("c_address2")
    private String c_address2;
    @SerializedName("c_mobile")
    private String c_mobile;
    @SerializedName("success")
    private int success;
    @SerializedName("message")
    private String message;
    @SerializedName("c_email")
    private String c_email;

    public updateProfileReasponse(String full_name, String c_address1, String c_address2, String c_mobile, int success, String message, String c_email) {
        this.full_name = full_name;
        this.c_address1 = c_address1;
        this.c_address2 = c_address2;
        this.c_mobile = c_mobile;
        this.success = success;
        this.message = message;
        this.c_email = c_email;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getC_address1() {
        return c_address1;
    }

    public String getC_address2() {
        return c_address2;
    }

    public String getC_mobile() {
        return c_mobile;
    }

    public int getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getC_email() {
        return c_email;
    }
}
