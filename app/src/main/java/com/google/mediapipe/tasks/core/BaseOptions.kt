package com.google.mediapipe.tasks.core

class BaseOptions private constructor(val modelAssetPath: String?) {
    class Builder {
        private var modelAssetPath: String? = null
        fun setModelAssetPath(path: String) = apply { this.modelAssetPath = path }
        fun build(): BaseOptions = BaseOptions(modelAssetPath)
    }
    companion object {
        fun builder() = Builder()
    }
}
