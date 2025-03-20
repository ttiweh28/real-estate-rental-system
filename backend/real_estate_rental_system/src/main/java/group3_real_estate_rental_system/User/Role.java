package group3_real_estate_rental_system.User;

public enum Role {

    ROLE_ADMIN("Administrator"),
    ROLE_TENANT("Tenant"),
    ROLE_PROPERTIES_OWNER("Properties Owner");

    private final String displayName;

    Role(String displayName) {
        this.displayName = displayName;
    }
}
