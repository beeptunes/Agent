package Models;


public class ErrorDetail {

    private int code;
    private String type;
    private String message;
    private String parameter;
    private Entity entity;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    @Override
    public String toString () {
        return "ErrorDetail{" +
                "code=" + code +
                ", type='" + type + '\'' +
                ", message='" + message + '\'' +
                ", parameter='" + parameter + '\'' +
                ", entity=" + entity.toString() +
                '}';
    }

    public class Entity{
        String type;

        @Override
        public String toString () {
            return "Entity{" +
                    "type='" + type + '\'' +
                    '}';
        }
    }



}
