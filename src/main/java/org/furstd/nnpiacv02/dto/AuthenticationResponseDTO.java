package org.furstd.nnpiacv02.dto;

import lombok.*;
import org.furstd.nnpiacv02.entity.AppUser;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponseDTO {

    private String token;
    private AppUser user;
}
