package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseItem {

    @JsonProperty("name")
    public String name;

    @JsonProperty("id")
    public String id;

    @JsonProperty("data")
    public Data data;

    @JsonProperty("createdAt")
    public String createdAt;

    @JsonProperty("updatedAt")
    public String updatedAt;


    public static class Data {

        @JsonProperty("year")
        public int year;

        @JsonProperty("price")
        public int price;

        @JsonProperty("CPU model")
        public String CPUModel;

        @JsonProperty("Hard disk size")
        public String hardDiskSize;

        @JsonProperty("generation")
        public String generation;

        @JsonProperty("color")
        public String color;

        @JsonProperty("capacity GB")
        public String capacityGB;

        @JsonProperty("capacity")
        public String capacity;

        @JsonProperty("weight")
        public String weight;

        @JsonProperty("Case Size")
        public String caseSize;
    }
}
