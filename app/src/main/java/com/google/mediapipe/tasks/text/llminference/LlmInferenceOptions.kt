package com.google.mediapipe.tasks.text.llminference

import com.google.mediapipe.tasks.core.BaseOptions

class LlmInferenceOptions private constructor(val baseOptions: BaseOptions?) {
    class Builder {
        private var baseOptions: BaseOptions? = null
        fun setBaseOptions(options: BaseOptions) = apply { this.baseOptions = options }
        fun build(): LlmInferenceOptions = LlmInferenceOptions(baseOptions)
    }
    companion object {
        fun builder() = Builder()
    }
}
