package models;

import lombok.Data;

@Data
public class GetUserByUserNameNegativeResponse {

    private int code;
    private String type, message;
}
