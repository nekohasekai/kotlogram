package com.github.badoualy.telegram.tl.api.messages;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLFoundStickerSets}: messages.foundStickerSets#5108d648</li>
 * <li>{@link TLFoundStickerSetsNotModified}: messages.foundStickerSetsNotModified#d54b65d</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsFoundStickerSets extends TLObject {
    public TLAbsFoundStickerSets() {
    }
}
