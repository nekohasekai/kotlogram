package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputStickerSetItem extends TLObject {
    public static final int CONSTRUCTOR_ID = 0xffa0a496;

    protected int flags;

    protected TLAbsInputDocument document;

    protected String emoji;

    protected TLMaskCoords maskCoords;

    private final String _constructor = "inputStickerSetItem#ffa0a496";

    public TLInputStickerSetItem() {
    }

    public TLInputStickerSetItem(TLAbsInputDocument document, String emoji, TLMaskCoords maskCoords) {
        this.document = document;
        this.emoji = emoji;
        this.maskCoords = maskCoords;
    }

    private void computeFlags() {
        flags = 0;
        flags = maskCoords != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(document, stream);
        writeString(emoji, stream);
        if ((flags & 1) != 0) {
            if (maskCoords == null) throwNullFieldException("maskCoords", flags);
            writeTLObject(maskCoords, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        document = readTLObject(stream, context, TLAbsInputDocument.class, -1);
        emoji = readTLString(stream);
        maskCoords = (flags & 1) != 0 ? readTLObject(stream, context, TLMaskCoords.class, TLMaskCoords.CONSTRUCTOR_ID) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += document.computeSerializedSize();
        size += computeTLStringSerializedSize(emoji);
        if ((flags & 1) != 0) {
            if (maskCoords == null) throwNullFieldException("maskCoords", flags);
            size += maskCoords.computeSerializedSize();
        }
        return size;
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public TLAbsInputDocument getDocument() {
        return document;
    }

    public void setDocument(TLAbsInputDocument document) {
        this.document = document;
    }

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }

    public TLMaskCoords getMaskCoords() {
        return maskCoords;
    }

    public void setMaskCoords(TLMaskCoords maskCoords) {
        this.maskCoords = maskCoords;
    }
}
