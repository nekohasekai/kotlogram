package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [langPackString#cad181f6][TLLangPackString]
 * * [langPackStringDeleted#2979eeb2][TLLangPackStringDeleted]
 * * [langPackStringPluralized#6c47ac9f][TLLangPackStringPluralized]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsLangPackString : TLObject() {
    abstract var key: String
}