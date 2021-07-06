import { FETCH_TODO_LIST, DELETE_TODO,CREATE_TODO, MODIFY_TODO_STATUS } from '../actions/constants';

export default( state = {
    todoList: null,
    createFlag: false,
    modifyStatus: 0,
}, action) => {
    switch(action.type) {
        case FETCH_TODO_LIST:
            return {
                ...state,
                todoList: action.payload.todoList
            }
        case DELETE_TODO:
            return {
                ...state
            }
        case CREATE_TODO:
            return {
                ...state,
                createFlag: true
            }
        case MODIFY_TODO_STATUS:
            return {
                ...state,
                modifyStatus: state.modifyStatus + 1
            }
        default:
            return state
    }
}