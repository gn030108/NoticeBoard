import { createSlice } from '@reduxjs/toolkit'

let initialState = {
    name:'박원우'
};

const homeSlice = createSlice({
    name:"board",
    initialState,
    reducers:{
        getname(state,action){
            state.name=action.payload
        },
    }
})

export const homeActions = homeSlice.actions
export default homeSlice.reducer