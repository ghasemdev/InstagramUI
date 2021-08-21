package com.example.instagramui.compose.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

sealed class Dimensions {
    object Width : Dimensions()
    object Height : Dimensions()

    sealed class DimensionOperator {
        object Equals : DimensionOperator()
        object NotEquals : DimensionOperator()
        object LessThan : DimensionOperator()
        object LessThanEquals : DimensionOperator()
        object GreaterThan : DimensionOperator()
        object GreaterThanEquals : DimensionOperator()
        object Between : DimensionOperator()
    }

    class DimensionComparator(
        val operator: DimensionOperator,
        private val dimension: Dimensions,
        val first: Dp,
        val second: Dp? = null
    ) {
        fun compare(screenWidth: Dp, screenHeight: Dp): Boolean {
            return if (dimension is Width) {
                when (operator) {
                    is DimensionOperator.Equals -> screenWidth == first
                    is DimensionOperator.NotEquals -> screenWidth != first
                    is DimensionOperator.LessThan -> screenWidth < first
                    is DimensionOperator.LessThanEquals -> screenWidth <= first
                    is DimensionOperator.GreaterThan -> screenWidth > first
                    is DimensionOperator.GreaterThanEquals -> screenWidth >= first
                    is DimensionOperator.Between -> first < screenWidth && screenWidth < second!!
                }
            } else {
                when (operator) {
                    is DimensionOperator.Equals -> screenHeight == first
                    is DimensionOperator.NotEquals -> screenHeight != first
                    is DimensionOperator.LessThan -> screenHeight < first
                    is DimensionOperator.LessThanEquals -> screenHeight <= first
                    is DimensionOperator.GreaterThan -> screenHeight > first
                    is DimensionOperator.GreaterThanEquals -> screenHeight >= first
                    is DimensionOperator.Between -> first < screenHeight && screenHeight < second!!
                }
            }
        }
    }
}

@Composable
fun MediaQuery(comparator: Dimensions.DimensionComparator, content: @Composable () -> Unit) {
    val screenWidth =
        LocalContext.current.resources.displayMetrics.widthPixels.dp / LocalDensity.current.density
    val screenHeight =
        LocalContext.current.resources.displayMetrics.heightPixels.dp / LocalDensity.current.density

    if (comparator.compare(screenWidth, screenHeight)) {
        content()
    }
}

infix fun Dimensions.eq(value: Dp): Dimensions.DimensionComparator {
    return Dimensions.DimensionComparator(
        operator = Dimensions.DimensionOperator.Equals,
        dimension = this,
        first = value
    )
}

infix fun Dimensions.neq(value: Dp): Dimensions.DimensionComparator {
    return Dimensions.DimensionComparator(
        operator = Dimensions.DimensionOperator.NotEquals,
        dimension = this,
        first = value
    )
}

infix fun Dimensions.less(value: Dp): Dimensions.DimensionComparator {
    return Dimensions.DimensionComparator(
        operator = Dimensions.DimensionOperator.LessThan,
        dimension = this,
        first = value
    )
}

infix fun Dimensions.lessEq(value: Dp): Dimensions.DimensionComparator {
    return Dimensions.DimensionComparator(
        operator = Dimensions.DimensionOperator.LessThanEquals,
        dimension = this,
        first = value
    )
}

infix fun Dimensions.greater(value: Dp): Dimensions.DimensionComparator {
    return Dimensions.DimensionComparator(
        operator = Dimensions.DimensionOperator.GreaterThan,
        dimension = this,
        first = value
    )
}

infix fun Dimensions.greaterEq(value: Dp): Dimensions.DimensionComparator {
    return Dimensions.DimensionComparator(
        operator = Dimensions.DimensionOperator.GreaterThanEquals,
        dimension = this,
        first = value
    )
}

fun Dimensions.between(from: Dp, to: Dp): Dimensions.DimensionComparator {
    return Dimensions.DimensionComparator(
        operator = Dimensions.DimensionOperator.Between,
        dimension = this,
        first = from,
        second = to
    )
}

infix fun Dimensions.between(value: Pair<Dp, Dp>) = this.between(value.first, value.second)