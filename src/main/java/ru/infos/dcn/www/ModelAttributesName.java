package ru.infos.dcn.www;

/**
 * @author Andrey Tsvetkov
 */
public enum ModelAttributesName {
    LOGIN("login"), REGISTRATION("reg");
    private final String name;

    private ModelAttributesName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
