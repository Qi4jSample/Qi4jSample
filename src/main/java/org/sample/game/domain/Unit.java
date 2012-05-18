package org.sample.game.domain;

import org.qi4j.api.common.Optional;
import org.qi4j.api.common.UseDefaults;
import org.qi4j.api.property.Property;

/**
 * @author Anton Chernetskiy
 */
public interface Unit {

    @UseDefaults
    public Property<Integer> health();

    @Optional
    public Property<String> name();
}
