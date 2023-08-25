package com.example.backend.dto.request;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryRequest {

    @NotBlank(message = "Không được để trống!")
    private String ma;
    @NotBlank(message = "Không được để trống!")
    private String ten;
}
