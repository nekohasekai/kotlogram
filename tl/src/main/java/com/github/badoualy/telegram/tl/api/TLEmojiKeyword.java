package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLStringVector;
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
public class TLEmojiKeyword extends TLAbsEmojiKeyword {
    public static final int CONSTRUCTOR_ID = 0x0;

    private final String _constructor = "emojiKeyword#0";

    public TLEmojiKeyword() {
    }

    public TLEmojiKeyword(String keyword, TLStringVector emoticons) {
        this.keyword = keyword;
        this.emoticons = emoticons;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(keyword, stream);
        writeTLVector(emoticons, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        keyword = readTLString(stream);
        emoticons = readTLStringVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(keyword);
        size += emoticons.computeSerializedSize();
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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public TLStringVector getEmoticons() {
        return emoticons;
    }

    public void setEmoticons(TLStringVector emoticons) {
        this.emoticons = emoticons;
    }
}
