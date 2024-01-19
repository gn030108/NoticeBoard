import { createSlice } from '@reduxjs/toolkit'

let initialState = {
    id:'',
    pw:'',
    name:'',
};

const SignupSlice = createSlice({
    name:"Signup",
    initialState,
    reducers:{
        getId(state,action){
            state.id=action.payload
        },
        getPw(state,action){
            state.pw=action.payload
        },
        getName(state,action){
            state.name=action.payload
        },
        reset(state,action){
            state.id=''
            state.pw=''
            state.name=''
        },
    }
})

export const SignupActions = SignupSlice.actions
export default SignupSlice.reducer