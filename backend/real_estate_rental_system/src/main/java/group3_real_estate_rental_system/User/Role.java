package group3_real_estate_rental_system.User;

public enum Role {

    ADMIN("Administrator"),
    TENANT("Tenant"),
    PROPERTIES_OWNER("Properties Owner"),;

    private final String displayName;

    Role(String displayName) {
        this.displayName = displayName;
    }
}
