package com.ml.shubham0204.docqa.domain

import android.content.Context
import com.google.mediapipe.tasks.core.BaseOptions
import com.google.mediapipe.tasks.text.llminference.LlmInference
import com.google.mediapipe.tasks.text.llminference.LlmInferenceOptions
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GemmaLocalAPI(context: Context) {
    private val llm: LlmInference

    init {
        val options =
            LlmInferenceOptions.builder()
                .setBaseOptions(
                    BaseOptions.builder()
                        .setModelAssetPath("/sdcard/DaoGemma/models/Gemma3n-e4b-it-int4.task")
                        .build(),
                )
                .build()
        llm = LlmInference.createFromOptions(context, options)
    }

    suspend fun getResponse(prompt: String): String? =
        withContext(Dispatchers.IO) {
            val result = llm.generateContent(prompt)
            result.text
        }
}
