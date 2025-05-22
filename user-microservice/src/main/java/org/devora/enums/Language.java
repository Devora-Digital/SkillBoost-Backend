package org.devora.enums;

import lombok.Getter;

@Getter
public enum Language {
    EN("English"),
    RU("Russian");

    public final String label;

    Language(String label) {
        this.label = label;
    }
}
