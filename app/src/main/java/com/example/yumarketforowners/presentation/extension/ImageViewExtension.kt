package com.example.yumarketforowners.presentation.extension

import android.graphics.Bitmap
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.Transformation
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory

// fade-in, fade-out의 애니메이션을 처리하기 위한 factory
private val factory = DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build()

fun ImageView.clear() = Glide.with(this).clear(this)

fun ImageView.load(
    uri: String,
    corner: Float = 0f,
    scaleType: Transformation<Bitmap> = CenterInside()
) = Glide.with(this)
    .load(uri)
    .transition(DrawableTransitionOptions.withCrossFade(factory)) // fade-in 애니메이션
    .diskCacheStrategy(DiskCacheStrategy.ALL)
    .apply {
        // 이미지의 라운딩 처리
        if (corner > 0f) {
            transform(scaleType, RoundedCorners(corner.fromDpToPx()))
        }
    }.into(this)
