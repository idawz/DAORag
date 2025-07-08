package com.google.mediapipe.tasks.text.llminference

import android.content.Context

class LlmInference private constructor(private val context: Context, private val options: LlmInferenceOptions) {
    data class GenerationResult(val text: String)

    fun generateContent(prompt: String): GenerationResult {
        // Stub implementation returns the prompt for now
        return GenerationResult("Stub response for: $prompt")
    }

    companion object {
        fun createFromOptions(context: Context, options: LlmInferenceOptions): LlmInference {
            return LlmInference(context, options)
        }
    }
}
