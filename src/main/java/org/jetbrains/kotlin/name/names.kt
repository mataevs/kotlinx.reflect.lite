/*
 * Copyright 2010-2017 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.name

data class FqName(private val fqName: String) {
    fun asString(): String = fqName

    val isRoot: Boolean
        get() = fqName.isEmpty()

    override fun toString(): String =
            fqName

    companion object {
        val ROOT = FqName("")
    }
}

data class ClassId(
        private val packageFqName: FqName,
        private val relativeClassName: FqName,
        private val local: Boolean
) {
    fun asString(): String {
        if (packageFqName.isRoot) return relativeClassName.asString()
        return packageFqName.asString().replace('.', '/') + "/" + relativeClassName.asString()
    }

    override fun toString() = asString()
}
