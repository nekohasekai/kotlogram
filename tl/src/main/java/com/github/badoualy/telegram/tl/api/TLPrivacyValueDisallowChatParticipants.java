package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLIntVector;
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
public class TLPrivacyValueDisallowChatParticipants extends TLAbsPrivacyRule {
    public static final int CONSTRUCTOR_ID = 0xacae0690;

    protected TLIntVector chats;

    private final String _constructor = "privacyValueDisallowChatParticipants#acae0690";

    public TLPrivacyValueDisallowChatParticipants() {
    }

    public TLPrivacyValueDisallowChatParticipants(TLIntVector chats) {
        this.chats = chats;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(chats, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        chats = readTLIntVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += chats.computeSerializedSize();
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

    public TLIntVector getChats() {
        return chats;
    }

    public void setChats(TLIntVector chats) {
        this.chats = chats;
    }
}
