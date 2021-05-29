import { routerActions } from 'connected-react-router';
import {SIGN_IN, SIGN_OUT, VALID_UID, VALID_PW} from './constants';

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
