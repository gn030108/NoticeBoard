import { createSlice } from '@reduxjs/toolkit'

let initialState = {
    memberId:'',
    password:'',
    name:'',
};

const SignupSlice = createSlice({
    name:"Signup",
    initialState,
    reducers:{
        getId(state,action){
            state.memberId=action.payload
        },
        getPw(state,action){
            state.password=action.payload
        },
        getName(state,action){
            state.name=action.payload
        },
        reset(state,action){
            state.memberId=''
            state.password=''
            state.name=''
        },
    }
})

export const SignupActions = SignupSlice.actions
export default SignupSlice.reducer