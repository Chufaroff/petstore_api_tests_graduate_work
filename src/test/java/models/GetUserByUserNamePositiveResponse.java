package models;

import lombok.Data;

@Data
public class GetUserByUserNamePositiveResponse {

    private int id, userStatus;
    private String username, firstName, lastName, email, password, phone;
}
