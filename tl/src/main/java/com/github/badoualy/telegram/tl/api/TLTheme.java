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
public class TLTheme extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean creator;

    protected boolean isDefault;

    protected long id;

    protected long accessHash;

    protected String slug;

    protected String title;

    protected TLAbsDocument document;

    protected TLThemeSettings settings;

    protected int installsCount;

    private final String _constructor = "theme#0";

    public TLTheme() {
    }

    public TLTheme(boolean creator, boolean isDefault, long id, long accessHash, String slug, String title, TLAbsDocument document, TLThemeSettings settings, int installsCount) {
        this.creator = creator;
        this.isDefault = isDefault;
        this.id = id;
        this.accessHash = accessHash;
        this.slug = slug;
        this.title = title;
        this.document = document;
        this.settings = settings;
        this.installsCount = installsCount;
    }

    private void computeFlags() {
        flags = 0;
        flags = creator ? (flags | 1) : (flags & ~1);
        flags = isDefault ? (flags | 2) : (flags & ~2);
        flags = document != null ? (flags | 4) : (flags & ~4);
        flags = settings != null ? (flags | 8) : (flags & ~8);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(id, stream);
        writeLong(accessHash, stream);
        writeString(slug, stream);
        writeString(title, stream);
        if ((flags & 4) != 0) {
            if (document == null) throwNullFieldException("document", flags);
            writeTLObject(document, stream);
        }
        if ((flags & 8) != 0) {
            if (settings == null) throwNullFieldException("settings", flags);
            writeTLObject(settings, stream);
        }
        writeInt(installsCount, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        creator = (flags & 1) != 0;
        isDefault = (flags & 2) != 0;
        id = readLong(stream);
        accessHash = readLong(stream);
        slug = readTLString(stream);
        title = readTLString(stream);
        document = (flags & 4) != 0 ? readTLObject(stream, context, TLAbsDocument.class, -1) : null;
        settings = (flags & 8) != 0 ? readTLObject(stream, context, TLThemeSettings.class, TLThemeSettings.CONSTRUCTOR_ID) : null;
        installsCount = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += SIZE_INT64;
        size += computeTLStringSerializedSize(slug);
        size += computeTLStringSerializedSize(title);
        if ((flags & 4) != 0) {
            if (document == null) throwNullFieldException("document", flags);
            size += document.computeSerializedSize();
        }
        if ((flags & 8) != 0) {
            if (settings == null) throwNullFieldException("settings", flags);
            size += settings.computeSerializedSize();
        }
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

    public boolean getCreator() {
        return creator;
    }

    public void setCreator(boolean creator) {
        this.creator = creator;
    }

    public boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAccessHash() {
        return accessHash;
    }

    public void setAccessHash(long accessHash) {
        this.accessHash = accessHash;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TLAbsDocument getDocument() {
        return document;
    }

    public void setDocument(TLAbsDocument document) {
        this.document = document;
    }

    public TLThemeSettings getSettings() {
        return settings;
    }

    public void setSettings(TLThemeSettings settings) {
        this.settings = settings;
    }

    public int getInstallsCount() {
        return installsCount;
    }

    public void setInstallsCount(int installsCount) {
        this.installsCount = installsCount;
    }
}
