package org.example.hibernate.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateItemDto {

    private String name;
    private String description;
    private int price;
    private String rubricName;
    private Map<String, String> properties;

}
