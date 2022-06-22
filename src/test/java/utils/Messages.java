package utils;

public enum Messages {
    NO_RECORDS_FOUND("No Records Found"),
    USERNAME_EMPTY("Username cannot be empty"),
    INVALID_CREDENTIALS("Invalid credentials");

    private String text;
    private Messages(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
