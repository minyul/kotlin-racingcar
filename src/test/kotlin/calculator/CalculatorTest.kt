package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource

class CalculatorTest {

    private val calculator: Calculator = Calculator()

    @Test
    fun `덧셈`() {
        val str = "1 + 2 + 3 + 6"
        assertThat(calculator.calculate(str)).isEqualTo(12)
    }

    @Test
    fun `뺄셈`() {
        val str = "1 + 2 + 5 - 6"
        assertThat(calculator.calculate(str)).isEqualTo(2)
    }

    @Test
    fun `곱하기`() {
        val str = "1 + 2 + 3 * 6"
        assertThat(calculator.calculate(str)).isEqualTo(36)
    }

    @Test
    fun `나누기`() {
        val str = "1 + 2 / 3 + 6"
        assertThat(calculator.calculate(str)).isEqualTo(7)
    }

    @Test
    fun `사칙연산이 아닐 경우`() {
        assertThatThrownBy {
            val str = "1 + 2 & 3 + 6"
            calculator.calculate(str)
        }.isExactlyInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `EXPRESSION_NULL_OR_빈문자`(input: String?) {
        assertThatThrownBy {
            calculator.calculate(input)
        }.isExactlyInstanceOf(IllegalArgumentException::class.java)
    }
}
