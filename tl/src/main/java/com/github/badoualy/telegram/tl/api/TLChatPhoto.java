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
public class TLChatPhoto extends TLAbsChatPhoto {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLFileLocationToBeDeprecated photoSmall;

    protected TLFileLocationToBeDeprecated photoBig;

    protected int dcId;

    private final String _constructor = "chatPhoto#0";

    public TLChatPhoto() {
    }

    public TLChatPhoto(TLFileLocationToBeDeprecated photoSmall, TLFileLocationToBeDeprecated photoBig, int dcId) {
        this.photoSmall = photoSmall;
        this.photoBig = photoBig;
        this.dcId = dcId;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(photoSmall, stream);
        writeTLObject(photoBig, stream);
        writeInt(dcId, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        photoSmall = readTLObject(stream, context, TLFileLocationToBeDeprecated.class, TLFileLocationToBeDeprecated.CONSTRUCTOR_ID);
        photoBig = readTLObject(stream, context, TLFileLocationToBeDeprecated.class, TLFileLocationToBeDeprecated.CONSTRUCTOR_ID);
        dcId = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += photoSmall.computeSerializedSize();
        size += photoBig.computeSerializedSize();
        size += SIZE_INT32;
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

    public TLFileLocationToBeDeprecated getPhotoSmall() {
        return photoSmall;
    }

    public void setPhotoSmall(TLFileLocationToBeDeprecated photoSmall) {
        this.photoSmall = photoSmall;
    }

    public TLFileLocationToBeDeprecated getPhotoBig() {
        return photoBig;
    }

    public void setPhotoBig(TLFileLocationToBeDeprecated photoBig) {
        this.photoBig = photoBig;
    }

    public int getDcId() {
        return dcId;
    }

    public void setDcId(int dcId) {
        this.dcId = dcId;
    }

    @Override
    public final boolean isEmpty() {
        return false;
    }

    @Override
    public final boolean isNotEmpty() {
        return true;
    }

    @Override
    public final TLChatPhoto getAsChatPhoto() {
        return this;
    }
}
