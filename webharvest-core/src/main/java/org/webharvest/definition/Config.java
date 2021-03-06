package org.webharvest.definition;

/**
 * Represents lazily loaded configuration object that is loaded from associated
 * {@link ConfigSource} on demand with call to {@link #reload()} method. For
 * already loaded configuration it is possible to get reference to a graph of
 * configuration elements with {@link #getElementDef}.
 *
 * @author Robert Bala
 * @since 2.1.0-SNAPSHOT
 * @version %I%, %G%
 * @see ConfigSource
 * @see IElementDef
 */
public interface Config {

    // TODO rbala Missing javadoc documentation
    enum Version {
        // TODO rbala Missing javadoc documentation
        v1,
        // TODO rbala Missing javadoc documentation
        v2
    }

    // TODO rbala Missing javadoc
    Version getVersion();

    /**
     * Gets reference to configuration resource {@link ConfigSource}.
     *
     * @return configuration resource that is meant to contain configuration.
     */
    ConfigSource getConfigSource();

    /**
     * Gets reference to configuration root element.
     *
     * @return for loaded configuration gets root element, throws
     *         {@link IllegalStateException} in case the configuration has not
     *         been loaded.
     */
    IElementDef getElementDef();

    /**
     * Loads configuration from resource defined by {@link #getConfigSource()}.
     * Once the configuration is successfully loaded it is possible to get
     * reference to root configuration element with {@link #getElementDef()}.
     */
    void reload();

}
