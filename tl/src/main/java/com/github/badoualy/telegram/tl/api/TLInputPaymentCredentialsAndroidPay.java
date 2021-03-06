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
public class TLInputPaymentCredentialsAndroidPay extends TLAbsInputPaymentCredentials {
    public static final int CONSTRUCTOR_ID = 0xca05d50e;

    protected TLDataJSON paymentToken;

    protected String googleTransactionId;

    private final String _constructor = "inputPaymentCredentialsAndroidPay#ca05d50e";

    public TLInputPaymentCredentialsAndroidPay() {
    }

    public TLInputPaymentCredentialsAndroidPay(TLDataJSON paymentToken, String googleTransactionId) {
        this.paymentToken = paymentToken;
        this.googleTransactionId = googleTransactionId;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(paymentToken, stream);
        writeString(googleTransactionId, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        paymentToken = readTLObject(stream, context, TLDataJSON.class, TLDataJSON.CONSTRUCTOR_ID);
        googleTransactionId = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += paymentToken.computeSerializedSize();
        size += computeTLStringSerializedSize(googleTransactionId);
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

    public TLDataJSON getPaymentToken() {
        return paymentToken;
    }

    public void setPaymentToken(TLDataJSON paymentToken) {
        this.paymentToken = paymentToken;
    }

    public String getGoogleTransactionId() {
        return googleTransactionId;
    }

    public void setGoogleTransactionId(String googleTransactionId) {
        this.googleTransactionId = googleTransactionId;
    }
}
