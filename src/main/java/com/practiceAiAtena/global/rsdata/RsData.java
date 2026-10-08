package com.practiceAiAtena.global.rsdata;

import com.fasterxml.jackson.annotation.JsonIgnore;

public record RsData<T> (String resultCode, String msg, T data){
    public static <T> RsData<T> of (String resultCode, String msg, T data){
        return new RsData<T>(resultCode, msg, data);
    }

    public static <T> RsData<T> of (String resultCode, String msg){
        return new RsData<T>(resultCode, msg, null);
    }

    @JsonIgnore
    public boolean isSuccess(){
        return resultCode.startsWith("S-");
    }

    @JsonIgnore
    public boolean isFail(){
        return !isSuccess();
    }
}
