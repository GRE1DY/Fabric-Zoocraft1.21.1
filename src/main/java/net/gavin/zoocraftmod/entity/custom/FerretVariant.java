package net.gavin.zoocraftmod.entity.custom;

import java.util.Arrays;
import java.util.Comparator;

public enum FerretVariant {
    DEFAULT(0),
    CHAMPAGNE(1);

    private static final FerretVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator
            .comparingInt(FerretVariant::getId)).toArray(FerretVariant[]::new);
    private final int id;

    FerretVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static FerretVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
