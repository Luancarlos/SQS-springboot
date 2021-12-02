package br.com.luanrocha.sqsdevcloud.model;

import lombok.*;

@Getter
@Setter
@ToString
public class Product {
    private Long id;
    private String name;
    private String description;
}
