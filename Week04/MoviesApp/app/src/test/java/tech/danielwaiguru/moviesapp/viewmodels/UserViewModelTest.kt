package tech.danielwaiguru.moviesapp.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import tech.danielwaiguru.moviesapp.models.User
import tech.danielwaiguru.moviesapp.repositories.UserRepository


class UserViewModelTest {
    private lateinit var userViewModel: UserViewModel
    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    @Mock
    lateinit var userRepository: UserRepository

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        userViewModel = UserViewModel(userRepository)
    }
    @Test
    fun registerUser(){
        val user = User(name = "Test user", username = "TestUser", password = "")
        val canNotRegister = userViewModel.isUserValid(user.username, user.password)
        assertEquals(false, canNotRegister)
    }
}