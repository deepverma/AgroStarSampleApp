package agrostar.demoapp.com.agrostar.models;

import java.io.Serializable;

/**
 * Created by Deep Verma on 22/5/16.
 */
public class ProductsDTO implements Serializable {

    private String productName;

    public Integer getImageIds() {
        return imageIds;
    }

    public void setImageIds(Integer imageIds) {
        this.imageIds = imageIds;
    }

    private Integer imageIds;
    private String price;


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}
