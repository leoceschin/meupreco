package com.ceschin.meupreco.Dto;

import java.io.Serializable;

public class ProductDto implements Serializable{

    public static Long serialVersionUID = 1L;

    private String searchUrl;

    public ProductDto() {
    }

    public String getSearchUrl() {
        return searchUrl;
    }

    public void setSearchUrl(String searchUrl) {
        this.searchUrl = searchUrl;
    }

    
}
