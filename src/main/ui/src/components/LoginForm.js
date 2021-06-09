import React from 'react';
import { useState, useCallback} from 'react';
import { connect } from 'react-redux';
import {useDispatch, useSelector} from 'react-redux';
import { signInAction, validatePwAction } from '../actions/actions';
import {signIn, validateUid, validatePassword, signUp, isExistUid} from '../operation';
// import ConfimationModal from './ConfimationModal';
import Modal from 'react-modal';

const LoginForm = () => {

    /**
     * click method
     */
    const dispatch = useDispatch();
    const onSignInClick = () => {
        signInAction({
            uid,
            password
        })
    }

    // uid --> uid in store(nearly state) / setUid --> set uid in store(nearly state)
    // 分割代入
    const [uid, setUid] = useState("")

    const infoUser = useSelector(state => state.users)
    
    // 1回目にOnBlurが動くことを回避するフラグ
    var message1 = undefined;
    const inputUid = useCallback((e) => {
        setUid(e.target.value)
        // message1 = dispatch(validateUid(e.target.value))
        // 値検証の結果をStoreに保存
        dispatch(validateUid(e.target.value))

    },[]);

    // 1回目にOnBlurが動くことを回避するフラグ
    var onBlurFlag_ = false;
    const [password, setPassword] = useState("")
    const inputPassword = useCallback((e) => { 
        // if (!onBlurFlag_) {
        //     onBlurFlag_ = true
        //     return
        // }
        setPassword(e.target.value)
        // message1 = dispatch(validateUid(e.target.value))
        // 値検証の結果をStoreに保存
        dispatch(validatePassword(e.target.value))
        console.log(infoUser)
    },[]);

    // Modal flag
    const [showModal, setShowModal] = useState(false);

    // modal style
    const modalStyle = {
        overlar: {
            position: "fixed",
            top: 0,
            left: 0
        },
        content: {
            position: "absolute",
            width: "200px",
            height: "200px",
            marginLeft: "auto",
            marginRight: "auto",
            marginTop: "2rem"
        }
    }

    /**
     * LoginForm Component
     */
    return (
    <div className="container">
        <div className="row">
            <h1 className="col-lg-3 col-sm-12">TODO List</h1>
            <span className="col-lg col-sm align-self-center">ようこそ！</span>
        </div>
        <br />
        <form>
            <div className="form-group row">
                <input
                    type="text"
                    id="inputID"
                    className="form-control col-lg-4 col-sm-6"
                    placeholder="User ID"
                    required
                    // autoFocus
                    // onChange={inputUid}
                    onBlur={inputUid}
                />
                <label
                    htmlFor="inputID"
                    className="col-lg col-sm-12"
                    // style="color: brown"
                    >
                        {infoUser.validateUidMessage}
                </label>
            </div>
            <div className="form-group row">
                <input
                    type="password"
                    id="inputPW"
                    className="form-control col-lg-4 col-sm-6"
                    placeholder="Password"
                    required
                    // autoFocus
                    // onChange={inputPassword}
                    onBlur={inputPassword}
                />
                <label
                    htmlFor="inputPW"
                    className="col-lg col-sm-12"
                    // style="color: brown"
                    // hidden
                    >{infoUser.validatePwMessage}</label
                >
            </div>
            <div className="form-submit">
                <button
                    type="button"
                    id="signIn"
                    className="btn btn-outline-primary"
                    disabled={!(infoUser.isValidateUid && infoUser.isValidatePw && !infoUser.isExist)}
                    onClick={() => dispatch(signIn(uid, password))}
                >
                    Sign in
                </button>
                <button
                    type="button"
                    id="signUp"
                    className="btn btn-outline-primary"
                    disabled={!(infoUser.isValidateUid && infoUser.isValidatePw && infoUser.isExist)}
                    // disabled={true}
                    onClick={() => setShowModal(true)}
                >
                    Sign up
                </button>
            </div>
        </form>
        
        {/* Push SignUp Method  */}
        <Modal isOpen={showModal}
          ariaHideApp={false}
          style={modalStyle}
        >
            <h5>新規登録</h5>
            <p>入力されたID.Passwordでユーザー登録を行いますよろしいですか？</p>
            
        <button style={{display: 'inline-block'}} className="btn btn-primary" onClick={() => dispatch(signUp(uid, password))}>登録</button>
        <button style={{display: 'inline-block'}} className="btn btn-danger" onClick={() => setShowModal(false)}>キャンセル</button>
      </Modal>
    </div>
    );
}

export default LoginForm;
