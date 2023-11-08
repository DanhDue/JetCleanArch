package extensions

import com.android.build.api.dsl.BuildType

fun BuildType.buildConfigStringField(name: String, value: String) {
    this.buildConfigField("String", name, "\"$value\"")
}

fun BuildType.buildConfigBooleanField(name: String, value: Boolean) {
    this.buildConfigField("boolean", name, "$value")
}
