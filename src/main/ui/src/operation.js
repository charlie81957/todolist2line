import {signInAction, validateUidAction, validatePwAction, isExistUidAction} from './actions/actions';
import {push} from 'connected-react-router';

export const validateUid = (uid) => {
    var mess = "";
    var isValid = true;
    if (!uid) {
        mess = "User IDを入力してください"
        isValid = false
    }
    else if (!uid.match(/^[0-9a-zA-Z]*$/)) {
        mess = "User IDは半角英数で入力してください"
        isValid = false
    }

    if (isValid) {
        return async (dispatch, getState) => {
            const state = getState()
            const url = "http://localhost:8080/isExist"

            const requestOptions = {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                mode: 'cors',
                credentials: 'same-origin',
                body: JSON.stringify({ 
                    userId: uid
                })
            };

            // https://stackoverflow.com/questions/48562406/trouble-with-fetch-in-react-with-cors
            const response = await fetch(url, requestOptions)
                .then(res => res.json())
                .then(resJson => 
                    {
                        // return resJson;
                        if (!resJson) {
                            // SignUp
                            mess = "このIDで新規登録を行います"
                        }
                        else {
                            // SignIn
                            mess = ""
                        }
                        dispatch(isExistUidAction(
                            mess, //validateUidMessage: 
                            !resJson, // isExist:  多分resJson.xxx
                            isValid
                        ));
                    })
                .catch(() => null)                   
            }
        }

    return (dispatch) => {
        dispatch(validateUidAction(mess, isValid))
    }
}

export const validatePassword = (pw) => {
    var mess = "";
    var isValid = true;
    if (!pw) {
        mess = "Passwordを入力してください"
        isValid = false
    }
    else if (!pw.match(/^[0-9a-zA-Z]{4,}/)) {
        mess = "Passwordは半角英数4字以上で入力してください"
        isValid = false
    }

 
    // のちに実装
    else if (false) {
        mess = "Passwordが異なります"
    }
    return (dispatch) => {
        dispatch(validatePwAction(mess, isValid))
    }
}

export const isExistUid = (uid) => {
    return async (dispatch, getState) => {
        const state = getState()
        const url = "http://localhost:8080/isExist"

        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            mode: 'cors',
            credentials: 'same-origin',
            body: JSON.stringify({ 
                userId: uid
            })
        };

        // https://stackoverflow.com/questions/48562406/trouble-with-fetch-in-react-with-cors
        const response = await fetch(url, requestOptions)
            .then(res => res.json())
            .then(resJson => 
                {
                    // return resJson;
                    if (!resJson) {
                        // ここにはサインインが失敗した時の処理
                    }

                    dispatch(isExistUidAction({
                        validateUidMessage: "このIDで新規登録を行います",
                        isExist: true // 多分resJson.xxx
                    }));
                })
            .catch(() => null)                   
        }
    }


export const signIn = (uid, password) => {
    return async (dispatch, getState) => {
        const state = getState()
        const isSignIn = state.isSignIn

        if (!isSignIn) {
            const url = "http://localhost:8080/signIn"

            const requestOptions = {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                mode: 'cors',
                credentials: 'same-origin',
                body: JSON.stringify({ 
                    userId: uid,
                    userPassword: password, 
                })
            };

            // https://stackoverflow.com/questions/48562406/trouble-with-fetch-in-react-with-cors
            const response = await fetch(url, requestOptions)
                .then(res => res.json())
                .then(resJson => 
                    {
                        if (!resJson) {
                            // ここにはサインインが失敗した時の処理
                        }
                        dispatch(signInAction({
                            uid: uid,
                            isSignIn: true
                        }));
                        // Return Main Todo screen!!
                        dispatch(push('/'));
                    })
                .catch(() => null)                   
        }
    }
}

export const signUp = (uid, pw) => {
    return async (dispatch, getState) => {
        const url = "http://localhost:8080/signUp"

        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            mode: 'cors',
            credentials: 'same-origin',
            body: JSON.stringify({ 
                userId: uid,
                userPassword: pw, 
            })
        };

        // https://stackoverflow.com/questions/48562406/trouble-with-fetch-in-react-with-cors
        const response = await fetch(url, requestOptions)
            .then(res => res.json())
            .then(resJson => 
                {
                    if (!resJson) {
                        // ここにはサインインが失敗した時の処理
                    }
                    dispatch(isExistUid({
                        uid: uid,
                        isSignIn: true
                    }));
                    // Return Main Todo screen!!
                    dispatch(push('/'));
                })
            .catch(() => null)
    }
}


export const createTodo = (title, detail, limit, notice) => {

    

    // When we regist todo, check valition 
    const validateFlag = false;


    return async (dispatch, getState) => {
        const state = getState()
        const url = "http://localhost:8080/isExist"

        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            mode: 'cors',
            credentials: 'same-origin',
            body: JSON.stringify({ 
                userId: "uid"
            })
        };
        // Return Main Todo screen!!
        dispatch(push('/'));

    }
}

