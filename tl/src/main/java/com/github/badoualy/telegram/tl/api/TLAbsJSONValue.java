package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLJsonArray}: jsonArray#0</li>
 * <li>{@link TLJsonBool}: jsonBool#0</li>
 * <li>{@link TLJsonNull}: jsonNull#0</li>
 * <li>{@link TLJsonNumber}: jsonNumber#0</li>
 * <li>{@link TLJsonObject}: jsonObject#0</li>
 * <li>{@link TLJsonString}: jsonString#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsJSONValue extends TLObject {
    public TLAbsJSONValue() {
    }
}
