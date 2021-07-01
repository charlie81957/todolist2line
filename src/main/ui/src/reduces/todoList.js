import { FETCH_TODO_LIST, DELETE_TODO,CREATE_TODO } from '../actions/constants';

export default( state = {
    todoList: null,
    createFlag: false,
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
        default:
            return state
    }
}