import { SIGN_IN, SIGN_OUT, VALID_UID, VALID_PW, EXIST_UID } from '../actions/constants';

export default( state = {
    isSignIn: false,
    uid: "",
    validateUidMessage: "",
    validatePwMessage: "",
    isValidateUid: false,
    isValidatePw: false,
    isExist: false,
}, action) => {
    switch(action.type) {
        case SIGN_IN:
            return {
                ...state,
                isSignIn: true,
                uid: action.payload.uid
            }
        case SIGN_OUT:
            return {
                ...state,
                isSignIn: false,
                uid: ""
            }
        case VALID_UID:
            return {
                ...state,
                ...action.payload
            }
        case VALID_PW:
            return {
                ...state,
                ...action.payload
            }
        case EXIST_UID:
            return {
                ...state,
                ...action.payload
            }
        default:
            return state
    }
}