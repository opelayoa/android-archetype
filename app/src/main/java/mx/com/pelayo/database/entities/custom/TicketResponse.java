package mx.com.pelayo.database.entities.custom;

import com.google.gson.annotations.SerializedName;

public class TicketResponse {
    @SerializedName("ticket-id")
    private Integer ticketId;
    private String message;

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
