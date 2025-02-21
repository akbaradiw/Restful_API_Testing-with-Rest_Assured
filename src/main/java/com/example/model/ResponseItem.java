package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseItem {

    /*
     * {
            "id": 195,
            "title": "Essence Mascara Lash Princess",
            "price": 9.99,
            "discountPercentage": 7.17,
            "stock": 5,
            "rating": 4.94,
            "description": "The Essence Mascara Lash Princess is a popular mascara known for its volumizing and lengthening effects. Achieve dramatic lashes with this long-lasting and cruelty-free formula.",
            "category": "beauty"
        }
     */

    //  {
    //     "name": "Apple MacBook Pro 16",
    //     "data": {
    //        "year": 2019,
    //        "price": 1849.99,
    //        "CPU model": "Intel Core i9",
    //        "Hard disk size": "1 TB"
    //     }
    //  }
    @JsonProperty("name")
    public String name;

    @JsonProperty("id")
    public String id;

    @JsonProperty("data")
    public dataItem dataItem;

    @JsonProperty("createdAt")
    public String createdAt;

 @JsonProperty("updatedAt")
    public String updatedAt;

    public class dataItem {

        @JsonProperty("year")
        public int year;

        @JsonProperty("price")
        public int price;

        @JsonProperty("CPU model")
        public String cpuModel;

        @JsonProperty("Hard disk size")
        public String hardDiskSize;

        @JsonProperty("generation")
        public String generation;
    }
}
