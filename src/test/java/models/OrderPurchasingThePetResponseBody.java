package models;

import lombok.Data;

@Data
public class OrderPurchasingThePetResponseBody {

    private int id, petId, quantity;
    private String status, shipDate;
    private boolean complete;

    public boolean getComplete() {
        return complete;
    }
}
