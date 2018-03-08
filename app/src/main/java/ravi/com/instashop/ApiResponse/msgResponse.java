package ravi.com.instashop.ApiResponse;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Parth on 05-Mar-18.
 */

public class msgResponse {
    @SerializedName("success")
    private int success;
    @SerializedName("message")
    private String message;

    public msgResponse(int success, String message) {
        this.success = success;
        this.message = message;
    }

    public int getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
