package JSPresso.DTO;

import JSPresso.type.ErrorCode;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginBackduuErrorResponse {
    private ErrorCode errorCode;
    private String errorMessage;
}