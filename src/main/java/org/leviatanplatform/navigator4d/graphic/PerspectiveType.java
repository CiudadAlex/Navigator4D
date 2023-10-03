package org.leviatanplatform.navigator4d.graphic;

/**
 * @author Alejandro
 * 
 */
public enum PerspectiveType {

    /** ISOMETRIC. */
    ISOMETRIC,

    /** KONIC. */
    KONIC;

    public String getDesc() {
        return toString().toLowerCase();
    }

    public long getId() {
        return getDesc().hashCode();
    }
}
