package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderPurchasingThePetRequestBody {

    private int id, petId, quantity;
    private String status, shipDate;
    private boolean complete;
}
