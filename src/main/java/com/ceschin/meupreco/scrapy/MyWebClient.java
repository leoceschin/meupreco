package com.ceschin.meupreco.scrapy;

import com.ceschin.meupreco.model.Product;
import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class MyWebClient {

    public Product getProductFromUrl(String searchUrl) {
        Product product = new Product();
        WebClient client = getNewClient();
        try {
            HtmlPage pageHtml = client.getPage(searchUrl);

            product.setName(getNameFromUrl(pageHtml));
            product.setPrice(getPriceFromUrl(pageHtml));
            product.setImgUrl(getImgFromUrl(pageHtml));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return product;
    }

    private WebClient getNewClient() {
        WebClient client = new WebClient(BrowserVersion.CHROME);
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);

        return client;
    }

    public String getNameFromUrl(HtmlPage page) {
        DomElement domElement = page.getElementById("productTitle");
        String name = domElement.getTextContent();
        return name;
    }
    
    public String getImgFromUrl(HtmlPage page){
        DomElement domElement = page.getElementById("imgBlkFront");
        String link = domElement.getAttribute("src");
        return link;
    }

    public Double getPriceFromUrl(HtmlPage page) {
        Double price = 0.0;

        DomElement domElement = page.getElementById("price");
        String elmString = formatPrice(domElement.getTextContent());
        price = Double.parseDouble(elmString);

        return price;
    }

    private String formatPrice(String price) {
        String priceTag = price.trim().substring(3);
        String pT = priceTag.replace(",", ".");
        return pT;
    }

}
