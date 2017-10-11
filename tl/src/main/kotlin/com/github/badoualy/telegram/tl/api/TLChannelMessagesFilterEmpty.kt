package com.github.badoualy.telegram.tl.api

/**
 * channelMessagesFilterEmpty#94d42ee7
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelMessagesFilterEmpty : TLAbsChannelMessagesFilter() {
    private val _constructor: String = "channelMessagesFilterEmpty#94d42ee7"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelMessagesFilterEmpty) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x94d42ee7.toInt()
    }
}