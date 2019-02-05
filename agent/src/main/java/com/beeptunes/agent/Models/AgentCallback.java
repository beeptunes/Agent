package com.beeptunes.agent.Models;

public interface AgentCallback<T> {
    public void success(T data);
    public void fail(Error err);

}
