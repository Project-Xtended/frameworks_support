/*
 * Copyright 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.arch.persistence.room.integration.kotlintestapp.vo

import android.arch.persistence.room.TypeConverter

/**
 * An enum class which gets saved as a bit set in the database.
 */
enum class Lang {
    TR,
    EN,
    ES;

    companion object {
        @JvmStatic
        @TypeConverter
        fun toInt(langs: Set<Lang>): Int {
            return langs.fold(0) { left, lang ->
                left.or(1 shl lang.ordinal)
            }
        }

        @JvmStatic
        @TypeConverter
        fun toSet(value: Int): Set<Lang> {
            return Lang.values().filter {
                (1 shl it.ordinal).and(value) != 0
            }.toSet()
        }
    }
}