package exceptions;

import java.io.Serializable;
import java.util.Date;

public class StandardError implements Serializable {
    private static final long serialVersionUID = 1L;

    private Date timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public StandardError(Date timestamp, Integer status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    // Getters e setters
}
