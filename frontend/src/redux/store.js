import { configureStore } from '@reduxjs/toolkit';
import homeReducer from './reducer/homeReducer';
import LoginReducer from './reducer/LoginReducer';
import SignupReducer from './reducer/SignupReducer';
import writeReducer from './reducer/writeReducer';


const store = configureStore({
    reducer:{
        home : homeReducer,
        Login : LoginReducer,
        SignUp : SignupReducer,
        write : writeReducer,
    }
})

export default store