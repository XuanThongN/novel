package com.xuanthongn.data.api.callback;

public abstract class Callback<T> {
    public abstract void returnResult(T t);

    public abstract void returnError(String message);
}
