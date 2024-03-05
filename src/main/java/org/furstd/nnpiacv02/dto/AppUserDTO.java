package org.furstd.nnpiacv02.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class AppUserDTO {
    @NotBlank(message = "Username cannot be null or blank")
    @Size(max = 255, message = "Username cannot exceed 255 characters")
    private String username;
    private String password;

}
