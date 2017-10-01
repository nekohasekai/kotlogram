package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * inputPrivacyValueDisallowUsers#90110467
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputPrivacyValueDisallowUsers() : TLAbsInputPrivacyRule() {
    var users: TLObjectVector<TLAbsInputUser> = TLObjectVector()

    private val _constructor: String = "inputPrivacyValueDisallowUsers#90110467"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(users: TLObjectVector<TLAbsInputUser>) : this() {
        this.users = users
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLVector(users)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        users = readTLVector<TLAbsInputUser>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += users.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputPrivacyValueDisallowUsers) return false
        if (other === this) return true

        return users == other.users
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x90110467.toInt()
    }
}