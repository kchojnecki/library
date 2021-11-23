package org.library.result;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public final class Empty implements Serializable {
    @Serial
    private static final long serialVersionUID = -9102432562894018590L;

    private Empty() {
    }

    public static Empty instance() {
        return new Empty();
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Empty;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Empty.class.getName() + (7 * 31));
    }
}
