package com.github.badoualy.telegram.tl.api.help

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.api.TLUserEmpty
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * help.support#17c6b5f6
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSupport() : TLObject() {
    var phoneNumber: String = ""

    var user: TLAbsUser = TLUserEmpty()

    private val _constructor: String = "help.support#17c6b5f6"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(phoneNumber: String, user: TLAbsUser) : this() {
        this.phoneNumber = phoneNumber
        this.user = user
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(phoneNumber)
        writeTLObject(user)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        phoneNumber = readString()
        user = readTLObject<TLAbsUser>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(phoneNumber)
        size += user.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSupport) return false
        if (other === this) return true

        return phoneNumber == other.phoneNumber
                && user == other.user
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x17c6b5f6.toInt()
    }
}