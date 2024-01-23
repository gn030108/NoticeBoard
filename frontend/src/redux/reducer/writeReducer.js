import { createSlice } from '@reduxjs/toolkit'

let initialState = {
    title:'',
    content:'',
};

const WriteSlice = createSlice({
    name:"write",
    initialState,
    reducers:{
        getTitle(state,action){
            state.title=action.payload
        },
        getContent(state,action){
            state.content=action.payload
        }

    }
})

export const WriteActions = WriteSlice.actions
export default WriteSlice.reducer