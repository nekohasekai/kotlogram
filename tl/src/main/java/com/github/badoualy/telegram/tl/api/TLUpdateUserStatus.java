package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLUpdateUserStatus extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int userId;

    protected TLAbsUserStatus status;

    private final String _constructor = "updateUserStatus#0";

    public TLUpdateUserStatus() {
    }

    public TLUpdateUserStatus(int userId, TLAbsUserStatus status) {
        this.userId = userId;
        this.status = status;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(userId, stream);
        writeTLObject(status, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        userId = readInt(stream);
        status = readTLObject(stream, context, TLAbsUserStatus.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += status.computeSerializedSize();
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public TLAbsUserStatus getStatus() {
        return status;
    }

    public void setStatus(TLAbsUserStatus status) {
        this.status = status;
    }
}
