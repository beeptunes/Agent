package Models;

public class Error {

    public ErrorDetail error;

    public int getCode () {
        return error.code;
    }

    public String getType () {
        return error.type;
    }

    public String getMessage () {
        return error.message;
    }

    public String getParameter () {
        return error.parameter;
    }

    public ErrorDetail.Entity getEntity () {
        return error.entity;
    }
}
