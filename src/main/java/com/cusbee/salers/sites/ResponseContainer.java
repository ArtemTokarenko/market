package com.cusbee.salers.sites;

public class ResponseContainer<T> {

    private T data = null;
    private int code = 0;
    private String message = null;
    private PageContainer pageContainer;

    public T getData() {
        return data;
    }

    public PageContainer getPageContainer() {
        return pageContainer;
    }

    public void setPageContainer(PageContainer pageContainer) {
        this.pageContainer = pageContainer;
    }

    public void setData(T data) {
        this.data = (T) data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setError(RestError error) {
        code = error.getAppErrorCode();
        message = error.getAppErrorMessage();
    }

}

