package group3_real_estate_rental_system.common;

import java.time.LocalDateTime;

public class BaseResponse {

    public static final String API_RESPONSE_SUCCESS_MESSAGE = "SUCCESS";
    public static final String API_RESPONSE_FAILED_MESSAGE = "FAILED";

    public static final int API_RESPONSE_SUCCESS_CODE = 200;
    public static final int API_RESPONSE_FAILURE_CODE = -1;

    private int status;
    private String message;
    private LocalDateTime timestamp;

    public static <T extends BaseResponse> T successResponse(Class<T> responseClazz) {
        return response(BaseResponse.API_RESPONSE_SUCCESS_CODE, BaseResponse.API_RESPONSE_SUCCESS_MESSAGE, responseClazz);
    }

    public static <T extends BaseResponse> T failureResponse( String message, Class<T> responseClazz) {
        return response(BaseResponse.API_RESPONSE_FAILURE_CODE, message, responseClazz);
    }

    public static <T extends BaseResponse> T response(int statusCode, String statusMessage, Class<T> responseClazz) {

        T response = null;

        try {

            response = responseClazz.getConstructor().newInstance();
            response.setStatus(statusCode);
            response.setMessage(statusMessage);
            response.setTimestamp(LocalDateTime.now());

            return response;

        } catch (Exception ignore) {
        }

        return response;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

}
