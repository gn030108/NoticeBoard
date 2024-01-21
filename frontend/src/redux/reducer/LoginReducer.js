import { createSlice } from '@reduxjs/toolkit'

let initialState = {
    memberId:'',
    password:'',
};

const LoginSlice = createSlice({
    name:"Login",
    initialState,
    reducers:{
        getId(state,action){
            state.memberId=action.payload
        },
        getPw(state,action){
            state.password=action.payload
        },
        reset(state,action){
            state.memberId=''
            state.password=''
        },
    }
})

export const LoginActions = LoginSlice.actions
export default LoginSlice.reducer