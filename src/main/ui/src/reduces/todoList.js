import { FETCH_TODO_LIST } from '../actions/constants';

export default( state = {
    todoList: null
}, action) => {
    switch(action.type) {
        case FETCH_TODO_LIST:
            return {
                ...state,
                todoList: action.payload.todoList
            }
        default:
            return state
    }
}