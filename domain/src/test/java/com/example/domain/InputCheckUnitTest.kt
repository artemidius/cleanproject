package com.example.domain

import com.example.domain.entities.AuthEntities
import com.example.domain.exceptions.InvalidEmailException
import com.example.domain.exceptions.InvalidPasswordException
import com.example.domain.exceptions.NoAgreementCheckedException
import com.example.domain.model.LoginScreenViewModel
import org.hamcrest.CoreMatchers.instanceOf
import org.junit.Assert.assertThat
import org.junit.Assert.assertTrue
import org.junit.Test


class InputCheckUnitTest {
    @Test
    fun email_isCorrect() {
        val model1 = LoginScreenViewModel (
                "",
                "",
                false,
                false
        )

        val model2 = LoginScreenViewModel (
                "Sssssss",
                "",
                false,
                false
        )

        try {
            AuthEntities().inputIsCorrect(model1)
        } catch (e:Throwable) {
            assertThat(e,instanceOf(InvalidEmailException::class.java))
        }

        try {
            AuthEntities().inputIsCorrect(model2)
        } catch (e:Throwable) {
            assertThat(e,instanceOf(InvalidEmailException::class.java))
        }
    }

    @Test
    fun password_isCorrect() {
        val model3 = LoginScreenViewModel (
                "Sssssss@ddddddd.ru",
                "",
                false,
                false
        )

        try {
            AuthEntities().inputIsCorrect(model3)
        } catch (e:Throwable) {
            assertThat(e,instanceOf(InvalidPasswordException::class.java))
        }

    }

    @Test
    fun agreement_isCorrect() {
        val model4 = LoginScreenViewModel (
                "Sssssss@ddddddd.ru",
                "dadadadada",
                false,
                false
        )

        try {
            AuthEntities().inputIsCorrect(model4)
        } catch (e:Throwable) {
            assertThat(e,instanceOf(NoAgreementCheckedException::class.java))
        }

    }

    @Test
    fun happyCase_isCorrect() {
        val model5 = LoginScreenViewModel (
                "Sssssss@ddddddd.ru",
                "dadadadada",
                true,
                false
        )

        val model6 = LoginScreenViewModel (
                "Sssssss@ddddddd.ru",
                "dadadadada",
                true,
                true
        )

        try {
            AuthEntities().inputIsCorrect(model5)
            AuthEntities().inputIsCorrect(model6)
            assertTrue(true)
        } catch (e:Throwable) {
            assertTrue(false)
        }
    }
}