package org.generation.cyberpunk.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Data transfer object (Objeto de transferencia de datos)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    private String email;
    private String password;
}
