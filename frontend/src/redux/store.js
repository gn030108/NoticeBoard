import { configureStore } from '@reduxjs/toolkit';
import homeReducer from './reducer/homeReducer';
import LoginReducer from './reducer/LoginReducer';
import SignupReducer from './reducer/SignupReducer';


const store = configureStore({
    reducer:{
        home : homeReducer,
        Login : LoginReducer,
        SignUp : SignupReducer
    }
})

export default store