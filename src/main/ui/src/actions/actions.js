import { routerActions } from 'connected-react-router';
import {SIGN_IN, SIGN_OUT, VALID_UID, VALID_PW, EXIST_UID, FETCH_TODO_LIST, DELETE_TODO,CREATE_TODO } from './constants';

export const signInAction = (userState) => {
    return {
        type: SIGN_IN,
        payload: {
            isSignIn: true,
            uid: userState.uid
        }
    }
}

export const signOutAction = () => {
    return {
        type: SIGN_OUT,
        payload: {
            isSignIn: false,
            uid: ""
        }
    }
}

export const validateUidAction = (message, isValid) => {
    return {
        type: VALID_UID,
        payload: {
            validateUidMessage: message,
            isValidateUid: isValid
        }
    }
} 


export const validatePwAction = (message, isValid) => {
    return {
        type: VALID_PW,
        payload: {
            validatePwMessage: message,
            isValidatePw: isValid
        }
    }
} 

export const isExistUidAction = (message, isExist, isValid) => {
    return {
        type: EXIST_UID,
        payload: {
            validateUidMessage: message,
            isExist: isExist,
            isValidateUid: isValid
        }
    }
} 

export const fetchTodoListAction = (todoList) => {
    return {
        type: FETCH_TODO_LIST,
        payload: 
            todoList
    }
} 

export const deleteTodoAction = () => {
    return {
        type: DELETE_TODO
    }
}

export const createTodoAction = () => {
    return {
        type: CREATE_TODO
    }
}