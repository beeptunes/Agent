package com.beeptunes.agent.Models;


public class ErrorDetail {

    public int code;
    public String type;
    public String message;
    public String parameter;
    public Entity entity;


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
        public String type;

        @Override
        public String toString () {
            return "Entity{" +
                    "type='" + type + '\'' +
                    '}';
        }
    }



}
