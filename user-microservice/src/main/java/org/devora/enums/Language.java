package org.devora.enums;

import lombok.Getter;

@Getter
public enum Language {
    EN("English"),
    RU("Russian");

    public final String value;

    Language(String value) {
        this.value = value;
    }
}
