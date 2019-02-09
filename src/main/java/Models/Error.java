package Models;

public class Error {

    private ErrorDetail error;

    public int getCode () {
        return error.getCode();
    }

    public String getType () {
        return error.getType();
    }

    public String getMessage () {
        return error.getMessage();
    }

    public String getParameter () {
        return error.getParameter();
    }

    public ErrorDetail.Entity getEntity () {
        return error.getEntity();
    }


    public ErrorDetail getError() {
        return error;
    }
    public void setError(ErrorDetail error) {
        this.error = error;
    }
}
