import { createSlice } from '@reduxjs/toolkit'

let initialState = {
    id:'',
    pw:'',
};

const LoginSlice = createSlice({
    name:"Login",
    initialState,
    reducers:{
        getId(state,action){
            state.id=action.payload
        },
        getPw(state,action){
            state.pw=action.payload
        },
        reset(state,action){
            state.id=''
            state.pw=''
        },
    }
})

export const LoginActions = LoginSlice.actions
export default LoginSlice.reducer