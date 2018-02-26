/*
 * DiagonalDrawable - A set of Android libraries to help speed up Android development.
 *
 * Copyright (c) 2018 DiagonalDrawable
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.massivedisaster.drawable

import android.graphics.*
import android.graphics.drawable.Drawable
import android.support.annotation.Nullable

class DiagonalDrawable(private val colorLeft: Int,
                       private val colorRight: Int,
                       private val orientation: Orientation = Orientation.LEFT_RIGHT) : Drawable() {

    enum class Orientation {
        LEFT_RIGHT,
        RIGHT_LEFT
    }

    private val paint = Paint()
    private lateinit var pathRight: Path
    private lateinit var pathLeft: Path

    private lateinit var rectBounds: Rect

    init {
        paint.style = Paint.Style.FILL
        paint.isAntiAlias = true
    }

    override fun onBoundsChange(bounds: Rect) {
        super.onBoundsChange(bounds)
        rectBounds = bounds

        pathLeft = Path()
        pathLeft.moveTo(0F, 0F)

        pathRight = Path()
        pathRight.moveTo(bounds.right.toFloat(), 0F)

        if (orientation == Orientation.LEFT_RIGHT) {
            pathLeft.lineTo(0F, bounds.bottom.toFloat())
            pathLeft.lineTo(bounds.right.toFloat(), bounds.bottom.toFloat())

            pathRight.lineTo(0F, 0F)
            pathRight.lineTo(bounds.right.toFloat(), bounds.bottom.toFloat())
        } else {
            pathRight.lineTo(0F, bounds.bottom.toFloat())
            pathRight.lineTo(bounds.right.toFloat(), bounds.bottom.toFloat())

            pathLeft.lineTo(0F, bounds.bottom.toFloat())
            pathLeft.lineTo(bounds.right.toFloat(), 0F)
        }

        pathLeft.moveTo(0F, 0F)
        pathLeft.close()

        pathLeft.moveTo(bounds.right.toFloat(), 0F)
        pathLeft.close()
    }

    override fun draw(canvas: Canvas) {
        paint.color = colorLeft
        canvas.drawPath(pathLeft, paint)
        paint.color = colorRight
        canvas.drawPath(pathRight, paint)

        if (orientation == Orientation.LEFT_RIGHT) {
            canvas.drawLine(0F, 0F, bounds.right.toFloat(), bounds.bottom.toFloat(), paint)
        } else {
            canvas.drawLine(bounds.right.toFloat(), 0F, 0F, bounds.bottom.toFloat(), paint)
        }
    }

    override fun setAlpha(alpha: Int) {}

    override fun setColorFilter(@Nullable colorFilter: ColorFilter?) {}

    override fun getOpacity(): Int {
        return PixelFormat.UNKNOWN
    }
}