package com.dutchOrder.server.model;

import java.io.Serializable;
import java.util.Objects;

public class MenuId implements Serializable {
    private Integer bnum;
    private Integer fnum;

    public MenuId() {}

    public MenuId(Integer bnum, Integer fnum) {
        this.bnum = bnum;
        this.fnum = fnum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MenuId)) return false;
        MenuId menuId = (MenuId) o;
        return Objects.equals(bnum, menuId.bnum) &&
                Objects.equals(fnum, menuId.fnum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bnum, fnum);
    }
}
